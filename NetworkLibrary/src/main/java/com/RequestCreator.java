package com;

import android.content.Context;

import java.io.InputStream;

public abstract class RequestCreator<T> {

    private BackgroundTask mBackgroundTask;

    public abstract String onCreateUrl();

    public abstract void onCreateRequestParams(RequestParams requestParams);

    public abstract void onCreateRequestHeaders(RequestHeaders requestHeaders);

    public abstract void onCreateMultipartRequestParams(MultipartRequestParams multipartRequestParams);

    public abstract int onCreateRetryCount();

    public abstract String onCreateRequestMethod();

    public abstract T onDownloadSuccess(InputStream inputStream) throws Exception;

    public abstract void onResult(T result) throws Exception;

    public void setErrorMessage(String errorMessage) {
        this.mBackgroundTask.setErrorMassage(errorMessage, "");
    }

    void setBackgroundTask(BackgroundTask mBackgroundTask) {
        this.mBackgroundTask = mBackgroundTask;
    }

    @SuppressWarnings("unused")
    protected BackgroundTask getBackgroundTask() {
        return this.mBackgroundTask;
    }

    @SuppressWarnings("unused")
    public Context getContext() {
        return this.mBackgroundTask.getContext();
    }
}
