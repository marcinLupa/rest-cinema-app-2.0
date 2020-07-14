package com.app.infrastructure.security.service;

import com.app.domain.model.User;
import com.app.domain.repository.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@Qualifier("userDetailsServiceImpl")
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    // w tej klasie jest metoda loadUserByUsername
    // kiedy user bedzie sie logowal to ta metoda bedzie wywolywana automatycznie
    // i bedzie dostawala jako argument username
    // na podstawie tego argumentu bedziemy wyciagac  uzytkownia z bazy danych
    // i bedziemy mogli przerobic go na specjalnego usera security

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository
                .findByUsername(username)
                .orElseThrow(() -> new SecurityException("cannot find user with username " + username));

        // tutaj mamy obiekt User ale z security
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getActivated(), true, true, true,
                user
                        .getRoles()
                        .stream()
                        .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
                        .collect(Collectors.toList())
        );
    }
}