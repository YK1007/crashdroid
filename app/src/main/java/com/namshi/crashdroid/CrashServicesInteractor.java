package com.namshi.crashdroid;

import android.util.SparseArray;

import com.namshi.crashdroid.service.CrashService;

/**
 * Created by vgaidarji on 10/15/15.
 */
public interface CrashServicesInteractor {
    SparseArray<CrashService> registerServices();
    void updateServiceState(int checkedServiceId, boolean isChecked);
}
