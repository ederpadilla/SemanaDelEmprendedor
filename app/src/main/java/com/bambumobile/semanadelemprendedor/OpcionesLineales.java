package com.bambumobile.semanadelemprendedor;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by bambumobile on 01/10/15.
 */
public class OpcionesLineales extends Fragment implements View.OnClickListener {

    ImageView item_1, item_2, item_3, item_4;
    TextView txt_1,txt_2,txt_3,txt_4;
    LinearLayout view_root,root_1, root_2, root_3, root_4;
    MainActivity mainActivity;
    int config;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tres_dos_opciones,
                container, false);

        view_root = (LinearLayout) view.findViewById(R.id.view_root);
        root_1 = (LinearLayout) view.findViewById(R.id.view_1);
        root_2 = (LinearLayout) view.findViewById(R.id.view_2);
        root_3 = (LinearLayout) view.findViewById(R.id.view_3);
        root_4 = (LinearLayout) view.findViewById(R.id.view_4);

        txt_1 = (TextView) view.findViewById(R.id.txt_1);
        txt_2 = (TextView) view.findViewById(R.id.txt_2);
        txt_3 = (TextView) view.findViewById(R.id.txt_3);
        txt_4 = (TextView) view.findViewById(R.id.txt_4);

        item_1 = (ImageView) view.findViewById(R.id.image_1);
        item_1.setOnClickListener(this);

        item_2 = (ImageView) view.findViewById(R.id.image_2);
        item_2.setOnClickListener(this);

        item_3 = (ImageView) view.findViewById(R.id.image_3);
        item_3.setOnClickListener(this);

        item_4 = (ImageView) view.findViewById(R.id.image_4);
        item_4.setOnClickListener(this);

        mainActivity =  (MainActivity)getActivity();
        changeConfiguracion(config);
        return view;
    }

    public void changeConfiguracion(int i){
        Log.e("OpLineales","Tipo de Config : "+i);
        switch (i){
            //Vista de si tienes proyecto
            case 0:
                mainActivity.titulo_pregunta.setText(getString(R.string.proyecto_pregunta));
                mainActivity.camino.add(7);
                item_1.setImageResource(R.mipmap.si);
                txt_1.setText("Si");
                item_2.setImageResource(R.mipmap.no);
                txt_2.setText("No");
                view_root.removeView(root_4);
                view_root.removeView(root_3);
                break;
            //  Tu proyecto esta en
            case 1:
                mainActivity.titulo_pregunta.setText(getString(R.string.tu_proyecto_pregunta));
                mainActivity.camino.add(9);
                item_1.setImageResource(R.mipmap.emprender);
                txt_1.setText(getString(R.string.emprender));
                item_2.setImageResource(R.mipmap.arrancando);
                txt_2.setText(getString(R.string.arrancando));
                item_3.setImageResource(R.mipmap.encrecimiento);
                txt_3.setText(getString(R.string.crecimiento));
                view_root.removeView(root_4);
                break;
            //Dispuesto a
            case 2:
                mainActivity.titulo_pregunta.setText(getString(R.string.dispuesto_pregunta));
                mainActivity.camino.add(13);
                item_1.setImageResource(R.mipmap.estasdispuestoa1);
                root_1.removeView(txt_1);
                item_2.setImageResource(R.mipmap.estasdispuestoa2);
                root_2.removeView(txt_2);
                item_3.setImageResource(R.mipmap.estasdispuestoa3);
                root_3.removeView(txt_3);
                view_root.removeView(root_4);
                break;

            //Que nececistas
            case 3:
                mainActivity.titulo_pregunta.setText(getString(R.string.necesitas_pregunta));
                mainActivity.camino.add(11);
                item_1.setImageResource(R.mipmap.quenecesitas1);
                root_1.removeView(txt_1);
                item_2.setImageResource(R.mipmap.quenecesitas2);
                root_2.removeView(txt_2);
                item_3.setImageResource(R.mipmap.quenecesitas3);
                root_3.removeView(txt_3);
                item_4.setImageResource(R.mipmap.quencesitas4);
                root_4.removeView(txt_4);
                break;
        }

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_1:
                switch (config){
                    case 0:
                        mainActivity.encuetado.tieneproyecto =  true;
                        mainActivity.changeView(9,false);
                        break;
                    case 1:
                        mainActivity.encuetado.estado_del_proyecto ="Quiero emprender";
                        mainActivity.changeView(8,false);
                        break;
                    case 2:
                        mainActivity.encuetado.esta_dispuesto = "ceder un % accionario";
                        mainActivity.changeView(15,false);
                        break;
                    case 3:
                        mainActivity.encuetado.nececita = "nececita recursos y esta dispuesto a dar rendimientos";
                        mainActivity.changeView(4,false);
                        break;
                }
                break;

            case R.id.image_2:
                switch (config){
                    case 0:
                        mainActivity.encuetado.tieneproyecto = false;
                        mainActivity.changeView(8,false);
                        break;
                    case 1:
                        mainActivity.encuetado.estado_del_proyecto ="Arrancando";
                        mainActivity.changeView(10,false);
                        break;
                    case 2:
                        mainActivity.encuetado.esta_dispuesto = "recibir recursos de invercionista";
                        mainActivity.changeView(14,false);
                        break;
                    case 3:
                        mainActivity.encuetado.nececita = "dispuesto a ceder acciones";
                        mainActivity.changeView(6,false);

                        break;
                }
                break;

            case R.id.image_3:
                Log.e("OpLine","Imagen 3 config : "+config);
                if (config == 1){
                    Log.e("OpLine","Cambiando de vista a la 10");
                    mainActivity.changeView(10,false);
                }
                if (config == 2){
                    mainActivity.changeView(4,false);
                }
                if (config == 3){
                    mainActivity.changeView(12,false);
                }

                break;

            case R.id.image_4:
                switch (config){
                    case 3:
                        mainActivity.encuetado.nececita = "Iniciativa sin fines de lucro";
                        mainActivity.changeView(5,false);
                        break;
                }
                break;
        }
    }
}
