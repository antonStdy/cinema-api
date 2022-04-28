package com.cinema.main.infrastructure.application.security;

import com.cinema.main.user.domain.User;
import com.cinema.main.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CinemaUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByAccount_Email(email)
                .map(this::toUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException("Not found by email: " + email));
    }

    private UserDetails toUserDetails(User user) {
        return new org.springframework.security.core.userdetails
                .User(user.getAccount().getEmail(), user.getAccount().getPassword(), Collections.emptyList());
    }
}
