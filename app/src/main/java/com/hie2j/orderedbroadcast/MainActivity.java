package com.hie2j.orderedbroadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private HighReceiver highReceiver;
    private MiddleReceiver middleReceiver;
    private LowerReceiver lowerReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lowerReceiver = new LowerReceiver();
        IntentFilter lowerFilter = new IntentFilter();
        lowerFilter.addAction("ORDERED_BROADCAST");
        lowerFilter.setPriority(20);
        registerReceiver(lowerReceiver,lowerFilter);

        middleReceiver = new MiddleReceiver();
        IntentFilter middleFilter = new IntentFilter();
        middleFilter.addAction("ORDERED_BROADCAST");
        middleFilter.addAction("LOCAL_BROADCAST");
        middleFilter.setPriority(50);
        registerReceiver(middleReceiver,middleFilter);

        highReceiver = new HighReceiver();
        IntentFilter highFilter = new IntentFilter();
        highFilter.addAction("ORDERED_BROADCAST");
        highFilter.addAction("LOCAL_BROADCAST");
        highFilter.setPriority(100);
        registerReceiver(highReceiver,highFilter);

        findViewById(R.id.btn_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("ORDERED_BROADCAST");
                sendOrderedBroadcast(intent,null);
            }
        });
    }

//    @Override
//    protected void onPause() {
//        super.onPause();
//        unregisterReceiver(highReceiver);
//        unregisterReceiver(middleReceiver);
//        unregisterReceiver(lowerReceiver);
//    }
}
