package viewController;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Iterator;

import org.openjfx.Administracion_Parqueadero.App;

import controller.MenuParqueaderoController;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Label;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Membresia;
import model.Pago;
import model.TipoMembresia;
import model.Vehiculo;

public class MenuParqueaderoViewController {
	
	App app;
	MenuParqueaderoController menuParqueaderoController;
	ObservableList<Vehiculo> listVehiculos = FXCollections.observableArrayList();
	Vehiculo selectedVehiculo;
	
	@FXML
    private TextField txtPlaca;

    @FXML
    private DatePicker cbxFechaInicial;

    @FXML
    private TableView<Vehiculo> tblListVehiculos;

    @FXML
    private Button dtnAtras;

    @FXML
    private Button btnPagoVehiculoMembresia;

    @FXML
    private Button btbAgregarVehiculo;

    @FXML
    private Button btnPagoVehiculoTemporal;
    
    @FXML
    private ComboBox<String> cbxTipoVehiculo;

    @FXML
    private TableColumn<Vehiculo, LocalDate> tbcHoraInicio;

    @FXML
    private TableColumn<Vehiculo, String> tbcPlaca;
    
    @FXML
    private TableColumn<Vehiculo, String> tbcTipoMembresia;
    
    @FXML
    private Label LabelEspacioMoto;

    @FXML
    private Label LabelEspacioCamion;
    
    @FXML
    private Label LabelEspacioAutomovil;
    

    @FXML
    void onPagoVehiculoTemporal() {
    	PagoVehiculoTemporal();
    }
    
    @FXML
    void onPagoVehiculoMembresia() {
    	PagoVehiculoMembresia();
    }

    @FXML
    void onAgregarVehiculo() {
    	crearVehiculoTemporal();
    	espaciosDispponibles();
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
    	menuParqueaderoController = new MenuParqueaderoController(app.parqueadero);
    	cbxTipoVehiculo.getItems().addAll("Moto", "Automovil", "Camion");



    	initView();
  }
    
	private void initView() {
		espaciosDispponibles();
	    // Traer los datos del cliente a la tabla
		initDataBinding();
		
		// Obtiene la lista
		obtenerVehiculo();
		
		// Limpiar la tabla
		tblListVehiculos.getItems().clear();
		
		// Agregar los elementos a la tabla
		tblListVehiculos.setItems(listVehiculos);
		
		// Seleccionar elemento de la tabla
		listenerSelection();
	}
	
	private void initDataBinding() {
        tbcPlaca.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPlaca()));
        
        tbcTipoMembresia.setCellValueFactory(cellData -> {
            var membresia = cellData.getValue().getMembresia();
            if (membresia == null) {
                System.out.println("Membresía es null para: " + cellData.getValue());
                return new SimpleObjectProperty("No tiene");
            }else {
            	return new SimpleObjectProperty(cellData.getValue().getMembresia().getTipoMembresia());

            }
        });
        
        tbcHoraInicio.setCellValueFactory(cellData -> {
            var membresia = cellData.getValue().getMembresia();
            if (membresia == null) {
                System.out.println("Membresía es null para: " + cellData.getValue());
                return new SimpleObjectProperty(cellData.getValue().getFechaIngreso());
            }else {
            	return new SimpleObjectProperty(cellData.getValue().getMembresia().getInicioMembresia());

            }
        });
    }
	
	private void espaciosDispponibles() {
		LabelEspacioAutomovil.setText(String.valueOf(menuParqueaderoController.EspacioAutomovil()));
        LabelEspacioMoto.setText(String.valueOf(menuParqueaderoController.EspacioMoto()));
        LabelEspacioCamion.setText(String.valueOf(menuParqueaderoController.EspacioCamion()));
	}
	
	private void obtenerVehiculo() {
        listVehiculos.addAll(menuParqueaderoController.obtenerListaVehiculos());
    }
	
	private void listenerSelection() {
        tblListVehiculos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
        	selectedVehiculo = newSelection;
            mostrarInformacionVehiculo(newSelection);
        });
    }
	
	private void mostrarInformacionVehiculo(Vehiculo vehiculo) {
        if (vehiculo != null) {
            txtPlaca.setText(String.valueOf(vehiculo.getPlaca()));
            
        }
    }
	
	private void crearVehiculoTemporal() {
        Vehiculo vehiculo = buildVehiculoTemporal();
        System.out.println("Tipo Vehiculo"+ cbxTipoVehiculo.getValue());
        if (menuParqueaderoController.crearVehiculoTemporal(vehiculo, cbxTipoVehiculo.getValue())) {
        	listVehiculos.add(vehiculo);
        	limpiarCamposVehiculo();
        }
    }
	
	private void limpiarSeleccion() {
        tblListVehiculos.getSelectionModel().clearSelection();
        limpiarCamposVehiculo();
    }

    private void limpiarCamposVehiculo() {
        txtPlaca.clear();
        cbxFechaInicial.setValue(null);
        cbxTipoVehiculo.setValue(null);
    }

    //private Vehiculo buildVehiculoTemporal() {
    //    Vehiculo vehiculo = new Vehiculo(txtPlaca.getText(), cbxFechaInicial.getValue());
    //    return vehiculo;
    //}
    private Vehiculo buildVehiculoTemporal() {
    LocalDate fecha = cbxFechaInicial.getValue();
    LocalDateTime fechaHora = fecha.atStartOfDay(); // o usa LocalTime.now() si prefieres
    Vehiculo vehiculo = new Vehiculo(txtPlaca.getText(), fechaHora);
    return vehiculo;
}
    
    private void PagoVehiculoMembresia() {
    	
    	Pago pago = menuParqueaderoController.pagoVehiculoMembresia(selectedVehiculo.getPlaca());
    	System.out.println("Pago desde menu"+ pago.getTotalpagar());
    	app.Pagos(pago);
        tblListVehiculos.refresh();
        limpiarSeleccion();
        limpiarCamposVehiculo();
    }
    
    private void PagoVehiculoTemporal() {
    	
    	Pago pago = menuParqueaderoController.pagoVehiculoTemporal(selectedVehiculo.getPlaca());
    	System.out.println("Pago desde menu"+ pago.getTotalpagar());
    	app.Pagos(pago);
        tblListVehiculos.refresh();
        limpiarSeleccion();
        limpiarCamposVehiculo();
    }

}
