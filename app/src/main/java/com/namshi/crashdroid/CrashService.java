package com.namshi.crashdroid;

/**
 * Base class. Contains general information about Crash Service.
 * Created by vgaidarji on 10/15/15.
 */
public abstract class CrashService {
    /**
     * Service name.
     * @return
     */
    abstract String getName();

    /**
     * Service id (must be unique).
     * @return
     */
    abstract String getId();


}
