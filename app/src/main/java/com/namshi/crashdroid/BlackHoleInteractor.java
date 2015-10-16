package com.namshi.crashdroid;

/**
 * Created by vgaidarji on 10/16/15.
 */
public interface BlackHoleInteractor {
    void throwStackOverflowException();
    void throwBadTokenException();
    void throwOutOfMemory();
    void throwIllegalStateException();
}
