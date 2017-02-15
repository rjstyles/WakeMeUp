package com.example.rajeev.wakemeup;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import java.util.Calendar;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button todays_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTodaysButton();
    }

    public void setTodaysButton() {
        Calendar calendar = Calendar.getInstance();
        switch (calendar.get(Calendar.DAY_OF_WEEK)) {
            case Calendar.MONDAY:
                todays_button = (Button) findViewById(R.id.mon);
                break;
            case Calendar.TUESDAY:
                todays_button = (Button) findViewById(R.id.tue);
                break;
            case Calendar.WEDNESDAY:
                todays_button = (Button) findViewById(R.id.wed);
                break;
            case Calendar.THURSDAY:
                todays_button = (Button) findViewById(R.id.thu);
                break;
            case Calendar.FRIDAY:
                todays_button = (Button) findViewById(R.id.fri);
                break;
            case Calendar.SATURDAY:
                todays_button = (Button) findViewById(R.id.sat);
                break;
        }
        Drawable bg = ContextCompat.getDrawable(getApplicationContext(), R.drawable.back);
        todays_button.setTextColor(Color.WHITE);
        todays_button.setBackground(bg);
    }

    public void onHolidayButtonClicked(View view) {
        Intent i = new Intent(this, HolidayActivity.class);
        startActivity(i);
    }

    public void setAlarm(View view) {

        TimePickerDialog mTimePicker = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {

            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                Calendar alarm = Calendar.getInstance();
                Calendar currTime = Calendar.getInstance();

                alarm.set(Calendar.HOUR_OF_DAY, selectedHour);
                alarm.set(Calendar.MINUTE, selectedMinute);
                alarm.set(Calendar.SECOND, 0);

                String AM_PM = "";

                AM_PM = alarm.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";

                String msg = "";

                if(selectedMinute > 0)
                    msg = "You will be notified at "+selectedHour+":"+selectedMinute+AM_PM;
                else
                    msg = "You will be notified at "+selectedHour+AM_PM;

                Intent alertIntent = new Intent(getApplicationContext(), AlertReceiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 1, alertIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT);

                AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

                if (alarm.getTimeInMillis() <= currTime.getTimeInMillis()) {
                    alarm.add(Calendar.DAY_OF_MONTH, 1);
                }

                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, alarm.getTimeInMillis(),
                        AlarmManager.INTERVAL_DAY, pendingIntent);

                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        }, 8, 0, true);

        mTimePicker.setTitle("Set Time");
        mTimePicker.show();
    }

    public void onWeekButtonClicked(View view) {
        Intent i = new Intent(this, Todays_Class.class);
        String day = "";

        switch (view.getId()) {
            case R.id.mon:
                day = "MONDAY";
                break;
            case R.id.tue:
                day = "TUESDAY";
                break;
            case R.id.wed:
                day = "WEDNESDAY";
                break;
            case R.id.thu:
                day = "THURSDAY";
                break;
            case R.id.fri:
                day = "FRIDAY";
                break;
            case R.id.sat:
                day = "SATURDAY";
        }

        i.putExtra("Day", day);
        startActivity(i);
    }
}