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
    private Button btGestioEspacios;

    @FXML
    private Button btGestioCliente;

    @FXML
    private Button btGestioTarifas;

    @FXML
    private Label txtTitleVehiculos;

    @FXML
    private Button btGestioVehiculos;

    @FXML
    void onOpenCrudTarifas() {
    	app.GestionTarifa();
    }

    @FXML
    void onOpenCrudCliente() {

    }

    @FXML
    void onOpenCrudVehiculos() {
    	app.CrearVehiculo();
    }

    @FXML
    void onOpenCrudEspacios() {

    }

    public void setApp(App app) {
        this.app = app;
    }
}
