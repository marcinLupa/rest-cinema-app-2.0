package com.app.application.service;

import com.app.application.dto.RegisterUserDto;
import com.app.domain.model.User;
import com.app.domain.repository.repositories.RoleRepository;
import com.app.domain.repository.repositories.UserRepository;
import com.app.domain.repository.repositories.VerificationTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SecurityService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
//    private final EmailService emailService;
    private final VerificationTokenRepository verificationTokenRepository;
    public Long register(RegisterUserDto registerUserDto) {

        if (Objects.isNull(registerUserDto)) {
            throw new SecurityServiceException("register user object is null");
        }

        if (Objects.isNull(registerUserDto.getUsername())) {
            throw new SecurityServiceException("register - username string is null");
        }

        if (userRepository.findByUsername(registerUserDto.getUsername()).isPresent()) {
            throw new SecurityServiceException("register - username already exixsts");
        }

        if (userRepository.findByEmail(registerUserDto.getEmail()).isPresent()) {
            throw new SecurityServiceException("register - email already exists");
        }

        if (Objects.isNull(registerUserDto.getEmail())) {
            throw new SecurityServiceException("register - email string is null");
        }

        if (!Objects.equals(registerUserDto.getPassword(), registerUserDto.getPasswordConfirmation())) {
            throw new SecurityServiceException("register - password are not the same");
        }

        if (Objects.isNull(registerUserDto.getRoles())) {
            throw new SecurityServiceException("register - roles collection is null");
        }

        var roles = roleRepository.findAllByName(registerUserDto.getRoles());

        var userToInsert = User.builder()
                .username(registerUserDto.getUsername())
                .email(registerUserDto.getEmail())
                .password(passwordEncoder.encode(registerUserDto.getPassword()))
                .activated(false)
                .roles(new HashSet<>(roles))
                .build();

        var token = UUID.randomUUID().toString().replace("\\W", "");

        var verificationToken = VerificationToken
                .builder()
                .token(token)
                .user(userToInsert)
                .expirationDateTime(LocalDateTime.now().plusMinutes(5))
                .build();

        var insertedVerification = verificationTokenRepository
                .saveOrUpdate(verificationToken)
                .orElseThrow(() -> new SecurityServiceException("cannot insert verification token"));


        var url = "http://localhost:8080/security/activate-user?token=" + token;
        var message = "Click to activate: " + url;
        emailService.send(userToInsert.getEmail(), "Register activation", message);

        return insertedVerification
                .getUser()
                .getId();
    }

    public Long activate(String token){
        User user=verificationTokenRepository
                .findByToken(token)
                .orElseThrow(() -> new SecurityServiceException("cannot get verification token object"))
                .getUser();
        user.setActivated(true);
        return user.getId();
    }

}
