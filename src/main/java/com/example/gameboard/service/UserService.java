package com.example.gameboard.service;

import com.example.gameboard.dto.UserInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class UserService {

    private final ExternalService externalService;
    private final StringRedisTemplate redisTemplate;

    public UserInfoDto getUser(String userId) {

        String username = null;

        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        String cacheName = ops.get("nameKey:" + userId);

        if (cacheName != null) {
            username = cacheName;
            System.out.println("캐싱 적용");
        } else {
             username = externalService.getUsername(userId);
             ops.set("nameKey:" + userId, username, 5, TimeUnit.SECONDS);
        }

        int userAge = externalService.getUserAge(userId);

        return new UserInfoDto(username, userAge);
    }
}
