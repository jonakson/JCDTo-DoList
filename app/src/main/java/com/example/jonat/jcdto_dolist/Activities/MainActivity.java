package com.example.jonat.jcdto_dolist.Activities;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.jonat.jcdto_dolist.Adapters.AdaptadorLV;
import com.example.jonat.jcdto_dolist.Database.TareaSQLiteHelper;
import com.example.jonat.jcdto_dolist.Modelos.Tarea;
import com.example.jonat.jcdto_dolist.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Atributos: UI.
    private FloatingActionButton fabTarea;
    private ImageView imagenPrioridad;
    // Atributos: Base de datos.
    private TareaSQLiteHelper tareasHelper;
    private SQLiteDatabase db;
    // Atributos: ListView.
    private ListView listViewTareas;
    private AdaptadorLV adaptador;
    // Atributos: Lista de Tareas.
    private List<Tarea> tareas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewTareas = (ListView) findViewById(R.id.listViewTareas);
        tareas = new ArrayList<Tarea>();


        imagenPrioridad = (ImageView) findViewById(R.id.imagenPrioridad);

        // Creamos/Abrimos la base de datos.
        tareasHelper = new TareaSQLiteHelper(this, "TareasDB", null, 1);
        db = tareasHelper.getWritableDatabase();

        // Llenamos el ListView haciendo uso de nuestro Adapter.
        adaptador = new AdaptadorLV(this, R.layout.elemento_tarea, tareas);
        listViewTareas.setAdapter(adaptador);

        // Lanzamos la Activity para crear nuevas tareas con el Floating Action Button.
        fabTarea = (FloatingActionButton) findViewById(R.id.fabTarea);
        fabTarea.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                lanzarCrearTarea();
            }
        });
    }

    private void lanzarCrearTarea() {
        Intent i = new Intent(this, NuevaTareaActivity.class);
        startActivity(i);
    }

}
