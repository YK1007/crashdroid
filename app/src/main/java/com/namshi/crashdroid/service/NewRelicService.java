package com.namshi.crashdroid.service;

import android.content.Context;

import com.namshi.crashdroid.R;
import com.newrelic.agent.android.NewRelic;

/**
 * NewRelic crash service.
 * Created by vgaidarji on 10/15/15.
 */
public class NewRelicService extends CrashService{

    public static final int ID = 1;
    private static final String TOKEN = "AAcf1379f8d4e1be18b219acddc3fd8ada80771c8f";

    public NewRelicService(Context context) {
        super(context);
    }

    @Override
    public String getName() {
        return context.getString(R.string.new_relic);
    }

    @Override
    public int getId() {
        return ID;
    }

    @Override
    public void enable() {
        if(isEnabled()) {
            NewRelic.withApplicationToken(TOKEN).start(context);
        }
    }

    @Override
    public void disable() {
        if(isEnabled()) {
            // we don't have other public API to stop NewRelic interaction.
            NewRelic.shutdown();
        }
    }
}
