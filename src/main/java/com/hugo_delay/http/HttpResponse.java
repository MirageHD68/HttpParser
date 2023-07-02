package com.hugo_delay.http;

public class HttpResponse extends HttpElement{
    ///TODO implement method to return the response to String
    public int code;
    public String codeVerbose;

    public HttpResponse(int code, String codeVerbose) {
        this.code = code;
        this.codeVerbose = codeVerbose;
    }

    public int getCode() {
        return code;
    }

    public String getCodeVerbose() {
        return codeVerbose;
    }

}
