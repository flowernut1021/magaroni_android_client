package com.nl.myapplication.application;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

/**
 * Created by benzistanbul on 2015/11/1.
 */
public class BaseApplication extends Application {

    private static final Handler handler = new Handler();
    public static Context globalContext;

    @Override
    public void onCreate() {
        super.onCreate();
        init(this);
    }

    private void init(Context context) {
        globalContext = context;
    }

    public static Handler getHandler() {
        return handler;
    }

    public static void runOnUiThread(Runnable runnable) {
        handler.post(runnable);
    }

    public static void runOnUiThreadDelayed(Runnable runnable, long delayMillis) {
        handler.postDelayed(runnable, delayMillis);
    }

    public static void runOnUiThreadAtTime(Runnable runnable, long uptimeMillis) {
        handler.postAtTime(runnable, uptimeMillis);
    }

    public static Context getContext() {
        return globalContext;
    }

}
