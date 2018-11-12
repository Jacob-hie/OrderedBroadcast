package com.hie2j.orderedbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MiddleReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle bundle = getResultExtras(false);
        String name = bundle.getString("NAME");
        int age = bundle.getInt("AGE");
        Log.e("MiddleReceiver","onReceive name = " + name + " age = " + age);
        bundle.putString("ADD","China");
        bundle.putString("WHO","myself");
        setResultExtras(bundle);
    }
}
