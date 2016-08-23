package com.bambumobile.semanadelemprendedor;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;


public class CapitalEmprendedor extends Fragment{


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tres_dos_opciones,
                container, false);

        /*

        String[] list = getResources().getStringArray(R.array.rango_edades);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_dropdown_item_1line, list);
        MaterialBetterSpinner spinner = (MaterialBetterSpinner) view.findViewById(R.id.spinner2);
        spinner.setAdapter(adapter);
        Log.e("CapitalEmprendedor","Entro");

*/
        return  view;
    }


}
