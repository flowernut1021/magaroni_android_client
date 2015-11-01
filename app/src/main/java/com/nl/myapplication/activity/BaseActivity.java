package com.nl.myapplication.activity;

import android.app.Activity;

import com.nl.myapplication.tools.ActivityJumper;

/**
 * Created by benzistanbul on 2015/11/1.
 */
public class BaseActivity extends Activity {

    protected ActivityJumper getActivityJumper() {
        return ActivityJumper.of(this);
    }

    protected void jumpTo(Class<? extends Activity> targetClass) {
        getActivityJumper().to(targetClass).jump();
    }
}
