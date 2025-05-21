package model;

import java.time.LocalDate;

public class Pago {

	private Parqueadero parqueadero;
	private String placa;
	private TipoMembresia membrecia;
	private int totalApagar;
	private LocalDate fecha;

	public Pago(Parqueadero parqueadero, String placa, TipoMembresia membrecia, int totalApagar, LocalDate fecha) {
		this.parqueadero = parqueadero;
		this.placa = placa;
		this.membrecia = membrecia;
		this.totalApagar = totalApagar;
		this.fecha = fecha;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getTotalApagar() {
		return totalApagar;
	}

	public void setTotalApagar(int totalApagar) {
		this.totalApagar = totalApagar;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	
}