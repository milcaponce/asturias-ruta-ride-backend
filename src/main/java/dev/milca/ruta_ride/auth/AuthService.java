package dev.milca.ruta_ride.auth;

import dev.milca.ruta_ride.user.UserEntity;
import dev.milca.ruta_ride.user.UserRepository;
import dev.milca.ruta_ride.user.dto.UserRegisterDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

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

        return userRepository.save(user);
    }
}
