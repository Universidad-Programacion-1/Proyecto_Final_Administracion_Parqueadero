package viewController;

import java.time.LocalDateTime;

import org.openjfx.Administracion_Parqueadero.App;

import controller.VehiculoController;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.Pago;


public class PagosViewController {
	
	App app;
//	Pago pago;

	@FXML
    private Button dtnAtras;

    @FXML
    private Label labelTipoMembresia;

    @FXML
    private Label labelTotalApagar;

    @FXML
    private Label labelPlaca;

    @FXML
    private Label labelFecha;

    @FXML
    void onOpenMenu() {
    	app.GestionarParqueadero();
    	limpiarCamposVehiculo();
    }
    
    public void setApp(App app, Pago pago) {
        this.app = app;
        System.out.println("Asignando el pago");
        initDataBinding(pago);
    }
    
    private void initDataBinding(Pago pago) {
    	System.out.println("Pago"+pago.getPlaca());
    	
        labelPlaca.setText(pago.getPlaca());
        if(pago.getMembresia() != null) {
        	labelTipoMembresia.setText(String.valueOf(pago.getMembresia()));
        }else {
        	labelTipoMembresia.setText("No tiene Membresia");
        }
        System.out.println("PRUEBA DESDE INTERFACES"+ pago.getTotalpagar());
        labelTotalApagar.setText(String.valueOf(pago.getTotalpagar()));

        if(pago.getFechaEntrada() != null) {
        	labelFecha.setText(String.valueOf(pago.getFechaEntrada()));
        }else {
        	labelFecha.setText(String.valueOf(LocalDateTime.now()));
        }

    }
    
    private void limpiarCamposVehiculo() {
    	labelPlaca.setText(null);
    	labelTipoMembresia.setText(null);
    	labelTotalApagar.setText(null);
    	labelFecha.setText(null);
    }

}
