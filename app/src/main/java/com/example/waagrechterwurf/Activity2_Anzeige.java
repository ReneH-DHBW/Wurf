package com.example.waagrechterwurf;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity2_Anzeige extends Activity implements View.OnClickListener {
// TextViews draußen deklarieren
    protected TextView textViewHoehe = null;
    protected TextView textViewV = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2__anzeige);

        textViewHoehe = findViewById(R.id.hoehe_anzeigen);
        textViewV = findViewById(R.id.v_anzeigen);
//Darstellung der Zahlen auf die TextViews aus dem erstellen Intent von der vorherigen Seite
        Intent intent = getIntent();
        String hoeheVonActivity1 = intent.getStringExtra("data_hoehe");
        textViewHoehe.setText(hoeheVonActivity1);

        String vVonActivity1 = intent.getStringExtra("data_beschleunigung");
        textViewV.setText(vVonActivity1);
    }

    @Override
    public void onClick(View view) {

    }
}
