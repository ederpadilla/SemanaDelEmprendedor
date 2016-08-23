package com.bambumobile.semanadelemprendedor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.andexert.library.RippleView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

/**
 * Created by bambumobile on 30/09/15.
 */
public class Salida extends Fragment implements RippleView.OnRippleCompleteListener{

    TextView informacion;
    RippleView terminar;
    ImageView imagen;
    MainActivity mainActivity;
    LinearLayout container_view;
    public int config;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.salida_framgent,container, false);
        mainActivity = (MainActivity)getActivity();
        informacion = (TextView)view.findViewById(R.id.texto_salida);
        terminar = (RippleView)view.findViewById(R.id.salida_rpv);
        terminar.setOnRippleCompleteListener(this);
        container_view = (LinearLayout) view.findViewById(R.id.view_root_salida);
        imagen = (ImageView)view.findViewById(R.id.imagen_salida);
        mainActivity.titulo_pregunta.setText("");
        configuaracion(config);

        return  view;
    }

    @Override
    public void onComplete(RippleView rippleView) {
        salvarInformacion();
        Intent terminar = new Intent(mainActivity.getApplicationContext(),InicarEncuesta.class);
        mainActivity.startActivity(terminar);
        mainActivity.finish();
    }

    public void salvarInformacion(){
        String encuestado = readFromFile();
        encuestado = mainActivity.encuetado.toString()+"\n";
        writeToFile(encuestado);
        Log.e("Encuentado", mainActivity.encuetado.toString());
    }

    private void writeToFile(String data) {
        try {

            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(mainActivity.openFileOutput("encuesta.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }


    private String readFromFile() {

        String ret = "";

        try {
            InputStream inputStream = mainActivity.openFileInput("encuesta.txt");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        return ret;
    }

    public void configuaracion(int vista){
        switch (vista){
            //Capital
            case 0:
                mainActivity.camino.add(6);
                informacion.setText(getString(R.string.capital_salida));
                imagen.setImageResource(R.mipmap.capital);
                mainActivity.encuetado.termino_en = "Platafoma de Capital";
                break;
            //Donacion
            case 1:
                mainActivity.camino.add(5);
                informacion.setText(getString(R.string.donacion_salida));
                imagen.setImageResource(R.mipmap.donacion);
                mainActivity.encuetado.termino_en = "Platafoma de Donacion";
                break;
            //Recompensas
            case 2:
                mainActivity.camino.add(12);
                informacion.setText(getString(R.string.recompensa_salida));
                imagen.setImageResource(R.mipmap.recompensa);
                mainActivity.encuetado.termino_en = "Platafoma de Recompensa";
                break;
            //Deuda
            case 3:
                mainActivity.camino.add(4);
                informacion.setText(getString(R.string.deuda_salida));
                imagen.setImageResource(R.mipmap.deuda);
                mainActivity.encuetado.termino_en = "Platafoma de Deuda";
                break;
            //Opciones
            case 4:
                mainActivity.camino.add(14);
                informacion.setText(getString(R.string.salida_texto));
                container_view.removeView(imagen);
                mainActivity.encuetado.termino_en = "Platafoma de Opciones";
                break;
            //Invercionista
            case 5:
                mainActivity.camino.add(16);
                informacion.setText(getString(R.string.salida_invercionista));
                imagen.setImageResource(R.mipmap.capital);
                mainActivity.encuetado.termino_en = "Platafoma de Invercion";
                break;

            //Informacion apoyos
            case 6:
                mainActivity.camino.add(16);
                informacion.setText(getString(R.string.salida_invercionista));
                imagen.setImageResource(R.mipmap.capital);
                mainActivity.encuetado.termino_en = "Platafoma de Invercion";
                break;
            case 7:
                mainActivity.camino.add(8);
                informacion.setText(getString(R.string.inf_proyecto_no_salida));
                container_view.removeView(imagen);
                mainActivity.titulo_pregunta.setVisibility(View.VISIBLE);
                mainActivity.titulo_pregunta.setText("¿Sabías que...?");
                mainActivity.encuetado.termino_en="Sabias que..?";
                break;

        }
    }
}
