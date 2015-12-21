package controllers;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import persistencia.dto.ReservaDTO;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import models.Reserva;
import models.Sucursal;

public class ControladorListarReservasSucursal extends ControladorCasoDeUso{
	 @FXML
	 private TableView<Reserva> reservasXsucursales;
	 @FXML
	 private TableColumn<Reserva, String> id;
	 @FXML
	 private TableColumn<Reserva, String> fechaRecogida;
	 @FXML
	 private TableColumn<Reserva, String> fechaDevolucion;
	 @FXML
	 private TableColumn<Reserva, String> sucursalRecogida;
	 @FXML
	 private TableColumn<Reserva, String> sucursalDevolucion;
	 @FXML
	 private TableColumn<Reserva, String> modalidadAlquiler;
	 @FXML
	 private TableColumn<Reserva, String> categoria;
	 @FXML
	 private TableColumn<Reserva, String> clienteRealiza;
	 public boolean pendientes;
	 //@FXML
	 //private Button aceptar;
	 
	 Dialog<String> dialog = new Dialog<>();
	 Sucursal sucursal;
	 @Override
	 public void initialize(URL location, ResourceBundle resources) {
	 stage = new Stage(StageStyle.DECORATED);
	 stage.setTitle("LISTADO DE RESERVAS POR SUCURSAL");
	 //El empleado selecciona la sucursal a la que pertenece
	 List<SucursalModelChoice> choices = new ArrayList<>();
	 List<Sucursal> sucursales = new ArrayList<>();
	 sucursales = ServicioAlquilerVehiculos.getAlquilerVehiculos().obtenerSucursales();
	 for (Sucursal s: sucursales){
		 choices.add(new SucursalModelChoice(s, s.getDireccion()));
	 }
	 
	 

	 ChoiceDialog<SucursalModelChoice> dialog = new ChoiceDialog<>(choices.get(0), choices);	 dialog.setTitle("Elige tu sucursal");
	 dialog.setHeaderText("¿A qué sucursal perteneces?");
	 dialog.setContentText("Sucursal:");

	 // Traditional way to get the response value.
	 Optional<SucursalModelChoice> result = dialog.showAndWait();
	 if (result.isPresent()){
	     sucursal = (Sucursal) result.get().suc;
         id.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()+""));
         fechaRecogida.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFechaRecogida().toString()));
         fechaDevolucion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFechaDevolucion().toString()));

         sucursalRecogida.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdSucursalRecogida()+""));
         sucursalDevolucion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdSucursalDevolucion()+""));
         modalidadAlquiler.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModalidadAlquiler()));
         categoria.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombreCategoria()));
         clienteRealiza.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDniCliente()));

		
		 List<ReservaDTO> reservaDTO = ServicioAlquilerVehiculos.getAlquilerVehiculos().listarReservasSucursal(sucursal);
		 for (ReservaDTO r: reservaDTO){
			 Reserva re = new Reserva(r.getId(), r.getFechaRecogida(),
		r.getFechaDevolucion(), r.getModalidadAlquiler(),
		r.getNombreCategoria(), r.getDniCliente(),  r.getIdSucursalRecogida(),
		r.getIdSucursalDevolucion());
			 if(this.pendientes){
				long today = System.currentTimeMillis();
				if(r.getFechaRecogida().toEpochDay()>today){
					 this.reservasXsucursales.getItems().add(re);	
				}
			}else{
				this.reservasXsucursales.getItems().add(re);
			}
		 }
	 } else if(!result.isPresent()) {
		 dialog.close();
		 stage = (Stage) stage.getScene().getWindow();
		 stage.close();
	 }
   }
}
