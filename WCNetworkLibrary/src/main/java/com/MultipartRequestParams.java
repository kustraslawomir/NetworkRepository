package com;

import java.util.HashMap;

public class MultipartRequestParams {

    private final HashMap<String, Object> fileParams = new HashMap<>();

    @SuppressWarnings("unused")
    public void put(String key, Object value) {
        fileParams.put(key, value);
    }

    public HashMap<String, Object> getFileRequestParams() {
        return fileParams;
    }
}
