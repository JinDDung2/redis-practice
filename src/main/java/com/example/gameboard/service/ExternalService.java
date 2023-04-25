package com.example.gameboard.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

// 외부 서비스 호출 역할
@Service
@Slf4j
public class ExternalService {
    public String getUsername(String userId) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {}

        log.info("getUsername 함수 호출 완료");

        if (userId.equals("A")) {
            return "Apple";
        }

        if (userId.equals("B")) {
            return "Banana";
        }

        return "Nothing";
    }

    @Cacheable(cacheNames = "ageKey", key = "#userId")
    public int getUserAge(String userId) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {}

        log.info("getUserAge 함수 호출 완료");

        if (userId.equals("A")) {
            return 17;
        }

        if (userId.equals("B")) {
            return 27;
        }

        return 0;
    }
}
