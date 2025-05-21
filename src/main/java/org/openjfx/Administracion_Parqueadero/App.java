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

/**
 * JavaFX App
 */
public class App extends Application {

    private Stage primaryStage;
    @SuppressWarnings("exports")
    private static Scene scene;
    
    @Override
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