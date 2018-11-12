package com.hie2j.orderedbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class HighReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("HighReceiver","onReceive");
        Bundle bundle = new Bundle();
        bundle.putString("NAME","Jacob");
        bundle.putInt("AGE",19);
        setResultExtras(bundle);
    }
}
