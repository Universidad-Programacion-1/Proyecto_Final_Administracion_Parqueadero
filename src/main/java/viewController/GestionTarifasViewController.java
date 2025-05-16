package viewController;

import org.openjfx.Administracion_Parqueadero.App;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class GestionTarifasViewController {

	App app;
	
    @FXML
    private TableColumn<?, ?> tbcAuto;

    @FXML
    private TableColumn<?, ?> tbcCamion;

    @FXML
    private TextField txtTarifaCamion;

    @FXML
    private Button dtnAtras;

    @FXML
    private Button btnActualizarVehiculo;

    @FXML
    private TextField txtTarifaMoto;

    @FXML
    private TableColumn<?, ?> tbcMoto;

    @FXML
    private TextField txtTarifaAuto;

    @FXML
    private TableView<?> tblListGestionTarifas;

    @FXML
    void onActualizarVehiculo() {

    }

    @FXML
    void onOpenMenu() {
    	app.GestionarParqueadero();
    }
    
    public void setApp(App app) {
        this.app = app;
    }

}
