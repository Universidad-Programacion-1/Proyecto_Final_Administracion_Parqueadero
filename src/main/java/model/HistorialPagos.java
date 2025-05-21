package model;

import java.time.LocalDate;

public class HistorialPagos {
	
	private Pago pago;
	private LocalDate fecha;
	public HistorialPagos(Pago pago, LocalDate fecha) {
		this.pago = pago;
		this.fecha = fecha;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	

}
