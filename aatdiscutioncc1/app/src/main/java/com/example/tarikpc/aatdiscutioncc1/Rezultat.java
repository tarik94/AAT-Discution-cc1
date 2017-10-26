package com.example.tarikpc.aatdiscutioncc1;

import io.realm.RealmObject;

/**
 * Created by Tarik PC on 26-10-17.
 */

public class Rezultat extends RealmObject {
    private boolean rez;

    public Rezultat() { }

    public boolean isRez() {
        return rez;
    }

    public void setRez(boolean rez) {
        this.rez = rez;
    }
}
