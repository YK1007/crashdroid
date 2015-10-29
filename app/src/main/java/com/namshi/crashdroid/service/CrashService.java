package com.namshi.crashdroid.service;

import android.content.Context;

import com.namshi.crashdroid.presenter.ActivityLifecyclePresenter;

/**
 * Contains general information about Crash Service.
 * Created by vgaidarji on 10/15/15.
 */
public abstract class CrashService implements ActivityLifecyclePresenter {

    protected Context context;
    private boolean isEnabled;

    public CrashService(Context context) {
        this.context = context;
        this.isEnabled = true;
    }

    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    /**
     * Service name.
     * @return
     */
    public abstract String getName();

    /**
     * Service id (must be unique).
     * @return
     */
    public abstract int getId();

    /**
     * Represents service state.
     * <br>true - service enabled, false - otherwise.
     * @return
     */
    public boolean isEnabled() {
        return this.isEnabled;
    }

    /**
     * Enable service.
     */
    public abstract void enable();

    /**
     * Disable service.
     */
    public abstract void disable();

    @Override
    public void onActivityCreate() {

    }

    @Override
    public void onActivityResume() {

    }

    @Override
    public void onActivityPause() {

    }
}
