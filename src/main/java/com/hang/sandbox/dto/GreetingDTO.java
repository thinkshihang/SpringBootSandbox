package com.hang.sandbox.dto;

public class GreetingDTO {

    private final long id;
    private final String content;

    public GreetingDTO(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return this.id;
    }

    public String getContent() {
        return this.content;
    }
}
