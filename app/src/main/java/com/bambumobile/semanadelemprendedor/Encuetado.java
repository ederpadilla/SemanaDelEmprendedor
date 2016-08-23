package com.bambumobile.semanadelemprendedor;

/**
 * Created by bambumobile on 29/09/15.
 */
public class Encuetado {
    public String genero;
    public String edad;
    public String oficio;//Emprendedor,Estudiante,Invercionista,Fondeador
    public String busca;
    public boolean tieneproyecto;
    public String estado_del_proyecto;
    public String sector_del_proyecto;
    public String tipo_del_proyecto;//Alto impacto o Tradicional
    public String esta_dispuesto;
    public String nececita;
    public String termino_en;

    public Encuetado (){
        this.genero ="-";
        this.edad="-";
        this.oficio="-";
        this.busca="-";
        this.tieneproyecto = false;
        this.estado_del_proyecto ="-";
        this.sector_del_proyecto ="-";
        this.tipo_del_proyecto = "-";
        this.esta_dispuesto = "-";
        this.nececita ="-";
        this.termino_en ="-";
    }

    @Override
    public String toString(){
        String a =this.genero+","+this.edad+","+this.oficio+","+this.busca+","+this.tieneproyecto+","+this.estado_del_proyecto+","+
                    this.sector_del_proyecto+","+this.tipo_del_proyecto+","+this.esta_dispuesto+","+this.nececita+","+this.termino_en;
        return a;
    }

}
