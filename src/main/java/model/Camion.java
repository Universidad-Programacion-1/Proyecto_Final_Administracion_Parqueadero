package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Camion extends Vehiculo{

    public Camion(String placa, String color, String modelo, Membresia membresia) {
        super(placa, color, modelo, membresia);
    }

    public Camion(String placa, LocalDateTime fechaIngreso) {
        super(placa, fechaIngreso);
        
    }

    

}
