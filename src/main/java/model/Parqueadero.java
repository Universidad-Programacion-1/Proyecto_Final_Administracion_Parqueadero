package model;

import java.util.Collection;

public class Parqueadero {

	private String nombre;
	//private Vehiculo vehiculo;
	//private Membresia membresia;
	//private Tarifa tarifa;
	//private Pago pago;
	private Collection<Automovil> automoviles;
	private Collection<Camion> camiones;
	private Collection<Moto> motos;
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
	public boolean crearAutomovil(Automovil automovil) {
		System.out.println(automovil);
		boolean centinela = false;
		if (!verificarAutomovil(automovil.getPlaca())) {
		automoviles.add(automovil);
		centinela = true;
		}
		return centinela;
		
    }
	public boolean eliminarAutomovil(String placa) {
        boolean centinela = false;
        for (Automovil automovil : automoviles) {
            if (automovil.getPlaca().equals(placa)) {
                automoviles.remove(automovil);
                centinela = true;
                break;
            }
        }
        return centinela;
    }
	public boolean verificarAutomovil(String placa) {
        boolean centinela = false;
        for (Automovil automovil : automoviles) {
            if (automovil.getPlaca().equals(placa)) {
                centinela = true;
            }
        }
        return centinela;
    }
	public boolean actualizarAutomovil(String placa, Automovil actualizado) {
        boolean centinela = false;
        for (Automovil automovil : automoviles) {
            if (automovil.getPlaca().equals(placa)) {
                automovil.setPlaca(actualizado.getPlaca());
                automovil.setColor(actualizado.getColor());
                automovil.setModelo(actualizado.getModelo());
                automovil.setPrecio(actualizado.getPrecio());
                centinela = true;
                break;
            }
        }
        return centinela;
    }
	public boolean crearMoto(Moto moto) {
		System.out.println(moto);
		boolean centinela = false;
		if (!verificarMoto(moto.getPlaca())) {
		motos.add(moto);
		centinela = true;
		}
		return centinela;
		
    }
	public boolean eliminarMoto(String placa) {
        boolean centinela = false;
        for (Moto moto : motos) {
            if (moto.getPlaca().equals(placa)) {
                motos.remove(moto);
                centinela = true;
                break;
            }
        }
        return centinela;
    }
	public boolean verificarMoto(String placa) {
        boolean centinela = false;
        for (Moto moto : motos) {
            if (moto.getPlaca().equals(placa)) {
                centinela = true;
            }
        }
        return centinela;
    }
	public boolean actualizarMoto(String placa, Moto actualizado) {
        boolean centinela = false;
        for (Moto moto : motos) {
            if (moto.getPlaca().equals(placa)) {
                moto.setPlaca(actualizado.getPlaca());
                moto.setColor(actualizado.getColor());
                moto.setModelo(actualizado.getModelo());
                moto.setPrecio(actualizado.getPrecio());
                centinela = true;
                break;
            }
        }
        return centinela;
    }

		

		

		
}