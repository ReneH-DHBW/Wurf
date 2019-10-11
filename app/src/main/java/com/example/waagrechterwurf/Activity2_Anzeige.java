package com.example.waagrechterwurf;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

        Button zur_hilfe_seite = findViewById(R.id.zur_hilfe_seite);
        zur_hilfe_seite.setOnClickListener(this);

//Darstellung der Zahlen auf die TextViews aus dem erstellen Intent von der vorherigen Seite
        Intent intent = getIntent();
        Double wertHoeheVA1 = intent.getDoubleExtra("wert_hoehe", 0);
        String wertHoeheVA1_String = String.valueOf(wertHoeheVA1);
        textViewHoehe.setText(wertHoeheVA1_String);

        Double wertVVA1 = intent.getDoubleExtra("wert_v", 0);
        String wertVVA1_String = String.valueOf(wertVVA1);
        textViewV.setText(wertVVA1_String);
// Berechnung und Darstellung der Werte
        weite = Math.round((wertVVA1 * Math.sqrt((2 * wertHoeheVA1) / gravitation))*100.0) / 100.0;
        String weiteString = String.valueOf(weite);
        textViewErgebnis.setText(weiteString);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
// Navigation zur Hilfe Seite
            case R.id.zur_hilfe_seite:
                Intent intentHilfe = new Intent(this, Activity3_Hilfe.class);
                startActivity(intentHilfe);
                break;
        }

    }
}
