
package viewController;

import org.openjfx.Administracion_Parqueadero.App;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class HistorialPagosViewController {
	
	App app;

    @FXML
    private TableColumn<?, ?> tbcMembresia;

    @FXML
    private DatePicker cbxFechaInicial;

    @FXML
    private Button dtnAtras;

    @FXML
    private TableColumn<?, ?> tbcPago;

    @FXML
    private TableColumn<?, ?> tbcPlaca;

    @FXML
    private TableColumn<?, ?> tbcFecha;

    @FXML
    private TableView<?> tblListHistorialPagos;

    @FXML
    void onOpenMenu() {
    	app.GestionarParqueadero();
    }
    
    public void setApp(App app) {
        this.app = app;
    }

}