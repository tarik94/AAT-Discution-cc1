package com.example.tarikpc.novahuehuehue;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import io.realm.Realm;

/**
 * Created by Tarik PC on 02-11-17.
 */

public class fragmentButton extends Fragment {
    Button back;
    Realm realm;
    private View view;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_button, container, false);
        back = (Button) view.findViewById(R.id.buttonBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                Rezultat rezultat = realm.createObject(Rezultat.class);
                rezultat.setRez(true);
                realm.commitTransaction();
                getActivity().finish();
            }
        });
        return view;
    }
}

