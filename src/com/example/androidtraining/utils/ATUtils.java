package com.example.androidtraining.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;

public class ATUtils{
	private final Context context;
	
	public ATUtils(Context context) {
		this.context = context;
	}
	
	public boolean isTablet() {
	    final int screenSize = ((Activity)context).getResources().getConfiguration().screenLayout
	            & Configuration.SCREENLAYOUT_SIZE_MASK;
	    
	    return screenSize == Configuration.SCREENLAYOUT_SIZE_LARGE
	            || screenSize == Configuration.SCREENLAYOUT_SIZE_XLARGE;
	}

}