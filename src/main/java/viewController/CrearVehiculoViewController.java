 package viewController;

import java.time.LocalDate;
import java.util.Date;

import org.openjfx.Administracion_Parqueadero.App;

import controller.VehiculoController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Membresia;
import model.TipoMembresia;
import model.Vehiculo;

public class CrearVehiculoViewController {

	VehiculoController vehiculoController;
	private App app;
	ObservableList<Vehiculo> listVehiculos = FXCollections.observableArrayList();
	Vehiculo selectedVehiculo;
	
    @FXML
    private TableColumn<Vehiculo, String> tbcColor;

    @FXML
    private TableColumn<Vehiculo, String> tbcTipoMembresia;

    @FXML
    private TextField txtModelo;

    @FXML
    private Button btnActualizarVehiculo;


    @FXML
    private TextField txtPlaca;

    @FXML
    private TableView<Vehiculo> tblListVehiculos;

    @FXML
    private Button dtnAtras;

    @FXML
    private TableColumn<Vehiculo, String> tbcModelo;

    @FXML
    private Button btbAgregarVehiculo;

    @FXML
    private TextField txtColor;

    @FXML
    private TableColumn<Vehiculo, String> tbcPlaca;

    @FXML
    private ComboBox<String> cbxTipoMembresia;
    
    @FXML
    private ComboBox<String> cbxTipoVehiculo;
    
    @FXML
    private DatePicker cbxFechaInicial;
    
    @FXML
    private TableColumn<Vehiculo, LocalDate> tbcFechaInicio;
    
    @FXML
    private TableColumn<Vehiculo, LocalDate> tbcFechaFin;

    @FXML
    void onActualizarVehiculo() {
    	actualizarVehiculoMembresia();
    }

    @FXML   
    void onAgregarVehiculo() {
    	crearVehiculoMembresia();
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
    	vehiculoController = new VehiculoController(app.parqueadero);
    	cbxTipoMembresia.getItems().addAll("MES AUTO", "MES MOTO", "MES CAMION", "TRESMESES AUTO", "TRESMESES MOTO", "TRESMESES CAMION", "AÑO AUTO", "AÑO MOTO", "AÑO CAMION");
    	
    	cbxTipoVehiculo.getItems().addAll("Moto", "Automovil", "Camion");

//    	cbxFechaInicial = new DatePicker(LocalDate.now());
//    	cbxFechaInicial.setEditable(false);


    	initView();
  }
    
    private void initView() {
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
        tbcColor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getColor()));
        tbcModelo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModelo()));
        tbcTipoMembresia.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getMembresia().getTipoMembresia()));
        tbcFechaInicio.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getMembresia().getInicioMembresia()));
        tbcFechaFin.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getMembresia().getFinMembresia()));

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
            txtColor.setText(String.valueOf(vehiculo.getColor()));
            txtModelo.setText(String.valueOf(vehiculo.getModelo()));
        }
    }
    
    private void obtenerVehiculo() {
        listVehiculos.addAll(vehiculoController.obtenerListaVehiculos());
    }
    
    private void crearVehiculoMembresia() {
        Vehiculo vehiculo = buildVehiculoMembresia();
        System.out.println("Tipo Vehiculo"+ cbxTipoVehiculo.getValue());
        if (vehiculoController.crearVehiculoMembresia(vehiculo, cbxTipoVehiculo.getValue())) {
        	listVehiculos.add(vehiculo);
        	limpiarCamposVehiculo();
        }
    }
    
    private void limpiarSeleccion() {
        tblListVehiculos.getSelectionModel().clearSelection();
        limpiarCamposVehiculo();
    }

    private void limpiarCamposVehiculo() {
        txtModelo.clear();
        txtPlaca.clear();
        txtColor.clear();
        cbxTipoMembresia.setValue(null);
        cbxFechaInicial.setValue(null);
        cbxTipoVehiculo.setValue(null);
    }

    private Vehiculo buildVehiculoMembresia() {
    	TipoMembresia tipoMembresia = tipoMembresia(cbxTipoMembresia.getValue()); 
    	LocalDate fechaFinal = calcularFechaFinal(cbxFechaInicial.getValue(), tipoMembresia);
    	Membresia membresia = new Membresia(tipoMembresia, cbxFechaInicial.getValue(), fechaFinal);
    	
        Vehiculo vehiculo = new Vehiculo(txtPlaca.getText(), txtColor.getText(), txtModelo.getText(), membresia);
        return vehiculo;
    }
    
    private TipoMembresia tipoMembresia(String tipo){
        TipoMembresia tipoMembresia = null;
        System.out.println(tipo);
        if(tipo == "MES AUTO"){
            tipoMembresia = TipoMembresia.MESAUTO;
            
        }else if(tipo == "MES MOTO") {
        	tipoMembresia = TipoMembresia.MESMOTO;
        	
        }else if(tipo == "MES CAMION") {
       	 	tipoMembresia = TipoMembresia.MESCAMION;
       	 
        }else if(tipo == "TRESMESES AUTO") {
        	tipoMembresia = TipoMembresia.TRESMESESAUTO;
      	 
        }else if(tipo == "TRESMESES MOTO") {
        	tipoMembresia = TipoMembresia.TRESMESESMOTO;
     	 
        }else if(tipo == "TRESMESES CAMION") {
        	tipoMembresia = TipoMembresia.TRESMESESCAMION;
        	
        }else if(tipo == "AÑO AUTO") {
        	tipoMembresia = TipoMembresia.ANIOAUTO;
        	
        }else if(tipo == "AÑO MOTO") {
        	tipoMembresia = TipoMembresia.ANIOMOTO;
     	 
        }else if(tipo == "AÑO CAMION") {
        	tipoMembresia = TipoMembresia.ANIOCAMION;
     	 
        }
        return tipoMembresia;
    }
    
    private LocalDate calcularFechaFinal(LocalDate fechaActual, TipoMembresia tipo){
        LocalDate fechaFinal= null;
//        System.out.println(tipo);
        if(tipo == TipoMembresia.MESAUTO || tipo == TipoMembresia.MESCAMION || tipo == TipoMembresia.MESMOTO){
            fechaFinal = fechaActual.plusMonths(1);
            
        }else if(tipo == TipoMembresia.TRESMESESAUTO || tipo == TipoMembresia.TRESMESESCAMION || tipo == TipoMembresia.TRESMESESMOTO) {
        	fechaFinal = fechaActual.plusMonths(3);
        	 
        }else if(tipo == TipoMembresia.ANIOAUTO || tipo == TipoMembresia.ANIOCAMION || tipo == TipoMembresia.ANIOMOTO) {
        	fechaFinal = fechaActual.plusMonths(12);
        	 
        }
        return fechaFinal;
    }
    
    private void actualizarVehiculoMembresia() {

        if (selectedVehiculo != null && vehiculoController.actualizarVehiculo(selectedVehiculo.getPlaca(), buildVehiculoMembresia())) {

            int index = listVehiculos.indexOf(selectedVehiculo);
            if (index >= 0) {
                listVehiculos.set(index, buildVehiculoMembresia());
            }

            tblListVehiculos.refresh();
            limpiarSeleccion();
            limpiarCamposVehiculo();
        }
    }
}



