package com.apaoduqs.example.DTO;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class StatusPerson {

    private final long id;
    private final String content;
    private final Boolean status;

}
