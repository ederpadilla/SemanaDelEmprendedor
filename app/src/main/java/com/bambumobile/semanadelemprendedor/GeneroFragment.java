package com.bambumobile.semanadelemprendedor;

import android.app.Dialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

/**
 * Created by bambumobile on 01/10/15.
 */
public class GeneroFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener {

    private ImageView hombre, mujer,interrogante,interrogante1;
    TextView title_1,title_2;
    MainActivity mainActivity;
    MaterialBetterSpinner spinner;
    public int config;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.genero_fragment,
                container, false);

        mainActivity = (MainActivity) getActivity();
        mainActivity.backQuestion.setVisibility(View.INVISIBLE);
        mainActivity.camino.add(1);
        hombre = (ImageView) view.findViewById(R.id.hombre);
        hombre.setOnClickListener(this);
        interrogante=(ImageView) view.findViewById(R.id.interrogante);
        interrogante.setOnClickListener(this);
        interrogante1=(ImageView) view.findViewById(R.id.interrogante1);
        interrogante1.setOnClickListener(this);
        title_1 = (TextView)view.findViewById(R.id.textView2);
        title_2 = (TextView)view.findViewById(R.id.textView3);

        mujer = (ImageView) view.findViewById(R.id.mujer);
        mujer.setOnClickListener(this);
        mainActivity.titulo_pregunta.setText(getString(R.string.edad_pregunta));

        configuRation(config, view);
        return view;
    }

    public void configuRation(int config, View view) {

        String[] list;
        ArrayAdapter<String> adapter;
        switch (config) {
            //Caso de Genero
            case 0:
                mainActivity.backQuestion.setVisibility(View.INVISIBLE);
                interrogante.setVisibility(View.INVISIBLE);
                interrogante1.setVisibility(View.INVISIBLE);
                mainActivity.camino.add(1);
                title_1.setText("Hombre");
                title_2.setText("Mujer");
                mujer.setImageResource(R.mipmap.mujer);
                hombre.setImageResource(R.mipmap.hombre);
                list = getResources().getStringArray(R.array.rango_edades);
                adapter = new ArrayAdapter<String>(getContext(),
                        android.R.layout.simple_dropdown_item_1line, list);
                spinner = (MaterialBetterSpinner) view.findViewById(R.id.spinner2);
                spinner.setAdapter(adapter);
                spinner.setOnItemClickListener(this);
                break;

            case 1:
                mainActivity.backQuestion.setVisibility(View.VISIBLE);
                mainActivity.camino.add(10);
                mainActivity.titulo_pregunta.setText(getString(R.string.sector_proyecto_pregunta));
                title_1.setText("Alto Impacto");
                title_2.setText("Tradicional");
                mujer.setImageResource(R.mipmap.tradicional);
                hombre.setImageResource(R.mipmap.altoimpacto);
                list = getResources().getStringArray(R.array.sectores);
                adapter = new ArrayAdapter<String>(getContext(),
                        android.R.layout.simple_dropdown_item_1line, list);
                spinner = (MaterialBetterSpinner) view.findViewById(R.id.spinner2);
                spinner.setAdapter(adapter);
                spinner.setOnItemClickListener(this);
                spinner.setHint("Tic´s");
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mujer:
                if (config == 0){
                    mainActivity.encuetado.genero = "Mujer";
                    changeToFourOpcions();
                }else {
                    mainActivity.encuetado.tipo_del_proyecto ="Normal";
                    mainActivity.changeView(11,false);
                }
                break;

            case R.id.hombre:
                if (config == 0){
                    mainActivity.encuetado.genero = "Hombre";
                    changeToFourOpcions();
                }else {
                    mainActivity.encuetado.tipo_del_proyecto ="Alto Impacto";
                    mainActivity.changeView(13,false);
                }
                break;
            case R.id.interrogante:
                new MaterialDialog.Builder(getActivity())
                        .title("Alto Impacto")
                        .content(R.string.definicion_altoimpacto)
                        .positiveText("Aceptar")
                        .show();
                break;
            case R.id.interrogante1:
                new MaterialDialog.Builder(getActivity())
                        .title("Tradicional")
                        .content(R.string.definicion_tradicional)
                        .positiveText("Aceptar")
                        .show();
                break;
        }
    }

    public void changeToLineal(int congfi){
        mainActivity.backQuestion.setVisibility(View.VISIBLE);
        OpcionesLineales lineales = new OpcionesLineales();
        lineales.config = congfi;
        mainActivity.getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.entrar_izquierda, R.anim.salir_derecha)
                .replace(R.id.contain_view, lineales, "")
                .commit();
    }

    public void changeToFourOpcions(){
        mainActivity.backQuestion.setVisibility(View.VISIBLE);
        CuatroOpciones cuatroOpciones = new CuatroOpciones();
        cuatroOpciones.config = 0;
        mainActivity.getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.entrar_izquierda, R.anim.salir_derecha)
                .replace(R.id.contain_view, cuatroOpciones, "")
                .commit();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (config ==0){
            mainActivity.encuetado.edad = getResources().getStringArray(R.array.rango_edades)[position];
        }else {
            mainActivity.encuetado.sector_del_proyecto = getResources().getStringArray(R.array.rango_edades)[position];
        }
    }
}
