package viewController;

import org.openjfx.Administracion_Parqueadero.App;
import controller.ClienteController;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Cliente;



public class CrearClienteViewController {
	
	ClienteController clienteController;
	private App app;
	ObservableList<Cliente> listClientes = FXCollections.observableArrayList();
	Cliente selectedCliente;

	

    @FXML
    private TableView<Cliente> tblListClientes;

    @FXML
    private TableColumn<Cliente, String> tbcTelefono;

    @FXML
    private TextField txtNombre;

    @FXML
    private Button dtnAtras;

    @FXML
    private TextField txtTelefono;

    @FXML
    private Button btbActualizarCliente;

    @FXML
    private TableColumn<Cliente, String> tbcNombre;

    @FXML
    private Button btbAgregarCliente;
    
    @FXML
    private Button btbEliminarCliente;

    @FXML
    private TableColumn<Cliente, String> tbcCedula;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TableColumn<Cliente, String> tbcCorreo;
    
    @FXML
    private TextField txtPlaca;
    
    @FXML
    private TableColumn<Cliente, String> tbcPlaca;

    @FXML
    void onActualizarCliente() {
    	actualizarCliente();
    }

    @FXML
    void onAgregarCliente() {
		crearCliente();
    }

    @FXML
	void onEliminarCliente() {
		eliminarCliente();	
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
 	   clienteController = new ClienteController(app.parqueadero);
    		initView();
  }
   
    private void initView() {
        // Traer los datos del cliente a la tabla
        initDataBinding();

        // Obtiene la lista
        obtenerCliente();

        // Limpiar la tabla
        tblListClientes.getItems().clear();

        // Agregar los elementos a la tabla
        tblListClientes.setItems(listClientes);

        // Seleccionar elemento de la tabla
        listenerSelection();
    }
   
    private void initDataBinding() {
 	   
  	  
 	   tbcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbcCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        tbcTelefono.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));
        tbcCorreo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCorreo()));
        tbcPlaca.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPlaca()));
    }
   
    private void listenerSelection() {
 	   tblListClientes.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
 		   selectedCliente = newSelection;
            mostrarInformacionCliente(newSelection);
        });
    }
   
    private void mostrarInformacionCliente(Cliente cliente) {
        if (cliente != null) {
     	   
     	      	 
            txtNombre.setText(String.valueOf(cliente.getNombre())); 
            txtCedula.setText(String.valueOf(cliente.getCedula()));
            txtTelefono.setText(String.valueOf(cliente.getTelefono()));            
            txtCorreo.setText(String.valueOf(cliente.getCorreo()));
            txtPlaca.setText(String.valueOf(cliente.getPlaca()));
        }
    }
   
    private void obtenerCliente() {
 	   listClientes.addAll(clienteController.obtenerListaClientes());
    }
   
   
    private void crearCliente() {
        Cliente cliente = buildCliente();
        if (clienteController.crearCliente(cliente)) {
        	   listClientes.add(cliente);
        	   limpiarCamposCliente();
        }
    }
   
    private void limpiarSeleccion() {
 	   tblListClientes.getSelectionModel().clearSelection();
        limpiarCamposCliente();
    }

    private void limpiarCamposCliente() {
        txtTelefono.clear();       
        txtNombre.clear();
        txtCedula.clear();
        txtCorreo.clear();
        txtPlaca.clear();
       
    }

    private Cliente buildCliente() {
       	
        Cliente cliente = new Cliente(txtNombre.getText(), txtCedula.getText(), txtTelefono.getText(),  txtCorreo.getText(), txtPlaca.getText());
        return cliente;
        
    }
   
    private void actualizarCliente() {
  	  
 	   if (selectedCliente != null && clienteController.actualizarCliente(selectedCliente.getCedula(), buildCliente())) {

            int index = listClientes.indexOf(selectedCliente);
            System.out.println("fff"+listClientes);
            if (index >= 0) {
         	   listClientes.set(index, buildCliente());
            }

            tblListClientes.refresh();
            limpiarSeleccion();
            limpiarCamposCliente();
        }	   				
 	}
   
    private void eliminarCliente() {
 	   if (clienteController.eliminarCliente(txtCedula.getText())) {
 		   	listClientes.remove(selectedCliente);
 		    limpiarCamposCliente();
             limpiarSeleccion();

 	   } 
    }
   
}


