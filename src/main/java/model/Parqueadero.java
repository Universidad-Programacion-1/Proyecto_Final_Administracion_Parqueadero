package model;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.LinkedList;

public class Parqueadero {

	private String nombre;
	private Vehiculo vehiculo;
	private Cliente cliente;
	private Membresia membresia;
	private Tarifa tarifa;
	private Pago pago;
    private EspaciosDisponibles espaciosDisponibles;
	private Collection<Vehiculo> vehiculos;
	private Collection<Cliente> clientes;
	private String direccion;
	private String representante;
	private String telefono;
	private int espaciosTotal;

	public Parqueadero(String nombre, String direccion, String representante, String telefono) {
		this.nombre = nombre;
		this.direccion = direccion;
        vehiculos = new LinkedList<>();
		this.representante = representante;
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getRepresentante() {
		return representante;
	}

	public void setRepresentante(String representante) {
		this.representante = representante;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public boolean actualizarCliente(String cedula, Cliente actualizado) {
        boolean centinela = false;
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
            	cliente.setNombre(actualizado.getNombre());
            	cliente.setCedula(actualizado.getCedula());
            	cliente.setTelefono(actualizado.getTelefono());
            	cliente.setCorreo(actualizado.getCorreo());
            	cliente.setPlaca(actualizado.getPlaca());
                centinela = true;
                break;
            }
        }
        return centinela;
    }
				
