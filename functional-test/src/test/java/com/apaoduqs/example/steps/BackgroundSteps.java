package com.apaoduqs.example.steps;

import cucumber.api.java.en.Given;

public class BackgroundSteps {


    @Given("^the service: (.*)$")
    public void setService(String url) {
        System.out.println("The service: " + url);
        MyServiceLogic.setURL(url);
    }

}
