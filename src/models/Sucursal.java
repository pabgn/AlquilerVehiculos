package models;

import java.util.List;

public class Sucursal {
private String direccion;
private int id;

private List<Coche> coches;
private List<Empleado> empleados;

private List<Reserva> reservas_recogida;
private List<Reserva> reservas_devolucion;

public Sucursal(int id, String direccion){
	this.id = id;
	this.direccion = direccion;
}
public String getDireccion() {
	return direccion;
}

public void setDireccion(String direccion) {
	this.direccion = direccion;
}
//Coches
public Coche consultar_coche(String matricula){
	for(Coche c:coches){
		if(c.getMatricula().compareTo(matricula)==0){ return c; }
	}
	return null;
}
public void anyadir_coche(Coche coche){
	coches.add(coche);
}
public void eliminar_coche(Coche coche){
	coches.remove(coche);
}

//Empleados
public Empleado consultar_empleado(String nombre){
	for(Empleado e:empleados){
		if(e.getNombre().compareTo(nombre)==0){ return e; }
	}
	return null;
}
public void anyadir_empleado(Empleado e){
	empleados.add(e);
}
public void eliminar_empleado(Empleado e){
	empleados.remove(e);
}

//Reservas Recogida

public List<Reserva> consultar_recogidas(){
	return reservas_recogida;
}
public void anyadir_reserva_recogida(Reserva r){
	reservas_recogida.add(r);
}
public void eliminar_reserva_recogida(Reserva r){
	reservas_recogida.remove(r);
}

//Reservas Devolucion

public List<Reserva> consultar_devoluciones(){
	return reservas_devolucion;
}
public void anyadir_reserva_devolucion(Reserva r){
	reservas_devolucion.add(r);
}
public void eliminar_reserva_devolucion(Reserva r){
	reservas_devolucion.remove(r);
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
}
