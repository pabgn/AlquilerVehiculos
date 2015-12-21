package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import models.Sucursal;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ControladorListarSucursales extends ControladorCasoDeUso {
	 @FXML
	 private TableView<Sucursal> sucursales;
	 @FXML
	 private TableColumn<Sucursal, Integer> id;
	 @FXML
	 private TableColumn<Sucursal, String> direccion;
	 @FXML
	 private Button aceptar;
	 Dialog<String> dialog = new Dialog<>();
	 @Override
	 public void initialize(URL location, ResourceBundle resources) {
		 stage = new Stage(StageStyle.DECORATED);
		 stage.setTitle("LISTADO DE SUCURSALES");
		 aceptar.setOnAction(event -> {
			 Stage stage = (Stage) aceptar.getScene().getWindow();
			 stage.close();
		 });
		 id.setCellValueFactory(param -> new
		ReadOnlyObjectWrapper<>(param.getValue().getId()));
		direccion.setCellValueFactory(param -> new
		ReadOnlyObjectWrapper<>(param.getValue().getDireccion()));
	 
		this.sucursales.getItems().addAll(ServicioAlquilerVehiculos.getAlquilerVehiculos().obtenerSucursales());}
	}