	public boolean eliminarCliente(String cedula) {
        boolean centinela = false;
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
            	clientes.remove(cliente);
                centinela = true;
                break;
            }
        }
        return centinela;
    }
	
	
	public Cliente buscarCliente (String cedula) {
		for(Cliente cliente : clientes) {
			 if (cliente.getCedula().equals(cedula)) {
				 return cliente;
			 }
		}
		return null;
	}
	
	public boolean verificarCliente(String cedula) {
        boolean centinela = false;
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                centinela = true;
            }
        }
        return centinela;
    }
	
	public boolean crerCliente(Cliente cliente) {
		boolean centinela = false;
		if (!verificarCliente(cliente.getCedula())) {
			clientes.add(cliente);
						
			centinela = true;
		}
		return centinela;
	}

    public boolean crearTarifa(Tarifa precio){
        System.out.println(tarifa);
        boolean centinela = false;
        this.tarifa = precio;
        return centinela = true;
    }


	public boolean eliminarVehiculo(String placa) {
        boolean centinela = false;
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPlaca().equals(placa)) {
                vehiculos.remove(vehiculo);
                centinela = true;
                break;
            }
        }
        return centinela;
    }
	public boolean verificarVehiculo(String placa) {
        boolean centinela = false;
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPlaca().equals(placa)) {
                centinela = true;
            }
        }
        return centinela;
    }
    public String crearVehiculoTemporal(Vehiculo vehiculo, String tipoVehiculo) {
        System.out.println(vehiculo);
        if (!verificarVehiculo(vehiculo.getPlaca())) {
            if (tipoVehiculo.equals("Automovil")) {
                Automovil auto = new Automovil(vehiculo.getPlaca(), LocalDateTime.now());
                vehiculos.add(auto);
                restaEspaciosAutomovil();
            } 
            if (tipoVehiculo.equals("Moto")) {
                Moto moto = new Moto(vehiculo.getPlaca(), LocalDateTime.now());
                vehiculos.add(moto);
                restaEspaciosMoto();
            } 
            if (tipoVehiculo.equals("Camion")) {
                Camion camion = new Camion(vehiculo.getPlaca(), LocalDateTime.now());
                vehiculos.add(camion);
                restaEspaciosCamion();
            }
            else { 
            System.out.println("Tipo de vehículo desconocido.");
            }
            
        }
        return tipoVehiculo;
    }


    
    public String crearVehiculoMembresia(Vehiculo vehiculo, String tipoVehiculo) {
        System.out.println(vehiculo);
        //boolean centinela = false;
        if (!verificarVehiculo(vehiculo.getPlaca())) {
            //vehiculos.add(vehiculo);
        // Identificar el tipo de vehículo
            if (tipoVehiculo.equals("Automovil")) {
                Automovil auto = new Automovil(vehiculo.getPlaca(), vehiculo.getColor(),vehiculo.getModelo(), vehiculo.getMembresia());
                vehiculos.add(auto);
                restaEspaciosAutomovil();
            } 
            if (tipoVehiculo.equals("Moto")) {
                Moto moto = new Moto(vehiculo.getPlaca(), vehiculo.getColor(), vehiculo.getModelo(), vehiculo.getMembresia());
                vehiculos.add(moto);
                restaEspaciosMoto();
            } 
            if (tipoVehiculo.equals("Camion")) {
                Camion camion = new Camion(vehiculo.getPlaca(), vehiculo.getColor(), vehiculo.getModelo(), vehiculo.getMembresia());
                vehiculos.add(camion);
                restaEspaciosCamion();
            }
            else { 
            System.out.println("Tipo de vehículo desconocido.");
            }
            
        }
        return tipoVehiculo;
    }

    public Pago crearPagoVehiculoMembresia(String placa){
        Pago pago = null;
        for(Vehiculo vehiculo : vehiculos){
            if(vehiculo.getPlaca().equals(placa)){
                System.out.println("si entro");
                if (vehiculo instanceof Automovil){
                    System.out.println("Tipo de vehiculo"+ vehiculo.getMembresia().getTipoMembresia());
                    System.out.println("Tipo membresia" + TipoMembresia.MESAUTO);
                    if(vehiculo.getMembresia().getTipoMembresia()==TipoMembresia.MESAUTO){
                        pago = new Pago(getNombre(), vehiculo.getPlaca(),vehiculo.getMembresia().getTipoMembresia() , LocalDate.now(), tarifa.getPrecioAutomovilMes());
                    }
                }
                if(vehiculo instanceof Moto){
                    System.out.println("Tipo de Vehiculo"+ vehiculo.getMembresia().getTipoMembresia());
                    System.out.println("Tipo de membresia"+ TipoMembresia.MESMOTO);
                    if(vehiculo.getMembresia().getTipoMembresia()==TipoMembresia.MESMOTO){
                        pago = new Pago(getNombre(), vehiculo.getPlaca(), vehiculo.getMembresia().getTipoMembresia(), LocalDate.now(), tarifa.getPrecioMotoMes());
                    }
                }
                if(vehiculo instanceof Camion){
                    System.out.println("Tipo de Vehiculo"+ vehiculo.getMembresia().getTipoMembresia());
                    System.out.println("Tipo de membresia"+ TipoMembresia.MESCAMION);
                    if(vehiculo.getMembresia().getTipoMembresia()==TipoMembresia.MESCAMION){
                        pago = new Pago(getNombre(),vehiculo.getPlaca(),vehiculo.getMembresia().getTipoMembresia(), LocalDate.now(), tarifa.getPrecioMotoMes());
                    }
                }
            }
        }
        return pago;

    }
	public boolean actualizarVehiculo(String placa, Vehiculo actualizado) {
        boolean centinela = false;
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPlaca().equals(placa)) {
                vehiculo.setPlaca(actualizado.getPlaca());
                vehiculo.setColor(actualizado.getColor());
                vehiculo.setModelo(actualizado.getModelo());
                centinela = true;
                break;
            }
        }
        return centinela;
    }
    public boolean restaEspaciosAutomovil(){
        int espacios = espaciosDisponibles.getEspaciosAutomovil();
        boolean centinela = false;
        if(espacios != 0){
            espaciosDisponibles.setEspaciosAutomovil(espacios-1);
            centinela = true;
        }
        else{
            System.out.println("NO HAY ESPACIOS DISPONIBLES");
        }
        return centinela;
    }
    public boolean restaEspaciosMoto(){
        int espacios = espaciosDisponibles.getEspaciosMoto();
        boolean centinela = false;
        if(espacios != 0){
            espaciosDisponibles.setEspaciosMoto(espacios-1);
            centinela = true;
        }
        else{
            System.out.println("NO HAY ESPACIOS DISPONIBLES");
        }
        return centinela;
    }
    public boolean restaEspaciosCamion(){
        int espacios = espaciosDisponibles.getEspaciosCamion();
        boolean centinela = false;
        if(espacios != 0){
            espaciosDisponibles.setEspaciosCamion(espacios-1);
            centinela = true;
        }
        else{
            System.out.println("NO HAY ESPACIOS DISPONIBLES");
        }
        return centinela;
    }
	
    


		

		

		
}