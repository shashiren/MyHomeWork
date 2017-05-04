package com.jikexueyuan.learnservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service {

    private boolean serviceRuning = false;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new Binder();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {



        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("Service Create");
        serviceRuning = true;

        new Thread(){
            @Override
            public void run() {
                super.run();
                while (serviceRuning){

                    System.out.println("服务正在运行...");

                    try {
                        sleep(1000);
                    }    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


            }
        }.start();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("Service Destroy");
        serviceRuning = false;
    }
}
