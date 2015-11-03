package com.namshi.crashdroid.service;

import android.content.Context;

import com.appsee.Appsee;
import com.namshi.crashdroid.R;

/**
 * AppSee crash service.
 * Created by vgaidarji on 10/15/15.
 */
public class AppSeeService extends CrashService{

    public static final int ID = 3;
    private static final String API_KEY = "ea3a20cecf2b4c39b7e51d12281243cc";

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
    public void enable() {
        if(isEnabled() && !isStarted) {
            super.enable();
            Appsee.start(API_KEY);
            isStarted = true;
        }
    }

    @Override
    public void disable() {
        if(isEnabled() && isStarted) {
            super.disable();
            Appsee.stopAndUpload();
            isStarted = false;
        }
    }
}
