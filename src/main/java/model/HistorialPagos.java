package model;

import java.time.LocalDate;

public class HistorialPagos {
	
	private Pago pagos;
	private LocalDate fecha;
	public HistorialPagos(Pago pagos, LocalDate fecha) {
		this.pagos = pagos;
		this.fecha = fecha;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	

}
