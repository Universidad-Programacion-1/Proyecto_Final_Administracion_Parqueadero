package model;

import java.util.Collection;

public class Parqueadero {

	private String nombre;
	private Vehiculo vehiculo;
	private Membresia membresia;
	private Tarifa tarifa;
	private Pago pago;
	private Collection<Camion> camiones;
	private String direccion;
	private String representante;
	private String telefono;
	private int espaciosTotal;

	public Parqueadero(String nombre, String direccion, String representante, String telefono, int espaciosTotal) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.representante = representante;
		this.telefono = telefono;
		this.espaciosTotal = espaciosTotal;
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

	public int getEspaciosTotal() {
		return espaciosTotal;
	}

	public void setEspaciosTotal(int espaciosTotal) {
		this.espaciosTotal = espaciosTotal;
	}

	public boolean crearCamion(Camion camion) {
		System.out.println(camion);
		boolean centinela = false;
		if (!verificarCamion(camion.getPlaca())) {
		camiones.add(camion);
		centinela = true;
		}
		return centinela;
		
    }
	public boolean eliminarCamion(String placa) {
        boolean centinela = false;
        for (Camion camion : camiones) {
            if (camion.getPlaca().equals(placa)) {
                camiones.remove(camion);
                centinela = true;
                break;
            }
        }
        return centinela;
    }
	public boolean verificarCamion(String placa) {
        boolean centinela = false;
        for (Camion camion : camiones) {
            if (camion.getPlaca().equals(placa)) {
                centinela = true;
            }
        }
        return centinela;
    }
	 public boolean actualizarCamion(String placa, Camion actualizado) {
        boolean centinela = false;
        for (Camion camion : camiones) {
            if (camion.getPlaca().equals(placa)) {
                camion.setPlaca(actualizado.getPlaca());
                camion.setColor(actualizado.getColor());
                camion.setModelo(actualizado.getModelo());
                camion.setPrecio(actualizado.getPrecio());
                centinela = true;
                break;
            }
        }
        return centinela;
    }
		

		

		
}