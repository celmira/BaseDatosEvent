package com.example.celmiramedina.drawerlayout_15;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.celmiramedina.drawerlayout_15.Modelo.Usuario_asistente;

/**
 * Created by Celmira Medina on 20/11/2017.
 */

public class PaginaRegistro extends AppCompatActivity {

    MiBasedeDatos miBasedeDatos;
    Button registrar;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paginaregistro_asistente);

        registrar = (Button) findViewById(R.id.registar_boton_Registrar);

        miBasedeDatos= MiBasedeDatos.getInstance(getApplicationContext());

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EditText editTextnombre = (EditText) findViewById(R.id.registro_campo_nombre);
                final EditText editTextfecha = (EditText) findViewById(R.id.registro_campo_fecha);
                final EditText editTextcedula = (EditText) findViewById(R.id.registro_campo_cedula);
                final EditText editTexteps = (EditText) findViewById(R.id.registro_campo_eps);
                final EditText editTextcorreo = (EditText) findViewById(R.id.registro_campo_correo);
                final EditText editTextgenero = (EditText) findViewById(R.id.registro_campo_genero);
                final EditText editTextintereses = (EditText) findViewById(R.id.registro_campo_intereses);
                final EditText editTextfoto = (EditText) findViewById(R.id.registro_campo_foto);/**/


                Usuario_asistente usuarioAsistente = new Usuario_asistente(editTextnombre.getText().toString(),
                        Integer.valueOf(editTextfecha.getText().toString()),Integer.valueOf(editTextcedula.getText().toString()),
                        editTexteps.getText().toString(), (int)(Math.random()*10),editTextcorreo.getText().toString(),
                        editTextgenero.getText().toString(),editTextintereses.getText().toString(),editTextfoto.getText().toString());

                miBasedeDatos.CrearAsistente(usuarioAsistente);

                Toast registro = Toast.makeText(getApplicationContext(), "Registro de usuario exitoso...", Toast.LENGTH_SHORT);
                registro.show();

            }
        });
    }
}
