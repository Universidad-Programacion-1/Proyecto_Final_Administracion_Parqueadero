package viewController;

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
//        this.pago = pago;
        initDataBinding(pago);
    }
    
    
//    @FXML
//    void initialize() {
////    	vehiculoController = new VehiculoController(app.parqueadero);
//
//    	initView();
//  }
//    
//    private void initView() {
//        // Traer los datos del cliente a la tabla
//        initDataBinding();
//    }
    
    private void initDataBinding(Pago pago) {
    	System.out.println("Pago"+pago.getPlaca());
    	
        labelPlaca.setText(pago.getPlaca());
        if(pago.getMembrecia() != null) {
        	labelTipoMembresia.setText(String.valueOf(pago.getMembrecia()));
        }else {
        	labelTipoMembresia.setText("No tiene Memnresia");
        }
        labelTotalApagar.setText(String.valueOf(pago.getTotalpagar()));
        labelFecha.setText(String.valueOf(pago.getFechaEntrada()));

    }
    
    private void limpiarCamposVehiculo() {
    	labelPlaca.setText(null);
    	labelTipoMembresia.setText(null);
    	labelTotalApagar.setText(null);
    	labelFecha.setText(null);
    }

}
