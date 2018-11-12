package com.hie2j.orderedbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class LowerReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = getResultExtras(false);
        String name = bundle.getString("NAME");
        String address = bundle.getString("ADD");
        String who = bundle.getString("WHO");
        Log.e("LowerReceiver","onReceive name = " + name + " address = " + address
                + " who = " + who);
    }
}
