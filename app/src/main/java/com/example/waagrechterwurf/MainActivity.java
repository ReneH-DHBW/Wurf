package com.example.waagrechterwurf;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

//edit Texte oben deklarieren und Buttons in onCreate
    protected EditText eingegebene_hoehe = null;
    protected EditText eingegebene_beschleunigung = null;
    protected Button weite_wird_berechnet;
    protected Button zur_hilfe_seite;
    protected Button hilfe_v;
    protected Button hilfe_h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weite_wird_berechnet = findViewById(R.id.weite_wird_berechnet);
        weite_wird_berechnet.setOnClickListener(this);

        zur_hilfe_seite = findViewById(R.id.zur_hilfe_seite);
        zur_hilfe_seite.setOnClickListener(this);

        eingegebene_hoehe = findViewById(R.id.eingegebene_hoehe);
        eingegebene_hoehe.addTextChangedListener(berechnenWatcher);
        eingegebene_beschleunigung = findViewById(R.id.eingegebene_beschleunigung);
        eingegebene_beschleunigung.addTextChangedListener(berechnenWatcher);

// Toast erstellen für Geschwindigkeit (Hilfe)
        hilfe_v = findViewById(R.id.hilfe_button_v);
        hilfe_v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, getString(R.string.toast_hilfe_v), Toast.LENGTH_LONG);
                toast.show();
            }
        });
// Toast erstellen für Geschwindigkeit (Hilfe)
        hilfe_h = findViewById(R.id.hilfe_button_h);
        hilfe_h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, getString(R.string.toast_hilfe_h), Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
//Für berechnen klick. Idee dahinter, je nachdem auf welchen Button ich drücke schaut der switch welchen Case er ausführen muss.
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
// Zur Ergebnis-Seite
            case R.id.weite_wird_berechnet:
                Intent intent = new Intent(this, Activity2_Anzeige.class);
// gebe die Hoehe weiter
                Double wertHoehe = Double.parseDouble(eingegebene_hoehe.getText().toString());
                intent.putExtra("wert_hoehe", wertHoehe);
// gebe die Geschwindigkeit weiter
                Double wertV = Double.parseDouble(eingegebene_beschleunigung.getText().toString());
                intent.putExtra("wert_v", wertV);
                startActivity(intent);
                break;
// Zur Hilfe Seite
            case R.id.zur_hilfe_seite:
                Intent intentHilfe = new Intent(this, Activity3_Hilfe.class);
                startActivity(intentHilfe);
                break;
        }

    }
//Der TextWatcher verhindet, dass ohne die Eingabe von Werten der Berechnen Button gedrückt werden kann
    private TextWatcher berechnenWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }
        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String hoeheString = eingegebene_hoehe.getText().toString().trim();
            String beschlString = eingegebene_beschleunigung.getText().toString().trim();
            weite_wird_berechnet.setEnabled(!hoeheString.isEmpty()&&!beschlString.isEmpty());
        }
        @Override
        public void afterTextChanged(Editable editable) {
        }
    };
}
