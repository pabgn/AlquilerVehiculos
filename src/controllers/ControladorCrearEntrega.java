package controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import persistencia.dto.CocheDTO;
import models.Coche;
import models.Daño;
import models.Devolucion;
import models.Entrega;
import models.Reserva;
import models.Sucursal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ControladorCrearEntrega extends ControladorCasoDeUso {
	@FXML
	private ChoiceBox<String> tipoSeguro;
	@FXML
	private TextField kms;
	@FXML
	private TextField combustible;
	@FXML
	private ComboBox<String> empleadoRealiza;
	@FXML
	private Button aceptar;
	@FXML
	private Button cancelar;
	private Entrega nuevaEntrega;
	public Reserva r;
	public CocheDTO coche;
	Alert alert = new Alert(AlertType.INFORMATION);
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		stage = new Stage(StageStyle.DECORATED);
		stage.setTitle("CREAR ENTREGA");
		List<String> choices = new ArrayList<String>();
		ObservableList<String> options = 
			    FXCollections.observableArrayList("Todo riesgo PLUS", "Todo riesgo", "Terceros", "Terceros Poliza Extra");

		tipoSeguro.setItems(options);
		tipoSeguro.getSelectionModel().select(0);

		//
		 ObservableList<String> empleados_list = FXCollections.observableArrayList("12345678A", "23456789B", "34567890C");
		empleadoRealiza.setItems(empleados_list);
		empleadoRealiza.getSelectionModel().select(0);
		 cancelar.setOnAction(event -> {
			 Stage stage = (Stage) cancelar.getScene().getWindow();
			 stage.close();
		});
		aceptar.setOnAction(event -> {
			//FALTA COMPLETAR ENTREGA
				
			
			 nuevaEntrega = new Entrega(
					 this.r.getId(),
					 LocalDate.now(), 
					 tipoSeguro.getSelectionModel().getSelectedItem(),
					 Float.parseFloat(kms.getText()),
					 Float.parseFloat(kms.getText()),
					 this.r , 
					 null, 
					 null,
					 new Coche(coche.getMatricula(), coche.getKmsActuales(), null, null),
					 empleadoRealiza.getSelectionModel().getSelectedItem());
			 if (nuevaEntrega != null) {
			 //Invocamos el servicio encargado de Crear una nueva entrega

				 ServicioAlquilerVehiculos.getAlquilerVehiculos().añadirNuevaEntrega(nuevaEntrega);
				alert.setTitle("Información de reserva");
				alert.setHeaderText("Se ha asignado una entrega");
				alert.setContentText("Identificador de la reserva asignada: " +nuevaEntrega.getReserva().getId());
				alert.showAndWait();
			 } else {
				 alert.setTitle("Información de reserva");
				 alert.setHeaderText("ERROR: No se ha asignado la entrega!!");
				 alert.showAndWait();		 
			 }
			 Stage stage = (Stage) aceptar.getScene().getWindow();
			    stage.close();
				 });
		
	}

}
