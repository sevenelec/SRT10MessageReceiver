package com.sevenelec.android.srt_10messagereceiver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static final String ACTION_RECEIVE = "kr.sevenelec.android.srt10connect.uart.ACTION_RECEIVE";

    SRT10MessageReceiver messageReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageReceiver = new SRT10MessageReceiver();

        this.registerReceiver(messageReceiver, new IntentFilter((ACTION_RECEIVE)));
    }

    @Override
    protected void onDestroy() {
        this.unregisterReceiver(messageReceiver);
        super.onDestroy();
    }
}