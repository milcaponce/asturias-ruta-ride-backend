package dev.milca.ruta_ride.auth;

import dev.milca.ruta_ride.user.UserEntity;
import dev.milca.ruta_ride.user.dto.UserRegisterDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dev.milca.ruta_ride.auth.dto.LoginRequest;
import dev.milca.ruta_ride.auth.dto.LoginResponse;


@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<UserEntity> register(@RequestBody UserRegisterDTO dto) {
        UserEntity newUser = authService.register(dto);
        return ResponseEntity.ok(newUser);
    }

    @GetMapping("/verify")
    public ResponseEntity<String> verifyEmail(@RequestParam String token) {
        String result = authService.verifyToken(token);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
    
}
