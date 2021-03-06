package com.example.jonat.jcdto_dolist.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jonat.jcdto_dolist.Modelos.Tarea;
import com.example.jonat.jcdto_dolist.R;

import java.util.List;

public class AdaptadorLV extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Tarea> tareas;

    public AdaptadorLV(Context context, int layout, List<Tarea> tareas) {
        this.context = context;
        this.layout = layout;
        this.tareas = tareas;
    }

    @Override
    public int getCount() {
        return this.tareas.size();
    }

    @Override
    public Object getItem(int position) {
        return this.tareas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Inflamos la Vista con nuestro layout personalizado.
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        View v = layoutInflater.inflate(R.layout.elemento_tarea, null);

        // Traemos el valor de la Tarea en función de su posición.
        Tarea tareaActual = tareas.get(position);


        ImageView imagenPrioridad = (ImageView) v.findViewById(R.id.imagenPrioridad);
        TextView tvNombreTarea = (TextView) v.findViewById(R.id.tvNombreTarea);
        TextView tvDeadline = (TextView) v.findViewById(R.id.tvDeadline);
        TextView tvPrioridad = (TextView) v.findViewById(R.id.tvPrioridad);

        // Fijamos el icono de la Tarea en funcioón de su Prioridad.
        if (tareaActual.getPrioridad() == "Baja") {
            imagenPrioridad.setImageResource(R.mipmap.ic_prioridad_baja);
        } else if (tareaActual.getPrioridad() == "Alta") {
            imagenPrioridad.setImageResource(R.mipmap.ic_prioridad_alta);
        }
        // Fijamos el Título de la Tarea.
        tvNombreTarea.setText(tareaActual.getTitulo());
        // Fijamos el Deadline de la Tarea.
        tvDeadline.setText(tareaActual.getDeadline());
        // Fijamos el texto de la Prioridad de la Tarea.
        tvPrioridad.setText("Prioridad" + tareaActual.getPrioridad());

        return v;
    }
}
