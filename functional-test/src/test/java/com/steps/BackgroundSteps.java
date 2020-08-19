package com.steps;

import cucumber.api.java.en.Given;

public class BackgroundSteps {

    MyServiceLogic myServiceLogic = new MyServiceLogic();

    @Given("^the service: (.*)$")
    public void setService(String url) {
        System.out.println("The service: " + url);
        myServiceLogic.setURL(url);
    }

}
