package com.cinema.main.infrastructure.application.security;

import com.cinema.main.user.domain.Account;
import com.cinema.main.user.domain.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final JWTUtil jwtUtil;
    private final AuthenticationManager authManager;

    @PostMapping("/authenticate")
    AuthToken authenticate(@RequestBody LoginCredentials creds) {
        try {
            UsernamePasswordAuthenticationToken authInputToken =
                    new UsernamePasswordAuthenticationToken(creds.getEmail(), creds.getPassword());

            authManager.authenticate(authInputToken);

            String token = jwtUtil.generateToken(creds.getEmail());

            return new AuthToken(token);
        }catch (AuthenticationException authExc){
            throw new RuntimeException("Invalid Login Credentials");
        }
    }

    @PostMapping("/register")
    AuthToken register(@RequestBody Account account) {
        User user = authService.registerUser(account);
        String token = jwtUtil.generateToken(user.getAccount().getEmail());
        return new AuthToken(token);
    }

    @Value
    private static class AuthToken {
        String token;
    }

    @Data
    private static class LoginCredentials {
        private String email;
        private String password;
    }
}
