package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Pago {

	private String parqueadero;
	private String placa;
	private Tarifa tarifa;
	private TipoMembresia membresia;
	private long totalpagar;
	private LocalDate fechaEntrada;
	private LocalDateTime HoraEntradaTemporal;

	public Pago(String parqueadero, String placa, TipoMembresia membresia, LocalDate horaEntrada, long totalpagar) {
		this.parqueadero = parqueadero;
		this.placa = placa;
		this.membresia = membresia;
		this.totalpagar = totalpagar;
		this.fechaEntrada = horaEntrada;
	}
	public Pago(String parqueadero, String placa, TipoMembresia membresia, LocalDateTime horaEntrada, long totalpagar) {
		this.parqueadero = parqueadero;
		this.placa = placa;
		this.membresia = membresia;
		this.totalpagar = totalpagar;
		this.HoraEntradaTemporal = horaEntrada;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public TipoMembresia getMembresia() {
		return membresia;
	}

	public void setMembresia(TipoMembresia membrecia) {
		this.membresia = membrecia;
	}

	public Tarifa getTarifa() {
		return tarifa;
	}

	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
	}

	public long getTotalpagar() {
		return totalpagar;
	}

	public void setTotalpagar(long totalpagar) {
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
	public LocalDateTime getHoraEntradaTemporal() {
		return HoraEntradaTemporal;
	}
	public void setHoraEntradaTemporal(LocalDateTime horaEntradaTemporal) {
		HoraEntradaTemporal = horaEntradaTemporal;
	}
	

	

	
	
	
}