package models;

import java.time.LocalDate;

public class Reserva {
private LocalDate fechaRecogida;
private LocalDate fechaDevolucion;
private String modalidadAlquiler;

private Cliente cliente;
private Sucursal sucursal_devolucion;
private Sucursal sucursal_recogida;
private int id;
private String dniCliente;
private String nombreCategoria;
private int idSucursalRecogida;
private int idSucursalDevolucion;

public Reserva(int id, LocalDate fechaRecogida,
		LocalDate fechaDevolucion, String modalidadAlquiler,
		String nombreCategoria, String dniCliente,  int idSucursalRecogida,
		int idSucursalDevolucion){
	this.setId(id);
	this.fechaRecogida = fechaRecogida;
	this.fechaDevolucion = fechaDevolucion;
	this.modalidadAlquiler = modalidadAlquiler;
	this.setDniCliente(dniCliente);
	this.setNombreCategoria(nombreCategoria);
	this.setIdSucursalRecogida(idSucursalRecogida);
	this.setIdSucursalDevolucion(idSucursalDevolucion);
	
}
public LocalDate getFechaRecogida() {
	return fechaRecogida;
}
public void setFechaRecogida(LocalDate fechaRecogida) {
	this.fechaRecogida = fechaRecogida;
}
public LocalDate getFechaDevolucion() {
	return fechaDevolucion;
}
public void setFechaDevolucion(LocalDate  fechaDevolucion) {
	this.fechaDevolucion = fechaDevolucion;
}
public String getModalidadAlquiler() {
	return modalidadAlquiler;
}
public void setModalidadAlquiler(String modalidadAlquiler) {
	this.modalidadAlquiler = modalidadAlquiler;
}
public Cliente getCliente() {
	return cliente;
}
public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}
public Sucursal getSucursal_devolucion() {
	return sucursal_devolucion;
}
public void setSucursal_devolucion(Sucursal sucursal_devolucion) {
	this.sucursal_devolucion = sucursal_devolucion;
}
public Sucursal getSucursal_recogida() {
	return sucursal_recogida;
}
public void setSucursal_recogida(Sucursal sucursal_recogida) {
	this.sucursal_recogida = sucursal_recogida;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getDniCliente() {
	return dniCliente;
}
public void setDniCliente(String dniCliente) {
	this.dniCliente = dniCliente;
}
public String getNombreCategoria() {
	return nombreCategoria;
}
public void setNombreCategoria(String nombreCategoria) {
	this.nombreCategoria = nombreCategoria;
}
public int getIdSucursalRecogida() {
	return idSucursalRecogida;
}
public void setIdSucursalRecogida(int idSucursalRecogida) {
	this.idSucursalRecogida = idSucursalRecogida;
}
public int getIdSucursalDevolucion() {
	return idSucursalDevolucion;
}
public void setIdSucursalDevolucion(int idSucursalDevolucion) {
	this.idSucursalDevolucion = idSucursalDevolucion;
}



}
