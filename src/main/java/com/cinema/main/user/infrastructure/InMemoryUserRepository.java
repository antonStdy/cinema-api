package com.cinema.main.user.infrastructure;

import com.cinema.main.user.domain.Account;
import com.cinema.main.user.domain.User;
import com.cinema.main.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class InMemoryUserRepository implements UserRepository {
    private final Map<Account, User> users = loadTest();

    @Override
    public User save(User user) {
        users.put(user.getAccount(), user);
        log.info("user saved: {}", user);
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

    private Map<Account, User> loadTest() {
        Map<Account, User> test = new HashMap<>();
        User u = new User(new Account("aaa@email.com",
                "$2a$10$Gw25ZT5i4XFe3QxGPdr8m.JYc7NmsNMT3PQ2/S20G38uWhi4DZmce"));
        test.put(u.getAccount(), u);
        return test;
    }
}
