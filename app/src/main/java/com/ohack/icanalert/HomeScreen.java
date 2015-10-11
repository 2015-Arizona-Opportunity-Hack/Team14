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
    //Button calender = new Button(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        feed = (Button)(findViewById(R.id.feedBtn));
        alerts = (Button)(findViewById(R.id.alertBtn));

        Intent intent = getIntent();
        language = intent.getIntExtra("language",3); //0 eng, 1 span, //3 is improper input?
        String[] spanishTxt = {"información", "alertas", "calandria"};
        String[] englishTxt = {"information", "alerts", "calender"};


        if(language == 0){
            feed.setText(englishTxt[0]);
            alerts.setText(englishTxt[1]);
            startActivity(intent);
            //calender.setText(englishTxt[2]);
        }
        else if(language == 1){
            feed.setText(spanishTxt[0]);
            alerts.setText(spanishTxt[1]);
            startActivity(intent);
            //calender.setText(spanishTxt[2]);
        }

    }



    public void feedButton(View view){
        /*ntent intent = new Intent(this, Feed.class);
        intent.putExtra("language",language);*/
    }

    public void alertButton(View view){
        /*Intent intent = new Intent(this, Alerts.class);
        intent.putExtra("language",language);*/
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
