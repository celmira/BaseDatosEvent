package com.example.celmiramedina.drawerlayout_15;

import android.database.Cursor;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.celmiramedina.drawerlayout_15.Adaptadores.AdaptadorPerfil;
import com.example.celmiramedina.drawerlayout_15.Adaptadores.EjemploCursorAdapter;
import com.example.celmiramedina.drawerlayout_15.Layout.perfil;

public class MainActivity extends AppCompatActivity  {

   // final Usuario_asistente[] miperfil ={new Usuario_asistente("Celmira Medina","04 noviembre 199?","F","Celmira@unicauca.edu.co","AIC","Paseos","http://e.studio92.com/normal/2017/08/21/565156_467018.jpg")};

   /* MiBasedeDatos miBasedeDatos;
    Button crear;
    EditText editText;*/

    EjemploCursorAdapter miperfilAdapter;
    private Cursor mCursor;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawerlayout);
       // crear =(Button)findViewById(R.id.registar_boton_Registrar);

       /* miBasedeDatos = MiBasedeDatos.getInstance(getApplicationContext());

        crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Usuario_asistente perfil = new Usuario_asistente("Celmira Medina", (int) 04/11/1992,(int)(Math.random()*
                ))
            }
        });
*/
        //miperfilAdapter = new AdaptadorPerfil(this,miperfil);
       listView = (ListView)findViewById(R.id.lista);
       mCursor = MiBasedeDatos.getInstance(this).leerAsistenteCursor();
        miperfilAdapter = new EjemploCursorAdapter(MainActivity.this,mCursor,0);
        listView.setAdapter(miperfilAdapter);

        final DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        final NavigationView navigationView = (NavigationView)findViewById(R.id.navigationView);
        setSupportActionBar(toolbar);
        final ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.abierto,R.string.cerrado);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected( MenuItem item) {

                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction tx = null;
                Fragment fragment = null;

                int [] ids = {R.id.Tramites,R.id.Perfil};
                for (int id:ids){

                    navigationView.getMenu().findItem(id).setChecked(false);

                }

                navigationView.getMenu().findItem(item.getItemId()).setChecked(true);
                switch (item.getItemId()){
                    case R.id.Tramites:
                        fragment = new Evento();
                        break;
                    case R.id.Perfil:
                        fragment = new perfil();
                        tx.replace(R.id.contenedor,fragment);
                        break;

                }
                if (null != fragment){
                    tx = fm.beginTransaction();
                    tx.replace(R.id.contenedor,fragment);
                    tx.commit();
                    drawer.closeDrawers();
                }
                return true;
            }

        });

    }


}


