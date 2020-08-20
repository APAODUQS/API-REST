package com.apaoduqs.example.controller;

import java.util.concurrent.atomic.AtomicLong;

import com.apaoduqs.example.DTO.DataPerson;
import com.apaoduqs.example.DTO.StatusPerson;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestApiController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/my-api-rest")
    public StatusPerson getApiRest(@RequestParam(value = "name", defaultValue = "World") String name,
                                   @RequestParam(value = "status", defaultValue = "true") Boolean status) {
        return new StatusPerson(counter.incrementAndGet(),
                String.format(template, name), status);
    }

    @PostMapping(path = "/my-api-rest", consumes = "application/json", produces = "application/json")
    public DataPerson postApiRest(@RequestBody DataPerson dataPerson) {
        return new DataPerson(dataPerson.getId(),
                dataPerson.getName(),
                dataPerson.getAge(),
                dataPerson.getEmployed());
    }

}
