package layout;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.celmiramedina.drawerlayout_15.Constantes;
import com.example.celmiramedina.drawerlayout_15.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class header extends Fragment {


    public header() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_header,container, true);
        TextView textView = (TextView)v.findViewById(R.id.nombre_header);
        SharedPreferences sp = getContext().getSharedPreferences(Constantes.NOMBRESHAREPREFERENCE, Context.MODE_APPEND);
        String nombre = sp.getString(Constantes.user,"no existe");
        textView.setText(nombre);
        return v;
    }

}
