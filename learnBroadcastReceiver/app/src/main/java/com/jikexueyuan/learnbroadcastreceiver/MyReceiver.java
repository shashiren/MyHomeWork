package com.jikexueyuan.learnbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {

    public static final String ACTION ="com.jikexueyuan.learnbroadcastreceiver.intent.action.MyrRceiver";

    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("MyReceiver 接收到了消息");
//        abortBroadcast();
    }
}
