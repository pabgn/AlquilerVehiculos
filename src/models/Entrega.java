package models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Entrega {
private LocalDate fecha;
private String tipoSeguro;
private float kms;
private float combustible;
private Reserva reserva;
private List<Da�o> da�os;
private Devolucion devolucion;
private Coche coche;
private String empleado;
private int id;

public Entrega(int id, LocalDate fecha, String tipoSeguro, float kms, float combustible, Reserva reserva,
		List<Da�o> da�os, Devolucion devolucion, Coche coche, String empleado){
	this.fecha = fecha;
	this.tipoSeguro = tipoSeguro;
	this.kms = kms;
	this.combustible = combustible;
	this.reserva = reserva;
	this.da�os = da�os;
	this.devolucion = devolucion;
	this.coche = coche;
	this.empleado = empleado;
	this.id = id;

}
public LocalDate getFecha() {
	return fecha;
}
public void setFecha(LocalDate fecha) {
	this.fecha = fecha;
}
public float getKms() {
	return kms;
}
public void setKms(float kms) {
	this.kms = kms;
}
public String getTipoSeguro() {
	return tipoSeguro;
}
public void setTipoSeguro(String tipoSeguro) {
	this.tipoSeguro = tipoSeguro;
}
public float getCombustible() {
	return combustible;
}
public void setCombustible(float combustible) {
	this.combustible = combustible;
}
public Reserva getReserva() {
	return reserva;
}
public void setReserva(Reserva reserva) {
	this.reserva = reserva;
}

//Da�os 
public List<Da�o> consultar_da�os(){
	return da�os;
	
}
public void anyadir_da�o(Da�o da�o){
	da�os.add(da�o);
}
public void eliminar_da�o(Da�o da�o){
	da�os.remove(da�o);
}
////
public Devolucion getDevolucion() {
	return devolucion;
}
public void setDevolucion(Devolucion devolucion) {
	this.devolucion = devolucion;
}
public Coche getCoche() {
	return coche;
}
public void setCoche(Coche coche) {
	this.coche = coche;
}
public String getEmpleado() {
	return empleado;
}
public void setEmpleado(String empleado) {
	this.empleado = empleado;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
}
