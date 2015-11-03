package com.namshi.crashdroid.service;

import android.content.Context;

import com.namshi.crashdroid.R;

import net.hockeyapp.android.CrashManager;
import net.hockeyapp.android.CrashManagerListener;
import net.hockeyapp.android.UpdateManager;

/**
 * HockeyApp crash service.
 * Created by vgaidarji on 10/15/15.
 */
public class HockeyAppService extends CrashService{

    public static final int ID = 0;
    private static final String APP_ID = "3adeb3ed480c4a2c143eadc71cf05d6b";

    public HockeyAppService(Context context) {
        super(context);
    }

    @Override
    public String getName() {
        return context.getString(R.string.hockey_app);
    }

    @Override
    public int getId() {
        return ID;
    }

    @Override
    public void enable() {
        if(isEnabled() && !isStarted) {
            super.enable();
            CrashManager.register(context, APP_ID, new CrashManagerListener() {
                @Override
                public boolean shouldAutoUploadCrashes() {
                    return true;
                }
            });
            isStarted = true;
        }
    }

    @Override
    public void disable() {
        if(isEnabled() && isStarted) {
            super.disable();
            UpdateManager.unregister();
            isStarted = false;
        }
    }
}
