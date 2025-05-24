package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Automovil extends Vehiculo{

    public Automovil(String placa, String color, String modelo, Membresia membresia) {
        super(placa, color, modelo, membresia);
    }

    public Automovil(String placa, LocalDate fechaIngreso) {
        super(placa, fechaIngreso);
        
    }

}