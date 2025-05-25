package model;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class Parqueadero {

	private String nombre;
	private Vehiculo vehiculo;
	private Membresia membresia;
	private Tarifa tarifa;
	private Pago pago;
    private Collection<HistorialPagos> historialPagos;
    private EspaciosDisponibles espaciosDisponibles;
    private Collection<Cliente> listaClientes;
	private Collection<Vehiculo> listaVehiculos;
	private String direccion;
	private String representante;
	private String telefono;
	private int espaciosTotal;

	public Parqueadero(String nombre, String direccion, String representante, String telefono) {
		this.nombre = nombre;
		this.direccion = direccion;
        this.listaVehiculos = new LinkedList<>();
        this.historialPagos = new LinkedList<>();
        this.listaClientes = new LinkedList<>();
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

    public Collection<HistorialPagos> gethistorialPagos() {
		return historialPagos;
	}

	public void sethistorialPagos(Collection<HistorialPagos> historialPagos) {
		this.historialPagos = historialPagos;
	}
	
	public EspaciosDisponibles getEspaciosDisponibles() {
		return espaciosDisponibles;
	}


	public void setEspaciosDisponibles(EspaciosDisponibles espaciosDisponibles) {
		this.espaciosDisponibles = espaciosDisponibles;
	}
	
	public Collection<Cliente> getListaClientes() {
		return listaClientes;
	}
	
	public void setListaClientes(Collection<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	public Tarifa getTarifa() {
		return tarifa;
	}


	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
	}
	
	public void crearEspaciposDisponibles(EspaciosDisponibles espaciosDisponibles) {
		this.espaciosDisponibles = espaciosDisponibles;
	}

	public boolean actualizarEspaciposDisponibles(EspaciosDisponibles espacios) {
        boolean centinela = false;       
        if (espacios != null) {
        	espaciosDisponibles.setEspaciosAutomovil(espacios.getEspaciosAutomovil());
        	espaciosDisponibles.setEspaciosCamion(espacios.getEspaciosCamion());
        	espaciosDisponibles.setEspaciosMoto(espacios.getEspaciosMoto());
        	restarVehiculosRegistrados();
        }
        return centinela;
    }
	
	public void restarVehiculosRegistrados() {
		for (Vehiculo vehiculo : listaVehiculos) {
			if (vehiculo instanceof Automovil){
				int espacios = espaciosDisponibles.getEspaciosAutomovil();
				espaciosDisponibles.setEspaciosAutomovil(espacios-1);
			}
            if (vehiculo instanceof Moto){
				int espacios = espaciosDisponibles.getEspaciosMoto();
				espaciosDisponibles.setEspaciosMoto(espacios-1);
			}
            if (vehiculo instanceof Camion){
				int espacios = espaciosDisponibles.getEspaciosCamion();
				espaciosDisponibles.setEspaciosCamion(espacios-1);
			}
		}
	}

	public boolean actualizarCliente(String cedula, Cliente actualizado) {
        boolean centinela = false;       
        for (Cliente cliente : listaClientes) {   
            if (cliente.getCedula().equals(cedula)) {
            	cliente.setNombre(actualizado.getNombre());
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
        for (Cliente cliente : listaClientes) {
            if (cliente.getCedula().equals(cedula)) {
            	listaClientes.remove(cliente);
                centinela = true;
                break;
            }
        }
        return centinela;
    }
	
	
	public Cliente buscarCliente (String cedula) {
		for(Cliente cliente : listaClientes) {
			 if (cliente.getCedula().equals(cedula)) {
				 return cliente;
			 }
		}
		return null;
	}
	
	public boolean verificarCliente(String cedula) {
        boolean centinela = false;
        for (Cliente cliente : listaClientes) {
            if (cliente.getCedula().equals(cedula)) {
                centinela = true;
            }
        }
        return centinela;
    }
	
	public boolean crearCliente(Cliente cliente) {
		boolean centinela = false;
		if (!verificarCliente(cliente.getCedula())) {
			if (verificarExistenciaVehiculo(cliente.getPlaca())) {
				listaClientes.add(cliente);
				
				centinela = true;
			}
			
		}
		return centinela;
	}
	
	public boolean verificarExistenciaVehiculo(String placa) {
		boolean centinela = false;
		for (Vehiculo vehiculo : listaVehiculos) {
			if (vehiculo.getPlaca().equals(placa)) {
				
				centinela = true;
			}			
		}
		return centinela;
	}

	public boolean crearTarifa(Tarifa precio){
        System.out.println(tarifa);
        boolean centinela = false;
        this.tarifa = precio;
        return centinela = true;
    }
    public boolean modificarTarifa(Tarifa actualizado) {
        boolean centinela = false;
        if (actualizado != null) {
            this.tarifa.setPrecioAnioAutomovil(actualizado.getPrecioAnioAutomovil());
            this.tarifa.setPrecioAnioCamion(actualizado.getPrecioAnioCamion());
            this.tarifa.setPrecioAnioMoto(actualizado.getPrecioAnioMoto());
            this.tarifa.setPrecioAutomovilHora(actualizado.getPrecioAutomovilHora());
            this.tarifa.setPrecioCamionHora(actualizado.getPrecioCamionHora());
            this.tarifa.setPrecioMotoHora(actualizado.getPrecioMotoHora());
            this.tarifa.setPrecioAutomovilTresMeses(actualizado.getPrecioAutomovilTresMeses());
            this.tarifa.setPrecioCamionTresMeses(actualizado.getPrecioCamionTresMeses());
            this.tarifa.setPrecioMotoTresMeses(actualizado.getPrecioMotoTresMeses());
            this.tarifa.setPrecioAutomovilMes(actualizado.getPrecioAutomovilMes());
            this.tarifa.setPrecioCamionMes(actualizado.getPrecioCamionMes());
            this.tarifa.setPrecioMotoMes(actualizado.getPrecioMotoMes());
            centinela = true;
//            break;
        }
        
        return centinela;
    }
    public boolean crearHistorialPagos(Pago pago) {
        boolean centinela = false;
        if (pago != null) {
            HistorialPagos historial = new HistorialPagos(pago, LocalDate.now());
            historialPagos.add(historial);
            centinela = true;
        }
        return centinela;
    }
    public boolean eliminarHistorialPagos(String placa) {
        boolean centinela = false;
        for (HistorialPagos historialpago : historialPagos) {
            if (historialpago.getPago().getPlaca().equals(placa)) {
            	historialPagos.remove(historialpago);
                centinela = true;
                break;
            }
        }
        return centinela;
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
                        crearHistorialPagos(pago);
                    }
                    else if(vehiculo.getMembresia().getTipoMembresia()==TipoMembresia.ANIOAUTO){
                        pago = new Pago(getNombre(), vehiculo.getPlaca(),vehiculo.getMembresia().getTipoMembresia() , LocalDate.now(), tarifa.getPrecioAnioAutomovil());
                        crearHistorialPagos(pago);
                    }
                    else if(vehiculo.getMembresia().getTipoMembresia()==TipoMembresia.TRESMESESAUTO){
                        pago = new Pago(getNombre(), vehiculo.getPlaca(),vehiculo.getMembresia().getTipoMembresia() , LocalDate.now(), tarifa.getPrecioAutomovilTresMeses());
                        crearHistorialPagos(pago);
                    }
                    
                }
                if(vehiculo instanceof Moto){
                    if(vehiculo.getMembresia().getTipoMembresia()==TipoMembresia.MESMOTO){
                        pago = new Pago(getNombre(), vehiculo.getPlaca(), vehiculo.getMembresia().getTipoMembresia(), LocalDate.now(), tarifa.getPrecioMotoMes());
                        crearHistorialPagos(pago);
                    }
                    else if(vehiculo.getMembresia().getTipoMembresia()==TipoMembresia.ANIOMOTO){
                        pago = new Pago(getNombre(), vehiculo.getPlaca(), vehiculo.getMembresia().getTipoMembresia(), LocalDate.now(), tarifa.getPrecioAnioMoto());
                        crearHistorialPagos(pago);
                    }
                    else if(vehiculo.getMembresia().getTipoMembresia()==TipoMembresia.TRESMESESMOTO){
                        pago = new Pago(getNombre(), vehiculo.getPlaca(), vehiculo.getMembresia().getTipoMembresia(), LocalDate.now(), tarifa.getPrecioMotoTresMeses());
                        crearHistorialPagos(pago);
                    }
                }
                if(vehiculo instanceof Camion){
                    if(vehiculo.getMembresia().getTipoMembresia()==TipoMembresia.MESCAMION){
                        pago = new Pago(getNombre(),vehiculo.getPlaca(),vehiculo.getMembresia().getTipoMembresia(), LocalDate.now(), tarifa.getPrecioMotoMes());
                        crearHistorialPagos(pago);
                    }
                    else if(vehiculo.getMembresia().getTipoMembresia()==TipoMembresia.ANIOCAMION){
                        pago = new Pago(getNombre(),vehiculo.getPlaca(),vehiculo.getMembresia().getTipoMembresia(), LocalDate.now(), tarifa.getPrecioAnioCamion());
                        crearHistorialPagos(pago);
                    }
                    else if(vehiculo.getMembresia().getTipoMembresia()==TipoMembresia.TRESMESESCAMION){
                        pago = new Pago(getNombre(),vehiculo.getPlaca(),vehiculo.getMembresia().getTipoMembresia(), LocalDate.now(), tarifa.getPrecioCamionTresMeses());
                        crearHistorialPagos(pago);
                    }
                }
            }
        }
        return pago;

    }
    public Pago crearPagoVehiculoTemporal(String placa) {
        Pago pago= null;

        LocalDate horaSalida = LocalDate.now();
        LocalDate horaEntrada = vehiculo.getFechaIngreso();

        long minutos = Duration.between(horaEntrada, horaSalida).toMinutes();
        long horasCobradas = (long) Math.ceil(minutos / 60.0); 

        for(Vehiculo vehiculo : listaVehiculos){
            if(vehiculo.getPlaca().equals(placa)){
                if (vehiculo instanceof Automovil){
                    pago = new Pago(getNombre(), vehiculo.getPlaca(), vehiculo.getMembresia().getTipoMembresia(), horaEntrada, horasCobradas*tarifa.getPrecioAutomovilHora());
                    sumaEspaciosAutomovil();
                    eliminarVehiculo(placa);
                }
            }

            if(vehiculo.getPlaca().equals(placa)){
                if (vehiculo instanceof Moto){
                    pago = new Pago(getNombre(), vehiculo.getPlaca(), vehiculo.getMembresia().getTipoMembresia(), horaEntrada, horasCobradas*tarifa.getPrecioMotoHora());
                    sumaEspaciosMoto();
                    eliminarVehiculo(placa);
                }
            }

            if(vehiculo.getPlaca().equals(placa)){
                if (vehiculo instanceof Camion){
                    pago = new Pago(getNombre(), vehiculo.getPlaca(), vehiculo.getMembresia().getTipoMembresia(), horaEntrada, horasCobradas*tarifa.getPrecioCamionHora());
                    sumaEspaciosCamion();
                    eliminarVehiculo(placa);
                }
            }
        }
        listaVehiculos.remove(vehiculo);
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
    public Collection<HistorialPagos> filtrarPagosPorFecha(LocalDate fechaInicio, LocalDate fechaSalida) {
        Collection<HistorialPagos> resultado = new ArrayList<>();

        for (HistorialPagos pago : historialPagos) {
            LocalDate fecha = pago.getFecha();

            if ((fecha.isEqual(fechaInicio) || fecha.isAfter(fechaInicio)) &&
                (fecha.isEqual(fechaSalida) || fecha.isBefore(fechaSalida))) {
                resultado.add(pago);
            }
        }

        return resultado;
    }
    public boolean sumaEspaciosCamion(){
        int espacios = espaciosDisponibles.getEspaciosCamion();
        boolean centinela = false;
        if(espacios != 0){
            espaciosDisponibles.setEspaciosCamion(espacios+1);
            centinela = true;
        }
        else{
            System.out.println("No se pudo sumar el espacio");
        }
        return centinela;
    }
    public boolean sumaEspaciosMoto(){
        int espacios = espaciosDisponibles.getEspaciosMoto();
        boolean centinela = false;
        if(espacios != 0){
            espaciosDisponibles.setEspaciosMoto(espacios+1);
            centinela = true;
        }
        else{
            System.out.println("No se pudo sumar el espacio");
        }
        return centinela;
    }
    public boolean sumaEspaciosAutomovil(){
        int espacios = espaciosDisponibles.getEspaciosAutomovil();
        boolean centinela = false;
        if(espacios != 0){
            espaciosDisponibles.setEspaciosAutomovil(espacios+1);
            centinela = true;
        }
        else{
            System.out.println("No se pudo sumar el espacio");
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
    
    public void TerminoMembresia(String placa) {
        LocalDate fin;
		for (Vehiculo vehiculo : listaVehiculos) {
			if (vehiculo.getPlaca().equals(placa)) {
				LocalDate actual = LocalDate.now();
				fin = vehiculo.getMembresia().getFinMembresia();
                if(actual == fin){
                    listaVehiculos.remove(placa);

                }

				
			}
		}
	}
		
}