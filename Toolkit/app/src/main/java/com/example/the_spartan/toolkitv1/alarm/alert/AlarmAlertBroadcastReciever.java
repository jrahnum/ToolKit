package com.example.the_spartan.toolkitv1.alarm.alert;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.the_spartan.toolkitv1.alarm.Alarm;
import com.example.the_spartan.toolkitv1.alarm.service.AlarmServiceBroadcastReciever;

/**
 * Created by Spartan on 2/2/2018.
 */

public class AlarmAlertBroadcastReciever extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent mathAlarmServiceIntent = new Intent(
                context,
                AlarmServiceBroadcastReciever.class);
        context.sendBroadcast(mathAlarmServiceIntent, null);

        StaticWakeLock.lockOn(context);
        Bundle bundle = intent.getExtras();
        final Alarm alarm = (Alarm) bundle.getSerializable("alarm");

        Intent mathAlarmAlertActivityIntent;

        mathAlarmAlertActivityIntent = new Intent(context, AlarmAlertActivity.class);

        mathAlarmAlertActivityIntent.putExtra("alarm", alarm);

        mathAlarmAlertActivityIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        context.startActivity(mathAlarmAlertActivityIntent);
    }

}
