package com.nl.myapplication.activity;

import android.os.Bundle;

import com.nl.myapplication.R;

import butterknife.ButterKnife;

/**
 * Created by benzistanbul on 2015/11/10.
 */
public class PostpartumRehabilitationListActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage_activity);
        ButterKnife.inject(this);
    }
}
