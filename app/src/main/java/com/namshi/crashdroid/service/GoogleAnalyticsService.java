package com.namshi.crashdroid.service;

import android.content.Context;

import com.namshi.crashdroid.AnalyticsTrackers;
import com.namshi.crashdroid.R;

/**
 * GoogleAnalytics crash service
 * Created by vgaidarji on 10/15/15.
 */
public class GoogleAnalyticsService extends CrashService{

    public static final int ID = 5;

    public GoogleAnalyticsService(Context context) {
        super(context);
    }

    @Override
    public String getName() {
        return context.getString(R.string.google_analytics);
    }

    @Override
    public int getId() {
        return ID;
    }

    @Override
    public void enable() {
        if(isEnabled()) {
            AnalyticsTrackers.initialize(context.getApplicationContext());
            AnalyticsTrackers.getInstance().get(AnalyticsTrackers.Target.APP);
            AnalyticsTrackers.getInstance().enableAnalytics();
        }
    }

    @Override
    public void disable() {
        if(isEnabled()) {
            AnalyticsTrackers.getInstance().disableAnalytics();
        }
    }
}
