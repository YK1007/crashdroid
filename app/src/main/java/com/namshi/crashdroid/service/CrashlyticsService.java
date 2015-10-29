package com.namshi.crashdroid.service;

import android.content.Context;

import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.core.CrashlyticsCore;
import com.namshi.crashdroid.R;

import io.fabric.sdk.android.Fabric;

/**
 * Crashlytics crash service.
 * Created by vgaidarji on 10/15/15.
 */
public class CrashlyticsService extends CrashService{

    public static final int ID = 4;

    public CrashlyticsService(Context context) {
        super(context);
    }

    @Override
    public String getName() {
        return context.getString(R.string.crashlytics);
    }

    @Override
    public int getId() {
        return ID;
    }

    @Override
    public void enable() {
        Fabric.with(context.getApplicationContext(), new Crashlytics());
    }

    @Override
    public void disable() {
        CrashlyticsCore core = new CrashlyticsCore.Builder().disabled(true).build();
        Fabric.with(context.getApplicationContext(),
                new Crashlytics.Builder().core(core).build());
    }
}
