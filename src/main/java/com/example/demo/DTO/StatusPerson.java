package com.example.demo.DTO;

public class StatusPerson {

    private final long id;
    private final String content;
    private final Boolean status;

    public StatusPerson(long id, String content, Boolean status) {
        this.id = id;
        this.content = content;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Boolean getStatus() {
        return status;
    }

}
