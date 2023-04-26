package com.example.gameboard.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RankingService {

    private static final String GAME_BOARD_KEY = "gameBoard";

    private final StringRedisTemplate redisTemplate;

    public boolean setUserScore(String userId, int score) {
        // sorted set
        ZSetOperations zSetOps = redisTemplate.opsForZSet();
        zSetOps.add(GAME_BOARD_KEY, userId, score);

        return true;
    }

    public Long getUserRanking(String userId) {
        ZSetOperations zSetOps = redisTemplate.opsForZSet();

        return zSetOps.reverseRank(GAME_BOARD_KEY, userId);
    }

    public List<String> getTopRankUsers(int limit) {
        ZSetOperations zSetOps = redisTemplate.opsForZSet();
        Set<String> topRankUser = zSetOps.reverseRange(GAME_BOARD_KEY, 0, limit - 1);

        return new ArrayList<>(topRankUser);
    }

}
