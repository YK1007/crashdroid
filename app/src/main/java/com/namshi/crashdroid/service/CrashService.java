package com.namshi.crashdroid.service;

import android.content.Context;

/**
 * Contains general information about Crash Service.
 * Created by vgaidarji on 10/15/15.
 */
public abstract class CrashService {

    protected Context context;
    /**
     * Shows if service should be started at application launch.
     */
    private boolean isEnabled = false;
    /**
     * Represents service state. <code>true</code> - the service is up and running,
     * <code>false</code> - otherwise.
     */
    protected boolean isStarted = false;

    public CrashService(Context context) {
        this.context = context;
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
}
