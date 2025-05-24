package model;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.LinkedList;

public class Parqueadero {

	private String nombre;
	private Vehiculo vehiculo;
	private Membresia membresia;
	private Tarifa tarifa;
	private Pago pago;
    private EspaciosDisponibles espaciosDisponibles;
	private Collection<Vehiculo> listaVehiculos;
	private String direccion;
	private String representante;
	private String telefono;
	private int espaciosTotal;

	public Parqueadero(String nombre, String direccion, String representante, String telefono) {
		this.nombre = nombre;
		this.direccion = direccion;
        this.listaVehiculos = new LinkedList<>();
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

	public Collection<Vehiculo> getListaVehiculos() {
		return listaVehiculos;
	}

	public void setListaVehiculos(Collection<Vehiculo> listaVehiculos) {
		this.listaVehiculos = listaVehiculos;
	}
	
	public void crearEspacipos(EspaciosDisponibles espaciosDisponibles) {
		this.espaciosDisponibles = espaciosDisponibles;
	}

	public boolean crearTarifa(Tarifa precio){
        System.out.println(tarifa);
        boolean centinela = false;
        this.tarifa = precio;
        return centinela = true;
    }


	public boolean eliminarVehiculo(String placa) {
        boolean centinela = false;
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.getPlaca().equals(placa)) {
            	listaVehiculos.remove(vehiculo);
                centinela = true;
                break;
            }
        }
        return centinela;
    }
	public boolean verificarVehiculo(String placa) {
        boolean centinela = false;
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.getPlaca().equals(placa)) {
                centinela = true;
            }
        }
        return centinela;
    }
    public boolean crearVehiculoTemporal(Vehiculo vehiculo, String tipoVehiculo) {
    	boolean centinela = false;
        System.out.println(tipoVehiculo);
        System.out.println(vehiculo.getPlaca());
        if (!verificarVehiculo(vehiculo.getPlaca())) {
            if (tipoVehiculo.equals("Automovil")) {
                Automovil auto = new Automovil(vehiculo.getPlaca(), vehiculo.getFechaIngreso());
                listaVehiculos.add(auto);
                restaEspaciosAutomovil();
                centinela = true;
            } 
            if (tipoVehiculo.equals("Moto")) {
                Moto moto = new Moto(vehiculo.getPlaca(), vehiculo.getFechaIngreso());
                listaVehiculos.add(moto);
                restaEspaciosMoto();
                centinela = true;
            } 
            if (tipoVehiculo.equals("Camion")) {
                Camion camion = new Camion(vehiculo.getPlaca(), vehiculo.getFechaIngreso());
                listaVehiculos.add(camion);
                restaEspaciosCamion();
                centinela = true;
            }
            else { 
            System.out.println("Tipo de vehículo desconocido.");
            }
            
        }
        return centinela;
    }


    
    public boolean crearVehiculoMembresia(Vehiculo vehiculo, String tipoVehiculo) {
        System.out.println(vehiculo);
        System.out.println("Espacios"+ espaciosDisponibles.getEspaciosAutomovil());
        boolean centinela = false;
        if (!verificarVehiculo(vehiculo.getPlaca())) {
            //vehiculos.add(vehiculo);
        // Identificar el tipo de vehículo
            if (tipoVehiculo.equals("Automovil")) {
                Automovil auto = new Automovil(vehiculo.getPlaca(), vehiculo.getColor(),vehiculo.getModelo(), vehiculo.getMembresia());
                listaVehiculos.add(auto);
                restaEspaciosAutomovil();
                centinela = true;
            } 
            if (tipoVehiculo.equals("Moto")) {
                Moto moto = new Moto(vehiculo.getPlaca(), vehiculo.getColor(), vehiculo.getModelo(), vehiculo.getMembresia());
                listaVehiculos.add(moto);
                restaEspaciosMoto();
                centinela = true;
            } 
            if (tipoVehiculo.equals("Camion")) {
                Camion camion = new Camion(vehiculo.getPlaca(), vehiculo.getColor(), vehiculo.getModelo(), vehiculo.getMembresia());
                listaVehiculos.add(camion);
                restaEspaciosCamion();
                centinela = true;
            }
            else { 
            System.out.println("Tipo de vehículo desconocido.");
            }
            
        }
        return centinela;
    }

    public Pago crearPagoVehiculoMembresia(String placa){
        Pago pago = null;
        for(Vehiculo vehiculo : listaVehiculos){
            if(vehiculo.getPlaca().equals(placa)){
                System.out.println("si entro");
                if (vehiculo instanceof Automovil){
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
        for (Vehiculo vehiculo : listaVehiculos) {
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