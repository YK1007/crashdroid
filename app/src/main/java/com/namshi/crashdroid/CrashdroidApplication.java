package com.namshi.crashdroid;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.namshi.crashdroid.interactor.CrashServicesInteractor;
import com.namshi.crashdroid.interactor.CrashServicesInteractorImpl;
import com.namshi.crashdroid.service.GoogleAnalyticsService;
import com.namshi.crashdroid.service.NewRelicService;
import io.fabric.sdk.android.Fabric;

/**
 * Created by vgaidarji on 10/19/15.
 */
public class CrashdroidApplication extends Application {

    CrashServicesInteractor crashServicesInteractor;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        setupServicesInteractor();
        enableServices();
    }

    private void enableServices() {
        crashServicesInteractor.getServiceById(NewRelicService.ID).enable();
        crashServicesInteractor.getServiceById(GoogleAnalyticsService.ID).enable();
    }

    private void setupServicesInteractor() {
        crashServicesInteractor = new CrashServicesInteractorImpl(this);
        crashServicesInteractor.initServices();
    }

    public CrashServicesInteractor getCrashServicesInteractor() {
        return crashServicesInteractor;
    }
}
