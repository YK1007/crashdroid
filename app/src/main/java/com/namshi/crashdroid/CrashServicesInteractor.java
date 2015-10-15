package com.namshi.crashdroid;

import android.content.Context;
import android.util.SparseArray;

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
public class CrashServicesInteractor {

    private SparseArray<CrashService> registeredServices;
    private Context context;

    public CrashServicesInteractor(Context context) {
        this.context = context;
    }

    public SparseArray<CrashService> registerServices() {
        registeredServices = new SparseArray<>(6);
        registeredServices.put(0, new HockeyAppService(context));
        registeredServices.put(1, new NewRelicService(context));
        registeredServices.put(2, new CrittercismService(context));
        registeredServices.put(3, new AppSeeService(context));
        registeredServices.put(4, new CrashlyticsService(context));
        registeredServices.put(5, new GoogleAnalyticsService(context));
        return registeredServices;
    }
}
