package viewController;

import java.time.LocalDate;
import java.util.Collection;

import org.openjfx.Administracion_Parqueadero.App;

import controller.TarifaController;
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
import model.Membresia;
import model.Tarifa;
import model.TipoMembresia;
import model.Vehiculo;

public class GestionTarifasViewController {

	TarifaController tarifaController;
	App app;
	Tarifa selectedTarifa;
	
	@FXML
    private TextField txtTarifaAutoMes;

    @FXML
    private TextField txtTarifaMotoMes;

    @FXML
    private TextField txtTarifaMotoHora;

    @FXML
    private TextField txtTarifaAutoAnio;

    @FXML
    private TextField txtTarifaCamionMes;

    @FXML
    private TextField txtTarifaMotoTresMeses;

    @FXML
    private TextField txtTarifaCamionHora;

    @FXML
    private Button btnActualizarTarifa;

    @FXML
    private TextField txtTarifaCamionTresMeses;

    @FXML
    private TextField txtTarifaAutoHora;

    @FXML
    private Button dtnAtras;

    @FXML
    private TextField txtTarifaCamionAnio;

    @FXML
    private TextField txtTarifaAutoTresMeses;

    @FXML
    private TextField txtTarifaMotoAnio;

    @FXML
    void onActualizarTarifa() {
    	actualizarTarifa();
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
    	tarifaController = new TarifaController(app.parqueadero);
    	
    	initView();
  }
    
    private void initView() {
        // Traer los datos del cliente a la tabla
        initDataBinding();

    }
    
    private Tarifa buildTarifa() {
    	long  n1 = Long.parseLong(txtTarifaMotoHora.getText());
    	long  n2 = Long.parseLong(txtTarifaCamionAnio.getText());
    	long  n3 = Long.parseLong(txtTarifaAutoHora.getText());
    	long  n4 = Long.parseLong(txtTarifaMotoMes.getText());
    	long  n5 = Long.parseLong(txtTarifaCamionMes.getText());
    	long  n6 = Long.parseLong(txtTarifaAutoMes.getText());
    	long  n7 = Long.parseLong(txtTarifaMotoTresMeses.getText());
    	long  n8 = Long.parseLong(txtTarifaCamionTresMeses.getText());
    	long  n9 = Long.parseLong(txtTarifaAutoTresMeses.getText());
    	long  n10 = Long.parseLong(txtTarifaMotoAnio.getText());
    	long  n11 = Long.parseLong(txtTarifaCamionAnio.getText());
    	long  n12 = Long.parseLong(txtTarifaAutoAnio.getText());
    	Tarifa tarifa = new Tarifa(n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12);
    	
        return tarifa;
    }
    
    
    private void initDataBinding() {
    	Tarifa tarifa = tarifaController.obtenerTarifa();
    	System.out.println("Entro a obtener tarifas"+ tarifa);
    	txtTarifaAutoHora.setText(String.valueOf(tarifa.getPrecioAutomovilHora()));
    	txtTarifaAutoMes.setText(String.valueOf(tarifa.getPrecioAutomovilMes()));
    	txtTarifaAutoTresMeses.setText(String.valueOf(tarifa.getPrecioAutomovilTresMeses()));
    	txtTarifaAutoAnio.setText(String.valueOf(tarifa.getPrecioAnioAutomovil()));
    	txtTarifaMotoHora.setText(String.valueOf(tarifa.getPrecioMotoHora()));
    	txtTarifaMotoMes.setText(String.valueOf(tarifa.getPrecioMotoMes()));
    	txtTarifaMotoTresMeses.setText(String.valueOf(tarifa.getPrecioMotoTresMeses()));
    	txtTarifaMotoAnio.setText(String.valueOf(tarifa.getPrecioAnioMoto()));
    	txtTarifaCamionHora.setText(String.valueOf(tarifa.getPrecioCamionHora()));
    	txtTarifaCamionMes.setText(String.valueOf(tarifa.getPrecioCamionMes()));
    	txtTarifaCamionTresMeses.setText(String.valueOf(tarifa.getPrecioCamionTresMeses()));
    	txtTarifaCamionAnio.setText(String.valueOf(tarifa.getPrecioAnioCamion()));
    }
    
    private void actualizarTarifa() {

    	System.out.println(tarifaController.actualizarTarifa(buildTarifa()));
    }

}
