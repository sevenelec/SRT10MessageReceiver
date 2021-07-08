package com.sevenelec.android.srt_10messagereceiver;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.Intent.EXTRA_TEXT;

public class SRT10MessageReceiver extends BroadcastReceiver {

    private int count = 0;

    @Override
    public void onReceive(Context context, Intent intent) {

        count++;

        if (intent.getAction().equals(MainActivity.ACTION_RECEIVE)) {
            BluetoothDevice d = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
            String s = intent.getStringExtra(EXTRA_TEXT);

            Toast.makeText(context, d.getName() +  "  " + s, Toast.LENGTH_SHORT).show();

            // d.getName() : Tag Name
            // Message Format : ABCDED,G,H,I,J
            // ABCDEF :  Anchor Address, 000000 - do not know the anchor address (Actually it is Adv Mode)
            // G : Conver Range (unit:m) of the Anchor
            // H : 0 -> Cover Range is the danger Area (In Conn Mode), -1 -> Emergency button pressed
            //     0 -> Distance is in the danger area (In Adv Mode), -1 -> Emergency button pressed
            //     1 -> Cover Range is the safe area (In Conn Mode), 127 -> Emergency button pressed
            //     1 -> Distance is in the safe area (In Adv Mode), 127 -> Emergency button pressed
            // I : Distance (unit : m)
            // J : Battery Level (unit : %)

        }
    }
}