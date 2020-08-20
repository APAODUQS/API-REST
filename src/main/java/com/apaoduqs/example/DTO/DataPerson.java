package com.apaoduqs.example.DTO;

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

    public void setId(long id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public void setAge(int age){ this.age = age; }

    public void setEmployed(Boolean employed) { this.employed = employed; }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge(){ return  age; }

    public Boolean getEmployed() {
        return employed;
    }

}
