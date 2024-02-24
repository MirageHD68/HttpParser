package com.hugo_delay.http;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HTTPResponseTest {

    @Test
    @DisplayName("Test of the HTTPResponse class")
    public void httpResponseTest(){
        HttpResponse httpResponse = new HttpResponse(404, "Not Found");
        httpResponse.addHeader("Date", "Sun, 18 Oct 2012 10:36:20 GMT");
        httpResponse.addHeader("Server", "Apache/2.2.14 (Win32)");
        httpResponse.addHeader("Content-Length", "230");
        httpResponse.addHeader("Connection", "Closed");
        httpResponse.addHeader("Content-Type", "text/html; charset=iso-8859-1");

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HTTP/1.1 ").append(404).append(" Not Found\r\n")
                .append("Date: Sun, 18 Oct 2012 10:36:20 GMT\r\n")
                .append("Server: Apache/2.2.14 (Win32)\r\n")
                .append("Content-Length: 230\r\n")
                .append("Connection: Closed\r\n")
                .append("Content-Type: text/html; charset=iso-8859-1");

        Assertions.assertEquals(stringBuilder.toString(), httpResponse.toString());
    }
}
