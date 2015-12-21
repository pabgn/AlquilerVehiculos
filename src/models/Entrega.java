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
private List<Daño> daños;
private Devolucion devolucion;
private Coche coche;
private String empleado;
private int id;

public Entrega(int id, LocalDate fecha, String tipoSeguro, float kms, float combustible, Reserva reserva,
		List<Daño> daños, Devolucion devolucion, Coche coche, String empleado){
	this.fecha = fecha;
	this.tipoSeguro = tipoSeguro;
	this.kms = kms;
	this.combustible = combustible;
	this.reserva = reserva;
	this.daños = daños;
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

//Daños 
public List<Daño> consultar_daños(){
	return daños;
	
}
public void anyadir_daño(Daño daño){
	daños.add(daño);
}
public void eliminar_daño(Daño daño){
	daños.remove(daño);
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
