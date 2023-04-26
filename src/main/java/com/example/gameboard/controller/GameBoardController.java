package com.example.gameboard.controller;

import com.example.gameboard.service.RankingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rank")
public class GameBoardController {

    private final RankingService rankingService;

    @GetMapping("/create")
    public Boolean setScore(@RequestParam String userId,
                            @RequestParam int score)
    {
        return rankingService.setUserScore(userId, score);
    }

    @GetMapping("/user")
    public Long getUserRank(@RequestParam String userId) {
        return rankingService.getUserRanking(userId);
    }

    @GetMapping("/users")
    public List<String> getTopRankUsers() {
        return rankingService.getTopRankUsers(3);
    }
}
