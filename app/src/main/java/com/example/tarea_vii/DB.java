package com.example.tarea_vii;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DB {
    public static final String table_name = "notas";
    public static final String id = "id";
    public static final String title = "titulo";
    public static final String content = "cuerpo";
    public static final String create = "CREATE TABLE " + table_name + "(" + id + " INTEGER PRIMARY KEY AUTOINCRENET, " + title + " TEXT NOT NULL, " + content + " TEXT;";
    private DB_Helper helper;
    private SQLiteDatabase db;
    public DB(Context context) {
        helper = new DB_Helper(context);
        db = helper.getWritableDatabase();
    }

    public ContentValues generarContentValues(String titulo, String
            nota) {
        ContentValues valores = new ContentValues();
        valores.put(title, titulo);
        valores.put(content, nota);
        return valores;
    }
    public void insertar(String titulo, String cuerpo) {
        db.insert(table_name, null, generarContentValues(titulo,
                cuerpo));
    }
    public void eliminar(String titulo){
        db.delete(table_name, title+"=?", new String[]{titulo});
    }
    public Cursor cargarCursorNotas(){
        String[] columnas = new String[]{id, title, content};
        return db.query(table_name,columnas, null, null, null, null,
                null);
    }
}
