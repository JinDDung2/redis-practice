package com.example.gameboard.controller;

import com.example.gameboard.dto.UserInfoDto;
import com.example.gameboard.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public String login(@RequestParam String name,
                        HttpSession session) {
        session.setAttribute("name", name);

        return "session saved";
    }

    @GetMapping("/{id}/info")
    public UserInfoDto getUser(@PathVariable String id) {
        return userService.getUser(id);
    }
}
