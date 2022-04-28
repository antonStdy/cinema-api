package com.cinema.main.user.infrastructure;

import com.cinema.main.film.domain.film.Film;
import com.cinema.main.user.domain.Account;
import com.cinema.main.user.domain.User;
import com.cinema.main.user.domain.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class InMemoryUserRepository implements UserRepository {

    private final Map<Account, User> users = new HashMap<>();

    @Override
    public User save(User user) {
        if (!exists(user)) {
            users.put(user.getAccount(), user);
            log.info("user saved: {}", user);
        }
        return user;
    }

    @Override
    public Optional<User> findByAccount_Email(String email) {
        for (Map.Entry<Account, User> accountUserEntry : users.entrySet()) {
            if (accountUserEntry.getKey().getEmail().equals(email)) {
                return Optional.of(accountUserEntry.getValue());
            }
        }
        return Optional.empty();
    }

    private boolean exists(User user) {
        return users.containsKey(user.getAccount());
    }
}
