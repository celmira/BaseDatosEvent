package com.example.celmiramedina.drawerlayout_15.Adaptadores;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.celmiramedina.drawerlayout_15.MiBasedeDatos;
import com.example.celmiramedina.drawerlayout_15.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Celmira Medina on 27/11/2017.
 */

public class EjemploCursorAdapter extends CursorAdapter {
    private LayoutInflater cursorInflater;
    Activity activity;

    public EjemploCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
        cursorInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return cursorInflater.inflate(R.layout.fragment_usuario,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView nombreT =(TextView) view.findViewById(R.id.nombreFragmen);
        TextView fechaNacT =(TextView) view.findViewById(R.id.fechaFrame);
        TextView generoT =(TextView) view.findViewById(R.id.generoFrame);
        TextView correoT =(TextView) view.findViewById(R.id.correoFrame);
        TextView epsT =(TextView) view.findViewById(R.id.epsFrame);
        TextView interesesT =(TextView) view.findViewById(R.id.interesesFrame);
        TextView fotoT =(TextView) view.findViewById(R.id.fotoFrame);

        String nombre =cursor.getString(cursor.getColumnIndex(MiBasedeDatos.COLUMNA_ASISTENTE_NOMBRE));
        String fechaNac =cursor.getString(cursor.getColumnIndex(MiBasedeDatos.COLUMNA_ASISTENTE_FECHANACIMIENTO));
        String genero =cursor.getString(cursor.getColumnIndex(MiBasedeDatos.COLUMNA_ASISTENTE_GENERO));
        String correo =cursor.getString(cursor.getColumnIndex(MiBasedeDatos.COLUMNA_ASISTENTE_CORREO));
        String eps =cursor.getString(cursor.getColumnIndex(MiBasedeDatos.COLUMNA_ASISTENTE_EPS));
        String intereses =cursor.getString(cursor.getColumnIndex(MiBasedeDatos.COLUMNA_ASISTENTE_INTERESES));
        String foto =cursor.getString(cursor.getColumnIndex(MiBasedeDatos.COLUMNA_ASISTENTE_FOTO));

        nombreT.setText(nombre);
        fechaNacT.setText(fechaNac);
        generoT.setText(genero);
        correoT.setText(correo);
        epsT.setText(eps);
        interesesT.setText(intereses);
        fotoT.setText(foto);


       // Picasso.with(activity).load(foto);



    }
}
