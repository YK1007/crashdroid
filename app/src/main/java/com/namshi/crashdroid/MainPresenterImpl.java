package com.namshi.crashdroid;

import android.content.Context;
import android.util.SparseArray;

import com.namshi.crashdroid.service.CrashService;

/**
 * Created by vgaidarji on 10/15/15.
 */
public class MainPresenterImpl implements MainPresenter {

    MainView mainView;
    Context context;
    CrashServicesInteractor crashServicesInteractor;
    BlackHoleInteractor blackHoleInteractor;

    public MainPresenterImpl(MainView mainView, Context context) {
        this.mainView = mainView;
        this.context = context;
        crashServicesInteractor = new CrashServicesInteractorImpl(context);
        blackHoleInteractor = new BlackHoleInteractorImpl(context);
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
        blackHoleInteractor.generateOutOfMemory();
    }

    @Override
    public void throwBadTokenException() {
        blackHoleInteractor.generateBadTokenException();
    }

    @Override
    public void throwStackOverflowException() {
        blackHoleInteractor.generateStackOverflowException();
    }

    @Override
    public void throwIllegalStateException() {
        blackHoleInteractor.generateIllegalStateException();
    }

    @Override
    public void throwNullPointerException() {
        blackHoleInteractor.generateNullPointerException();
    }

}
