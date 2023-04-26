package com.example.gameboard;

import com.example.gameboard.service.ChatService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class GameboardApplication implements CommandLineRunner {

    private final ChatService chatService;

    public GameboardApplication(ChatService chatService) {
        this.chatService = chatService;
    }

    public static void main(String[] args) {
        SpringApplication.run(GameboardApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Application run started..");

        chatService.enterChatRoom("chat-1");
    }
}
