package org.openjfx.Administracion_Parqueadero;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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

    private static Scene scene;

    @Override
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
    

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}