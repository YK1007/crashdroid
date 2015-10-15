package com.namshi.crashdroid.service;

import android.content.Context;

import com.namshi.crashdroid.R;

/**
 * CrittercismService crash service.
 * Created by vgaidarji on 10/15/15.
 */
public class CrittercismService extends CrashService {

    public static final int ID = 3;

    public CrittercismService(Context context) {
        super(context);
    }

    @Override
    String getName() {
        return context.getString(R.string.crittercism);
    }

    @Override
    int getId() {
        return ID;
    }
}
