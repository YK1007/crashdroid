package com.namshi.crashdroid.service;

import android.content.Context;

/**
 * Contains general information about Crash Service.
 * Created by vgaidarji on 10/15/15.
 */
public abstract class CrashService {

    protected Context context;

    public CrashService(Context context) {
        this.context = context;
    }

    /**
     * Service name.
     * @return
     */
    abstract String getName();

    /**
     * Service id (must be unique).
     * @return
     */
    abstract int getId();

    /**
     * Represents service state.
     * <br>true - service enabled, false - otherwise.
     * @return
     */
    abstract boolean isEnabled();
}
