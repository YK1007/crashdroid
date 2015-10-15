package com.namshi.crashdroid;

import android.content.Context;

/**
 * Created by vgaidarji on 10/15/15.
 */
public class MainPresenterImpl implements MainPresenter {

    MainView mainView;
    CrashServicesInteractor crashServicesInteractor;

    public MainPresenterImpl(MainView mainView, Context context) {
        this.mainView = mainView;
        crashServicesInteractor = new CrashServicesInteractor(context);
    }

    @Override
    public void onCreate() {
        mainView.setupServices(crashServicesInteractor.registerServices());
    }

    @Override
    public void onResume() {

    }
}
