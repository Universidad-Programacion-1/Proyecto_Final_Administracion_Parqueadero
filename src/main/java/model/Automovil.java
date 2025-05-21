package model;

public class Automovil extends Vehiculo{
    private int precio;

	public Automovil(String placa,int precio, String color, String modelo) {
        super(placa, color, modelo);
        this.precio=precio;
        
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    

    

}