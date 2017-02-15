package com.example.rajeev.wakemeup;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Calendar;
import android.support.v4.app.NotificationCompat;

public class AlertReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        String TodaysClass = "";

        Calendar calendar = Calendar.getInstance();
        switch (calendar.get(Calendar.DAY_OF_WEEK)) {
            case Calendar.SUNDAY:
                TodaysClass += "Today no class, Enjoy the Holiday :)";
                break;

            case Calendar.MONDAY:
                TodaysClass += "08-09:OOSD, " +
                               "09-10:ECO, " +
                               "10-11:CD, " +
                               "12-01:HPCA, " +
                               "01-02:CG";
                break;

            case Calendar.TUESDAY:
                TodaysClass += "08-11:CG LAB, " +
                               "11-12:HPCA, " +
                               "03-04:CD, " +
                               "04-05:CG, " +
                               "05-06:ECO";
                break;

            case Calendar.WEDNESDAY:
                TodaysClass += "08-09:OOSD, " +
                               "09-10:CG, " +
                               "10-11:CD, " +
                               "03-06:SE LAB";

            case Calendar.THURSDAY:
                TodaysClass += "11-02:CD LAB, " +
                               "03-04:HPCA, " +
                               "04-05:OOSD, " +
                               "05-06:CD";
                break;

            case Calendar.FRIDAY:
                TodaysClass += "11-12:HPCA, " +
                               "12-01:OOSD, " +
                               "01-02:ECO, " +
                               "12-01:HPCA, " +
                               "03-06:CAT-2";
                break;

            case Calendar.SATURDAY:
                TodaysClass += "Today no class, Enjoy the Holiday :)";
                break;
        }

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        Intent intent1 = new Intent(context, Todays_Class.class);
        intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent notificIntent = PendingIntent.getActivity(context, 100, intent1,
                PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
                .setContentIntent(notificIntent)
                .setSmallIcon(R.drawable.cs5)
                .setContentTitle("Today's Class")
                .setContentText(TodaysClass)
                .setAutoCancel(true);

        mBuilder.setDefaults(Notification.DEFAULT_SOUND);

        notificationManager.notify(100, mBuilder.build());
    }
}
