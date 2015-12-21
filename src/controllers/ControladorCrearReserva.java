package controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import models.Categoria;
import models.Cliente;
import models.Reserva;
import models.Sucursal;

class ClientesChoice {
	 String dni; String displayString;
	 ClientesChoice(String id, String displayString) { this.dni = id; this.displayString = displayString; }
	    @Override public String toString() { return displayString; }
	    @Override public boolean equals(Object o) {
	      if (this == o) return true;
	      if (o == null || getClass() != o.getClass()) return false;
	      ClientesChoice choice = (ClientesChoice) o;
	      return displayString != null && displayString.equals(choice.displayString) || dni != null && dni.equals(choice.dni);
	 }
}
class SucursalChoice {
	Integer id; String displayString;
	SucursalChoice(Integer id)                       { this(id, null); }
	SucursalChoice(String  displayString)            { this(null, displayString); }
	SucursalChoice(Integer id, String displayString) { this.id = id; this.displayString = displayString; }
    @Override public String toString() { return displayString; }
    @Override public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      SucursalChoice choice = (SucursalChoice) o;
      return displayString != null && displayString.equals(choice.displayString) || id != null && id.equals(choice.id);
    }
}
    
public class ControladorCrearReserva extends ControladorCasoDeUso {
	 @FXML
	 private TextField id;
	 @FXML
	 private DatePicker fechaRecogida;
	 @FXML
	 private DatePicker fechaDevolucion;
	 @FXML
	 private TextField modalidadAlquiler;
	 @FXML
	 private ComboBox<String> categoria;
	 @FXML
	 private ComboBox<ClientesChoice> clienteRealiza;
	 @FXML
	 private ComboBox<SucursalChoice> sucursalRecogida;
	 @FXML
	 private ComboBox<SucursalChoice> sucursalDevolucion;
	 @FXML
	 private Button cancelar;
	 @FXML
	 private Button aceptar;
	 private Reserva nuevaReserva;
	 Dialog<String> dialog = new Dialog<>();
	 Alert alert = new Alert(AlertType.INFORMATION);
	 
	 
	 @Override
	 public void initialize(URL location, ResourceBundle resources) {

		 
		 //Obtenemos categorias
		  ObservableList<String> choices = FXCollections.observableArrayList();
		 List<Categoria> categorias = ServicioAlquilerVehiculos.getAlquilerVehiculos().obtenerCategorias();
		 for (Categoria s: categorias){
			 choices.add(s.getNombre());
		 }
		categoria.setItems(choices);
		categoria.getSelectionModel().select(0);
		
		//Obtener proximo ID:
		List<Reserva> reservas =  ServicioAlquilerVehiculos.getAlquilerVehiculos().obtenerReservas();
		if(reservas.size()>0){
		Reserva r = reservas.get(reservas.size()-1);
		id.setText((r.getId()+1)+"");
		}else{
			id.setText("0");
		}
		//Obtener clientes:
		List<Cliente> clientes =  ServicioAlquilerVehiculos.getAlquilerVehiculos().obtenerClientes();
		  ObservableList<ClientesChoice> clientes_choices = FXCollections.observableArrayList();
		  for(Cliente c: clientes){
			  clientes_choices.add(new ClientesChoice(c.getDNI(), c.getNombreyApellidos()));
		  }
		  clienteRealiza.setItems(clientes_choices);
		  clienteRealiza.getSelectionModel().select(0);

		//Obtener sucursales:
		  List<Sucursal> sucursales = ServicioAlquilerVehiculos.getAlquilerVehiculos().obtenerSucursales();
		  ObservableList<SucursalChoice> sucursales_choices =  FXCollections.observableArrayList();
		  for(Sucursal c: sucursales){
			  sucursales_choices.add(new SucursalChoice(c.getId(), c.getDireccion()));
		  }
		  sucursalRecogida.setItems(sucursales_choices);
		  sucursalDevolucion.setItems(sucursales_choices);
		  sucursalRecogida.getSelectionModel().select(0);
		  sucursalDevolucion.getSelectionModel().select(1);
		  
	stage = new Stage(StageStyle.DECORATED);
	 stage.setTitle("CREAR RESERVA");
	 cancelar.setOnAction(event -> {
		 Stage stage = (Stage) cancelar.getScene().getWindow();
		 stage.close();});
	 aceptar.setOnAction(event -> {
	 nuevaReserva = new Reserva(Integer.parseInt(id.getText()), fechaRecogida.getValue(), fechaDevolucion.getValue(),modalidadAlquiler.getText(), categoria.getSelectionModel().getSelectedItem(), clienteRealiza.getSelectionModel().getSelectedItem().dni, sucursalRecogida.getSelectionModel().getSelectedItem().id,sucursalDevolucion.getSelectionModel().getSelectedItem().id);
	 
	 if (nuevaReserva != null) {
	 //Invocamos el servicio encargado de Crear una nueva reserva

		 ServicioAlquilerVehiculos.getAlquilerVehiculos().añadirNuevaReserva(nuevaReserva);
		alert.setTitle("Información de reserva");
		alert.setHeaderText("Se ha creado una nueva reserva");
		alert.setContentText("Identificador de reserva "+nuevaReserva.getId());
		alert.showAndWait();
	 } else {
		 alert.setTitle("Información de reserva");
		 alert.setHeaderText("ERROR: No se ha creado una nueva reserva!!");
		 alert.showAndWait();		 
	 }
	 Stage stage = (Stage) aceptar.getScene().getWindow();
	    stage.close();
		 });

	 
	 }
	 

}
