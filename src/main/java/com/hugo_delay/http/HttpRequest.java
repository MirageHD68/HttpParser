package com.hugo_delay.http;

public class HttpRequest extends HttpElement{
    ///TODO add method to return request to string
    private String httpMethod;
    private String path;
    public HttpRequest(String httpMethod, String path){
        this.httpMethod = httpMethod;
        this.path = path;
    }

    public String getPath(){
        return path;
    }

    public String getHttpMethod(){
        return httpMethod;
    }
}
