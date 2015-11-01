package com.nl.myapplication.activity;

import android.os.Bundle;

import com.nl.myapplication.R;

/**
 * Created by benzistanbul on 2015/11/1.
 */
public class LoginTitleActivity extends BaseTitleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
    }

    @Override
    protected void setTitleBar() {
        hideLeftTitle();
        setMiddleTitleText(R.string.login);
        showMiddleTitle();
    }
}
