package com.cinema.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CinemaApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext c = SpringApplication.run(CinemaApplication.class, args);
    }

}
