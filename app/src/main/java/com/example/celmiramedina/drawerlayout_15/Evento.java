package com.example.celmiramedina.drawerlayout_15;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.celmiramedina.drawerlayout_15.Modelo.Evento_Clase;
import com.example.celmiramedina.drawerlayout_15.Modelo.Usuario_asistente;

import static com.example.celmiramedina.drawerlayout_15.R.id.txt_descripcion_input_it;



/**
 * A simple {@link Fragment} subclass.
 */
public class Evento extends Fragment {
    MiBasedeDatos miBasedeDatos;
    Button registrar_Evento;

    public Evento() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_evento, container, false);

        registrar_Evento = (Button) registrar_Evento.findViewById(R.id.fab_imput_it_gallery);

       // miBasedeDatos= MiBasedeDatos.getInstance();

        registrar_Evento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editTextnombre = null;
                EditText editTextDescripcion = null;
                EditText editTextfechaInicio = null;
                EditText editTextfechaFin = null;
                EditText editTextPunto = null;
                EditText editTextSubcategoria = null;
                EditText editTextPrecio = null;
                EditText editTextGuia = null;

                editTextnombre= (EditText) editTextnombre.findViewById(R.id.txt_titulo_input_it);
                editTextDescripcion = (EditText) editTextDescripcion.findViewById(txt_descripcion_input_it);
                editTextfechaInicio = (EditText) editTextfechaInicio.findViewById(R.id.fecha_inicio_input_it);
                editTextfechaFin = (EditText) editTextfechaFin.findViewById(R.id.fecha_inicio_input_it);
                editTextPunto = (EditText) editTextPunto.findViewById(R.id.edt_pto_encuentro_imput_it);
                editTextSubcategoria = (EditText) editTextSubcategoria.findViewById(R.id.spnr_categoria_input_it);
                editTextPrecio = (EditText) editTextPrecio.findViewById(R.id.edt_precio_imput_it);

                Evento_Clase evento = new Evento_Clase(editTextnombre.getText().toString(),editTextDescripcion.getText().toString(),
                        editTextPunto.getText().toString(),(int)(Math.random()*10),Integer.valueOf(editTextSubcategoria.getText().toString()),
                        Integer.valueOf(editTextfechaInicio.getText().toString()),Integer.valueOf(editTextfechaFin.getText().toString()),Integer.valueOf(editTextPrecio.getText().toString()),(int)(Math.random()*10));

                miBasedeDatos.CrearEvento(evento);

                //Toast registro = Toast.makeText(container, "Registro de usuario exitoso...", Toast.LENGTH_SHORT);
             //   registro.show();
            }
        });

        return view;

    }

}
