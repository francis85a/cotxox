package edu.teamrocket.cotxox.carrera;

import edu.teamrocket.cotxox.conductor.*;
import edu.teamrocket.cotxox.tarifa.Tarifa;

public class Carrera {
    private String tarjetaCredito = null;
    private String origen = null;
    private String destino = null;
    private double distancia = 0d;
    private int tiempoEsperado = 0;
    private int tiempoCarrera = 0;
    private double costeTotal = 0;
    private int propina = 0;

    private Conductor conductor = null;

    public Carrera(String tarjetaCredito){
        this.tarjetaCredito = tarjetaCredito;
    }

    public String getTarjetaCredito() {
        return this.tarjetaCredito;
    }

    public void setOrigen (String origen) {
        this.origen = origen;
    }

    public String getOrigen() {
        return this.origen;
    }

    public void setDestino (String destino) {
        this.destino = destino;
    }
    public String getDestino() {
        return this.destino;
    }

    public void setDistancia (double distancia) {
        this.distancia = distancia;
    }

    public double getDistancia() {
        return this.distancia;
    }

    public void setTiempoEsperado (int tiempoEsperado) {
        this.tiempoEsperado = tiempoEsperado;
    }

    public int getTiempoEsperado() {
        return this.tiempoEsperado;
    }

    public double getCosteEsperado() {
        return Tarifa.getCosteTotalEsperado(this);
    }

    public void setTiempoCarrera (int tiempoCarrera) {
        this.tiempoCarrera = tiempoCarrera;
    }

    public int getTiempoCarrera() {
        return this.tiempoCarrera;
    }

    public void setConductor (Conductor conductor) {
        this.conductor = conductor;
    }

    public Conductor getConductor() {
        return this.conductor;
    }

    public void asignarConductor(PoolConductores conductores) {
        setConductor(conductores.asignarConductor());
    }

    public void realizarPago(double pago) {
        this.costeTotal = pago;
    }

    public double getCosteTotal(){
        return this.costeTotal;
    }

    public void recibirPropina(int propina) {
        this.propina = propina;
    }

    public int getPropina(){
        return this.propina;
    }

    public void liberarConductor(){
        getConductor().setOcupado(false);
    }

}