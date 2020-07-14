package com.app.infrastructure.controller;

import com.app.application.dto.RegisterUserDto;
import com.app.application.service.SecurityService;
import com.app.infrastructure.dto.RefreshTokenDto;
import com.app.infrastructure.dto.TokensDto;
import com.app.infrastructure.security.tokens.TokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/security")
public class SecurityController {

    private final TokenManager tokenManager;
    private final SecurityService securityService;

    @PostMapping("/register")
    public Long register(@RequestBody RegisterUserDto registerUserDto){
        return  securityService.register(registerUserDto);
    }
    @GetMapping("/activate-user")
    public String verification(@RequestParam String token) {
        var activatedUserId = securityService.activate(token);
        return "User with id " + activatedUserId + " has been activated";
    }

    @PostMapping("/refresh-tokens")
    public TokensDto refreshTokens(@RequestBody RefreshTokenDto refreshTokenDto) {
        return tokenManager.parseFromRefreshToken(refreshTokenDto);
    }
}
