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
    protected TextView textViewErgebnis = null;

    double weite = 0;
    double gravitation = 9.81;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2__anzeige);

        textViewHoehe = findViewById(R.id.hoehe_anzeigen);
        textViewV = findViewById(R.id.v_anzeigen);
        textViewErgebnis = findViewById(R.id.ergebnis_anzeigen);

//Darstellung der Zahlen auf die TextViews aus dem erstellen Intent von der vorherigen Seite
        Intent intent = getIntent();
        Double hoeheVonActivity1 = intent.getDoubleExtra("data_hoehe", 0);
        String hoeheVonActivity1_2 = String.valueOf(hoeheVonActivity1);
        textViewHoehe.setText(hoeheVonActivity1_2);

        Double vVonActivity1 = intent.getDoubleExtra("data_beschleunigung", 0);
        String vVonActivity1_2 = String.valueOf(vVonActivity1);
        textViewV.setText(vVonActivity1_2);
// Berechnung und Darstellung der Werte
        weite = (vVonActivity1 * Math.sqrt((2 * hoeheVonActivity1) / gravitation));
        String weiteString = String.valueOf(weite);
        textViewErgebnis.setText(weiteString);

    }

    @Override
    public void onClick(View view) {

    }
}
