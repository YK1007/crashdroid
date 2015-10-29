package com.namshi.crashdroid.interactor;

import android.content.Context;
import android.util.SparseArray;

import com.namshi.crashdroid.service.AppSeeService;
import com.namshi.crashdroid.service.CrashService;
import com.namshi.crashdroid.service.CrashlyticsService;
import com.namshi.crashdroid.service.CrittercismService;
import com.namshi.crashdroid.service.GoogleAnalyticsService;
import com.namshi.crashdroid.service.HockeyAppService;
import com.namshi.crashdroid.service.NewRelicService;
import com.pixplicity.easyprefs.library.Prefs;

/**
 * Created by vgaidarji on 10/15/15.
 */
public class CrashServicesInteractorImpl implements CrashServicesInteractor{
    private SparseArray<CrashService> registeredServices;
    private SparseArray<CrashService> checkedServices;
    private Context context;

    public CrashServicesInteractorImpl(Context context) {
        this.context = context;
    }

    @Override
    public SparseArray<CrashService> initServices() {
        if(registeredServices != null) {
            initCheckedServices();
            return registeredServices;
        }
        registeredServices = new SparseArray<>(6);
        registeredServices.put(HockeyAppService.ID, setServiceEnabled(new HockeyAppService(context)));
        registeredServices.put(NewRelicService.ID, setServiceEnabled(new NewRelicService(context)));
        registeredServices.put(CrittercismService.ID, setServiceEnabled(new CrittercismService(context)));
        registeredServices.put(AppSeeService.ID, setServiceEnabled(new AppSeeService(context)));
        registeredServices.put(CrashlyticsService.ID, setServiceEnabled(new CrashlyticsService(context)));
        registeredServices.put(GoogleAnalyticsService.ID, setServiceEnabled(new GoogleAnalyticsService(context)));
        initCheckedServices();
        return registeredServices;
    }

    public void initCheckedServices() {
        if(checkedServices == null) {
            checkedServices = new SparseArray<>();
        }

        for(int i = 0, size = registeredServices.size(); i < size; i++) {
            CrashService service = registeredServices.get(i);
            if(service.isEnabled()) {
                checkedServices.put(service.getId(), service);
            }
        }
    }

    /**
     * Initializes service default state (enabled/disabled)
     * based on the saved service state in preferences.
     * @param service
     * @return
     */
    private CrashService setServiceEnabled(CrashService service) {
        boolean isEnabled = Prefs.getBoolean(service.getName(), false);
        service.setEnabled(isEnabled);
        return service;
    }

    @Override
    public void refreshServicesStates() {
        if(registeredServices == null) {
            return;
        }
        for(int i = 0, size = registeredServices.size(); i < size; i++) {
            CrashService service = registeredServices.get(i);
            setServiceEnabled(service);
        }
        if(checkedServices != null) {
            checkedServices.clear();
            checkedServices = null;
        }
    }

    @Override
    public CrashService getServiceById(int serviceId) {
        if(registeredServices == null) {
            return null;
        }
        return registeredServices.get(serviceId);
    }

    @Override
    public void startAllServices() {
        if(registeredServices == null) {
            return;
        }

        for(int i = 0, size = registeredServices.size(); i < size; i++) {
            CrashService service = registeredServices.get(i);
            if(service.isEnabled()) {
                service.enable();
            }
        }
    }

    @Override
    public void updateServiceState(int checkedServiceId, boolean isChecked) {
        // we don't update service state here
        // all the changes will be applied by pressing "Apply" button
        if(checkedServices == null) {
            checkedServices = new SparseArray<>();
        }
        CrashService service = getServiceById(checkedServiceId);
        if(isChecked) {
            checkedServices.put(service.getId(), service);
        }else{
            checkedServices.remove(service.getId());
        }
    }

    @Override
    public void saveServicesStates() {
        Prefs.clear();
        if(checkedServices == null) {
            return;
        }

        for(int i = 0, size = registeredServices.size(); i < size; i++) {
            CrashService service = checkedServices.get(i, null);
            if(service != null) {
                Prefs.putBoolean(service.getName(), true);
            }
        }
    }
}
