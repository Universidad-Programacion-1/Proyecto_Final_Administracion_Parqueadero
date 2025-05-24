package controller;

import model.EspaciosDisponibles;
import model.Parqueadero;
import model.Tarifa;

public class EspaciosDisponiblesController {

	Parqueadero parqueadero;

    public EspaciosDisponiblesController(Parqueadero parqueadero) {
        this.parqueadero = parqueadero;
    }

    public EspaciosDisponibles obtenerEspaciosDisponibles() {
        return parqueadero.getEspaciosDisponibles();
    }

    public boolean actualizarEspaciposDisponibles(EspaciosDisponibles esoacios) {
       return parqueadero.actualizarEspaciposDisponibles(esoacios);
    }
}
