package com.namshi.crashdroid;

import android.app.Application;

import com.namshi.crashdroid.service.NewRelicService;

/**
 * Created by vgaidarji on 10/19/15.
 */
public class CrashdroidApplication extends Application {

    CrashServicesInteractor crashServicesInteractor;

    @Override
    public void onCreate() {
        super.onCreate();
        setupServicesInteractor();
        enableServices();
    }

    private void enableServices() {
        crashServicesInteractor.getServiceById(NewRelicService.ID).enable();
    }

    private void setupServicesInteractor() {
        crashServicesInteractor = new CrashServicesInteractorImpl(this);
        crashServicesInteractor.initServices();
    }

    public CrashServicesInteractor getCrashServicesInteractor() {
        return crashServicesInteractor;
    }
}
