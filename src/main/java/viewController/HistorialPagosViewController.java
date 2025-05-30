
package viewController;

import java.time.LocalDate;
import java.util.Collection;

import org.openjfx.Administracion_Parqueadero.App;

import controller.HistorialPagosController;
import controller.VehiculoController;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.HistorialPagos;
import model.Vehiculo;

public class HistorialPagosViewController {
	
	HistorialPagosController historialPagosController;
	App app;
	ObservableList<HistorialPagos> listHistorialPagos = FXCollections.observableArrayList();
	HistorialPagos selectedHistorialPago;
    @FXML
    private TableColumn<HistorialPagos, String> tbcMembresia;

    @FXML
    private DatePicker cbxFechaFinal;

    @FXML
    private DatePicker cbxFechaInicial;
    
    @FXML
    private Button btnFiltro;

    @FXML
    private Button dtnAtras;

    @FXML
    private TableColumn<HistorialPagos, String> tbcPago;

    @FXML
    private TableColumn<HistorialPagos, String> tbcPlaca;

    @FXML
    private TableColumn<HistorialPagos, String> tbcFecha;

    @FXML
    private TableView<HistorialPagos> tblListHistorialPagos;
    
    @FXML
    private Button btnPagoVehiculoMembresia;
    
    @FXML
    private Button btnPagoVehiculoTemporal;
    
    @FXML
    void onFiltrar() {
    	filtrarHistorilPago();
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
    	historialPagosController = new HistorialPagosController(app.parqueadero);

    	initView();
  }
    
    private void initView() {
        // Traer los datos del cliente a la tabla
        initDataBinding();

        // Obtiene la lista
        obtenertHistorialPagos();

        // Limpiar la tabla
        tblListHistorialPagos.getItems().clear();

		// Agregar los elementos a la tabla
//        ObservableList<Vehiculo> listaActual = nuevaListaVehiculosMembresia(listVehiculos);
        tblListHistorialPagos.setItems(listHistorialPagos);
        System.out.println("DESCRIPCION"+ listHistorialPagos);

        // Seleccionar elemento de la tabla
    }
    
    private void initDataBinding() {
        tbcPlaca.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPago().getPlaca()));
        tbcPago.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getPago().getTotalpagar()));
        tbcFecha.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getFecha()));
        tbcMembresia.setCellValueFactory(cellData -> {
            var membresia = cellData.getValue().getPago().getMembresia();
            if (membresia == null) {
                System.out.println("Membresía es null para: " + cellData.getValue());
                return new SimpleObjectProperty("No tiene");
            }else {
            	return new SimpleObjectProperty(cellData.getValue().getPago().getMembresia());
            }
        });
    }
    
    private void obtenertHistorialPagos() {
        listHistorialPagos.addAll(historialPagosController.obtenerListaHistorialPagos());
    }
    /* 
    public  void filtrarHistorilPago() {
        System.out.println("PRUEBA FECHAAAAA"+ historialPagosController.filtrarPagos(cbxFechaInicial.getValue(), cbxFechaFinal.getValue()));
        System.out.println("--------------------------");
        listHistorialPagos.clear();
        System.out.println(listHistorialPagos);
        listHistorialPagos.addAll(historialPagosController.filtrarPagos(cbxFechaInicial.getValue(),cbxFechaFinal.getValue()));
        initDataBinding();
        listHistorialPagos.setAll(listHistorialPagos);
		tblListHistorialPagos.getItems().clear();
        System.out.println("CARLOS"+listHistorialPagos);
        tblListHistorialPagos.setItems(listHistorialPagos);
	} */

    public void filtrarHistorilPago() {
        LocalDate fechaInicio = cbxFechaInicial.getValue();
        LocalDate fechaFinal = cbxFechaFinal.getValue();
        
        if (fechaInicio != null && fechaFinal != null) {
            Collection<HistorialPagos> filtrados = historialPagosController.filtrarPagos    (fechaInicio, fechaFinal);
            listHistorialPagos.setAll(filtrados); // actualiza bien la lista
            tblListHistorialPagos.setItems(listHistorialPagos);
        } else {
            System.out.println("⚠️ Alguna de las fechas es nula");
        }
    }

}