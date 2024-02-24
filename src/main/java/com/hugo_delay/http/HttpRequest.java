package com.hugo_delay.http;

import java.util.Objects;

public class HttpRequest extends HttpElement{
    private final String httpMethod;
    private final String path;
    public HttpRequest(String httpMethod, String path){
        super();
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
        StringBuilder stringBuilder = new StringBuilder(httpMethod);
        stringBuilder.append(" ").append(path).append(" HTTP/1.1\r\n")
                .append(this.getHeaderAsString())
                .append(this.getBody() == null ? "" : this.getBody());
        if(this.getBody() == null){stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());}
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object element){
        if(element == null || getClass() != element.getClass()){
            return false;
        }

        HttpRequest comparisonElement = (HttpRequest) element;
        return headers.equals(comparisonElement.getHeaders()) &&
                Objects.equals(body, comparisonElement.getBody()) &&
                Objects.equals(this.httpMethod, comparisonElement.getHttpMethod()) &&
                Objects.equals(this.path, comparisonElement.getPath());
    }
}
