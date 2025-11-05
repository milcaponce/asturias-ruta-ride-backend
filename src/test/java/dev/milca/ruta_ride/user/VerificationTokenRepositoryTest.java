package dev.milca.ruta_ride.user;

import dev.milca.ruta_ride.config.TestConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
@TestPropertySource(properties = {"spring.sql.init.mode=never"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(TestConfig.class)
class VerificationTokenRepositoryTest {
    @Autowired
    private VerificationTokenRepository tokenRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("should find token by value when exists")
    void testFindByToken_Found() {
        UserEntity user = UserEntity.builder()
                .name("Milca")
                .email("milca@example.com")
                .password("12345")
                .profileImage("/images/default.png")
                .build();

        userRepository.save(user);

        VerificationToken token = VerificationToken.builder()
                .token("abc123")
                .user(user)
                .expiryDate(LocalDateTime.now().plusHours(1))
                .build();

        tokenRepository.save(token);

        Optional<VerificationToken> result = tokenRepository.findByToken("abc123");

        assertThat(result).isPresent();
        assertThat(result.get().getUser().getEmail()).isEqualTo("milca@example.com");
    }

    @Test
    @DisplayName("should return empty when token does not exist")
    void testFindByToken_NotFound() {

        Optional<VerificationToken> result = tokenRepository.findByToken("fake-token");

        assertThat(result).isEmpty();
    }
}
