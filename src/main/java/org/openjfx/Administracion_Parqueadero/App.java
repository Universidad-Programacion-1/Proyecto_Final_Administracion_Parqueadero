package org.openjfx.Administracion_Parqueadero;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import viewController.CrearClienteViewController;
import viewController.CrearVehiculoViewController;
import viewController.GestionEspaciosDisponiblesViewController;
import viewController.GestionParqueaderoViewController;
import viewController.GestionTarifasViewController;
import viewController.HistorialPagosViewController;
import viewController.PagosViewController;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.time.LocalDate;

import model.Automovil;
import model.Membresia;
import model.Pago;
import model.Parqueadero;
import model.Tarifa;
import model.TipoMembresia;
import model.Vehiculo;

/**
 * JavaFX App
 */
public class App extends Application {

    private Stage primaryStage;
    @SuppressWarnings("exports")
    private static Scene scene;
    
    @Override
<<<<<<< HEAD
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Administracion de Parqueadero");
		GestionarParqueadero();
    }
    
    public void GestionarParqueadero() {
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
=======
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
        Parqueadero p= new Parqueadero("EJERCICIO", "CALLE 45", "ALEJO", "1234");
        Tarifa t= new Tarifa(0, 0, 0, 0, 1000, 20000, 0, 0, 0, 0, 0, 0);
        Membresia membresia = new Membresia(TipoMembresia.MESAUTO,LocalDate.now(), LocalDate.now());
        Vehiculo v= new Automovil("DOSPEA", "NEGRO", "ASMNDASF", membresia); 
        p.crearTarifa(t);  
        System.out.println("VEHICULO"+ p.crearVehiculo(v));
        //p.crearVehiculo(v);
        Pago pago = p.crearPagoVehiculoMembresia("DOSPEA");
        System.out.println(pago.getTotalpagar());
        
        
    }
    
>>>>>>> c4f33be2f09c9b315691bc0942632660d8b49f72

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
    
    public void Pagos() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("Pago.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            PagosViewController pagos = loader.getController();
            pagos.setApp(this);

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
        

    public static void main(String[] args) {
        launch();
    }

    
}