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

public class ControladorListarVehiculosSucursal extends ControladorCasoDeUso{

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
		stage.setTitle("LISTADO DE COCHES DE SUCURSAL");
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
		     populate(sucursal);
		 }
		
	}
	public void populate(Sucursal s){
		List<CocheDTO> coches =  ServicioAlquilerVehiculos.getAlquilerVehiculos().obtenerCochesEnSucursal(s.getId());
		for(CocheDTO c:coches){
				this.vehiculos.getItems().add(c);
		}
        matricula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMatricula()));
        kms.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getKmsActuales()+""));
        categoria.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCategoria()+""));
        
	}
	
	 

}
