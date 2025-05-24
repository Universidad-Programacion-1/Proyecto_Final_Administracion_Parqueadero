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
import viewController.MenuParqueaderoViewController;
import viewController.PagosViewController;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.time.LocalDate;

import model.Automovil;
import model.EspaciosDisponibles;
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
    public static Parqueadero parqueadero = new Parqueadero("Parqueadero al gusto","Fundadores","Carlos Andres Ruiz","123456789");
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Administracion de Parqueadero");
		GestionarParqueadero();
    }
    
    public void inicializarData(){
        EspaciosDisponibles espaciosDisponibles = new EspaciosDisponibles(10, 10, 10);
        parqueadero.crearEspacipos(espaciosDisponibles);
        Tarifa tarifa = new Tarifa(100, 150, 200, 20000, 35000, 30000, 50000, 95000, 80000, 200000, 350000, 300000);
        parqueadero.crearTarifa(tarifa);
        Membresia membresia = new Membresia(TipoMembresia.MESAUTO, LocalDate.now(), LocalDate.now());
        Vehiculo vehiculo = new Vehiculo("123", "Azul", "2020", membresia);
        parqueadero.crearVehiculoMembresia(vehiculo, "Automovil");
    }
    
    public void GestionarParqueadero() {
    	inicializarData();
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