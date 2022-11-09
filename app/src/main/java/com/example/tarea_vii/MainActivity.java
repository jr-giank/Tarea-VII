package com.example.tarea_vii;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {
    private DB db;
    private Cursor cursor;
    private ListView lista;
    private SimpleCursorAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DB(this);
        lista = (ListView) findViewById(R.id.lista);
        String[] from = new String[]{db.title,db.content};
        int[] to = new int[]{android.R.id.titulo, android.R.id.cuerpo};
        cursor = db.cargarCursorNotas();
        adaptador = new SimpleCursorAdapter(this, android.R.layout.items, cursor,from,to,0);
        lista.setAdapter(adaptador);
    }
}