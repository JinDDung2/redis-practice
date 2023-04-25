package com.example.gameboard.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserInfoDto {

    @JsonProperty
    private String name;

    @JsonProperty
    private int age;

    public UserInfoDto(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
