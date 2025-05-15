package model;

public class Camion extends Vehiculo{
    private int precio;

    public Camion(String placa, String color, String modelo) {
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
