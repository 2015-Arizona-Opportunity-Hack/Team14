package com.ohack.icanalert;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by KChapman14 on 10/11/2015.
 */
public class CalendarActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_calendar);

        ArrayList<CalendarEvent> events = new ArrayList<CalendarEvent>();
        Date date1 = new Date();
        events.add(new CalendarEvent(date1,"Test Event"));
        Date date2 = new Date();
        events.add(new CalendarEvent(date2,"Second Test Event"));
        Date date3 = new Date();
        events.add(new CalendarEvent(date3,"Third Test Event"));
        Date date4 = new Date();
        events.add(new CalendarEvent(date4,"Last Event in the List"));

        LinearLayout layout = (LinearLayout)(findViewById(R.id.layoutId));

        for (int i = 0;i<events.size();i++)
        {
            CalendarEvent event = events.get(i);

            if (event == null)
                continue;

            String dateString = SimpleDateFormat.getDateTimeInstance().format(event.date);

            Button button = new Button(this);
            button.setText(dateString + ": " + event.title);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            final float scale = this.getResources().getDisplayMetrics().density;
            int margin =  (int)(15 * scale + 0.5f);

            params.setMargins(0,margin,0,margin);

            button.setLayoutParams(params);

            layout.addView(button);
        }

    }

    private class CalendarEvent
    {
        Date date;
        String title;

        public CalendarEvent (Date d, String t)
        {
            date = d;
            title = t;
        }
    }
}
