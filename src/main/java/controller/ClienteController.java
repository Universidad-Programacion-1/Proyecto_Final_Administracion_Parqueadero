package controller;

import java.util.Collection;
import model.Cliente;
import model.Parqueadero;



public class ClienteController {
	Parqueadero parqueadero;

    public ClienteController(Parqueadero parqueadero) {
        this.parqueadero = parqueadero;
    }

    public boolean crearCliente(Cliente cliente) {
        return parqueadero.crearCliente(cliente);
    }

    public Collection<Cliente> obtenerListaClientes() {
        return parqueadero.getListaClientes();
    }

    public boolean eliminarCliente(String cedula) {
       return parqueadero.eliminarCliente(cedula);
    }

    public boolean actualizarCliente(String cedula, Cliente actualizado) {
       return parqueadero.actualizarCliente(cedula, actualizado);
    }

    public Cliente buscarCliente(String cedula) {
    	return parqueadero.buscarCliente(cedula);
    	
    }
//    public boolean comprarVehiculo(Vehiculo vehiculo){
//        return consecionario.crearCompraMoto(vehiculo);
//    }

}
