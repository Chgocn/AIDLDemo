package io.chgocn.demo.aidl.engine;

import android.content.Context;
import android.util.Log;

/**
 * Created by chgocn(chgocn@gmail.com).
 */
public class FishingEngine extends BaseEngine{
    public static String TAG = FishingEngine.class.getSimpleName();

    public FishingEngine(){

    }

    @Override
    public void init(Context context) {
        this.mContext = context;
    }

    @Override
    public void statWork() {
        showNotification();
        fishing();
    }

    @Override
    public void stopWork() {
        Log.e(TAG, "stop fishing...");
    }

    protected void fishing() {
        Log.d(TAG, "I am fishing...");
    }
}
