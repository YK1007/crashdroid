package com.namshi.crashdroid.service;

import android.content.Context;

import com.crittercism.app.Crittercism;
import com.namshi.crashdroid.R;

/**
 * Crittercism crash service.
 * Created by vgaidarji on 10/15/15.
 */
public class CrittercismService extends CrashService {

    private static final String APP_ID = "562343238d4d8c0a00d07e6a";
    public static final int ID = 2;

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
    public void enable() {
        if(isEnabled()) {
            Crittercism.initialize(context.getApplicationContext(), APP_ID);
            Crittercism.setOptOutStatus(true);
        }
    }

    @Override
    public void disable() {
        if(isEnabled()) {
            Crittercism.setOptOutStatus(false);
        }
    }
}
