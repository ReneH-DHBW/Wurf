package com.example.waagrechterwurf.datenbank;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
//StringBuilder? Brauche ich den?
@Entity
public class User {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "Höhe")
    private double hoehe;
    @ColumnInfo(name ="Beschleunigung")
    private double beschleunigung;
    @ColumnInfo(name ="Ergebnis")
    private double ergebnis;

    public User(int id, double hoehe, double beschleunigung, double ergebnis){
        this.id = id;
        this.hoehe = hoehe;
        this.beschleunigung = beschleunigung;
        this.ergebnis = ergebnis;
    }

    public User(String toString) {

    }

    public double getHoehe() {
        return hoehe;
    }

    public double getBeschleunigung() {
        return beschleunigung;
    }

    public double getErgebnis() {
        return ergebnis;
    }

    public int getId() {
        return id;
    }
}
