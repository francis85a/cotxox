package edu.teamrocket.cotxox.carrera;

import edu.teamrocket.cotxox.conductor.Conductor;

public class Carrera {
    private String tarjetaCredito = null;
    private String origen = null;
    private String destino = null;
    private double distancia = 0;
    private int tiempoEsperado = 0;
    private int tiempoCarrera = 0;
    private double costeTotal = 0;
    private int propina = 0;



    public Carrera(String tarjetaCredito){
        this.tarjetaCredito = tarjetaCredito;
    }

    private Conductor conductor = null;

    String getTarjetaCredito() {
        return this.tarjetaCredito;
    }

    void setOrigen (String origen) {
        this.origen = origen;
    }

    String getOrigen() {
        return this.origen;
    }

    void setDestino (String destino) {
        this.destino = destino;
    }
    String getDestino() {
        return this.destino;
    }

    void setDistancia (double distancia) {
        this.distancia = distancia;
    }

    double getDistancia() {
        return this.distancia;
    }

    void setTiempoEsperado (int tiempoEsperado) {
        this.tiempoEsperado = tiempoEsperado;
    }

    int getTiempoEsperado() {
        return this.tiempoEsperado;
    }

    double getCosteEsperado() {
        return this.distancia;
    }

    void setTiempoCarrera (int tiempoCarrera) {
        this.tiempoCarrera = tiempoCarrera;
    }

    int getTiempoCarrera() {
        return this.tiempoCarrera;
    }

    void setConductor (Conductor conductor) {
        this.conductor = conductor;
    }

    Conductor getConductor() {
        return this.conductor;
    }

    public void asignarConductor(PoolConductores conductores) {
        setConductor(conductores.asignarConductor());
    }

    public void realizarPago(double pago) {
        this.costeTotal = pago;
    }

    double getCosteTotal(){
        return this.costeTotal;
    }

    public void recibirPropina(int propina) {
        this.propina = propina;
    }

    int getPropina(){
        return this.propina;
    }

    public void liberarConductor(){
        getConductor().setOcupado(false);
    }




}