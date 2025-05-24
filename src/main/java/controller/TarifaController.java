package controller;

import java.util.Collection;

import model.Cliente;
import model.Parqueadero;
import model.Tarifa;

public class TarifaController {

	Parqueadero parqueadero;

    public TarifaController(Parqueadero parqueadero) {
        this.parqueadero = parqueadero;
    }

    public Tarifa obtenerTarifa() {
        return parqueadero.getTarifa();
    }

    public boolean actualizarTarifa(Tarifa tarifa) {
       return parqueadero.modificarTarifa(tarifa);
    }
}
