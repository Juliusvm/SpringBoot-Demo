package com.example.demo.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Person {
    @JsonProperty("id")
    private final UUID id;
    @JsonProperty("name")
    private final String name;
}
