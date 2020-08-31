package com.apaoduqs.example.steps;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.HashMap;

public class MyServiceLogic {

    public static String URL;

    public static void setURL(String url){
        URL = url;
    }

    public static HttpResponse getRequest(HashMap<String, Object> queryParam, HashMap<String, String> headerParam) throws UnirestException {
        return Unirest.get(URL)
                .queryString(queryParam)
                .headers(headerParam)
                .asString();
    }

    public static HttpResponse postRequest(HashMap<String, String> headerParam, String bodyParam) throws UnirestException {
        return Unirest.post(URL)
                .headers(headerParam)
                .body(bodyParam)
                .asJson();
    }

}
