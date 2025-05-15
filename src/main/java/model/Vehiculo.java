package model;

public class Vehiculo {
	
	private String placa;
	private String color;
	private String modelo;
	public Vehiculo(String placa, String color, String modelo) {
		this.placa = placa;
		this.color = color;
		this.modelo = modelo;
	}
	public Vehiculo(String placa) {
		this.placa = placa;
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

	

}