package com.example.gameboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {

    @GetMapping("/login")
    public String login(@RequestParam String name,
                        HttpSession session) {
        session.setAttribute("name", name);

        return "session saved";
    }

    @GetMapping("/info")
    public String getUser(HttpSession session) {
        String name = (String) session.getAttribute("name");

        return name;
    }
}
