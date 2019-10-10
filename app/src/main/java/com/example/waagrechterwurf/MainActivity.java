package com.example.waagrechterwurf;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

//edit Texte oben deklarieren und Buttons in onCreate
    protected EditText eingegebene_hoehe = null;
    protected EditText eingegebene_beschleunigung = null;

    int hoehe = 0;
    int beschleunigung = 0;
    int weite = 0;
    int gravitation = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button weite_wird_berechnet = findViewById(R.id.weite_wird_berechnet);
        weite_wird_berechnet.setOnClickListener(this);

        Button zur_hilfe_seite = (Button) findViewById(R.id.zur_hilfe_seite);
        zur_hilfe_seite.setOnClickListener(this);

        eingegebene_hoehe = findViewById(R.id.eingegebene_hoehe);
        eingegebene_beschleunigung = findViewById(R.id.eingegebene_beschleunigung);


// Toast erstellen für Geschwindigkeit (Hilfe)
        Button hilfe_v = findViewById(R.id.hilfe_button_v);
        hilfe_v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, getString(R.string.toast_hilfe_v), Toast.LENGTH_LONG);
                toast.show();
            }
        });
// Toast erstellen für Geschwindigkeit (Hilfe)
        Button hilfe_h = (Button) findViewById(R.id.hilfe_button_h);
        hilfe_h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, getString(R.string.toast_hilfe_h), Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
//Für berechnen klick
    @Override
    public void onClick(View view) {

//Für die nächste Seite zum darstellen
        Intent intent = new Intent(this, Activity2_Anzeige.class);
// gebe die Hoehe weiter
        Double wertHoehe = Double.parseDouble(eingegebene_hoehe.getText().toString());
        intent.putExtra("wert_hoehe", wertHoehe);
// gebe die Geschwindigkeit weiter
        Double wertV = Double.parseDouble(eingegebene_beschleunigung.getText().toString());
        intent.putExtra("wert_v", wertV);

        startActivity(intent);
    }
}
