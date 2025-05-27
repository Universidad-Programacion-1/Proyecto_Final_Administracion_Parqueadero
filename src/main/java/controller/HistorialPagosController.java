package controller;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;

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
    
    public Collection<HistorialPagos> filtrarPagos(LocalDate inicio, LocalDate fin) {
        System.out.println("XXXXXXXXXXXXXXXXXXXXX"+ parqueadero.filtrarPagosPorFecha(inicio, fin));
		return parqueadero.filtrarPagosPorFecha(inicio, fin);
	}
    
}
