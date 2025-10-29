package dev.milca.ruta_ride.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;


@TestConfiguration
public class TestConfig {
    
    @Bean
    public JavaMailSender javaMailSender() {
        // Bean falso para evitar errores de dependencia en los tests
        return new JavaMailSenderImpl();
    }
    
}
