package controllers;

import persistencia.dto.CocheDTO;
import models.Reserva;
import models.Sucursal;
import excepciones.LogicaExcepcion;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class ControladorPrincipal {
	 public Reserva shared_reserva;
	 private static final String CREAR_CLIENTE = "../vistas/crear-cliente.fxml";
	 private static final String LISTAR_RESERVAS_SUCURSAL = "../vistas/listarreservas-sucursal.fxml";
	 private static final String LISTAR_SUCURSALES = "../vistas/listarsucursales.fxml";
	 //TODO añadir constantes de tipo String para la vistas correspondientes a los
	//casos de uso Crear Reserva y Listar Reservas de una Sucursal
	 private static final String CREAR_RESERVA = "../vistas/crear-reserva.fxml";
	 private static final String LISTAR_RESERVAS_SUCURSAL_ENTREGA = "../vistas/listarreservas-sucursal(entrega).fxml";
	 private static final String LISTAR_COCHES_SUCURSAL = "../vistas/listarvehiculos(entrega).fxml";
	 private static final String CREAR_ENTREGA = "../vistas/entregar-reserva.fxml";
	 private static final String LISTAR_VEHICULOS = "../vistas/listarvehiculos.fxml";

	 private Stage primaryStage;
	 @FXML
	 void listarSucursales(ActionEvent event) throws LogicaExcepcion {
		 initCasoDeUso(LISTAR_SUCURSALES,ControladorListarSucursales.class).show();
	 }
	 @FXML
	 void crearCliente(ActionEvent event) throws LogicaExcepcion {
		 initCasoDeUso(CREAR_CLIENTE, ControladorCrearCliente.class).show();
	 }
	 @FXML
	 void crearReserva(ActionEvent event) {
	 // TODO implementar el manejador del C.U. Crear Reserva
		 initCasoDeUso(CREAR_RESERVA,ControladorCrearReserva.class).show();
	 }
	 @FXML
	 void entregarVehiculo(ActionEvent event) {
	 // TODO implementar el manejador del C.U. Crear Reserva
		 initCasoDeUso(LISTAR_RESERVAS_SUCURSAL_ENTREGA,ControladorListarReservasPendientesSucursal.class).show();
	 }
	 @FXML
	 void listarReservasSucursal(ActionEvent event) throws LogicaExcepcion {
	 //TODO implementar el manejador del C.U. Listar reservas de una sucursal
		 initCasoDeUso(LISTAR_RESERVAS_SUCURSAL,ControladorListarReservasSucursal.class).show();
	 
	 }
	 @FXML
	 void listarVehiculos(ActionEvent event) throws LogicaExcepcion {
	 //TODO implementar el manejador del C.U. Listar reservas de una sucursal
		 initCasoDeUso(LISTAR_VEHICULOS,ControladorListarVehiculosSucursal.class).show();
	 
	 }
	 @FXML
	 void salir(ActionEvent event) {
	     Platform.exit();
	 }
	 public void selectorCocheParaReserva(Reserva r){
		 ControladorListarVehiculosEntrega c = initCasoDeUso(LISTAR_COCHES_SUCURSAL,ControladorListarVehiculosEntrega.class);
		 c.populate(r);
		 c.show();

	 }
	 public void crearEntrega(Reserva r, CocheDTO coche){
		 ControladorCrearEntrega c = initCasoDeUso(CREAR_ENTREGA,ControladorCrearEntrega.class);
		 c.coche = coche;
		 c.r = r;
		 c.show();
	 }
	 public void setPrimaryStage(Stage primaryStage) {
		 this.primaryStage = primaryStage;
	 }
	 private <T extends ControladorCasoDeUso> T initCasoDeUso(String urlVista,Class<T> controlClass) {
		 return ControladorCasoDeUso.initCasoDeUso(urlVista, controlClass,primaryStage, ControladorPrincipal.this);
	 }
	}