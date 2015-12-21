package models;

import java.time.LocalDateTime;
import java.util.List;

public class Devolucion {
private LocalDateTime fecha;
private float totalACobrar;
private float cobrado;
private float kms;
private float combustible;
private List<Da�o> da�os;
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

public List<Da�o> consultar_da�os(){
	return da�os;
	
}
public void anyadir_da�o(Da�o da�o){
	da�os.add(da�o);
}
public void eliminar_da�o(Da�o da�o){
	da�os.remove(da�o);
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
