package viewController;

import java.net.URL;
import java.util.ResourceBundle;

import org.openjfx.Administracion_Parqueadero.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class GestionParqueaderoViewController {

	@FXML
    private ResourceBundle resources;

    App app;
    
    @FXML
    private Button btRealizarpagp;

    @FXML
    private Button btHistorialPagos;
    
    @FXML
    private Button btGestionEspacios;

    @FXML
    private Button btGestionCliente;

    @FXML
    private Button btGestionTarifas;

    @FXML
    private Label txtTitleVehiculos;

    @FXML
    private Button btGestionVehiculos;
    
    @FXML
    private Button btGestionParqueadero;

    @FXML
    void onOpenCrudTarifas() {
    	app.GestionTarifa();
    }

    @FXML
    void onOpenCrudCliente() {
    	app.CrearCliente();
    }
    
    @FXML
    void onOpenHistorialPagos() {
    	app.HistorialPagos();
    }
    
    @FXML
    void onOpenPagos() {
    	app.Pagos();
    }

    @FXML
    void onOpenCrudVehiculos() {
    	app.CrearVehiculo();
    }

    @FXML
    void onOpenCrudEspacios() {
    	app.GestionEspaciosDisponibles();
    }
    
    @FXML
    void onOpenGestionParqueadero() {
    	app.GestionMenuParqueadero();
    }

    public void setApp(App app) {
        this.app = app;
    }
}
