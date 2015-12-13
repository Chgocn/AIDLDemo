package io.chgocn.demo.aidl.engine;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import io.chgocn.demo.aidl.R;
import io.chgocn.demo.aidl.activity.MainActivity;

/**
 * Created by chgocn(chgocn@gmail.com).
 */
public abstract class BaseEngine {
    public static String TAG = BaseEngine.class.getSimpleName();

    protected Context mContext;

    public abstract void init(Context context);

    public abstract void statWork();

    public abstract void stopWork();

    protected void showNotification(){
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        Log.i(TAG, "null == mContext ? : " + (this.mContext == null));
        intent.setClass(mContext, MainActivity.class);
        Notification notification = new Notification.Builder(mContext)
                .setContentTitle(mContext.getString(R.string.app_name))
                .setContentText(mContext.getString(R.string.app_running_warning))
                .setContentIntent(PendingIntent.getActivity(this.mContext, 0, intent, PendingIntent.FLAG_ONE_SHOT))
                .setSmallIcon(R.mipmap.ic_launcher)
                .setWhen(System.currentTimeMillis())
                .build();
        ((Service) this.mContext).startForeground(19172439, notification);
    }
}
