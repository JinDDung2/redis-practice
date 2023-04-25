package com.example.gameboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class GameboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameboardApplication.class, args);
    }

}
