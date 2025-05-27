package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Cliente;
import model.EspaciosDisponibles;
import model.Membresia;
import model.Parqueadero;
import model.Tarifa;
import model.TipoMembresia;
import model.Vehiculo;

import java.time.LocalDate;

public class ParqueaderoTest {
    private Parqueadero parqueadero;

    @BeforeEach
    public void setup() {
        parqueadero = new Parqueadero("uniq", "ff", "jhonnatan", "5001");
        EspaciosDisponibles espaciosDisponibles = new EspaciosDisponibles(10, 10, 10);
        parqueadero.crearEspaciposDisponibles(espaciosDisponibles);
        Tarifa tarifa = new Tarifa(100, 150, 200, 20000, 35000, 30000, 50000, 95000, 80000, 200000, 350000, 300000);
        parqueadero.crearTarifa(tarifa);

    }

    @Test
    public void testCrearVehiculoTemporal_Automovil() {
        Vehiculo vehiculo = new Vehiculo("AAA111", LocalDate.now());
        boolean resultado = parqueadero.crearVehiculoTemporal(vehiculo, "Automovil");
        assertTrue(resultado, "El vehículo temporal Automovil debería crearse correctamente");
    }

    @Test
    public void testCrearVehiculoTemporal_VehiculoYaExistente() {
        Vehiculo vehiculo1 = new Vehiculo("DEF456", LocalDate.now());
        parqueadero.crearVehiculoTemporal(vehiculo1, "Moto"); // Lo crea primero

        Vehiculo vehiculo2 = new Vehiculo("DEF456", LocalDate.now());
        boolean resultado = parqueadero.crearVehiculoTemporal(vehiculo2, "Moto"); // Intenta crearlo otra vez

        assertFalse(resultado, "No debería permitir crear un vehículo con placa ya registrada");
    }

    @Test
    public void testCrearVehiculoMembresia_Moto() {
        Vehiculo vehiculo = new Vehiculo("XYZ789", "Rojo", "Yamaha", new Membresia(TipoMembresia.MESMOTO, LocalDate.now(), LocalDate.now().plusMonths(1)));
        boolean resultado = parqueadero.crearVehiculoMembresia(vehiculo, "Moto");
        assertTrue(resultado, "Debería permitir crear moto con membresía");
    }

    @Test
    public void testCrearCliente_Exitoso() {
        Vehiculo vehiculo = new Vehiculo("LMN001", LocalDate.now());
        parqueadero.crearVehiculoTemporal(vehiculo, "Camion"); // Primero crea el vehículo

        Cliente cliente = new Cliente("Alejo", "10902", "3001", "alej@uq.com", "LMN001");
        boolean resultado = parqueadero.crearCliente(cliente);
        System.out.println("carlos" + resultado);
        assertTrue(resultado, "Cliente debería crearse porque ya existe el vehículo con su placa");
        
    }

    @Test
    public void testCrearCliente_SinVehiculo() {
        Cliente cliente = new Cliente("Carlos", "11902", "4001", "carl@uq.com", null);
        boolean resultado = parqueadero.crearCliente(cliente);
        assertFalse(resultado, "Cliente no debería crearse porque su vehículo no existe");
    }
}
