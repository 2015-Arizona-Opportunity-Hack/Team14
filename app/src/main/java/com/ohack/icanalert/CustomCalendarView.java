package com.ohack.icanalert;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.CalendarView;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by KChapman14 on 10/11/2015.
 */
public class CustomCalendarView extends CalendarView
{
    ArrayList<ScheduledEvent> listOfEvents;

    public CustomCalendarView(Context context)
    {
        super(context);
        listOfEvents = new ArrayList<ScheduledEvent>();

    }

    private class ScheduledEvent
    {
        Date dateOfEvent;
        String nameOfEvent;
    }
}
