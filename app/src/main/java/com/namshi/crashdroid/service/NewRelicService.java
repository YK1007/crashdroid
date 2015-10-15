package com.namshi.crashdroid.service;

import android.content.Context;

import com.namshi.crashdroid.R;

/**
 * NewRelic crash service.
 * Created by vgaidarji on 10/15/15.
 */
public class NewRelicService extends CrashService{

    public static final int ID = 2;

    public NewRelicService(Context context) {
        super(context);
    }

    @Override
    String getName() {
        return context.getString(R.string.new_relic);
    }

    @Override
    int getId() {
        return ID;
    }
}
