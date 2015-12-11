package io.chgocn.demo.aidl.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import io.chgocn.demo.aidl.IMyAidlInterface;
import io.chgocn.demo.aidl.R;
import io.chgocn.demo.aidl.service.MainService;

/**
 * @author chgocn(chgocn@gmail.com)
 */
public class MainActivity extends AppCompatActivity {
    private int result;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            iMyAidlInterface = IMyAidlInterface.Stub.asInterface(service);
            try {
                result = iMyAidlInterface.plus(3, 5);
                Log.d("TAG", "result is " + result);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    private IMyAidlInterface iMyAidlInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bindService).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindService(new Intent(MainActivity.this, MainService.class), connection, BIND_AUTO_CREATE);
            }
        });

        findViewById(R.id.getServiceData).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"获取的数据源为："+ result,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
