package com.example.jonat.jcdto_dolist.Activities;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.jonat.jcdto_dolist.Database.TareaSQLiteHelper;
import com.example.jonat.jcdto_dolist.R;

import java.util.Calendar;
import java.util.Date;

public class NuevaTareaActivity extends AppCompatActivity {

    // Atributos: Base de datos.
    private TareaSQLiteHelper tareasHelper;
    private SQLiteDatabase db;
    // Atributos: UI.
    private EditText etFecha, etHora, etTitulo;
    private RadioButton rbEstadoHecha, rbEstadoPendiente, rbPrioridadBaja, rbPrioridadMedia, rbPrioridadAlta;
    private Button btnCancelar, btnGuardar, btnReset;
    // Atributo: Constante 7 días.
    private static final int SIETE_DIAS = 604800000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_tarea);

        // Creamos/Abrimos la base de datos.
        tareasHelper = new TareaSQLiteHelper(this, "TareasDB", null, 1);
        db = tareasHelper.getWritableDatabase();

        etTitulo = (EditText) findViewById(R.id.etTitulo);
        etFecha = (EditText) findViewById(R.id.etFecha);
        etHora = (EditText) findViewById(R.id.etHora);
        rbEstadoHecha = (RadioButton) findViewById(R.id.rbEstadoHecha);
        rbEstadoPendiente = (RadioButton) findViewById(R.id.rbEstadoPendiente);
        rbPrioridadBaja = (RadioButton) findViewById(R.id.rbPrioridadBaja);
        rbPrioridadMedia = (RadioButton) findViewById(R.id.rbPrioridadMedia);
        rbPrioridadAlta = (RadioButton) findViewById(R.id.rbPrioridadAlta);
        btnCancelar = (Button) findViewById(R.id.btnCancelar);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnReset = (Button) findViewById(R.id.btnReset);


    }

    public void fijarFechaPorDefecto() {
        Date momento = new Date();
        momento = new Date(momento.getTime() + SIETE_DIAS);
        Calendar cal = Calendar.getInstance();
        cal.setTime(momento);

        etFecha.setText(crearStringFecha(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_MONTH)));
        etHora.setText(crearStringHora(cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE)));
    }

    private static String crearStringFecha(int año, int mes, int dia) {
        mes++;
        String sMes = String.valueOf(mes);
        String sDia = String.valueOf(dia);
        if(mes < 10) { sMes = "0" + mes; }
        if (dia < 10) { sDia = "0" + dia; }
        return sDia + sMes + año;
    }

    public static String crearStringHora(int horas, int minutos) {
        String sHoras = String.valueOf(horas);
        String sMinutos = String.valueOf(minutos);
        if(horas < 10) { sHoras = "0" + horas; }
        if(minutos < 10) { sMinutos = "0" + minutos; }
        return sHoras + sMinutos;
    }
}
