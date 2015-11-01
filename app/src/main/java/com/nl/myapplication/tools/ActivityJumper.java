package com.nl.myapplication.tools;

import java.io.Serializable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.google.common.base.Optional;

public class ActivityJumper {
    private Activity activity;
    private Optional<Integer> requestCode = Optional.absent();
    private Class<? extends Activity> targetClass;
    private Bundle bundle;

    private ActivityJumper(Activity activity) {
        this.activity = activity;
        bundle = new Bundle();
    }

    public static ActivityJumper of(Activity activity) {
        return new ActivityJumper(activity);
    }

    public ActivityJumper to(Class<? extends Activity> targetClass) {
        this.targetClass = targetClass;
        return this;
    }

    public ActivityJumper requestCode(int requestCode) {
        this.requestCode = Optional.of(requestCode);
        return this;
    }

    public void jump() {
        Intent intent = new Intent(activity, targetClass);
        intent.putExtras(bundle);
        if(requestCode.isPresent()) {
            activity.startActivityForResult(intent, requestCode.get());
        } else {
            activity.startActivity(intent);
        }
    }

    public ActivityJumper add(String key, Serializable serializable) {
        bundle.putSerializable(key, serializable);
        return this;
    }

    public ActivityJumper add(String key, String string) {
        bundle.putString(key, string);
        return this;
    }

    public ActivityJumper add(String key, boolean value) {
        bundle.putBoolean(key, value);
        return this;
    }
}
