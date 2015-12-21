package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import models.Cliente;

public class ControladorCrearCliente extends ControladorCasoDeUso {
	 @FXML
	 private TextField dni;
	 @FXML
	 private TextField nombreApellidos;
	 @FXML
	 private TextField direccion;
	 @FXML
	 private TextField añoTC;
	 @FXML
	 private TextField mesTC;
	 @FXML
	 private TextField codigoPostal;
	 @FXML
	 private TextField poblacion;
	 @FXML
	 private DatePicker fechaCarnet;
	 @FXML
	 private TextField cvc;
	 @FXML
	 private TextField tipoTarjeta;
	 @FXML
	 private TextField digitosTC;
	 @FXML
	 private Button aceptar;
	 @FXML
	 private Button cancelar;
	 private Cliente nuevoCliente;
	 Dialog<String> dialog = new Dialog<>();
	 Alert alert = new Alert(AlertType.INFORMATION);
	 @Override
	 public void initialize(URL location, ResourceBundle resources) {
	 stage = new Stage(StageStyle.DECORATED);
	 stage.setTitle("CREAR CLIENTE");
	 cancelar.setOnAction(event -> {
		 Stage stage = (Stage) cancelar.getScene().getWindow();
		 stage.close();});
	 aceptar.setOnAction(event -> {
		 nuevoCliente = new Cliente(nombreApellidos.getText(),
		 direccion.getText(),
		 poblacion.getText(), codigoPostal.getText(),
		 fechaCarnet.getValue(), digitosTC.getText(),
		 Integer.parseInt(mesTC.getText()),
		 Integer.parseInt(añoTC.getText()),
		 Integer.parseInt(cvc.getText()), tipoTarjeta.getText(),dni.getText());
		 if (nuevoCliente != null) {
			 //Invocamos el servicio encargado de Crear un nuevo cliente

			 ServicioAlquilerVehiculos.getAlquilerVehiculos().añadirNuevoCliente(nuevoCliente);
			 alert.setTitle("Información de cliente");
			 alert.setHeaderText("Se ha creado un nuevo cliente");
			 alert.setContentText("DNI "+nuevoCliente.getDNI());
			 alert.showAndWait();
		 } else {
			 alert.setTitle("Información de cliente");
			 alert.setHeaderText("ERROR: NO se ha creado un nuevo cliente!!");	
			 alert.showAndWait();
		 }
		 	Stage stage = (Stage) aceptar.getScene().getWindow();
		    stage.close();
		 });
	}
}