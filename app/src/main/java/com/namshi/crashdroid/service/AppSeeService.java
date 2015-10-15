package com.namshi.crashdroid.service;

import android.content.Context;

import com.namshi.crashdroid.R;

/**
 * AppSee crash service.
 * Created by vgaidarji on 10/15/15.
 */
public class AppSeeService extends CrashService{

    public static final int ID = 4;

    public AppSeeService(Context context) {
        super(context);
    }

    @Override
    public String getName() {
        return context.getString(R.string.app_see);
    }

    @Override
    public int getId() {
        return ID;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
