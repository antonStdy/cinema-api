package com.cinema.main.user.domain;

import lombok.*;

@EqualsAndHashCode
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    private Account account;
}
