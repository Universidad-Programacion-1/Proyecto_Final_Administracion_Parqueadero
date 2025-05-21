package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Moto extends Vehiculo{
    public Moto(String placa, String color, String modelo, Membresia membresia) {
        super(placa, color, modelo, membresia);
    }

    public Moto(String placa, LocalDateTime fechaIngreso) {
        super(placa, fechaIngreso);
        
    }

}
