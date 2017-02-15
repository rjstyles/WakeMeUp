package com.example.rajeev.wakemeup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

public class Todays_Class extends AppCompatActivity {

    TextView textView;
    String day = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todays_class);

        textView = (TextView)findViewById(R.id.todays_class);
        Bundle data = getIntent().getExtras();

        if(data != null) {
                day = data.getString("Day");
        }

        setTodaysClass(day);
    }

    public void setTodaysClass(String day) {
        String todaysClass = "";
        Calendar calendar = Calendar.getInstance();

        if(day.equals("")) {
            switch (calendar.get(Calendar.DAY_OF_WEEK)) {
                case Calendar.MONDAY: day = "MONDAY"; break;
                case Calendar.TUESDAY: day = "TUESDAY"; break;
                case Calendar.WEDNESDAY: day = "WEDNESDAY"; break;
                case Calendar.THURSDAY: day = "THURSDAY"; break;
                case Calendar.FRIDAY: day = "FRIDAY"; break;
            }
        }
        else {
            TextView textView = (TextView) findViewById(R.id.textView4);
            textView.setText(day.charAt(0)+ day.toLowerCase().substring(1)+"'s Class");
        }

        switch (day) {
            case "SUNDAY":
                todaysClass += "Today no class,\nEnjoy the Holiday :)";
                break;

            case "MONDAY":
                todaysClass += "08-09  :  OOSD(C4)\n\n" +
                               "09-10  :   ECO(C4)\n\n" +
                               "10-11  :    CD(C4)\n\n" +
                               "12-01  :  HPCA(C4)\n\n" +
                               "01-02  :    CG(C4)";
                break;

            case "TUESDAY":
                todaysClass += "08-11  :  CG LAB(DL9)\n\n" +
                               "11-12  :    HPCA(C16)\n\n" +
                               "03-04  :      CD(C10)\n\n" +
                               "04-05  :      CG(C10)\n\n" +
                               "05-06  :     ECO(C10)";
                break;

            case "WEDNESDAY":
                todaysClass += "08-09  :    OOSD(C13)\n\n" +
                               "09-10  :      CG(C13)\n\n" +
                               "10-11  :      CD(C13)\n\n" +
                               "03-06  :  SE LAB(DL3)";
                break;

            case "THURSDAY":
                todaysClass += "11-02  :  CD LAB(DL6)\n\n" +
                               "03-04  :     HPCA(C9)\n\n" +
                               "04-05  :     OOSD(C9)\n\n" +
                               "05-06  :       CD(C9)";
                break;

            case "FRIDAY":
                todaysClass += "11-12  :   HPCA(C13)\n\n" +
                               "12-01  :   OOSD(C13)\n\n" +
                               "01-02  :    ECO(C13)\n\n" +
                               "03-06  :  CAT-2(DL2)";
                break;
        }

        textView.setText(todaysClass);
    }
}
