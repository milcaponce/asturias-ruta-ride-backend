package dev.milca.ruta_ride.user;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    
    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    public void sendVerificationEmail(String to, String token) {
        String subject = "Verifica tu cuenta en RutaRide ";
        String verificationUrl = "http://localhost:8080/api/v1/auth/verify?token=" + token;

        String body = "¡Bienvenido a RutaRide!\n\n"
                + "Para activar tu cuenta, haz clic en el siguiente enlace:\n"
                + verificationUrl + "\n\n"
                + "Este enlace expirará en 24 horas.\n\n"
                + "¡Nos vemos en el camino! ";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);
    }
}
