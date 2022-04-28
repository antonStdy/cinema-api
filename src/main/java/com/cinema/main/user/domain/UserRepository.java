package com.cinema.main.user.domain;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByAccount_Email(String email);
    User save(User user);
}
