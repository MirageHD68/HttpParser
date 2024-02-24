package com.hugo_delay.http;

import java.util.Objects;

public class HttpResponse extends HttpElement{
    public final int code;
    public final String codeVerbose;

    public HttpResponse(int code, String codeVerbose) {
        super();
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
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HTTP/1.1 " )
                .append(code)
                .append(" ")
                .append(codeVerbose)
                .append("\r\n")
                .append(this.getHeaderAsString())
                .append(body == null ? "" : ("\r\n" + body));
        if(body == null){stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());}

        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object element){
        if(element == null || getClass() != element.getClass()){
            return false;
        }

        HttpResponse comparisonElement = (HttpResponse) element;
        return headers.equals(comparisonElement.getHeaders()) &&
                Objects.equals(body, comparisonElement.getBody()) &&
                code == comparisonElement.getCode() &&
                Objects.equals(codeVerbose, comparisonElement.getCodeVerbose());

    }
}
