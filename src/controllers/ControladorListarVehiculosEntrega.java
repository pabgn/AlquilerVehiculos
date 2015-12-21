package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import persistencia.dto.CocheDTO;
import models.Categoria;
import models.Coche;
import models.Reserva;
import models.Sucursal;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ControladorListarVehiculosEntrega extends ControladorCasoDeUso{

	@FXML
	private TableView<CocheDTO> vehiculos;
	@FXML
	private TableColumn<CocheDTO, String> matricula;
	@FXML
	private TableColumn<CocheDTO, String> kms;
	@FXML
	private TableColumn<CocheDTO, String> categoria;
	@FXML
	private Button aceptar;
	Dialog<String> dialog = new Dialog<>();
	Sucursal sucursal;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		stage = new Stage(StageStyle.DECORATED);
		stage.setTitle("LISTADO DE COCHES DISPONIBLES PARA LA SUCURSAL DE ENTREGA");
		
	}
	public void populate(Reserva r){
		List<CocheDTO> coches =  ServicioAlquilerVehiculos.getAlquilerVehiculos().obtenerCochesEnSucursal(r.getIdSucursalRecogida());
		for(CocheDTO c:coches){
				this.vehiculos.getItems().add(c);
		}
        matricula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMatricula()));
        kms.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getKmsActuales()+""));
        categoria.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCategoria()+""));
        vehiculos.setRowFactory( tv -> {
		    TableRow<CocheDTO> row = new TableRow<>();
		    row.setOnMouseClicked(event -> {
		        if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
		        	CocheDTO rowData = row.getItem();
		        	this.controladorPrincipal.crearEntrega(r, rowData);
		           // this.controladorPrincipal.selectorCocheParaReserva(rowData);
		        }
		    });
		    return row ;
		});	
	}
	
	 

}
