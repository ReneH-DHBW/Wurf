package com.example.waagrechterwurf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity4_Tabelle extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity4__tabelle);

        Button zur_Tabelle = findViewById(R.id.zur_Startseite);
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
        }
    }
}