package edu.teamrocket.cotxox.tarifa;

import edu.teamrocket.cotxox.carrera.Carrera;

public class Tarifa {
    final static double COSTE_MILLA = 1.35;
    final static double COSTE_MINUTO = 0.35;
    final static double COSTE_MINIMO = 5.20;
    final static byte PORCENTAJE_COMISION = 20;
    
    public Tarifa (){}

    public static double getCosteDistancia(double distancia){
        return distancia * COSTE_MILLA;
    }

    public static double getCosteTiempo(int minutos) {
        return minutos * COSTE_MINIMO;
    }

    public static double getCosteTotalEsperado(Carrera carrera) {
        double costeTotal = getCosteDistancia(carrera.getDistancia()) + getCosteTiempo(carrera.getTiempoEsperado());
        return costeTotal > COSTE_MINIMO ? costeTotal : COSTE_MINIMO;
    }
}
