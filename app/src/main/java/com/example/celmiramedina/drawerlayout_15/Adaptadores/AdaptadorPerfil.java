package com.example.celmiramedina.drawerlayout_15.Adaptadores;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.celmiramedina.drawerlayout_15.Modelo.Usuario_asistente;
import com.example.celmiramedina.drawerlayout_15.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Celmira Medina on 17/11/2017.
 */

class ViewHolder{
    TextView nombre;
    TextView fechaNac;
    TextView genero;
    TextView correo;
    TextView eps;
    TextView intereses;
    ImageView foto;
}

public class AdaptadorPerfil extends BaseAdapter {
    Activity activity;
    Usuario_asistente[] usuarioAsistente;


    public AdaptadorPerfil(Context context, Usuario_asistente[] usuarioAsistente) {
        this.usuarioAsistente = usuarioAsistente;
        this.activity = (Activity)context;
    }

    @Override
    public int getCount() {
        return usuarioAsistente.length;
    }

    @Override
    public Object getItem(int i) {
        return usuarioAsistente[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        View item = convertView;
        ViewHolder viewHolder;
        if(item == null){
            LayoutInflater inflater = this.activity.getLayoutInflater();
            item =inflater.inflate(R.layout.fragment_usuario,null);
            viewHolder = new ViewHolder();
            viewHolder.nombre = (TextView)item.findViewById(R.id.nombreFragmen);
            viewHolder.fechaNac =(TextView)item.findViewById(R.id.fechaFrame);
            viewHolder.genero =(TextView)item.findViewById(R.id.generoFrame);
            viewHolder.correo =(TextView)item.findViewById(R.id.correoFrame);
            viewHolder.eps =(TextView)item.findViewById(R.id.epsFrame);
            viewHolder.intereses =(TextView)item.findViewById(R.id.interesesFrame);
            viewHolder.foto =(ImageView) item.findViewById(R.id.fotoFrame);
            item.setTag(viewHolder);
        }
        else {
            viewHolder =(ViewHolder)item.getTag();
        }
        viewHolder.nombre.setText(usuarioAsistente[position].getName());
        viewHolder.fechaNac.setText(usuarioAsistente[position].getFechaNacimiento()); // preguntar
        viewHolder.genero.setText(usuarioAsistente[position].getGenero());
        viewHolder.correo.setText(usuarioAsistente[position].getCorreo());
        viewHolder.eps.setText(usuarioAsistente[position].getEps());
        viewHolder.intereses.setText(usuarioAsistente[position].getIntereses());
        Picasso.with(activity).load(usuarioAsistente[position].getFoto()).into((viewHolder.foto));
        return item;
    }
}
