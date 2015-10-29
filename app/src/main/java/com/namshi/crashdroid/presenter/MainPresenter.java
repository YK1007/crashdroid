package com.namshi.crashdroid.presenter;

/**
 * Created by vgaidarji on 10/15/15.
 */
public interface MainPresenter extends ActivityLifecyclePresenter{
    void onServiceChecked(int checkedServiceId, boolean isChecked);
    void throwOutOfMemory();
    void throwBadTokenException();
    void throwStackOverflowException();
    void throwIllegalStateException();
    void throwNullPointerException();
    void onApplyChangesClick();
}
