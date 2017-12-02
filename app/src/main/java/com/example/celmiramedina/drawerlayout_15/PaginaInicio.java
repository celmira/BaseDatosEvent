package com.example.celmiramedina.drawerlayout_15;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Celmira Medina on 20/11/2017.
 */

public class PaginaInicio extends AppCompatActivity {


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paginainicio);

        Button ingresar = (Button) findViewById(R.id.boton_paginaInicio_ingresar);
        Button registrar = (Button) findViewById(R.id.boton_paginainicio_registrar);

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaginaInicio.this, Inicio.class);
                startActivity(intent);
            }
        });

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaginaInicio.this, PaginaRegistro.class);
                startActivity(intent);
            }
        });
    }
}
