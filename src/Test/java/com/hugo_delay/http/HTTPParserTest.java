package com.hugo_delay.http;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedHashMap;

public class HTTPParserTest {
    @Test
    @DisplayName("parseResponse function test")
    public void parseResponseTest() {
        StringReader stringReader = new StringReader("HTTP/1.1 404 Not Found\r\n" +
                "Date: Sun, 18 Oct 2012 10:36:20 GMT\r\n" +
                "Server: Apache/2.2.14 (Win32)\r\n" +
                "Content-Length: 230\r\n" +
                "Connection: Closed\r\n" +
                "Content-Type: text/html; charset=iso-8859-1");

        HttpResponse httpResponse = new HttpResponse(404, "Not Found");
        httpResponse.addHeader("Date", "Sun, 18 Oct 2012 10:36:20 GMT");
        httpResponse.addHeader("Server", "Apache/2.2.14 (Win32)");
        httpResponse.addHeader("Content-Length", "230");
        httpResponse.addHeader("Connection", "Closed");
        httpResponse.addHeader("Content-Type", "text/html; charset=iso-8859-1");

        HttpResponse parsedResponse;

        try {
            parsedResponse = HttpParser.parseAnswer(new BufferedReader(stringReader));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertEquals(httpResponse, parsedResponse);
    }

    @Test
    @DisplayName("parseRequest function test")
    public void parseRequestTest() throws IOException {
        HttpRequest httpRequest = new HttpRequest("GET", "/index.html");
        httpRequest.setHeaders(new LinkedHashMap<String, String>());
        httpRequest.addHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE5.01; Windows NT)");
        httpRequest.addHeader("Host", "www.hugo-delay.com");
        httpRequest.addHeader("Accept-Language", "en-us");
        httpRequest.addHeader("Accept-Encoding", "gzip, deflate");
        httpRequest.addHeader("Connection", "Keep-Alive");

        StringBuilder parserInput = new StringBuilder();
        parserInput.append("GET /index.html HTTP/1.1").append("\r\n").append("User-Agent: Mozilla/4.0 (compatible; MSIE5.01; Windows NT)");
        parserInput.append("\r\n").append("Host: www.hugo-delay.com\r\n").append("Accept-Language: en-us\r\n").append("Accept-Encoding: gzip, deflate\r\n");
        parserInput.append("Connection: Keep-Alive");

        Assertions.assertEquals(httpRequest, HttpParser.parseRequest(new BufferedReader(new StringReader(parserInput.toString()))));
    }
}
