package controllers;
import java.time.LocalDate;
import java.util.List;

import persistencia.ReservaDAOImp;
import persistencia.dto.CategoriaDTO;
import persistencia.dto.ClienteDTO;
import persistencia.dto.CocheDTO;
import persistencia.dto.ReservaDTO;
import persistencia.dto.SucursalDTO;
import models.*;

public class ServicioAlquilerVehiculos {

private AlquilerVehiculos alquilerVehiculos;
private DAL dal;
private static ServicioAlquilerVehiculos INSTANCIA = new ServicioAlquilerVehiculos();

private ServicioAlquilerVehiculos(){
	alquilerVehiculos = new AlquilerVehiculos();
    this.dal = DAL.getDAL();
	cargaSistema();
}

public static ServicioAlquilerVehiculos getAlquilerVehiculos(){
	return INSTANCIA;
}

private void cargaSistema(){
	cargaCategorias();
	cargaSucursal();
	cargaCliente();
	cargaReservas();
}
public boolean existeEntregaConReserva(Reserva r){
	return dal.existeEntrega(r);
}
private void cargaCategorias(){
	List<CategoriaDTO> listacatDTO = dal.obtenerCategorias();
	 //Crear y añadir todas las categorias a la colección
	for (CategoriaDTO catDTO : listacatDTO) {
		añadirCategoria(new Categoria(catDTO.getNombre(),
			catDTO.getPrecioModIlimitada(), catDTO.getPrecioModKms(),
		    catDTO.getPrecioKMModKms(), catDTO.getPrecioSeguroTRiesgo(),
		    catDTO.getPrecioSeguroTerceros()));
	 }
}

private void cargaSucursal(){
	List<SucursalDTO> listaSucursalDTO = dal.obtenerSucursales();
	for (SucursalDTO sucDTO : listaSucursalDTO) {
		añadirSucursal(new Sucursal(sucDTO.getId(),sucDTO.getDirección()));
	 }
}
private void cargaReservas(){
	List<ReservaDTO> listaReservasDTO = dal.obtenerTodasReservas();
	for (ReservaDTO r : listaReservasDTO) {
		añadirReserva(new Reserva(r.getId(), r.getFechaRecogida(),
		r.getFechaDevolucion(), r.getModalidadAlquiler(),
		r.getNombreCategoria(), r.getDniCliente(),  r.getIdSucursalRecogida(),
		r.getIdSucursalDevolucion()));
	 }
}
private void cargaCliente(){
	List<ClienteDTO> listaClienteDTO = dal.obtenerClientes();
	for (ClienteDTO cliDTO : listaClienteDTO) {
		añadirCliente(new Cliente(cliDTO.getNombreyApellidos(), cliDTO.getDireccion(), cliDTO.getPoblacion(), cliDTO.getCodPostal(),cliDTO.getFechaCanetConducir(), cliDTO.getDigitosTC(), cliDTO.getMesTC(), cliDTO.getAñoTC(), cliDTO.getCvcTC(), cliDTO.getTipoTC(), cliDTO.getDni()));
	}
	
}

public void añadirNuevoCliente(Cliente cliente) {
	dal.insertarCliente(cliente);
	this.añadirCliente(cliente);
	
}

public void añadirCliente(Cliente cliente) {
	//dal.insertarCliente(cliente);
	alquilerVehiculos.anyadir_cliente(cliente);
	
}

public void añadirReserva(Reserva reserva) {
	//dal.insertarReserva(reserva);
	alquilerVehiculos.anyadir_reservas(reserva);
	
}
public void añadirNuevaReserva(Reserva reserva) {
	dal.insertarReserva(reserva);
	añadirReserva(reserva);
}
public void añadirNuevaEntrega(Entrega entrega) {
	dal.insertarEntrega(entrega);
	añadirEntrega(entrega);
}
public void añadirEntrega(Entrega entrega) {
	//dal.insertarEntrega(entrega);
	alquilerVehiculos.anyadir_entrega(entrega);
	
}

private void añadirCategoria(Categoria c){
	alquilerVehiculos.anyadir_categoria(c);
}

private void añadirSucursal(Sucursal s){
	alquilerVehiculos.anyadir_sucursal(s);
}
public Cliente buscarCliente(String dni){
	List<Cliente> clientes = alquilerVehiculos.consultar_clientes();
	for(Cliente c: clientes){
		if(c.getDNI().compareTo(dni)==0){
			return c;
		}
	}
	return null;
}
public List<Sucursal> obtenerSucursales(){
	return alquilerVehiculos.consultar_sucursales();	
}
public List<Categoria> obtenerCategorias(){
	return alquilerVehiculos.consultar_categorias();
}
public List<Reserva> obtenerReservas(){
	return alquilerVehiculos.consultar_reservas();
}
public List<Cliente> obtenerClientes(){
	return alquilerVehiculos.consultar_clientes();
}
public List<CocheDTO> obtenerCochesEnSucursal(int s){
	return this.dal.obtenerCochesPorSucursal(s);
}
public void crearReserva(int id, Cliente c, Sucursal recogida, Sucursal devolucion, Categoria categoria, LocalDate fecha_recogida, LocalDate fecha_devolucion, String modalidad){
	Reserva r = new Reserva( id, fecha_recogida, fecha_devolucion,  modalidad, categoria.getNombre(), c.getDNI(),recogida.getId(), devolucion.getId());
	alquilerVehiculos.anyadir_reservas(r);
	dal.insertarReserva(r);

}
public void crearCliente(String nombre, String direccion, String poblacion, String cp, LocalDate fecha_caducidad_carnet, String digitosTC, int mesTC, int añoTC, int cvcTC, String tipoTC, String dni){
	Cliente c = new Cliente(nombre, direccion, poblacion, cp, fecha_caducidad_carnet, digitosTC, mesTC,  añoTC,  cvcTC,  tipoTC, dni);
	alquilerVehiculos.anyadir_cliente(c);
	
}
public Sucursal buscarSucursal(int id){
	List<Sucursal> sucursales = alquilerVehiculos.consultar_sucursales();
	for(Sucursal s: sucursales){
		if(s.getId()==id){
			return s;
		}
	}
	return null;
}
public List<ReservaDTO> listarReservasSucursal(Sucursal s){
	try{
	ReservaDAOImp reserva = new ReservaDAOImp();
	List<ReservaDTO> listaReservaDTO = reserva.obtenerReservasPorSucursalOrigen(s.getId());
	return listaReservaDTO;
	} catch (Exception e){}
	return null;
}
}
