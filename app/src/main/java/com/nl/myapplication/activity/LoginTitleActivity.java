package com.nl.myapplication.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.nl.myapplication.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by benzistanbul on 2015/11/1.
 */
public class LoginTitleActivity extends BaseTitleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        ButterKnife.inject(this);
    }

    @Override
    protected void setTitleBar() {
        hideLeftTitle();
        setMiddleTitleText(R.string.login);
        showMiddleTitle();
    }

    @OnClick(R.id.login_button)
    protected void login(View view) {
        getActivityJumper().to(MainTabActivity.class).jump();
    }
}
