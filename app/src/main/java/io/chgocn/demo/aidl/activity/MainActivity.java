package io.chgocn.demo.aidl.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import io.chgocn.demo.aidl.R;
import io.chgocn.demo.aidl.service.IMainservice;
import io.chgocn.demo.aidl.service.MainService;

/**
 * @author chgocn(chgocn@gmail.com)
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static String TAG = MainActivity.class.getSimpleName();

    private int result;
    private IMainservice serviceInstance;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            serviceInstance = (IMainservice) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "process id is " + android.os.Process.myPid());
        findViewById(R.id.startService).setOnClickListener(this);
        findViewById(R.id.bindService).setOnClickListener(this);
        findViewById(R.id.stopService).setOnClickListener(this);
        findViewById(R.id.unBindService).setOnClickListener(this);
        findViewById(R.id.getServiceData).setOnClickListener(this);
    }

    @Override
    public void onClick(View viewClicked) {
        Intent intent = new Intent(this, MainService.class);
        switch (viewClicked.getId()){
            case R.id.startService:
                startService(intent);
                break;
            case R.id.bindService:
                bindService(intent, connection, BIND_AUTO_CREATE);
                break;
            case R.id.stopService:
                stopService(intent);
                break;
            case R.id.unBindService:
                unbindService(connection);
                break;
            case R.id.getServiceData:
                //result = serviceInstance.plus(3,5);
                //Toast.makeText(MainActivity.this,"获取的数据源为："+ result,Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
