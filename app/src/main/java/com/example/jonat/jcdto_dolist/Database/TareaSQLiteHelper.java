package com.example.jonat.jcdto_dolist.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TareaSQLiteHelper extends SQLiteOpenHelper {

    String crearTablaNotas = "CREATE TABLE Tareas (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            "titulo TEXT, prioridad TEXT, estado INTEGER, deadline TEXT)";

    public TareaSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(crearTablaNotas);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Eliminamos la versión anterior de la tabla.
        db.execSQL("DROP TABLE IF EXISTS Tareas");
        // Se crea la nueva versión de la tabla.
        db.execSQL(crearTablaNotas);
    }
}
