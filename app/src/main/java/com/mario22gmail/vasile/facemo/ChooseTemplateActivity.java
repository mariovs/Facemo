package com.mario22gmail.vasile.facemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import java.lang.String;

public class ChooseTemplateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_template);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void selectVideo1(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        String video = "godfather";
        intent.putExtra("film", video);
        startActivity(intent);
    }
    public void selectVideo2(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        String video = "scarface";
        intent.putExtra("film", video);
        startActivity(intent);
    }
    public void selectVideo3(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        String video = "gladiator";
        intent.putExtra("film", video);
        startActivity(intent);
    }

}
