package com.namshi.crashdroid;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.WindowManager.BadTokenException;

import com.namshi.crashdroid.fragment.DummyFragment;

/**
 * Every method in this class must trigger application crash.
 * Created by vgaidarji on 10/16/15.
 */
public class BlackHoleInteractorImpl implements BlackHoleInteractor {

    Context context;

    public BlackHoleInteractorImpl(Context context) {
        this.context = context;
    }

    @Override
    public void throwStackOverflowException() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                // stack size in Thread = 1036KB
                recursiveMethod();
            }
        }).start();
    }

    @Override
    public void throwBadTokenException() {
        throw new BadTokenException("Test BadTokenException");
    }

    @Override
    public void throwOutOfMemory() {
        throw new OutOfMemoryError("Test OutOfMemory error");
    }

    @Override
    public void throwIllegalStateException() {
        ((Activity)context).finish();
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                FragmentActivity activity = ((FragmentActivity) context);
                FragmentManager fm = activity.getSupportFragmentManager();
                fm.beginTransaction()
                        .add(new DummyFragment(), "")
                        .commit();
            }
        }.execute((Void)null);
    }


    /**
     * No exit point from recursion - StackOverflowException should be thrown.
     */
    private void recursiveMethod() {
        recursiveMethod();
    }
}
