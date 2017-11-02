package com.example.tarikpc.aatdiscutioncc1;

import io.realm.RealmObject;

/**
 * Created by Tarik PC on 02-11-17.
 */

public class Pokusaj extends RealmObject {
    String rezultat;

    public String getRezultat() {
        return rezultat;
    }

    public void setRezultat(String rezultat) {
        this.rezultat = rezultat;
    }
}
