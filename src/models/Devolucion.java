package models;

import java.time.LocalDateTime;
import java.util.List;

public class Devolucion {
private LocalDateTime fecha;
private float totalACobrar;
private float cobrado;
private float kms;
private float combustible;
private List<Daño> daños;
private Empleado empleado;
private Entrega entrega;

public float getTotalACobrar() {
	return totalACobrar;
}
public void setTotalACobrar(float totalACobrar) {
	this.totalACobrar = totalACobrar;
}
public float getCobrado() {
	return cobrado;
}
public void setCobrado(float cobrado) {
	this.cobrado = cobrado;
}
public float getKms() {
	return kms;
}
public void setKms(float kms) {
	this.kms = kms;
}
public float getCombustible() {
	return combustible;
}
public void setCombustible(float combustible) {
	this.combustible = combustible;
}

public List<Daño> consultar_daños(){
	return daños;
	
}
public void anyadir_daño(Daño daño){
	daños.add(daño);
}
public void eliminar_daño(Daño daño){
	daños.remove(daño);
}
public Empleado getEmpleado() {
	return empleado;
}
public void setEmpleado(Empleado empleado) {
	this.empleado = empleado;
}
public LocalDateTime getFecha() {
	return fecha;
}
public void setFecha(LocalDateTime fecha) {
	this.fecha = fecha;
}
public Entrega getEntrega() {
	return entrega;
}
public void setEntrega(Entrega entrega) {
	this.entrega = entrega;
}


}
