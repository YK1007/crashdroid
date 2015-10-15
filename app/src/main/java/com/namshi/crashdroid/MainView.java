package com.namshi.crashdroid;

import android.util.SparseArray;

import com.namshi.crashdroid.service.CrashService;

/**
 * Created by vgaidarji on 10/15/15.
 */
public interface MainView {
    void setupServices(SparseArray<CrashService> services);
    void showProgress();
    void hideProgress();
}
