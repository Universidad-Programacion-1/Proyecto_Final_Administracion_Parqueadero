package org.openjfx.Administracion_Parqueadero;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import viewController.CrearClienteViewController;
import viewController.CrearVehiculoViewController;
import viewController.GestionEspaciosDisponiblesViewController;
import viewController.GestionParqueaderoViewController;
import viewController.GestionTarifasViewController;
import viewController.HistorialPagosViewController;
import viewController.MenuParqueaderoViewController;
import viewController.PagosViewController;
import javafx.scene.layout.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import model.Automovil;
import model.EspaciosDisponibles;
import model.Membresia;
import model.Pago;
import model.Parqueadero;
import model.Tarifa;
import model.TipoMembresia;
import model.Vehiculo;
import model.HistorialPagos;

/**
 * JavaFX App
 */
public class App extends Application {

    private Stage primaryStage;
    @SuppressWarnings("exports")
    private static Scene scene;
    public static Parqueadero parqueadero = new Parqueadero("Parqueadero al gusto","Fundadores","Carlos Andres Ruiz","123456789");
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Administracion de Parqueadero");
		inicializarData();
		GestionarParqueadero();
    }
    
    public void inicializarData(){
    	System.out.println("Inicializar Datos");
        EspaciosDisponibles espaciosDisponibles = new EspaciosDisponibles(10, 10, 10);
        parqueadero.crearEspaciposDisponibles(espaciosDisponibles);
        Tarifa tarifa = new Tarifa(100, 150, 200, 20000, 35000, 30000, 50000, 95000, 80000, 200000, 350000, 300000);
        parqueadero.crearTarifa(tarifa);
        Membresia membresia = new Membresia(TipoMembresia.MESAUTO, LocalDate.of(2025, 4, 25), LocalDate.of(2025, 5, 25));
        Vehiculo vehiculo = new Vehiculo("123", "Azul", "2020", membresia);
        parqueadero.crearVehiculoMembresia(vehiculo, "Automovil");
        /* 
        Pago pago = new Pago(parqueadero.getNombre(), "1234" ,TipoMembresia.MESAUTO, LocalDate.of(2024, 5, 8), 100);
        Pago pago7 = new Pago(parqueadero.getNombre(), "7777", null,LocalDateTime.of(2025, 5, 26, 12, 30), 10000);
        Pago pago1 = new Pago(parqueadero.getNombre(), "12345" ,TipoMembresia.MESAUTO, LocalDate.of(2024, 8, 4), 100);
        Pago pago2 = new Pago(parqueadero.getNombre(), "12346" ,TipoMembresia.MESAUTO, LocalDate.of(2003, 1, 10), 100);
        Pago pago3 = new Pago(parqueadero.getNombre(), "12347" ,TipoMembresia.MESAUTO, LocalDate.of(2025, 4, 20), 100);
        parqueadero.crearHistorialPagos(pago);
        parqueadero.crearHistorialPagos(pago1);
        parqueadero.crearHistorialPagos(pago2);
        parqueadero.crearHistorialPagos(pago3);
        parqueadero.crearHistorialPagos(pago7);
        */
        parqueadero.prueba();


    }
    
    public void GestionarParqueadero() {
    	parqueadero.TerminoMembresia(null);
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("GestionParqueadero.fxml"));
            javafx.scene.layout.VBox rootLayout = (javafx.scene.layout.VBox) loader.load();
            GestionParqueaderoViewController gestionParqueadero = loader.getController();
            gestionParqueadero.setApp(this);
            
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
  
    }
        
    
    public void CrearCliente() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("CrearCliente.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            CrearClienteViewController crearCliente = loader.getController();
            crearCliente.setApp(this);
            
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void CrearVehiculo() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("CrearVehiculo.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            CrearVehiculoViewController crearVehiculo = loader.getController();
            crearVehiculo.setApp(this); 
            
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void GestionTarifa() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("GestionTarifas.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            GestionTarifasViewController gestionartarifa = loader.getController();
            gestionartarifa.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    
    public void GestionEspaciosDisponibles() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("GestionEspaciosDisponibles.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            GestionEspaciosDisponiblesViewController gestionEspaciosDisponibles = loader.getController();
            gestionEspaciosDisponibles.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void Pagos(Pago pago) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("Pago.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            PagosViewController pagos = loader.getController();
            pagos.setApp(this, pago);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void HistorialPagos() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("HistorialPago.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            HistorialPagosViewController historialPagos = loader.getController();
            historialPagos.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void GestionMenuParqueadero() {
        try {
        	FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("MenuParqueadero.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            MenuParqueaderoViewController menuParqueadero = loader.getController();
            menuParqueadero.setApp(this);
            
//        	Image imagenFondo = new Image("file:/C:/Users/ruizc/OneDrive/Imágenes/Screenshots/Screenshot 2024-11-28 174254.png"); // usa la ruta correcta
//            BackgroundImage fondo = new BackgroundImage(imagenFondo,
//                    BackgroundRepeat.NO_REPEAT,
//                    BackgroundRepeat.NO_REPEAT,
//                    BackgroundPosition.DEFAULT,
//                    new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
//
//            rootLayout.setBackground(new Background(fondo));

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
        

    public static void main(String[] args) {
        launch();
    }

    
}