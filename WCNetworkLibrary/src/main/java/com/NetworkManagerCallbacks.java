package com;

public interface NetworkManagerCallbacks {

    void onStart() throws Exception;

    void onError(String error, String errorCode) throws Exception;

    void onSuccess() throws Exception;

    void onCancelled() throws Exception;

}
