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

public class CrearVehiculoViewController {

	
	private App app;
	
    @FXML
    private TableColumn<?, ?> tbcMarca;

    @FXML
    private TableColumn<?, ?> tbcTipoMembresia;

    @FXML
    private TextField txtModelo;

    @FXML
    private Button btnActualizarVehiculo;

    @FXML
    private TextField txtCliente;

    @FXML
    private TextField txtPlaca;

    @FXML
    private TableView<?> tblListVehiculos;

    @FXML
    private Button dtnAtras;

    @FXML
    private TableColumn<?, ?> tbcModelo;

    @FXML
    private Button btbAgregarVehiculo;

    @FXML
    private TableColumn<?, ?> tbcCliente;

    @FXML
    private TextField txtColor;

    @FXML
    private TableColumn<?, ?> tbcPlaca;

    @FXML
    private ComboBox<String> cbxTipoMembresia;
    
    @FXML
    private ComboBox<String> cbxTipoVehiculo;
    
    @FXML
    private DatePicker cbxFechaInicial;

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
    	cbxTipoMembresia.getItems().addAll("MES AUTO", "MES MOTO", "MES CAMION", "TRESMESES AUTO", "TRESMESES MOTO", "TRESMESES CAMION", "AÑO AUTO", "AÑO MOTO", "AÑO CAMION");
    	
    	cbxTipoVehiculo.getItems().addAll("Moto", "Automovil", "Camion");

    	cbxFechaInicial = new DatePicker(LocalDate.now());
    	cbxFechaInicial.setEditable(false);


//    	initView();
  }
}


//    @FXML
//    void initialize() {
//       crearVehiculo = new CrearVehiculo();
//       cbxTipoMembresia.getItems().addAll("MES AUTO", "MES MOTO", "MES CAMION", "TRESMESES AUTO", "TRESMESES MOTO", "TRESMESES CAMION", "AÑO AUTO", "AÑO MOTO", "AÑO CAMION");
//
//       initView();
//    }
    
//    private void initView() {
//        // Traer los datos del cliente a la tabla
//        initDataBinding();
//
//        // Obtiene la lista
//        obtenerPickUpHibrido();
//
//        // Limpiar la tabla
//        tblListPickUpHibrido.getItems().clear();
//
//        // Agregar los elementos a la tabla
//        tblListPickUpHibrido.setItems(listPickUpHibridos);
//
//        // Seleccionar elemento de la tabla
//        listenerSelection();
//    }
//    
//    private void listenerSelection() {
//        tblListPickUpHibrido.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
//            selectedPickUpHibrido = newSelection;
//            mostrarInformacionPickUpHibrido(newSelection);
//        });
//    }
//    
//    private void obtenerPickUpHibrido() {
//        listPickUpHibridos.addAll(pickUpHibridoController.obtenerListaPickUpHibrido());
//    }
//    
//    private void initDataBinding() {
//        tbcPlaca.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPlaca()));
//        tbcEnchufable.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getEnchufable()));
//        tbcCapaCarga.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getCapacidadCajaCarga()));
//        tbcBolsasAire.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getNumBolsas()));
//        tbcNumPasajero.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getNumPasajero()));
//        tbcCilindraje.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getCilindraje()));
//        tbcEstado.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getNuevoUsado()));
//        tbc4Por4.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getCuatroXcuatro()));
//        tbcMarca.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarca()));
//        tbcModelo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModelo()));
//        tbcPrecio.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getPrecio()));
//        tbcPuertas.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getNumPuerta()));
//        tbcVelocidadMax.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getVelocidadmax()));
//        tbcTipoHibrido.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getTipoHibrido()));
//        tbcTransmision.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getTransmision()));
//        tbcAireAcondicionado.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getAireAcondicionado()));
//        tbcCamTrasera.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getCamReversa()));
//        tbcAbs.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getAbs()));
//        
//
//    }
