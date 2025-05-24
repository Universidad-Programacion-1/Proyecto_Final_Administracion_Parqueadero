package model;

//import java.rmi.registry.LocateRegistry;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Vehiculo {
	private Membresia membresia;
	private String placa;
	private String color;
	private String modelo;
	private LocalDate fechaIngreso;

	public Vehiculo(String placa, String color, String modelo, Membresia membresia) {

		this.placa = placa;
		this.color = color;
		this.modelo = modelo;
		this.membresia = membresia;
	}
	public Vehiculo(String placa, LocalDate fechaIngreso) {
		this.placa = placa;
		this.fechaIngreso = fechaIngreso;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Membresia getMembresia() {
		return membresia;
	}
	public void setMembresia(Membresia membresia) {
		this.membresia = membresia;
	}
	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
}