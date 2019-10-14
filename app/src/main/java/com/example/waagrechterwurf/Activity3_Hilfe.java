package com.example.waagrechterwurf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity3_Hilfe extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity3__hilfe);

        Button zur_Startseite = findViewById(R.id.zur_Startseite);
        zur_Startseite.setOnClickListener(this);

        Button zur_Tabelle = findViewById(R.id.zur_Tabelle);
        zur_Tabelle.setOnClickListener(this);
    }
// Buttons zur Navigation
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
// Zur start Seite
            case R.id.zur_Startseite:
                Intent intentStart = new Intent(this, MainActivity.class);
                startActivity(intentStart);
                break;
// Zur Tabellen Seite
        }
    }
}
