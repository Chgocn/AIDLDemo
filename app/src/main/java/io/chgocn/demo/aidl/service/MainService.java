package io.chgocn.demo.aidl.service;

import android.app.Service;
import android.content.Intent;
import android.os.*;
import android.support.annotation.Nullable;
import android.util.Log;

import io.chgocn.demo.aidl.IMyAidlInterface;

/**
 * Created by chgocn(chgocn@gmail.com).
 */
public class MainService extends Service{
    public static String TAG = MainService.class.getSimpleName();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    IMyAidlInterface.Stub mBinder = new IMyAidlInterface.Stub() {
        @Override
        public int plus(int a, int b) throws RemoteException {
            return a+b;
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate() executed");
        Log.d(TAG,"process id is " + android.os.Process.myPid());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand() executed");
        Log.d(TAG,"process id is " + android.os.Process.myPid());
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() executed");
    }
}
