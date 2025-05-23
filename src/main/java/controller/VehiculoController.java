package controller;

import java.util.Collection;

import model.Parqueadero;
import model.Vehiculo;

public class VehiculoController {

	Parqueadero parqueadero;

    public VehiculoController(Parqueadero parqueadero) {
        this.parqueadero = parqueadero;
    }

    public boolean crearVehiculoMembresia(Vehiculo vehiculo, String tipo) {
        return parqueadero.crearVehiculoMembresia(vehiculo, tipo);
    }

    public Collection<Vehiculo> obtenerListaVehiculos() {
        return parqueadero.getListaVehiculos();
    }

    public boolean eliminarVehiculo(String placa) {
       return parqueadero.eliminarVehiculo(placa);
    }

    public boolean actualizarVehiculo(String placa, Vehiculo vehiculo) {
       return parqueadero.actualizarVehiculo(placa, vehiculo);
    }
//
//    public boolean comprarVehiculo(Vehiculo vehiculo){
//        return consecionario.crearCompraMoto(vehiculo);
//    }
}
