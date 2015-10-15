package com.namshi.crashdroid.service;

import android.content.Context;

import com.namshi.crashdroid.R;

/**
 * Crittercism crash service.
 * Created by vgaidarji on 10/15/15.
 */
public class CrittercismService extends CrashService {

    public static final int ID = 3;

    public CrittercismService(Context context) {
        super(context);
    }

    @Override
    public String getName() {
        return context.getString(R.string.crittercism);
    }

    @Override
    public int getId() {
        return ID;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
