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
        User u = new User(new Account("aaaa@email.com",
                "$2a$10$TFvBDMb4PhuY3ktYmD553eN.kpv15w4WzqXI0HLFxKnMoy0v42HXu"));
        test.put(u.getAccount(), u);
        return test;
    }
}
