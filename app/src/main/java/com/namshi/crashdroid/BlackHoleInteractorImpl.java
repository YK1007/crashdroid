package com.namshi.crashdroid;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.WindowManager.BadTokenException;
import android.widget.ImageView;

import com.namshi.crashdroid.fragment.DummyFragment;

import java.io.IOException;
import java.io.InputStream;

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
        try {
            InputStream bitmap = context.getAssets().open("really_big_image.jpg");
            Bitmap bit = BitmapFactory.decodeStream(bitmap);
            ImageView testImage = new ImageView(context);
            testImage.setImageBitmap(bit);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
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
