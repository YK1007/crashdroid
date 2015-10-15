package com.namshi.crashdroid;

import android.content.Context;
import android.util.SparseArray;

import com.namshi.crashdroid.service.CrashService;

/**
 * Created by vgaidarji on 10/15/15.
 */
public class MainPresenterImpl implements MainPresenter {

    MainView mainView;
    CrashServicesInteractor crashServicesInteractor;

    public MainPresenterImpl(MainView mainView, Context context) {
        this.mainView = mainView;
        crashServicesInteractor = new CrashServicesInteractorImpl(context);
    }

    @Override
    public void onCreate() {
        SparseArray<CrashService> services = crashServicesInteractor.createServices();
        crashServicesInteractor.startServices();
        mainView.setupServices(services);
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onServiceChecked(int checkedServiceId, boolean isChecked) {
        crashServicesInteractor.updateServiceState(checkedServiceId, isChecked);
    }

    @Override
    public void throwOutOfMemory() {
        throw new OutOfMemoryError("Test OutOfMemory error");
    }
}
