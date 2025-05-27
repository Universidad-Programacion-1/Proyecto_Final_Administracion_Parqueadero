package test;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.Cliente;
import model.EspaciosDisponibles;
import model.Membresia;
import model.Pago;
import model.Parqueadero;
import model.Tarifa;
import model.TipoMembresia;
import model.Vehiculo;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
        Vehiculo vehiculo = new Vehiculo("AAA111", LocalDateTime.now());
        boolean resultado = parqueadero.crearVehiculoTemporal(vehiculo, "Automovil");
        assertTrue(resultado, "El vehículo temporal Automovil debería crearse correctamente");
    }

    @Test
    public void testCrearVehiculoTemporal_VehiculoYaExistente() {
        Vehiculo vehiculo1 = new Vehiculo("DEF456", LocalDateTime.now());
        parqueadero.crearVehiculoTemporal(vehiculo1, "Moto"); // Lo crea primero

        Vehiculo vehiculo2 = new Vehiculo("DEF456", LocalDateTime.now());
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
        Vehiculo vehiculo = new Vehiculo("LMN001", LocalDateTime.now());
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
    
    @Test
    public void testCrearPagoVehiculoMembresia_MotoMes() {
        Vehiculo moto = new Vehiculo("MOTO123", "Roja", "Yamaha", new Membresia(TipoMembresia.MESMOTO, LocalDate.now(), LocalDate.now().plusMonths(1)));
        parqueadero.crearVehiculoMembresia(moto, "Moto");

        Pago pago = parqueadero.crearPagoVehiculoMembresia("MOTO123");

        assertNotNull(pago);
        assertEquals("MOTO123", pago.getPlaca());
        assertEquals(20000, pago.getTotalpagar()); 
    }

    @Test
    public void testCrearPagoVehiculoMembresia_CamionAnual() {
    	Membresia membresia = new Membresia(TipoMembresia.ANIOCAMION, LocalDate.now(), LocalDate.now().plusYears(1));
        Vehiculo camion = new Vehiculo("CAM123", "Blanco", "Volvo", membresia);
        parqueadero.crearVehiculoMembresia(camion, "Camion");

        Pago pago = parqueadero.crearPagoVehiculoMembresia("CAM123");

        assertNotNull(pago);
        assertEquals("CAM123", pago.getPlaca());
        assertEquals(350000, pago.getTotalpagar()); 
    }
    
    @Test
    public void testCrearPagoVehiculoTemporal_Automovil() {
        Vehiculo auto = new Vehiculo("AUTO999", LocalDateTime.now().minusHours(2)); // Ingresó hace 2 horas
        parqueadero.crearVehiculoTemporal(auto, "Automovil");

        Pago pago = parqueadero.crearPagoVehiculoTemporal("AUTO999");

        assertNotNull(pago);
        assertEquals("AUTO999", pago.getPlaca());
        assertEquals(2 * 100, pago.getTotalpagar()); // 2 horas * 100 según la tarifa
    }
    
    @Test
    public void testModificarTarifa() {
        Tarifa nuevaTarifa = new Tarifa(999, 888, 777, 50, 60, 70, 11111, 22222, 33333, 44444, 55555, 66666);
        boolean resultado = parqueadero.modificarTarifa(nuevaTarifa);

        assertTrue(resultado);
        assertEquals(777, parqueadero.getTarifa().getPrecioAutomovilHora());
        assertEquals(66666, parqueadero.getTarifa().getPrecioAnioAutomovil());
    }
    
    @Test
    public void testCrearPagoVehiculoMembresia_Vencida() {
    	LocalDate inicio = LocalDate.of(2025, 4, 20);
    	LocalDate fin = LocalDate.of(2025, 5, 20);//vencida hace un mes
    	
    	Membresia membresiaVencida = new Membresia(TipoMembresia.MESAUTO, inicio, fin);
    	Vehiculo vehiculo = new Vehiculo("VEN123", "Gris", "kia", membresiaVencida);
    	
    	parqueadero.crearVehiculoMembresia(vehiculo, "Automovil");
    	Pago pago = parqueadero.crearPagoVehiculoMembresia("VEN123");
    	parqueadero.TerminoMembresia("VEN123");
    	
    	assertFalse(parqueadero.getListaVehiculos().contains(vehiculo));    	       	
    	
    }
    
    
}
