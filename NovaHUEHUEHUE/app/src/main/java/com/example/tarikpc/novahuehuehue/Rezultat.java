package com.example.tarikpc.novahuehuehue;

import io.realm.RealmObject;

/**
 * Created by Tarik PC on 02-11-17.
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
