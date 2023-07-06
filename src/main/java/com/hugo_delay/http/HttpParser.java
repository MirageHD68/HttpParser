package com.hugo_delay.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

public class HttpParser {

    public static HttpResponse parseAnswer(BufferedReader reader) throws IOException {
        String firstLine = reader.readLine();
        HttpResponse answer = new HttpResponse(Integer.parseInt(firstLine.split(" ")[1]), firstLine.split(" ")[2]);

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

    private static HashMap<String, String> parseHeader(BufferedReader reader) throws IOException {
        String line;
        HashMap<String, String> headers = new HashMap<>();

        while(!(line = reader.readLine()).equals("\r\n")){
            headers.put(line.split(": ")[0], line.split(": ")[1]);
        }

        return headers;
    }

    private static String parseBody(BufferedReader reader) throws IOException {
        StringBuilder body = new StringBuilder();
        String line;

        while((line = reader.readLine()) != null){
            body.append(line);
        }

        return body.toString();
    }
}
