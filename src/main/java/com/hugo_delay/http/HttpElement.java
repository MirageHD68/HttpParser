package com.hugo_delay.http;
import java.util.HashMap;

public class HttpElement {
    protected String httpMethod;
    protected HashMap<String, String> headers;
    protected String body;

    protected HttpElement(String httpMethod){
        this.httpMethod = httpMethod;
    }
    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public HashMap<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(HashMap<String, String> headers) {
        this.headers = headers;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
