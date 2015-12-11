package io.chgocn.demo.aidl.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import io.chgocn.demo.aidl.IMyAidlInterface;

/**
 * Created by chgocn(chgocn@gmail.com).
 */
public class MainService extends Service{

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
        Log.d("TAG", "onCreate() executed");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("TAG", "onStartCommand() executed");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("TAG", "onDestroy() executed");
    }
}
