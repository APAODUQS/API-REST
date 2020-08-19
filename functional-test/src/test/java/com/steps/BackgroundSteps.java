package com.steps;

import cucumber.api.java.en.Given;

public class BackgroundSteps {

    private MyServiceLogic myServiceLogic;

    @Given("^the service: (.*)$")
    public void setService(String url) {
        System.out.println("The service: " + url);
        myServiceLogic.setURL(url);
    }

}
