package com.jikexueyuan.connectservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service {
    private boolean runing = false;
    private int i ;
    private String data = "这是默认信息";

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new Binder();

    }

    public class Binder extends android.os.Binder{

        public void setData(String data){
            MyService.this.data = data;
        }

        public MyService getService(){
            return MyService.this;
        }

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        data = intent.getStringExtra("data");


        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        runing = true;

        new Thread(){
            @Override
            public void run() {
                super.run();
                int i = 0;

                while (runing){
                    i++;
                    String str = i+":"+data;
                    System.out.println(str);
                    if (callback!=null){
                        callback.onDataChange(str);
                    }


                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        runing = false;
    }

    private Callback callback = null;

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public Callback getCallback() {
        return callback;
    }

    public static interface Callback{
        void onDataChange(String data);
    }
}
