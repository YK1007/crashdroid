package com.namshi.crashdroid;

import android.app.Application;
import android.content.ContextWrapper;

import com.namshi.crashdroid.interactor.CrashServicesInteractor;
import com.namshi.crashdroid.interactor.CrashServicesInteractorImpl;
import com.namshi.crashdroid.service.CrashlyticsService;
import com.namshi.crashdroid.service.GoogleAnalyticsService;
import com.namshi.crashdroid.service.NewRelicService;
import com.pixplicity.easyprefs.library.Prefs;

/**
 * Created by vgaidarji on 10/19/15.
 */
public class CrashdroidApplication extends Application {

    CrashServicesInteractor crashServicesInteractor;

    @Override
    public void onCreate() {
        super.onCreate();
        initializePreferences();
        setupServicesInteractor();
        enableServices();
    }

    private void initializePreferences() {
        new Prefs.Builder()
                .setContext(this)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(getPackageName())
                .setUseDefaultSharedPreference(true)
                .build();
    }

    private void setupServicesInteractor() {
        crashServicesInteractor = new CrashServicesInteractorImpl(this);
        crashServicesInteractor.initServices();
    }

    private void enableServices() {
        crashServicesInteractor.getServiceById(NewRelicService.ID).enable();
        crashServicesInteractor.getServiceById(GoogleAnalyticsService.ID).enable();
        crashServicesInteractor.getServiceById(CrashlyticsService.ID).enable();
    }

    public CrashServicesInteractor getCrashServicesInteractor() {
        return crashServicesInteractor;
    }
}
