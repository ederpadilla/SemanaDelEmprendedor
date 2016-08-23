package com.bambumobile.semanadelemprendedor;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by bambumobile on 30/09/15.
 */
public class CuatroOpciones extends Fragment implements View.OnClickListener{

    LinearLayout root_1,root_2,root_3,root_4;
    ImageView item_1,item_2,item_3,item_4;
    Boolean esta_en_eres;
    MainActivity mainActivity;
    public int config;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cuatro_opciones,
                container, false);
        mainActivity = (MainActivity)getActivity();

        root_1 = (LinearLayout)view.findViewById(R.id.root_1);
        root_2 = (LinearLayout)view.findViewById(R.id.root_2);
        root_3 = (LinearLayout)view.findViewById(R.id.root_3);
        root_4 = (LinearLayout)view.findViewById(R.id.root_4);

        item_1 = (ImageView)view.findViewById(R.id.item_1);
        item_1.setOnClickListener(this);
        item_2 = (ImageView)view.findViewById(R.id.item_2);
        item_2.setOnClickListener(this);
        item_3 = (ImageView)view.findViewById(R.id.item_3);
        item_3.setOnClickListener(this);
        item_4 = (ImageView)view.findViewById(R.id.item_4);
        item_4.setOnClickListener(this);
        configuracion(config);
        return  view;
    }

    private void configuracion(int config){

        switch (config){
            //Sin Texto
            case 0:
                mainActivity.titulo_pregunta.setText(getString(R.string.eres_pregunta));
                mainActivity.camino.add(2);
                item_1.setImageResource(R.mipmap.emprendedor);
                item_2.setImageResource(R.mipmap.estudiante);
                item_3.setImageResource(R.mipmap.fondeador);
                item_4.setImageResource(R.mipmap.inversionista);
                esta_en_eres = true;
                break;

            case 1:
                mainActivity.titulo_pregunta.setText("¿ Que Buscas ?");
                mainActivity.camino.add(3);
                root_1.removeViewAt(1);
                root_2.removeViewAt(1);
                root_3.removeViewAt(1);
                root_4.removeViewAt(1);

                item_1.setImageResource(R.mipmap.quebuscas1);
                item_2.setImageResource(R.mipmap.quebuscas2);
                item_3.setImageResource(R.mipmap.quebuscas3);
                item_4.setImageResource(R.mipmap.quebuscas4);
                esta_en_eres = false;
                break;
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.item_1:
                if(esta_en_eres){
                    mainActivity.encuetado.oficio = "Emprendedor";
                    mainActivity.changeView(7,false);
                }else {
                    mainActivity.encuetado.busca = "Recibir rendimientos";
                    changFra(3);
                }
                break;
            case R.id.item_2:
                if(esta_en_eres){
                    mainActivity.encuetado.oficio = "Estudiante";
                    mainActivity.changeView(7,false);
                }else {
                    mainActivity.encuetado.busca = "% accionario";
                    changFra(0);
                }
                break;
            case R.id.item_3:
                if(esta_en_eres){
                    mainActivity.encuetado.oficio = "Fondeador";
                    mainActivity.changeView(3,false);
                }else {
                    mainActivity.encuetado.busca = "Beneficios no financieros";
                    mainActivity.changeView(12,false);
                }
                break;
            case R.id.item_4:
                if(esta_en_eres){
                    mainActivity.encuetado.oficio = "Invercionista";
                    mainActivity.changeView(3,false);
                }else {
                    mainActivity.encuetado.busca = "No espera recibir nada a cambio";
                    mainActivity.changeView(5,false);


                }
                break;
        }
    }

    private void changFra(int i){
        Salida salida = new Salida();
        salida.config = i;
        mainActivity.getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.entrar_izquierda, R.anim.salir_derecha)
                .replace(R.id.contain_view, salida , "")
                .commit();
    }

    private void changeFragment(boolean don_dinero){
        if (don_dinero){
        CuatroOpciones cuatroOpciones = new CuatroOpciones();
        cuatroOpciones.config = 1;
        mainActivity.getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.entrar_izquierda, R.anim.salir_derecha)
                .replace(R.id.contain_view, cuatroOpciones , "")
                .commit();
        }else {
            OpcionesLineales opcLineales = new OpcionesLineales();
            opcLineales.config = 1;
            mainActivity.getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.entrar_izquierda, R.anim.salir_derecha)
                    .replace(R.id.contain_view, opcLineales , "")
                    .commit();
        }
    }

}
