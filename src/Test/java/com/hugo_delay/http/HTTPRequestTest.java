package com.hugo_delay.http;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

public class HTTPRequestTest {
    @Test
    @DisplayName("HTTPRequest Building test")
    void httpRequestTest(){
        HttpRequest httpRequest = new HttpRequest("GET", "/index.html");
        httpRequest.setHeaders(new LinkedHashMap<String, String>());
        httpRequest.addHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE5.01; Windows NT)");
        httpRequest.addHeader("Host", "www.hugo-delay.com");
        httpRequest.addHeader("Accept-Language", "en-us");
        httpRequest.addHeader("Accept-Encoding", "gzip, deflate");
        httpRequest.addHeader("Connection", "Keep-Alive");

        StringBuilder expectedRequest = new StringBuilder();
        expectedRequest.append("GET /index.html HTTP/1.1").append("\r\n").append("User-Agent: Mozilla/4.0 (compatible; MSIE5.01; Windows NT)");
        expectedRequest.append("\r\n").append("Host: www.hugo-delay.com\r\n").append("Accept-Language: en-us\r\n").append("Accept-Encoding: gzip, deflate\r\n");
        expectedRequest.append("Connection: Keep-Alive");

        Assertions.assertEquals(expectedRequest.toString(), httpRequest.toString());
    }
}
