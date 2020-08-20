package com.apaoduqs.example.DTO;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class DataPerson {

    private long id;
    private String name;
    private int age;
    private Boolean employed;

    public DataPerson(long id, String name, int age, Boolean employed) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.employed = employed;
    }


}
