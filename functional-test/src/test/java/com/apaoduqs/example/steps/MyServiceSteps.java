package com.apaoduqs.example.steps;

import com.apaoduqs.example.DTO.StatusPerson;
import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import cucumber.api.java.en.*;
import org.testng.Assert;

import java.util.HashMap;

public class MyServiceSteps {

    private HttpResponse response;
    private String name;
    private final Gson gson = new Gson();


    @Given("^the username is: (.*)$")
    public void setUsername(String username) {
        System.out.println("The username is: " + username);
        name = username;
    }

    @When("^the user does a (.*) petition$")
    public void callService(String petition) throws UnirestException {
        System.out.println("The user does a " + petition + " petition");
        HashMap<String, Object> query = new HashMap<>();
        HashMap<String, String> header = new HashMap<>();
        query.put("name", name);
        header.put("Accept", "application/json");
        response = MyServiceLogic.getRequest(query, header);
        System.out.println("The Response is: " + response);
        System.out.println("The Body is: " + response.getBody());
    }

    @Then("^the response is (\\d+)$")
    public void getResponse(Integer codeExpected) {
        Integer codeResponse = response.getStatus();
        Assert.assertEquals(codeExpected, codeResponse);
        System.out.println("The response is " + codeExpected);
    }

    @And("^the content response is: (.*)$")
    public void getBodyResponse(String nameExpected) {
        StatusPerson statusPerson = gson.fromJson(response.getBody().toString(), StatusPerson.class);
        String currentName = statusPerson.getContent();
//        String currentName = response.getBody().toString();
//        currentName = currentName.substring(currentName.indexOf("content") + 10, currentName.indexOf("status") - 3);
        Assert.assertEquals(nameExpected, currentName);
        System.out.println("The response is " + nameExpected);
    }
}
