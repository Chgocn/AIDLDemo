package io.chgocn.demo.aidl.engine;

import android.content.Context;
import android.util.Log;

/**
 * Created by chgocn(chgocn@gmail.com).
 */
public class ShoppingEngine extends BaseEngine{
    public static String TAG = ShoppingEngine.class.getSimpleName();

    public ShoppingEngine(){

    }

    @Override
    public void init(Context context) {
        this.mContext = context;
    }

    public void statWork(){
        shopping();
    }

    @Override
    public void stopWork() {
        Log.e(TAG, "stop shopping...");
    }

    protected void shopping() {
        Log.d(TAG, "I am shopping...");
    }
}
