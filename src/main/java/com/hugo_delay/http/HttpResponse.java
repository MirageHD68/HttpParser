package com.hugo_delay.http;

public class HttpResponse extends HttpElement{
    public final int code;
    public final String codeVerbose;

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

    @Override
    public String toString(){
        return "HTTP/1.1 " + code + " " + codeVerbose +
                "\r\n" +
                this.getHeaderAsString() + "\r\n" +
                body;
    }

}
