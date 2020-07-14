package com.app;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import javax.crypto.SecretKey;

@PropertySource("classpath:application.properties")
@SpringBootApplication
public class CinemaSecurityDockerAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(CinemaSecurityDockerAppApplication.class, args);
    }

    @Bean
    public SecretKey secretKey() {
        return Keys.secretKeyFor(SignatureAlgorithm.HS512);
    }
}
