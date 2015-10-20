package com.namshi.crashdroid.presenter;

import android.app.Activity;
import android.content.Context;

import com.namshi.crashdroid.CrashdroidApplication;
import com.namshi.crashdroid.MainView;
import com.namshi.crashdroid.interactor.BlackHoleInteractor;
import com.namshi.crashdroid.interactor.BlackHoleInteractorImpl;
import com.namshi.crashdroid.interactor.CrashServicesInteractor;
import com.namshi.crashdroid.service.AppSeeService;
import com.namshi.crashdroid.service.HockeyAppService;

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
        crashServicesInteractor = getCrashServicesInteractor();
        blackHoleInteractor = new BlackHoleInteractorImpl(context);
    }

    @Override
    public void onActivityCreate() {
        mainView.setupServices(crashServicesInteractor.initServices());
        crashServicesInteractor.getServiceById(AppSeeService.ID).enable();
    }

    @Override
    public void onActivityResume() {
        resumeServices();
    }

    @Override
    public void onActivityPause() {
        pauseServices();
    }

    private void resumeServices() {
        crashServicesInteractor.getServiceById(HockeyAppService.ID).enable();
        crashServicesInteractor.getServiceById(AppSeeService.ID).enable();
    }

    private void pauseServices() {
        crashServicesInteractor.getServiceById(HockeyAppService.ID).disable();
        crashServicesInteractor.getServiceById(AppSeeService.ID).disable();
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

    private CrashServicesInteractor getCrashServicesInteractor() {
        return ((CrashdroidApplication)(((Activity) context).getApplication())).getCrashServicesInteractor();
    }

}
