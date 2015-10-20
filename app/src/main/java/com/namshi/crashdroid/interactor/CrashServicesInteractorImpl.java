package com.namshi.crashdroid.interactor;

import android.content.Context;
import android.util.SparseArray;
import android.widget.Toast;

import com.namshi.crashdroid.service.AppSeeService;
import com.namshi.crashdroid.service.CrashService;
import com.namshi.crashdroid.service.CrashlyticsService;
import com.namshi.crashdroid.service.CrittercismService;
import com.namshi.crashdroid.service.GoogleAnalyticsService;
import com.namshi.crashdroid.service.HockeyAppService;
import com.namshi.crashdroid.service.NewRelicService;

/**
 * Created by vgaidarji on 10/15/15.
 */
public class CrashServicesInteractorImpl implements CrashServicesInteractor{
    private SparseArray<CrashService> registeredServices;
    private Context context;

    public CrashServicesInteractorImpl(Context context) {
        this.context = context;
    }

    @Override
    public SparseArray<CrashService> initServices() {
        if(registeredServices != null) {
            return registeredServices;
        }
        registeredServices = new SparseArray<>(6);
        registeredServices.put(HockeyAppService.ID, new HockeyAppService(context));
        registeredServices.put(NewRelicService.ID, new NewRelicService(context));
        registeredServices.put(CrittercismService.ID, new CrittercismService(context));
        registeredServices.put(AppSeeService.ID, new AppSeeService(context));
        registeredServices.put(CrashlyticsService.ID, new CrashlyticsService(context));
        registeredServices.put(GoogleAnalyticsService.ID, new GoogleAnalyticsService(context));
        return registeredServices;
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
        CrashService service = getServiceById(checkedServiceId);
        if(service != null) {
            if(isChecked) {
                service.enable();
            }else {
                service.disable();
            }
            Toast.makeText(context, String.format("%s%s", service.getName(),
                    isChecked ? " enabled" : " disabled"), Toast.LENGTH_SHORT).show();
        }
    }
}
