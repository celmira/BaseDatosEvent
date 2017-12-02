package com.example.celmiramedina.drawerlayout_15;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Celmira Medina on 11/11/2017.
 */

public class Inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.iniciosesion);

        final SharedPreferences sp1 = getBaseContext().getSharedPreferences(Constantes.NOMBRESHAREPREFERENCE, Context.MODE_APPEND);
        String usuarioObtenido = sp1.getString(Constantes.KEYEDITTEXTUSUARIO, "No registrado");

        final SharedPreferences sp2 = getBaseContext().getSharedPreferences(Constantes.NOMBRESHAREPREFERENCE, Context.MODE_APPEND);
        String contraseniaObtenida = sp2.getString(Constantes.KEYEDITTEXTCONTRA, "No registrado");

        if(!usuarioObtenido.equals("No registrado") || !contraseniaObtenida.equals("No registrado")){
            Intent intent = new Intent(Inicio.this,MainActivity.class);
            startActivity(intent);
        }

        final EditText editTextnombre = (EditText) findViewById(R.id.campo_nombre);
        final EditText editTextcontrasenia = (EditText) findViewById(R.id.campo_contraseña);

        Button ingresar = (Button) findViewById(R.id.boton_Ingresar);

        editTextnombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                SharedPreferences sp = getBaseContext().getSharedPreferences(Constantes.NOMBRESHAREPREFERENCE, Context.MODE_APPEND);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString(Constantes.KEYEDITTEXTUSUARIO, editable.toString()).commit();

            }
        });

        editTextcontrasenia.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                SharedPreferences sp = getBaseContext().getSharedPreferences(Constantes.NOMBRESHAREPREFERENCE, Context.MODE_APPEND);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString(Constantes.KEYEDITTEXTCONTRA, editable.toString()).commit();

            }
        });

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp1 = getBaseContext().getSharedPreferences(Constantes.NOMBRESHAREPREFERENCE, Context.MODE_APPEND);
                String usuarioObtenido = sp1.getString(Constantes.KEYEDITTEXTUSUARIO, "No registrado");

                SharedPreferences sp2 = getBaseContext().getSharedPreferences(Constantes.NOMBRESHAREPREFERENCE, Context.MODE_APPEND);
                String contraseniaObtenida = sp2.getString(Constantes.KEYEDITTEXTCONTRA, "No registrado");

                if (editTextnombre.getText().toString().isEmpty() ||editTextcontrasenia.getText().toString().isEmpty()) {
                    Toast incorecto = Toast.makeText(getApplicationContext(), "Ingrese el nombre de usuario y la contraseña", Toast.LENGTH_SHORT);
                    incorecto.show();
                }  else if (usuarioObtenido.equals(Constantes.user) && contraseniaObtenida.equals(Constantes.password)) {
                    Intent intent = new Intent(Inicio.this, MainActivity.class);
                    startActivity(intent);

                } else if (!usuarioObtenido.equals(Constantes.user) || !contraseniaObtenida.equals(Constantes.password)) {
                    Toast incorecto = Toast.makeText(getApplicationContext(), "usuario o contraseña incorrectos", Toast.LENGTH_SHORT);
                    incorecto.show();
                }
            }
        });
    }
}