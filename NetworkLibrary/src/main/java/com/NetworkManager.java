package com;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.ArrayList;
import java.util.List;

public class NetworkManager {

    @SuppressWarnings("unused")
    private static final String TAG = "NetworkManager";

    private static NetworkManager mNetworkManager;

    private final List<BackgroundTask> mBackgroundTaskList = new ArrayList<>();

    public static synchronized NetworkManager getInstance(Context pContext) {
        if (!(pContext instanceof Application)) {
            throw new RuntimeException("Context should be instance of application");
        }
        if (NetworkManager.mNetworkManager == null) {
            NetworkManager.mNetworkManager = new NetworkManager(pContext);
        }
        return NetworkManager.mNetworkManager;
    }

    private NetworkManager(Context pContext) {
        final Application mApplication = (Application) pContext;
        mApplication.registerActivityLifecycleCallbacks(this.mActivityLifecycleListener);
    }

    public BackgroundTask createBackgroundTask(Context pContext, boolean pCancelOnDestroy) {
        final BackgroundTask mBackgroundTask = new BackgroundTask(this.mBackgroundTaskList, pContext, pCancelOnDestroy);
        this.mBackgroundTaskList.add(mBackgroundTask);
        Debug.log(TAG, "BackgroundTaskCount: " + mBackgroundTaskList.size());
        return mBackgroundTask;
    }

    @SuppressWarnings("FieldCanBeLocal")
    private final ActivityLifecycleListener mActivityLifecycleListener = new ActivityLifecycleListener() {
        @Override
        public void onActivityDestroyed(Activity activity) {
            Debug.log(TAG, "onActivityDestroyed: " + activity.getClass().getName());
            for (final BackgroundTask backgroundTask : mBackgroundTaskList) {
                if (backgroundTask.getContext() == null) {
                    continue;
                }

                if (activity == backgroundTask.getContext() && backgroundTask.isCancelOnDestroy() && !backgroundTask.isFinished()) {
                    backgroundTask.cancelRequests();
                }
            }
        }
    };

    @SuppressWarnings("WeakerAccess")
    public static boolean isInternetConnection(Context context) {
        final ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }
}
