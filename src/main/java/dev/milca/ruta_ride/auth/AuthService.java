package dev.milca.ruta_ride.auth;

import dev.milca.ruta_ride.user.*;
import dev.milca.ruta_ride.user.dto.UserRegisterDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final VerificationTokenRepository tokenRepository;
    private final EmailService emailService;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    //Registra nuevo usuario + envía correo de verif
    public UserEntity register(UserRegisterDTO dto) {
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("El correo ya está registrado");
}

    UserEntity user = UserEntity.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .profileImage(dto.getProfileImage())
                .isVerified(false)
                .build();

        user = userRepository.save(user);

        // Token de verificación con exp. de 24hs
        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = VerificationToken.builder()
                .token(token)
                .user(user)
                .expiryDate(LocalDateTime.now().plusHours(24))
                .build();

        // Enviar correo
        emailService.sendVerificationEmail(user.getEmail(), token);

        return user;
    }

    //Verifica el token recibido por correo
    public String verifyToken(String token) {
        VerificationToken verificationToken = tokenRepository.findByToken(token)
                .orElseThrow(() -> new RuntimeException("Token no válido"));

        if (verificationToken.isExpired()) {
            throw new RuntimeException("Token expirado");
        }

        UserEntity user = verificationToken.getUser();
        user.setVerified(true);
        userRepository.save(user);

        //Elima el token después de la verif
        tokenRepository.delete(verificationToken);

        return "Cuenta verificada correctamente";
    }
}
