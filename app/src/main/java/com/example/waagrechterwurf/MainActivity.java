package com.example.waagrechterwurf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    protected Button _weite_wird_berechnet;
    protected Button _zur_hilfe_seite;

    protected EditText _eingegebene_höhe;
    protected EditText _eingegebene_beschleunigung;

    int hoehe;
    int beschleunigung;

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
            }
        });

    }

}
