package models;

public class Empleado {
private String nombre;
private boolean administrador;

private Sucursal sucursal;

public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public boolean isAdministrador() {
	return administrador;
}
public void setAdministrador(boolean administrador) {
	this.administrador = administrador;
}
public Sucursal getSucursal() {
	return sucursal;
}
public void setSucursal(Sucursal sucursal) {
	this.sucursal = sucursal;
}
}
