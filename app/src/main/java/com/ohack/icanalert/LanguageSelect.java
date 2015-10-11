package com.ohack.icanalert;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;

public class LanguageSelect extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_select);
    }

    public void englishButton(View view){
        Intent intent = new Intent(this, HomeScreen.class);
        intent.putExtra("language",0); //english 0
        startActivity(intent);
    }

    public void spanishButton(View view){
        Intent intent = new Intent(this, HomeScreen.class);
        intent.putExtra("language",1); //spanish
        startActivity(intent);
    }

}
