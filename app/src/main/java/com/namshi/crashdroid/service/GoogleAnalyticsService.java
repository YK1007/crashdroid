package com.namshi.crashdroid.service;

import android.content.Context;

import com.namshi.crashdroid.R;

/**
 * GoogleAnalytics crash service
 * Created by vgaidarji on 10/15/15.
 */
public class GoogleAnalyticsService extends CrashService{

    public static final int ID = 6;

    public GoogleAnalyticsService(Context context) {
        super(context);
    }

    @Override
    String getName() {
        return context.getString(R.string.google_analytics);
    }

    @Override
    int getId() {
        return ID;
    }
}
