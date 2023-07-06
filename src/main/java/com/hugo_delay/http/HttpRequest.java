package com.hugo_delay.http;

public class HttpRequest extends HttpElement{
    private final String httpMethod;
    private final String path;
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

    @Override
    public String toString(){
        return httpMethod + " " + " HTTP/1.1\r\n" + path +
                this.getHeaderAsString() + "\r\n" +
                this.getBody();
    }
}
