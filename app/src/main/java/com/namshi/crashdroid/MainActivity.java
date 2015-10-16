package com.namshi.crashdroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.namshi.crashdroid.service.CrashService;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView, OnCheckedChangeListener {

    @Bind(R.id.servicesLayout)
    LinearLayout servicesLayout;
    @Bind(R.id.progressBarFrameLayout)
    FrameLayout progressBarLayout;

    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new MainPresenterImpl(this, this);
        presenter.onCreate();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void setupServices(SparseArray<CrashService> services) {
        createServicesCheckboxes(services);
    }

    @Override
    public void showProgress() {
        progressBarLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBarLayout.setVisibility(View.GONE);
    }

    private void createServicesCheckboxes(SparseArray<CrashService> services) {
        for(int i = 0, size = services.size(); i < size; i++) {
            CrashService s = services.get(i);
            CheckBox cb = createCheckboxForService(s);
            servicesLayout.addView(cb);
        }
    }

    private CheckBox createCheckboxForService(CrashService service) {
        CheckBox cb = new CheckBox(this);
        cb.setText(service.getName());
        cb.setTag(service.getId());
        cb.setEnabled(service.isEnabled());
        cb.setChecked(service.isEnabled());
        cb.setOnCheckedChangeListener(this);
        return cb;
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
        presenter.onServiceChecked((int) compoundButton.getTag(), checked);
    }

    @OnClick(R.id.buttonOutOfMemory)
    public void onOutOfMemoryClick(View v) {
        presenter.throwOutOfMemory();
    }

    @OnClick(R.id.buttonBadTokenException)
    public void onBadTokenExceptionClick(View v) {
        presenter.throwBadTokenException();
    }

    @OnClick(R.id.buttonStackOverflowError)
    public void onStackOverflowExceptionClick(View v) {
        presenter.throwStackOverflowException();
    }

    @OnClick(R.id.buttonIllegalFragmentException)
    public void onIllegalStateExceptionClick(View v) {
        presenter.throwIllegalStateException();
    }
}
