package com.namshi.crashdroid.interactor;

/**
 * Created by vgaidarji on 10/16/15.
 */
public interface BlackHoleInteractor {
    void generateStackOverflowException();
    void generateBadTokenException();
    void generateOutOfMemory();
    void generateIllegalStateException();
    void generateNullPointerException();
}
