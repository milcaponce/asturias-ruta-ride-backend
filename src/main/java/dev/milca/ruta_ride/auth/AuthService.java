package dev.milca.ruta_ride.auth;

import dev.milca.ruta_ride.user.*;
import dev.milca.ruta_ride.user.dto.UserRegisterDTO;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import dev.milca.ruta_ride.auth.dto.LoginRequest;
import dev.milca.ruta_ride.auth.dto.LoginResponse;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService {

    private static final String DEFAULT_PROFILE_IMAGE = "/images/default-profile.png";

    private final UserRepository userRepository;
    private final VerificationTokenRepository tokenRepository;
    private final EmailService emailService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    

    //Registra nuevo usuario + envía correo de verif
    public UserEntity register(UserRegisterDTO dto) {
        final String email = safeTrim(dto.getEmail());
        final String name  = safeTrim(dto.getName());

        if (userRepository.existsByEmail(email)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "El correo ya está registrado");
        }

    //Imagen por defecto si no viene o está vacía
        final String incomingProfileImage = safeTrim(dto.getProfileImage());
        final String profileImage = (incomingProfileImage == null || incomingProfileImage.isEmpty())
                ? DEFAULT_PROFILE_IMAGE
                : incomingProfileImage;

    UserEntity user = UserEntity.builder()
                .name(name)
                .email(email)
                .password(passwordEncoder.encode(dto.getPassword()))
                .profileImage(profileImage)
                .isVerified(false)
                .phone(dto.getPhone())
                .build();

        user = userRepository.save(user);

        // Token de verificación con exp. de 24hs
        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = VerificationToken.builder()
                .token(token)
                .user(user)
                .expiryDate(LocalDateTime.now().plusHours(24))
                .build();

        tokenRepository.save(verificationToken);

        // Enviar correo
        emailService.sendVerificationEmail(user.getEmail(), token, user.getName());

        return user;
    }

    //Verifica el token recibido por correo
    public String verifyToken(String token) {

        //System.out.println("🧪 Token recibido desde frontend: [" + token + "]");
        
        VerificationToken verificationToken = tokenRepository.findByToken(token)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Token no válido"));

        if (verificationToken.isExpired()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Token expirado");
        }

        UserEntity user = verificationToken.getUser();
        user.setVerified(true);
        userRepository.save(user);

        //Elima el token después de la verif
        tokenRepository.delete(verificationToken);

        return "Cuenta verificada correctamente";
    }

    //Autenticación del login
    public LoginResponse login(LoginRequest request) {
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciales inválidas"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciales inválidas");
        }

        if (!user.isVerified()) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Cuenta no verificada");
        }

        String token = jwtService.generateToken(user.getEmail());
        return new LoginResponse(token);
    }

    private String safeTrim(String value) {
        return value == null ? null : value.trim();
    }
}
