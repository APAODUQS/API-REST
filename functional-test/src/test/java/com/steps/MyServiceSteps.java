package com.steps;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import cucumber.api.java.en.*;
import org.junit.Assert;

public class MyServiceSteps {

    MyServiceLogic myServiceLogic = new MyServiceLogic();
    HttpResponse response;
    String name;

    @Given("^the username is: (.*)$")
    public void setUsername(String username) {
        System.out.println("The username is: " + username);
        name = username;
    }

    @When("^the user does a (.*) petition$")
    public void callService(String petition) throws UnirestException {
        System.out.println("The user does a " + petition + " petition");
        response = Unirest.get(myServiceLogic.getURL())
                .queryString("name", name)
                .header("Accept", "application/json")
                .asString();
        System.out.println("The Response is: " + response);
        System.out.println("The Body is: " + response.getBody());
    }

    @Then("^the response is (\\d+)$")
    public void getResponse(Integer code) {
        Integer codeResponse = response.getStatus();
        Assert.assertEquals(code, codeResponse);
        System.out.println("The response is " + code);
    }

}
