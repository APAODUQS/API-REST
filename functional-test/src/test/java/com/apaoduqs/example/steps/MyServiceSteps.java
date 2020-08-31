package com.apaoduqs.example.steps;

import com.apaoduqs.example.DTO.DataPerson;
import com.apaoduqs.example.DTO.StatusPerson;
import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import cucumber.api.java.en.*;
import org.testng.Assert;

import java.util.HashMap;

public class MyServiceSteps {

    private HttpResponse response;
    private final Gson gson = new Gson();
    private StatusPerson statusPerson;
    private DataPerson bodyRequest = new DataPerson();
    private DataPerson bodyResponse;

//    ------------------------- Get Petition ----------------------------- //

    @Given("^the username: (.*)$")
    public void setUsername(String username) {
        System.out.println("The username: " + username);
        bodyRequest.setName(username);
    }

    @When("^the user searches his name$")
    public void callService() throws UnirestException {
        System.out.println("The user searches his name");
        HashMap<String, Object> query = new HashMap<>();
        HashMap<String, String> header = new HashMap<>();
        query.put("name", bodyRequest.getName());
        header.put("Accept", "application/json");
        response = MyServiceLogic.getRequest(query, header);
        statusPerson = gson.fromJson(response.getBody().toString(), StatusPerson.class);
        System.out.println("The Response is: " + response);
        System.out.println("The Body is: " + response.getBody());
    }

    @Then("^the response is (\\d+)$")
    public void getResponse(Integer codeExpected) {
        Integer codeResponse = response.getStatus();
        Assert.assertEquals(codeExpected, codeResponse);
        System.out.println("The response is " + codeResponse);
    }

    @And("^the content response is: (.*)$")
    public void getBodyResponse(String nameExpected) {
        String currentName = statusPerson.getContent();
//        String currentName = response.getBody().toString();
//        currentName = currentName.substring(currentName.indexOf("content") + 10, currentName.indexOf("status") - 3);
        Assert.assertEquals(nameExpected, currentName);
        System.out.println("The response is " + nameExpected);
    }

//    ------------------------- Post Petition ----------------------------- //

    @Given("^the user id: (\\d+)$")
    public void setUserId(Long id) {
        System.out.println("The user id: " + id);
        bodyRequest.setId(id);
    }

    @And("^the user age: (\\d+)$")
    public void setUserAge(Integer age) {
        System.out.println("The user age " + age);
        bodyRequest.setAge(age);
    }

    @And("^the user is employed: (.*)$")
    public void setUserEmployed(Boolean employed) {
        System.out.println("The user employed: " + employed);
        bodyRequest.setEmployed(employed);
    }

    @When("^the user ingress his information$")
    public void callPostService() throws UnirestException {
        System.out.println("The user ingress his information");
        HashMap<String, String> header = new HashMap<>();
        header.put("Content-Type", "application/json");
        String body = gson.toJson(bodyRequest);
        response = MyServiceLogic.postRequest(header, body);
        bodyResponse = gson.fromJson(response.getBody().toString(), DataPerson.class);
        System.out.println("The Body is: " + response.getBody());
    }

    @And("^the content response has the username: (.*)$")
    public void verifyUsernameName(String nameExpected) {
        System.out.println("The content response has the username: " + nameExpected);
        String currentName = bodyResponse.getName();
        Assert.assertEquals(nameExpected, currentName);
        System.out.println("The response is " + nameExpected);
    }

    @And("^the content response has the age: (.*)$")
    public void verifyAge(Integer ageExpected) {
        System.out.println("The content response has the age: " + ageExpected);
        Integer currentAge = bodyResponse.getAge();
        Assert.assertEquals(ageExpected, currentAge);
        System.out.println("The response is " + ageExpected);
    }

    @And("^the content response has the employed: (.*)$")
    public void verifyEmployed(Boolean employedExpected) {
        System.out.println("The content response has the employed: " + employedExpected);
        Boolean currentEmployed = bodyResponse.getEmployed();
        Assert.assertEquals(employedExpected, currentEmployed);
        System.out.println("The response is " + employedExpected);
    }
}
