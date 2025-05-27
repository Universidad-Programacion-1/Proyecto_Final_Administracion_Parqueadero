package controller;

import java.util.Collection;

import model.Pago;
import model.Parqueadero;
import model.Vehiculo;

public class MenuParqueaderoController {

	Parqueadero parqueadero;

    public MenuParqueaderoController(Parqueadero parqueadero) {
        this.parqueadero = parqueadero;
    }
    
    public boolean crearVehiculoTemporal(Vehiculo vehiculo, String tipo) {
        return parqueadero.crearVehiculoTemporal(vehiculo, tipo);
    }
    
	public Collection<Vehiculo> obtenerListaVehiculos() {
        return parqueadero.getListaVehiculos();
    }
	
	public Pago pagoVehiculoMembresia(String placa){
		return parqueadero.crearPagoVehiculoMembresia(placa);
	}
  
	public Pago pagoVehiculoTemporal(String placa){
		return parqueadero.crearPagoVehiculoTemporal(placa);
	}
	
	public int EspacioCamion(){
		return parqueadero.getEspaciosDisponibles().getEspaciosCamion();
	}
  
	public int EspacioMoto(){
		return parqueadero.getEspaciosDisponibles().getEspaciosMoto();
	}
	
	public int EspacioAutomovil(){
		return parqueadero.getEspaciosDisponibles().getEspaciosAutomovil();
	}
}
