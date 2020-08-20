package com.apaoduqs.example.steps;

public class MyServiceLogic {

    public static String URL;

    /**
     * ToDo: WARNING: No te recomiendo hacer esto, puedes probocar un RuntimeException
     * @param url
     */
    public static void setURL(String url){
        URL = url;
    }

    public static String getURL(){
        return URL;
    }
}
