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

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
@TestPropertySource(properties = {"spring.sql.init.mode=never"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(TestConfig.class)
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("Should save user and retrieve it by email")
    void testFindByEmail() {
        UserEntity user = UserEntity.builder()
                .name("Milca Ponce")
                .email("milca@example.com")
                .password("1234")
                .profileImage("img.png")
                .isVerified(false)
                .build();

        userRepository.save(user);

        var result = userRepository.findByEmail("milca@example.com");

        assertThat(result).isPresent();
        assertThat(result.get().getName()).isEqualTo("Milca Ponce");
    }

    @Test
    @DisplayName("Should detect when email already exists")
    void testExistsByEmail() {
        UserEntity user = UserEntity.builder()
                .name("Juan Pérez")
                .email("juan@example.com")
                .password("abcd")
                .profileImage("jp.png")
                .build();

        userRepository.save(user);

        boolean exists = userRepository.existsByEmail("juan@example.com");

        assertThat(exists).isTrue();
    }

    @Test
    @DisplayName("Should return false when email does not exist")
    void testExistsByEmail_False() {
        boolean exists = userRepository.existsByEmail("notfound@example.com");

        assertThat(exists).isFalse();
    }
}
