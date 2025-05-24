package viewController;

import java.util.Collection;

import org.openjfx.Administracion_Parqueadero.App;

import controller.EspaciosDisponiblesController;
import controller.VehiculoController;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.EspaciosDisponibles;
import model.Tarifa;
import model.Vehiculo;

public class GestionEspaciosDisponiblesViewController {

	EspaciosDisponiblesController espaciosDisponiblesController;
	App app;
	ObservableList<EspaciosDisponibles> listEspacios = FXCollections.observableArrayList();
	EspaciosDisponibles selectedEspacios;
	
    @FXML
    private TextField txtEspaciosMoto;

    @FXML
    private TableColumn<EspaciosDisponibles, String> tbcCamion;

    @FXML
    private Button dtnAtras;

    @FXML
    private TableColumn<EspaciosDisponibles, String> tbcAuto;

    @FXML
    private TableView<EspaciosDisponibles> tblListGestionEspacios;

    @FXML
    private TextField txtEspaciosAuto;

    @FXML
    private TableColumn<EspaciosDisponibles, String> tbcMoto;

    @FXML
    private Button btnActualizarEspacios;

    @FXML
    private TextField txtEspaciosCamion;

    @FXML
    void onActualizarEspacios() {
    	actualizarEspaciosDisponibles();
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
    	espaciosDisponiblesController = new EspaciosDisponiblesController(app.parqueadero);

    	initView();
  }
    
    private void initView() {
        // Traer los datos del cliente a la tabla
        initDataBinding();

        // Obtiene la lista
        obtenerEspaciosDisponibles();

        // Limpiar la tabla
        tblListGestionEspacios.getItems().clear();

        // Agregar los elementos a la tabla
        tblListGestionEspacios.setItems(listEspacios);

        // Seleccionar elemento de la tabla
        listenerSelection();
    }
    
    private void initDataBinding() {
        tbcAuto.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getEspaciosAutomovil()));
        tbcCamion.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getEspaciosCamion()));
        tbcMoto.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getEspaciosMoto()));
        
    }
    
    private void obtenerEspaciosDisponibles() {
        listEspacios.addAll(espaciosDisponiblesController.obtenerEspaciosDisponibles());
    }

    private void listenerSelection() {
        tblListGestionEspacios.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
        	selectedEspacios = newSelection;
        	mostrarInformacionEspaciosDisponibles(newSelection);
        });
    }
    
    private void mostrarInformacionEspaciosDisponibles(EspaciosDisponibles espacios) {
        if (espacios != null) {
            txtEspaciosAuto.setText(String.valueOf(espacios.getEspaciosAutomovil()));
            txtEspaciosCamion.setText(String.valueOf(espacios.getEspaciosCamion()));
            txtEspaciosMoto.setText(String.valueOf(espacios.getEspaciosMoto()));
        }
    }
    
    private EspaciosDisponibles buildEspaciosDisponibles() {
    	int  n1 = Integer.parseInt(txtEspaciosAuto.getText());
    	int  n2 = Integer.parseInt(txtEspaciosCamion.getText());
    	int  n3 = Integer.parseInt(txtEspaciosMoto.getText());
    	EspaciosDisponibles espacios = new EspaciosDisponibles(n1, n3, n2);
    	
        return espacios;
    }
    
    private void limpiarSeleccion() {
        tblListGestionEspacios.getSelectionModel().clearSelection();
        limpiarCamposEspaciosDisponibles();
    }
    
    private void limpiarCamposEspaciosDisponibles() {
        txtEspaciosAuto.clear();
        txtEspaciosCamion.clear();
        txtEspaciosMoto.clear();
    }
    
    private void actualizarEspaciosDisponibles() {

    	System.out.println(espaciosDisponiblesController.actualizarEspaciposDisponibles(buildEspaciosDisponibles()));
    	tblListGestionEspacios.refresh();
        limpiarSeleccion();
        limpiarCamposEspaciosDisponibles();
    }

}
