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

    private MainServiceBinder mBinder;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    private class MainServiceBinder extends IMyAidlInterface.Stub implements IMainservice{
        @Override
        public void keepAlive() throws RemoteException {

        }

        @Override
        public int plus(int a, int b) {
            return a+ b;
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        mBinder = new MainServiceBinder();
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
