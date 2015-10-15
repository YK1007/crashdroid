package com.namshi.crashdroid.service;

import android.content.Context;

import com.namshi.crashdroid.R;

/**
 * Crashlytics crash service.
 * Created by vgaidarji on 10/15/15.
 */
public class CrashlyticsService extends CrashService{

    public static final int ID = 5;

    public CrashlyticsService(Context context) {
        super(context);
    }

    @Override
    String getName() {
        return context.getString(R.string.crashlytics);
    }

    @Override
    int getId() {
        return ID;
    }
}
