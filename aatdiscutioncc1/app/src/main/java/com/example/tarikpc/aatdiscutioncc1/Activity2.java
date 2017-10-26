package com.example.tarikpc.aatdiscutioncc1;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

/**
 * Created by Tarik PC on 26-10-17.
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


