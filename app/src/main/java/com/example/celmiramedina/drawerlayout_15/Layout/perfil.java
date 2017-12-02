package com.example.celmiramedina.drawerlayout_15.Layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.celmiramedina.drawerlayout_15.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class perfil extends Fragment {


    public perfil() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       /* View v =
        TextView textView =(TextView) v.findViewById(R.id.texto);
        SharedPreferences sp = getContext().getSharedPreferences(Constantes.NOMBRESHAREPREFERENCE, Context.MODE_APPEND);
        String dato = sp.getString(Constantes.KEYEDITTEXTUSUARIO,"no existe");
        textView.setText(dato);
*/

        return inflater.inflate(R.layout.fragment_usuario, container, false);
    }
}
