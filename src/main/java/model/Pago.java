package model;

import java.time.LocalDate;

public class Pago {

	private String parqueadero;
	private String placa;
	private Tarifa tarifa;
	private TipoMembresia membrecia;
	private int totalpagar;
	private LocalDate fechaSalida;

	public Pago(String parqueadero, String placa, TipoMembresia membrecia, LocalDate fechaSalida, int totalpagar) {
		this.parqueadero = parqueadero;
		this.placa = placa;
		this.membrecia = membrecia;
		this.totalpagar = totalpagar;
		this.fechaSalida = fechaSalida;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}


	

	public TipoMembresia getMembrecia() {
		return membrecia;
	}

	public void setMembrecia(TipoMembresia membrecia) {
		this.membrecia = membrecia;
	}

	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Tarifa getTarifa() {
		return tarifa;
	}

	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
	}

	public int getTotalpagar() {
		return totalpagar;
	}

	public void setTotalpagar(int totalpagar) {
		this.totalpagar = totalpagar;
	}

	public String getParqueadero() {
		return parqueadero;
	}

	public void setParqueadero(String parqueadero) {
		this.parqueadero = parqueadero;
	}

	

	
	
	
}