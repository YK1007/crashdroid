package com.namshi.crashdroid;

import android.content.Intent;

/**
 * Created by vgaidarji on 10/15/15.
 */
public interface MainPresenter {
    void onCreate();
    void onResume();
    void onServiceChecked(int checkedServiceId, boolean isChecked);
    void throwOutOfMemory();
    void throwBadTokenException();
}
