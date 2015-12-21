package models;

import java.util.ArrayList;
import java.util.List;

public class AlquilerVehiculos {

private List<Sucursal> sucursales;
private List<Categoria> categorias;
private List<Reserva> reservas;
private List<Cliente> clientes;
private List<Entrega> entregas;

//Sucursales
public AlquilerVehiculos(){
	this.categorias = new ArrayList<Categoria>();
	this.sucursales = new ArrayList<Sucursal>();
	this.clientes = new ArrayList<Cliente>();
	this.reservas = new ArrayList<Reserva>();
	this.entregas = new ArrayList<Entrega>();

}
public List<Sucursal> consultar_sucursales(){
	return sucursales;
}
public void anyadir_sucursal(Sucursal s){
	sucursales.add(s);
}
public void eliminar_sucursal(Sucursal s){
	sucursales.remove(s);
}

//Categorias

public List<Categoria> consultar_categorias(){
	return categorias;
}
public void anyadir_categoria(Categoria c){
	categorias.add(c);
}
public void eliminar_categoria(Categoria c){
	categorias.remove(c);
}


//Reservas

public List<Reserva> consultar_reservas() {
	return reservas;
}

public void anyadir_reservas(Reserva r) {
	reservas.add(r);
}

public void eliminar_reserva(Reserva r){
	reservas.remove(r);
}

//Clientes

public List<Cliente> consultar_clientes() {
	return clientes;
}

public void anyadir_cliente(Cliente c) {
	clientes.add(c);
}

public void eliminar_cliente(Cliente c){
	clientes.remove(c);
}

//Entregas

public List<Entrega> consultar_entregas() {
	return entregas;
}

public void anyadir_entrega(Entrega e) {
	entregas.add(e);
}

public void eliminar_entrega(Entrega e){
	entregas.remove(e);
}

}
