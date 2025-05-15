package model;

public class Moto extends Vehiculo{

    private int precio;

    public Moto(String placa, String color, String modelo) {
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
