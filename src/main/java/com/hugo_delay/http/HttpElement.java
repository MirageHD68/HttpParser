package com.hugo_delay.http;

import java.util.LinkedHashMap;

public class HttpElement {
    protected LinkedHashMap<String, String> headers;
    protected String body;

    public LinkedHashMap<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(LinkedHashMap<String, String> headers) {
        this.headers = headers;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    public void addHeader(String key, String value){
        headers.put(key, value);
    }

    public HttpElement(){
        this.headers = new LinkedHashMap<>();
    }
    public String getHeaderAsString(){
        StringBuilder headerString = new StringBuilder();

        for(String key: headers.keySet()){
            headerString.append(key);
            headerString.append(": ");
            headerString.append(headers.get(key));
            headerString.append("\r\n");
        }

        return headerString.toString();
    }
}
