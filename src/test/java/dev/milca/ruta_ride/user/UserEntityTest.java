package dev.milca.ruta_ride.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class UserEntityTest {

    @Test
    @DisplayName("Should correctly set and get properties using setters")
    void testGettersAndSetters() {
        UserEntity user = new UserEntity();
        user.setId(1L);
        user.setName("Milca Ponce");
        user.setEmail("milca@example.com");
        user.setPassword("hashed-password");
        user.setProfileImage("profile.png");
        user.setPhone("123456789");
        user.setVerified(true);

        assertThat(user.getId()).isEqualTo(1L);
        assertThat(user.getName()).isEqualTo("Milca Ponce");
        assertThat(user.getEmail()).isEqualTo("milca@example.com");
        assertThat(user.getPassword()).isEqualTo("hashed-password");
        assertThat(user.getProfileImage()).isEqualTo("profile.png");
        assertThat(user.getPhone()).isEqualTo("123456789");
        assertThat(user.isVerified()).isTrue();
    }

    @Test
    @DisplayName("Should create user with builder and default isVerified = false")
    void testBuilderCreatesUserCorrectly() {
        UserEntity user = UserEntity.builder()
                .id(10L)
                .name("Juan Pérez")
                .email("juan@example.com")
                .password("1234")
                .profileImage("juan.png")
                .phone("987654321")
                .build();

        assertThat(user.getId()).isEqualTo(10L);
        assertThat(user.getName()).isEqualTo("Juan Pérez");
        assertThat(user.getEmail()).isEqualTo("juan@example.com");
        assertThat(user.getPassword()).isEqualTo("1234");
        assertThat(user.getProfileImage()).isEqualTo("juan.png");
        assertThat(user.getPhone()).isEqualTo("987654321");

        assertThat(user.isVerified()).isFalse();
    }
}