package controllers;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDate;
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
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import models.Reserva;
import models.Sucursal;

class SucursalModelChoice {
	Sucursal suc; String displayString;
	SucursalModelChoice(Sucursal suc)                       { this(suc, null); }
	SucursalModelChoice(String  displayString)            { this(null, displayString); }
	SucursalModelChoice(Sucursal id, String displayString) { this.suc = id; this.displayString = displayString; }
    @Override public String toString() { return displayString; }
    @Override public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      SucursalModelChoice choice = (SucursalModelChoice) o;
      return displayString != null && displayString.equals(choice.displayString) || suc != null && suc.equals(choice.suc);
    }
}

public class ControladorListarReservasPendientesSucursal extends ControladorCasoDeUso{
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
	 //@FXML
	 //private Button aceptar;
	 Dialog<String> dialog = new Dialog<>();
	 Sucursal sucursal;
	 @Override
	 public void initialize(URL location, ResourceBundle resources) {
	 stage = new Stage(StageStyle.DECORATED);
	 stage.setTitle("LISTADO DE RESERVAS PENDIENTES POR SUCURSAL");
	 //El empleado selecciona la sucursal a la que pertenece
	 List<SucursalModelChoice> choices = new ArrayList<>();
	 List<Sucursal> sucursales = new ArrayList<>();
	 sucursales = ServicioAlquilerVehiculos.getAlquilerVehiculos().obtenerSucursales();
	 for (Sucursal s: sucursales){
		 choices.add(new SucursalModelChoice(s, s.getDireccion()));
	 }
	 

	 ChoiceDialog<SucursalModelChoice> dialog = new ChoiceDialog<>(choices.get(0), choices);
	 dialog.setTitle("Elige tu sucursal");
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

         ZoneId zoneId = ZoneId.systemDefault();
		 List<ReservaDTO> reservaDTO = ServicioAlquilerVehiculos.getAlquilerVehiculos().listarReservasSucursal(sucursal);
		 for (ReservaDTO r: reservaDTO){
			 Reserva re = new Reserva(r.getId(), r.getFechaRecogida(),
		r.getFechaDevolucion(), r.getModalidadAlquiler(),
		r.getNombreCategoria(), r.getDniCliente(),  r.getIdSucursalRecogida(),
		r.getIdSucursalDevolucion());
		long today = System.currentTimeMillis()/1000;
		long day = r.getFechaRecogida().atStartOfDay(zoneId).toEpochSecond();
		
		if(day>today && ServicioAlquilerVehiculos.getAlquilerVehiculos().existeEntregaConReserva(re)==false){
					 this.reservasXsucursales.getItems().add(re);	
		}
			
		 }
	 } else if(!result.isPresent()) {
		 dialog.close();
		 stage = (Stage) stage.getScene().getWindow();
		 stage.close();
	 }
   
	 reservasXsucursales.setRowFactory( tv -> {
		    TableRow<Reserva> row = new TableRow<>();
		    row.setOnMouseClicked(event -> {
		        if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
		            Reserva rowData = row.getItem();
		            this.controladorPrincipal.selectorCocheParaReserva(rowData);
		        }
		    });
		    return row ;
		});
	 }
}
