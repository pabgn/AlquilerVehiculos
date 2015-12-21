package models;

import java.util.List;

public class Categoria {
private String nombre;
private double precioModIlimitada;
private double precioModKms;
private double precioKmModKms;
private double precioSeguroTRiesgo;
private double precioSeguroTerceros;

private List<Coche> coches;
private Categoria superior;

public Categoria(String nombre, double precioModIlimitada2,
		double precioModKms2, double precioKMModKms2,
		double precioSeguroTRiesgo2, double precioSeguroTerceros2) {
	this.nombre = nombre;
	this.precioModIlimitada =precioModIlimitada2;
	this.precioKmModKms = precioKMModKms2;
	this.precioModKms = precioModKms2;
	this.precioSeguroTRiesgo = precioSeguroTRiesgo2;
	this.precioSeguroTerceros = precioSeguroTerceros2;
}
public double getPrecioModIlimitada() {
	return precioModIlimitada;
}
public void setPrecioModIlimitada(double precioModIlimitada) {
	this.precioModIlimitada = precioModIlimitada;
}
public double getPrecioModKms() {
	return precioModKms;
}
public void setPrecioModKms(double precioModKms) {
	this.precioModKms = precioModKms;
}
public double getPrecioSeguroTerceros() {
	return precioSeguroTerceros;
}
public void setPrecioSeguroTerceros(double precioSeguroTerceros) {
	this.precioSeguroTerceros = precioSeguroTerceros;
}
public double getPrecioSeguroTRiesgo() {
	return precioSeguroTRiesgo;
}
public void setPrecioSeguroTRiesgo(double precioSeguroTRiesgo) {
	this.precioSeguroTRiesgo = precioSeguroTRiesgo;
}
public double getPrecioKmModKms() {
	return precioKmModKms;
}
public void setPrecioKmModKms(double precioKmModKms) {
	this.precioKmModKms = precioKmModKms;
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
public Categoria getSuperior() {
	return superior;
}
public void setSuperior(Categoria superior) {
	this.superior = superior;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}

}
