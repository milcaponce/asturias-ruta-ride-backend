package dev.milca.ruta_ride.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class VerificationTokenTest {
    @Test
    @DisplayName("should return false when token is not expired")
    void testIsExpired_False() {
        VerificationToken token = VerificationToken.builder()
                .token("abc123")
                .expiryDate(LocalDateTime.now().plusHours(1))
                .build();

        assertThat(token.isExpired()).isFalse();
    }

    @Test
    @DisplayName("should return true when token is expired")
    void testIsExpired_True() {
        VerificationToken token = VerificationToken.builder()
                .token("abc123")
                .expiryDate(LocalDateTime.now().minusMinutes(5))
                .build();

        assertThat(token.isExpired()).isTrue();
    }

    @Test
    @DisplayName("should correctly set and get fields")
    void testGettersAndSetters() {
        UserEntity user = UserEntity.builder()
                .id(1L)
                .name("Milca")
                .email("milca@example.com")
                .password("12345")
                .build();

        VerificationToken token = new VerificationToken();
        token.setId(10L);
        token.setToken("xyz789");
        token.setUser(user);
        token.setExpiryDate(LocalDateTime.of(2025, 1, 1, 12, 0));

        assertThat(token.getId()).isEqualTo(10L);
        assertThat(token.getToken()).isEqualTo("xyz789");
        assertThat(token.getUser()).isEqualTo(user);
        assertThat(token.getExpiryDate()).isEqualTo(LocalDateTime.of(2025, 1, 1, 12, 0));
    }
}
