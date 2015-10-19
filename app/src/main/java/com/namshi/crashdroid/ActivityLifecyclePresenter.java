package com.namshi.crashdroid;

/**
 * Contains Activity lifecycle related methods.
 * Created by vgaidarji on 10/19/15.
 */
public interface ActivityLifecyclePresenter {
    void onActivityCreate();
    void onActivityResume();
    void onActivityPause();
}
