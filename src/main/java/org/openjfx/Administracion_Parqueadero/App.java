package org.openjfx.Administracion_Parqueadero;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

import controller.CrearClienteViewController;

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
		CrearCliente();
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
      
    public static void main(String[] args) {
        launch();
    }

    
}