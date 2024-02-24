package com.hugo_delay.http;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

public class HTTPElementTest {

    @Test
    @DisplayName("HTTPElement test of getHeaderAsString")
    void getHeaderAsStringTest(){
        HttpElement httpElement = new HttpElement();
        LinkedHashMap<String, String> testHeaderHashmap = new LinkedHashMap<>();
        StringBuilder expectedHeaders = new StringBuilder();
        expectedHeaders.append("Security: None\r\n").append("Version: 1.2.5\r\n").append("Language: FR\r\n");
        testHeaderHashmap.put("Security", "None");
        testHeaderHashmap.put("Version", "1.2.5");
        httpElement.setHeaders(testHeaderHashmap);
        httpElement.addHeader("Language", "FR");

        Assertions.assertEquals(expectedHeaders.toString(), httpElement.getHeaderAsString());
    }
}
