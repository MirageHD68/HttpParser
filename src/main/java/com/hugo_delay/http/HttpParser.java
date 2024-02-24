package com.hugo_delay.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedHashMap;

public class HttpParser {

    public static HttpResponse parseAnswer(BufferedReader reader) throws IOException {
        String firstLine = reader.readLine();
        HttpResponse answer = new HttpResponse(Integer.parseInt(firstLine.split(" ")[1]), firstLine.split(" ",3)[2]);

        answer.setHeaders(parseHeader(reader));
        answer.setBody(parseBody(reader));

        return answer;
    }
    public static HttpRequest parseRequest(BufferedReader reader) throws IOException {
        String firstLine = reader.readLine();
        HttpRequest request = new HttpRequest(firstLine.split(" ")[0], firstLine.split(" ")[1]);

        request.setHeaders(parseHeader(reader));
        request.setBody(parseBody(reader));

        return request;
    }

    private static LinkedHashMap<String, String> parseHeader(BufferedReader reader) throws IOException {
        String line;
        LinkedHashMap<String, String> headers = new LinkedHashMap<>();
        boolean loopingCondition = true;

        while(loopingCondition){
            line = reader.readLine();
            if(line == null){
                loopingCondition = false;
            } else {
                if((line).equals("\r\n")){
                    loopingCondition = false;
                } else {
                    headers.put(line.split(": ")[0], line.split(": ")[1]);
                }
            }
        }

        return headers;
    }

    private static String parseBody(BufferedReader reader) throws IOException {
        StringBuilder body = new StringBuilder();
        String line;

        while((line = reader.readLine()) != null){
            body.append(line);
        }

        return body.isEmpty() ? null : body.toString();
    }
}
