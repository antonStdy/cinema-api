package com.cinema.main.infrastructure.application.security;

import com.cinema.main.user.domain.Account;
import com.cinema.main.user.domain.User;
import com.cinema.main.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private static final String passwordRegex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).{10,}$";
    private static final String emailRegex = "^(.+)@(.+)$";

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User registerUser(Account account) {
        validateCreds(account);
        checkUserExists(account);

        account.setPassword(passwordEncoder.encode(account.getPassword()));
        User user = new User(account);
        return userRepository.save(user);
    }

    private void checkUserExists(Account account) {
        userRepository.findByAccount_Email(account.getEmail())
                .map(User::getAccount)
                .ifPresent((u) -> {
                    throw new RuntimeException("User already exists: " + u.getEmail());
                });
    }

    private void validateCreds(Account account) {
        if (!areCredentialsValid(account)) {
            throw new RuntimeException("Credentials are not valid");
        }
    }

    private boolean areCredentialsValid(Account account) {
        String email = account.getEmail();
        String password = account.getPassword();
        return email != null && password != null
                && email.matches(emailRegex)
                && password.matches(passwordRegex);
    }
}
