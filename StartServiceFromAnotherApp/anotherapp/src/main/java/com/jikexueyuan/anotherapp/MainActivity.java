package com.jikexueyuan.anotherapp;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ServiceConnection {

    private Intent serviceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        serviceIntent = new Intent();
        serviceIntent.setComponent(new ComponentName("com.jikexueyuan.startservicefromanotherapp","com.jikexueyuan.startservicefromanotherapp.AppService"));

        findViewById(R.id.btnStartAppService).setOnClickListener(this);
        findViewById(R.id.btnStopAppService).setOnClickListener(this);
        findViewById(R.id.btnBindAppService).setOnClickListener(this);
        findViewById(R.id.btnUnbindAppService).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnStartAppService:
                startService(serviceIntent);

                break;
            case R.id.btnStopAppService:
                stopService(serviceIntent);

                break;
            case R.id.btnBindAppService:
                bindService(serviceIntent,this, Context.BIND_AUTO_CREATE);

                break;
            case R.id.btnUnbindAppService:
               unbindService(this);

                break;
        }

    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder service) {

        System.out.println("Bind Service");
        System.out.println(service);


//        binder.registCallback();
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {

    }

//    private IAppServiceRemoteBinder binder =null;
}
