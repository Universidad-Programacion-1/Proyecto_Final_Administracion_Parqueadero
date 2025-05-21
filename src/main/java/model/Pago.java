package model;

import java.time.LocalDate;

public class Pago {

	private String parqueadero;
	private String placa;
	private Tarifa tarifa;
	private TipoMembresia membrecia;
	private int totalpagar;
	private LocalDate fechaEntrada;

	public Pago(String parqueadero, String placa, TipoMembresia membrecia, LocalDate fechaEntrada, int totalpagar) {
		this.parqueadero = parqueadero;
		this.placa = placa;
		this.membrecia = membrecia;
		this.totalpagar = totalpagar;
		this.fechaEntrada = fechaEntrada;
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

	public LocalDate getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(LocalDate fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	

	
	
	
}