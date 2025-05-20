package viewController;

import org.openjfx.Administracion_Parqueadero.App;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class GestionEspaciosDisponiblesViewController {

	App app;
	
    @FXML
    private TextField txtEspaciosMoto;

    @FXML
    private TableColumn<?, ?> tbcCamion;

    @FXML
    private Button dtnAtras;

    @FXML
    private TableColumn<?, ?> tbcAuto;

    @FXML
    private TableView<?> tblListGestionEspacios;

    @FXML
    private TextField txtEspaciosAuto;

    @FXML
    private TableColumn<?, ?> tbcMoto;

    @FXML
    private Button btnActualizarEspacios;

    @FXML
    private TextField txtEspaciosCamion;

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
