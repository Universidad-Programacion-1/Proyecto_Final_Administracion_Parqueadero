package viewController;


import java.time.LocalDate;

import org.openjfx.Administracion_Parqueadero.App;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MenuParqueaderoViewController {
	
	App app;
	
	 @FXML
    private TextField txtPlaca;

    @FXML
    private DatePicker cbxFechaInicial;

    @FXML
    private TableView<?> tblListVehiculos;

    @FXML
    private Button dtnAtras;

    @FXML
    private Button btnActualizarVehiculo;

    @FXML
    private Button btbAgregarVehiculo;

    @FXML
    private ComboBox<String> cbxTipoVehiculo;

    @FXML
    private TableColumn<?, ?> tbcHoraInicio;

    @FXML
    private TableColumn<?, ?> tbcPlaca;

    @FXML
    void onActualizarVehiculo() {

    }

    @FXML
    void onAgregarVehiculo() {
    	
    }

    @FXML
    void onOpenMenu() {
    	app.GestionarParqueadero();
    }
    
    public void setApp(App app) {
        this.app = app;
    }
    
    @FXML
    void initialize() {
//    	crearVehiculo = new CrearVehiculo();
    	
    	cbxTipoVehiculo.getItems().addAll("Moto", "Automovil", "Camion");

    	cbxFechaInicial = new DatePicker(LocalDate.now());
    	cbxFechaInicial.setEditable(false);


//    	initView();
  }

}
