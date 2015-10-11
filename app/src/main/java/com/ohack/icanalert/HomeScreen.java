package com.ohack.icanalert;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

public class HomeScreen extends AppCompatActivity {

    private int language;
    Button feed;
    Button alerts;
    Button calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        feed = (Button)(findViewById(R.id.feedBtn));
        alerts = (Button)(findViewById(R.id.alertBtn));
        calendar = (Button)(findViewById(R.id.calendarBtn));

        Intent intent = getIntent();
        language = intent.getIntExtra("language",3); //0 eng, 1 span, //3 is improper input?
        String[] spanishTxt = {"información", "alertas", "calandria"};
        String[] englishTxt = {"information", "alerts", "calendar"};


        if(language == 0){
            feed.setText(englishTxt[0]);
            alerts.setText(englishTxt[1]);
            calendar.setText(englishTxt[2]);
        }
        else if(language == 1){
            feed.setText(spanishTxt[0]);
            alerts.setText(spanishTxt[1]);
            calendar.setText(spanishTxt[2]);
        }

    }

    public void init(){

    }

    public void feedButton(View view){
        Intent intent = new Intent(this, Feed.class);
        intent.putExtra("language",language);
        startActivity(intent);
    }

    public void alertButton(View view){
        Intent intent = new Intent(this, Alerts.class);
        intent.putExtra("language",language);
        startActivity(intent);
    }

    public void calendarButton(View view){
        Intent intent = new Intent(this, CalendarActivity.class);
        intent.putExtra("language",language);
        startActivity(intent);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }


        return super.onOptionsItemSelected(item);
    }



}
