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
        String day = "";
        Calendar calendar = Calendar.getInstance();
        switch (calendar.get(Calendar.DAY_OF_WEEK)) {
            case Calendar.SUNDAY:
                TodaysClass += "Today no class, Enjoy the Holiday :)";
                day = "SUNDAY";
                break;

            case Calendar.MONDAY:
                TodaysClass += "OOSD, " +
                               "ECO, " +
                               "CD, " +
                               "HPCA, " +
                               "CG";
                day = "MONDAY";
                break;

            case Calendar.TUESDAY:
                TodaysClass += "CG LAB, " +
                               "HPCA, " +
                               "CD, " +
                               "CG, " +
                               "ECO";
                day = "TUESDAY";
                break;

            case Calendar.WEDNESDAY:
                TodaysClass += "OOSD, " +
                               "CG, " +
                               "CD, " +
                               "SE LAB";
                day = "WEDNESDAY";
                break;

            case Calendar.THURSDAY:
                TodaysClass += "CD LAB, " +
                               "HPCA, " +
                               "OOSD, " +
                               "CD";
                day = "THURSDAY";
                break;

            case Calendar.FRIDAY:
                TodaysClass += "HPCA, " +
                               "OOSD, " +
                               "ECO, " +
                               "HPCA, " +
                               "CAT-2";
                day = "FRIDAY";
                break;

            case Calendar.SATURDAY:
                TodaysClass += "Today no class, Enjoy the Holiday :)";
                day = "SATURDAY";
                break;
        }

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent intent1 = new Intent(context, Todays_Class.class);
        intent1.putExtra("Day", day);
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
