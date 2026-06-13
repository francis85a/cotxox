package edu.teamrocket.cotxox.conductor;

import java.util.ArrayList;

public class Conductor {

    private String nombre = null;
    private String modelo = null;
    private String matricula = null;
    private double valoracionMedia = 0d;
    private boolean ocupado = false;
    private ArrayList<Byte> valoraciones = new ArrayList<>();
    

    public Conductor(){

    }

    public Conductor (String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public String getModelo(){
        return this.modelo;
    }

    public void setMatricula(String matricula){
        this.matricula = matricula;
    }

    public String getMatricula(){
        return this.matricula;
    }

    public void setValoracion(byte valoracion){

        this.valoraciones.add(valoracion);
        this.calcularValoracionMedia();
    }

    public double getValoracion() {
        return this.valoracionMedia;
    }

    public int getNumeroValoraciones() {
        return this.valoraciones.size();
    }

    private double calcularValoracionMedia() {
        int sumaValoraciones = 0;
        for (byte valoracion : this.valoraciones) {
            sumaValoraciones += valoracion;
        }

        this.valoracionMedia = (double) sumaValoraciones / getNumeroValoraciones();
        return this.valoracionMedia;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public boolean isOcupado() {
        return this.ocupado;
    }


}
