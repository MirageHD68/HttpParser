package com.hugo_delay.http;

import java.io.BufferedReader;

public class HttpParser {
    public static HttpElement parseRequest(BufferedReader reader){

        return new HttpElement("GET");
    }
}
