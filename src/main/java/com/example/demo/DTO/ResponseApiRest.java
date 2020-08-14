package com.example.demo.DTO;

public class ResponseApiRest {

    private final long id;
    private final String content;
    private final Boolean status;

    public ResponseApiRest(long id, String content, Boolean status) {
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

    public Boolean getStatusOK() {
        return status;
    }

}
