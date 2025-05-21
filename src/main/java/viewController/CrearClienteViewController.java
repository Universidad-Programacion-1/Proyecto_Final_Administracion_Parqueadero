package viewController;

import org.openjfx.Administracion_Parqueadero.App;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CrearClienteViewController {
	
	App app;
	

    @FXML
    private TableView<?> tblListClientes;

    @FXML
    private TableColumn<?, ?> tbcTelefono;

    @FXML
    private TextField txtNombre;

    @FXML
    private Button dtnAtras;

    @FXML
    private TextField txtTelefono;

    @FXML
    private Button btnActualizarCliente;

    @FXML
    private TableColumn<?, ?> tbcNombre;

    @FXML
    private Button btbAgregarCliente;

    @FXML
    private TableColumn<?, ?> tbcCedula;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TableColumn<?, ?> tbcCorreo;
    
    @FXML
    private TextField txtPlaca;
    
    @FXML
    private TableColumn<?, ?> tbcPlaca;

    @FXML
    void onActualizarCliente( ) {

    }

    @FXML
    void onAgregarCliente() {

    }

    @FXML
    void onOpenMenu( ) {
    	app.GestionarParqueadero();
   }
    
   public void setApp(App app) {
	   this.app = app;
   }
   
   
}


