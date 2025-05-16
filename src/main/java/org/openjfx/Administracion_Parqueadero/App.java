package org.openjfx.Administracion_Parqueadero;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import viewController.CrearVehiculoViewController;
import viewController.GestionParqueaderoViewController;
import viewController.GestionTarifasViewController;
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

    public static void main(String[] args) {
        launch();
    }

}