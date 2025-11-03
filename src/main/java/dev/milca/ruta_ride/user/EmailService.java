package dev.milca.ruta_ride.user;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

@Service
@RequiredArgsConstructor
public class EmailService {
    
    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    public void sendVerificationEmail(String to, String token, String name) {
        try {
            // Load HTML template
            ClassPathResource resource = new ClassPathResource("templates/verification-email.html");
            String html = Files.readString(resource.getFile().toPath(), StandardCharsets.UTF_8);

            // Replace variables in template
            String verificationUrl = "http://localhost:5173/verify-email?token=" + token;
            html = html.replace("{{name}}", name != null ? name : "")
                        .replace("{{verificationLink}}", verificationUrl);

            // Prepare email with HTML
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, StandardCharsets.UTF_8.name());

            helper.setFrom(fromEmail);
            helper.setTo(to);
            helper.setSubject("Verifica tu cuenta en Ruta&Ride");
            helper.setText(html, true); // true = HTML

            mailSender.send(message);
            System.out.println("✅ Correo HTML enviado correctamente a: " + to);

        } catch (MessagingException | MailException e) {
            System.err.println("❌ Error enviando correo HTML a " + to + ": " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("❌ Error cargando plantilla HTML: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
