package com.nl.myapplication.tools;

import android.content.Context;

import com.nl.myapplication.application.BaseApplication;

public class UnitUtil {

	static Context context= BaseApplication.getContext();

	public static int dip2px(float dipValue) {
		float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dipValue * scale + 0.5f);
	}

	public static float px2dip(int pxvalue) {
		float scale = context.getResources().getDisplayMetrics().density;
		return pxvalue/scale;		
	}

}
