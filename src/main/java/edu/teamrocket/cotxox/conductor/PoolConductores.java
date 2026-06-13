package edu.teamrocket.cotxox.conductor;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class PoolConductores {

    private List<Conductor> poolConductores = new ArrayList<Conductor>();
    public PoolConductores(List<Conductor> poolConductores) {
        this.poolConductores = poolConductores;
    }

    public List<Conductor> getPoolConductores(){
        return this.poolConductores;
    }

    public Conductor asignarConductor(){
        Conductor conductor = new Conductor();
        Random aleatorio = new Random();

        boolean asignado = false;

        while (!asignado){
            int index = aleatorio.nextInt(getPoolConductores().size());
            conductor = getPoolConductores().get(index);
            if (!conductor.isOcupado()) {
                conductor.setOcupado(true);
                asignado = true;
            }
        }
        return conductor;
    }
    
}
