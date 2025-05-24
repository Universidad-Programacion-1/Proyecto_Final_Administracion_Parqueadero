package controller;

import java.util.Collection;

import model.HistorialPagos;
import model.Parqueadero;
import model.Vehiculo;

public class HistorialPagosController {

	Parqueadero parqueadero;

    public HistorialPagosController(Parqueadero parqueadero) {
        this.parqueadero = parqueadero;
    }

    public Collection<HistorialPagos> obtenerListaHistorialPagos() {
        return parqueadero.gethistorialPagos();
    }
}
