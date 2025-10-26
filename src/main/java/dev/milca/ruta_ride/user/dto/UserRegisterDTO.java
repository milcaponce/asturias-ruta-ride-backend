package dev.milca.ruta_ride.user.dto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegisterDTO {
    private String name;
    private String email;
    private String password;
    private String profileImage;
}
