package com.example.tarikpc.novahuehuehue;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Tarik PC on 02-11-17.
 */

public class Activity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        final FragmentManager fm = getFragmentManager();
        fragmentButton fb = new fragmentButton();
        fm.beginTransaction().replace(R.id.frame, fb).commit();
    }
}
