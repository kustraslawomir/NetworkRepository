package com;

import java.util.HashMap;

public class RequestParams {

    private final HashMap<String, String> urlParams = new HashMap<>();

    @SuppressWarnings("unused")
    public void put(String key, String value) {
        urlParams.put(key, value);
    }

    @SuppressWarnings("unused")
    public void put(String key, double value) {
        urlParams.put(key, String.valueOf(value));
    }

    @SuppressWarnings("unused")
    public void put(String key, int value) {
        urlParams.put(key, String.valueOf(value));
    }

    @SuppressWarnings("unused")
    public void put(String key, float value) {
        urlParams.put(key, String.valueOf(value));
    }

    public HashMap<String, String> getUrlParams() {
        return urlParams;
    }
}
