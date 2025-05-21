package viewController;

import org.openjfx.Administracion_Parqueadero.App;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class PagosViewController {
	
	App app;

	@FXML
    private Button dtnAtras;

    @FXML
    private Label labelTipoMembresia;

    @FXML
    private Label labelTotalApagar;

    @FXML
    private Label labelPlaca;

    @FXML
    private Label labelFecha;

    @FXML
    void onOpenMenu() {
    	app.GestionarParqueadero();
    }
    
    public void setApp(App app) {
        this.app = app;
    }

}
