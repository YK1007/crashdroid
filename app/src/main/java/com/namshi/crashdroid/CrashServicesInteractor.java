package com.namshi.crashdroid;

import android.util.SparseArray;

import com.namshi.crashdroid.service.CrashService;

/**
 * Created by vgaidarji on 10/15/15.
 */
public interface CrashServicesInteractor {
    SparseArray<CrashService> createServices();
    void startServices();
    void updateServiceState(int checkedServiceId, boolean isChecked);
}
