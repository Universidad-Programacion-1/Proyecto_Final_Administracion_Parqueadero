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
	private Collection<Vehiculo> vehiculos;
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
    /* 
	public boolean crearVehiculo(Vehiculo vehiculo) {
		System.out.println(vehiculo);
		boolean centinela = false;
		if (!verificarVehiculo(vehiculo.getPlaca())) {
            vehiculos.add(vehiculo);
            centinela = true;
		}
		return centinela;
		
    }
        */

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
    public String crearVehiculoTemporal(Vehiculo vehiculo) {
    for (Vehiculo v : vehiculos) {
        if (v.getPlaca().equalsIgnoreCase(vehiculo.getPlaca())) {
            LocalDateTime fechaIngreso = vehiculo.getFechaIngreso(); 
            // OTRO METODO Duration duracion = Duration.between(fechaIngreso);
            long horas = duracion.toHours();
            if (duracion.toMinutes() % 60 != 0) {
                horas++; 
            }

            int tarifaPorHora = 0;
            if (vehiculo instanceof Automovil) {
                tarifaPorHora = tarifa.getPrecioAutomovilHora();
            } else if (vehiculo instanceof Moto) {
                tarifaPorHora = tarifa.getPrecioMotoHora();
            } else if (vehiculo instanceof Camion) {
                tarifaPorHora = tarifa.getPrecioCamionHora();
            }

            int total = (int) horas * tarifaPorHora;
            vehiculos.remove(vehiculo);

            return "Vehículo con placa " + placa + " estuvo " + horas + " horas. Total a pagar: $" + total;
        }
    }

    return "Vehículo no encontrado.";
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


            } else if (tipoVehiculo.equals("Moto")) {
                tipoVehiculo= "Moto";
                vehiculos.add(vehiculo);
            } else if (vehiculo instanceof Camion) {
            tipoVehiculo= "Camion";
            vehiculos.add(vehiculo);
            } else { 
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
                        pago = new Pago(getNombre(),vehiculo.getPlaca(),, null, espaciosTotal)
                    }
                }
            }
        }
        return pago;

    }
    
    //public boolean CobrarVehiculoMembresia(Vehiculo vehiculo, Tarifa tarifa){
    //    boolean centinela = false;
        //if(){

        //}

    //}
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

    
	//public boolean eliminarAutomovil(String placa) {
    //    boolean centinela = false;
    //    for (Automovil automovil : automoviles) {
    //        if (automovil.getPlaca().equals(placa)) {
    //            automoviles.remove(automovil);
    //            centinela = true;
    //            break;
    //        }
    //    }
    //    return centinela;
    //}
	//public boolean verificarAutomovil(String placa) {
    //    boolean centinela = false;
    //    for (Automovil automovil : automoviles) {
    //        if (automovil.getPlaca().equals(placa)) {
    //            centinela = true;
    //        }
    //    }
    //    return centinela;
    //}
	//public boolean actualizarAutomovil(String placa, Automovil actualizado) {
    //    boolean centinela = false;
    //    for (Automovil automovil : automoviles) {
    //        if (automovil.getPlaca().equals(placa)) {
    //            automovil.setPlaca(actualizado.getPlaca());
    //            automovil.setColor(actualizado.getColor());
    //            automovil.setModelo(actualizado.getModelo());
    //            automovil.setPrecio(actualizado.getPrecio());
    //            centinela = true;
    //            break;
    //        }
    //    }
    //    return centinela;
    //}
	
    


		

		

		
}