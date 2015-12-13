package io.chgocn.demo.aidl.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import io.chgocn.demo.aidl.IMyAidlInterface;
import io.chgocn.demo.aidl.engine.FishingEngine;
import io.chgocn.demo.aidl.engine.ShoppingEngine;

/**
 * Created by chgocn(chgocn@gmail.com).
 */
public class MainService extends Service{
    public static String TAG = MainService.class.getSimpleName();

    private MainServiceBinder mBinder;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        if (mBinder == null) {
            mBinder = new MainServiceBinder();
        }
        return mBinder;
    }

    private class MainServiceBinder extends IMyAidlInterface.Stub implements IMainservice{
        private FishingEngine fishingEngine;
        private ShoppingEngine shoppingEngine;

        public FishingEngine getFishingEngine(){
            return fishingEngine;
        }

        public ShoppingEngine getShoppingEngine(){
            return shoppingEngine;
        }

        public MainServiceBinder(){
            fishingEngine = new FishingEngine();
            shoppingEngine = new ShoppingEngine();
        }
        @Override
        public void keepAlive() throws RemoteException {

        }

        @Override
        public void fishing() {
            fishingEngine.init(MainService.this);
            fishingEngine.statWork();
            Log.e(TAG,"yes,good boy,you finished fishing...");
        }

        @Override
        public void shopping() {
            shoppingEngine.init(MainService.this);
            shoppingEngine.statWork();
            Log.e(TAG,"yes,good boy,you finished shopping...");
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate() executed");
        Log.d(TAG,"process id is " + android.os.Process.myPid());
    }

    /**
     * here is really work.
     * @param intent
     * @param flags
     * @param startId
     * @return
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(null == mBinder){
            mBinder = new MainServiceBinder();
            mBinder.fishing();
            mBinder.shopping();
        }
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
