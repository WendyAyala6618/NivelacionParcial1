package com.wendy.ejercicionivelacion;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Puntos extends ListActivity {
    private ArrayList<String> listajugadores;
    private ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_puntos);
        listajugadores = new ArrayList<>();

        Collections.sort(MainActivity.lstjugadores, new Comparator<Jugadores>() {
            @Override
            public int compare(Jugadores o1, Jugadores o2) {
                return new Integer(o2.getPuntos()).compareTo(new Integer(o1.getPuntos()));
            }
        });
        for (int i = 0; i < 3; i++) {
            Jugadores ju = MainActivity.lstjugadores.get(i);
            listajugadores.add(ju.getNombre() + " " + String.valueOf(ju.getPuntos()) + " pts");
        }
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listajugadores);
        this.setListAdapter(adapter);
    }
}
