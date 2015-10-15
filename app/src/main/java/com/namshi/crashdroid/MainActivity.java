package com.namshi.crashdroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.namshi.crashdroid.service.AppSeeService;
import com.namshi.crashdroid.service.CrashService;
import com.namshi.crashdroid.service.CrashlyticsService;
import com.namshi.crashdroid.service.CrittercismService;
import com.namshi.crashdroid.service.GoogleAnalyticsService;
import com.namshi.crashdroid.service.HockeyAppService;
import com.namshi.crashdroid.service.NewRelicService;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.servicesLayout)
    LinearLayout servicesLayout;

    private SparseArray<CrashService> registeredServices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setupServices();
    }

    private void setupServices() {
        registerServices();
        createServicesCheckboxes();
    }

    private void registerServices() {
        registeredServices = new SparseArray<>(6);
        registeredServices.put(0, new HockeyAppService(this));
        registeredServices.put(1, new NewRelicService(this));
        registeredServices.put(2, new CrittercismService(this));
        registeredServices.put(3, new AppSeeService(this));
        registeredServices.put(4, new CrashlyticsService(this));
        registeredServices.put(5, new GoogleAnalyticsService(this));
    }

    private void createServicesCheckboxes() {
        for(int i = 0, size = registeredServices.size(); i < size; i++) {
            CrashService s = registeredServices.get(i);
            CheckBox cb = createCheckboxForService(s);
            servicesLayout.addView(cb);
        }
    }

    private CheckBox createCheckboxForService(CrashService service) {
        CheckBox cb = new CheckBox(this);
        cb.setText(service.getName());
        cb.setTag(service.getId());
        return cb;
    }
}
