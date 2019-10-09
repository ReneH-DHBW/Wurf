package com.example.waagrechterwurf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    protected Button _weite_wird_berechnet = null;
    protected Button _zur_hilfe_seite = null;

    protected EditText _eingegebene_höhe = null;
    protected EditText _eingegebene_beschleunigung = null;

    int hoehe = 0;
    int beschleunigung = 0;
    int weite = 0;
    int gravitation = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _weite_wird_berechnet = (Button) findViewById(R.id.weite_wird_berechnet);
        _zur_hilfe_seite = (Button) findViewById(R.id.zur_hilfe_seite);
        _eingegebene_höhe = (EditText) findViewById(R.id.eingegebene_höhe);
        _eingegebene_beschleunigung = (EditText) findViewById(R.id.eingegebene_beschleunigung);

        _weite_wird_berechnet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hoehe =  Integer.valueOf(_eingegebene_höhe.getText().toString());
                beschleunigung = Integer.valueOf(_eingegebene_beschleunigung.getText().toString());
                weite = (int) (beschleunigung*Math.sqrt((2*hoehe)/gravitation));
            }
        });
// Toast erstellen für Geschwindigkeit (Hilfe)
        Button hilfe_v = (Button) findViewById(R.id.hilfe_button_v);
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



}
