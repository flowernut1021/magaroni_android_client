package com.nl.myapplication.activity;

import android.os.Bundle;

import com.nl.myapplication.R;
import com.nl.myapplication.application.BaseApplication;


public class LaunchActivity extends BaseActivity {

    private static final int DURATION = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        BaseApplication.runOnUiThreadDelayed(loginJumper, DURATION);
    }

    @Override
    public void onBackPressed() {
        // Disabled back button
    }

    private Runnable loginJumper = new Runnable() {
        @Override
        public void run() {
            getActivityJumper().to(LoginTitleActivity.class).jump();
            finish();
        }
    };
}
