package dev.milca.ruta_ride.user.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class UserRegisterDTOTest {

    @Test
    @DisplayName("should correctly set and get fields")
    void testGettersAndSetters() {
        UserRegisterDTO dto = new UserRegisterDTO();
        dto.setName("Milca");
        dto.setEmail("milca@example.com");
        dto.setPassword("mypassword");
        dto.setPhone("123456789");
        dto.setProfileImage("avatar.jpg");

        assertThat(dto.getName()).isEqualTo("Milca");
        assertThat(dto.getEmail()).isEqualTo("milca@example.com");
        assertThat(dto.getPassword()).isEqualTo("mypassword");
        assertThat(dto.getPhone()).isEqualTo("123456789");
        assertThat(dto.getProfileImage()).isEqualTo("avatar.jpg");
    }

    @Test
    @DisplayName("should create object using all-args constructor")
    void testAllArgsConstructor() {
        UserRegisterDTO dto = new UserRegisterDTO(
                "Milca",
                "milca@example.com",
                "mypassword",
                "123456789",
                "avatar.jpg"
        );

        assertThat(dto.getName()).isEqualTo("Milca");
        assertThat(dto.getEmail()).isEqualTo("milca@example.com");
        assertThat(dto.getPassword()).isEqualTo("mypassword");
        assertThat(dto.getPhone()).isEqualTo("123456789");
        assertThat(dto.getProfileImage()).isEqualTo("avatar.jpg");
    }

    @Test
    @DisplayName("should create object using builder")
    void testBuilder() {
        UserRegisterDTO dto = UserRegisterDTO.builder()
                .name("Milca")
                .email("milca@example.com")
                .password("mypassword")
                .phone("123456789")
                .profileImage("avatar.jpg")
                .build();

        assertThat(dto.getName()).isEqualTo("Milca");
        assertThat(dto.getEmail()).isEqualTo("milca@example.com");
        assertThat(dto.getPassword()).isEqualTo("mypassword");
        assertThat(dto.getPhone()).isEqualTo("123456789");
        assertThat(dto.getProfileImage()).isEqualTo("avatar.jpg");
    }
}
