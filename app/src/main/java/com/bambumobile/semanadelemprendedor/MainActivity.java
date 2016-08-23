package com.bambumobile.semanadelemprendedor;

import android.animation.LayoutTransition;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.andexert.library.RippleView;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by bambumobile on 29/09/15.
 */
public class MainActivity extends FragmentActivity implements RippleView.OnRippleCompleteListener{

    LinearLayout view_root;
    TextView titulo_pregunta;
    public RippleView backQuestion;
    Encuetado encuetado;
    ArrayList<Integer> camino;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);


        if(Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) {
            View v = this.getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else if(Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            decorView.setSystemUiVisibility(uiOptions);
        }

        camino = new ArrayList<>();
        encuetado = new Encuetado();
        LayoutTransition transition = new LayoutTransition();
        view_root = (LinearLayout) findViewById(R.id.root_view_ly);
        view_root.setLayoutTransition(transition);
        titulo_pregunta = (TextView) findViewById(R.id.title_root);

        backQuestion = (RippleView)findViewById(R.id.back);
        backQuestion.setOnRippleCompleteListener(this);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contain_view, new GeneroFragment(), "")
                .commit();
    }
    static ArrayList<Integer> removeDuplicates(ArrayList<Integer> list) {

        ArrayList<Integer> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (Integer item : list) {
            if (!set.contains(item)) {
                result.add(item);
                set.add(item);
            }
        }
        return result;
    }
    @Override
    public void onComplete(RippleView rippleView) {
            switch (rippleView.getId()){
                case R.id.back:
                    camino = removeDuplicates(camino);
                    String phat = "";
                    for (int i =0;i<camino.size(); i++) {
                        phat +=" "+camino.get(i)+" ";
                    }
                    camino.remove(camino.size() - 1);
                    backQuestion.setVisibility(View.VISIBLE);
                    Log.e("MainActivity","Secuencia : "+phat);
                    Log.e("MainActivity", "Size : " + camino.size());
                    Log.e("MainActivity", "Camino : " + camino.get(camino.size() - 1));
                    changeView(camino.get(camino.size() - 1),true);
                    break;

            }
    }
    private void changeFrgmaet(Fragment salida,boolean es_salida){
        if (es_salida){
                getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.entrar_derecha, R.anim.salir_izquerda)
                .replace(R.id.contain_view, salida , "")
                .commit();
        }else {
            getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.entrar_izquierda, R.anim.salir_derecha)
                    .replace(R.id.contain_view, salida , "")
                    .commit();
        }
    }

    public void changeView(int no_pantalla,boolean estado){

        switch (no_pantalla){
            case 1:
                GeneroFragment genero = new GeneroFragment();
                genero.config = 0;
                backQuestion.setVisibility(View.INVISIBLE);
                changeFrgmaet(genero,estado);
                break;
            case 2:
                CuatroOpciones frg = new CuatroOpciones();
                frg.config=0;
                changeFrgmaet(frg,estado);
                break;
            case 3:
                CuatroOpciones frag = new CuatroOpciones();
                frag.config=1;
                changeFrgmaet(frag,estado);
                break;
            case 4:
                Salida salidaDeuda = new Salida();
                salidaDeuda.config =3;
                changeFrgmaet(salidaDeuda,estado);
                break;
            case 5:
                Salida salidaDonacion = new Salida();
                salidaDonacion.config =1;
                changeFrgmaet(salidaDonacion,estado);
                break;
            case 6:
                Salida salidaCapital = new Salida();
                salidaCapital.config =0;
                changeFrgmaet(salidaCapital,estado);
                break;
            case 7:
                OpcionesLineales opcionesLineales = new OpcionesLineales();
                opcionesLineales.config = 0;
                changeFrgmaet(opcionesLineales,estado);
                break;
            case 8:
                Salida salidaInfo = new Salida();
                salidaInfo.config =7;
                changeFrgmaet(salidaInfo,estado);
                break;
            case 9:
                OpcionesLineales proyectoEstado = new OpcionesLineales();
                proyectoEstado.config = 1;
                changeFrgmaet(proyectoEstado,estado);
                break;
            case 10:
                GeneroFragment industria = new GeneroFragment();
                industria.config = 1;
                changeFrgmaet(industria,estado);
                break;
            case 11:
                OpcionesLineales proyectoNeed = new OpcionesLineales();
                proyectoNeed.config = 3;
                changeFrgmaet(proyectoNeed,estado);
                break;
            case 12:
                Salida salidaRecop = new Salida();
                salidaRecop.config =2;
                changeFrgmaet(salidaRecop,estado);
                break;
            case 13:
                OpcionesLineales proyectoDisp = new OpcionesLineales();
                proyectoDisp.config = 2;
                changeFrgmaet(proyectoDisp,estado);
                break;
            case 14:
                Salida salidaCon = new Salida();
                salidaCon.config =4;
                changeFrgmaet(salidaCon,estado);
                break;
            case 15:
                Salida salidaInver = new Salida();
                salidaInver.config =5;
                changeFrgmaet(salidaInver,estado);
                break;
            case 16:
                Salida salidaPreguntas = new Salida();
                salidaPreguntas.config =6;
                changeFrgmaet(salidaPreguntas,estado);
                break;

        }
    }

}
