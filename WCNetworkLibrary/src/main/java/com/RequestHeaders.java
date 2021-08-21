package com;

import java.util.HashMap;

public class RequestHeaders {

    private final HashMap<String, String> urlParams = new HashMap<>();

    @SuppressWarnings("unused")
    public void put(String key, String value) {
        urlParams.put(key, value);
    }

    public HashMap<String, String> getHeaders() {
        return urlParams;
    }
}
