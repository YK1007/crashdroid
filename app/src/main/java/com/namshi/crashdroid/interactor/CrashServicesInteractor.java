package com.namshi.crashdroid.interactor;

import android.util.SparseArray;

import com.namshi.crashdroid.service.CrashService;

/**
 * Created by vgaidarji on 10/15/15.
 */
public interface CrashServicesInteractor {
    SparseArray<CrashService> initServices();
    CrashService getServiceById(int serviceId);
    void startAllServices();
    void updateServiceState(int checkedServiceId, boolean isChecked);

    /**
     * Synchronizes services states with states saved in preferences.
     */
    void refreshServicesStates();
    void saveServicesStates();
}
