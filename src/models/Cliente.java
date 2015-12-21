package models;

import java.time.LocalDate;

public class Cliente {
private String nombreyApellidos;
private String direccion;
private String poblacion;
private String codPostal;
private LocalDate fechaCarnetConducir;
private String digitosTC;
private int mesTC;
private int añoTC;
private int cvcTC;
private String tipoTC;
private String DNI;

public Cliente(String nombreyApellidos, String direccion, String poblacion, String codPostal, LocalDate fechaCarnetConducir, String digitosTC, int mesTC, int añoTC, int cvcTC, String tipoTC, String DNI){
	this.nombreyApellidos = nombreyApellidos;
	this.direccion = direccion;
	this.poblacion = poblacion;
	this.codPostal = codPostal;
	this.fechaCarnetConducir = fechaCarnetConducir;
	this.digitosTC = digitosTC;
	this.mesTC = mesTC;
	this.añoTC = añoTC;
	this.cvcTC = cvcTC;
	this.tipoTC = tipoTC;
	this.DNI = DNI;
}
public int getAñoTC() {
	return añoTC;
}
public void setAñoTC(int añoTC) {
	this.añoTC = añoTC;
}
public int getCvcTC() {
	return cvcTC;
}
public void setCvcTC(int cvcTC) {
	this.cvcTC = cvcTC;
}
public String getTipoTC() {
	return tipoTC;
}
public void setTipoTC(String tipoTC) {
	this.tipoTC = tipoTC;
}
public String getDigitosTC() {
	return digitosTC;
}
public void setDigitosTC(String digitosTC) {
	this.digitosTC = digitosTC;
}
public LocalDate getFechaCarnetConducir() {
	return fechaCarnetConducir;
}
public void setFechaCarnetConducir(LocalDate fechaCarnetConducir) {
	this.fechaCarnetConducir = fechaCarnetConducir;
}
public String getCodPostal() {
	return codPostal;
}
public void setCodPostal(String codPostal) {
	this.codPostal = codPostal;
}
public String getPoblacion() {
	return poblacion;
}
public void setPoblacion(String poblacion) {
	this.poblacion = poblacion;
}
public String getDireccion() {
	return direccion;
}
public void setDireccion(String direccion) {
	this.direccion = direccion;
}
public String getNombreyApellidos() {
	return nombreyApellidos;
}
public void setNombreyApellidos(String nombreyApellidos) {
	this.nombreyApellidos = nombreyApellidos;
}
public int getMesTC() {
	return mesTC;
}
public void setMesTC(int mesTC) {
	this.mesTC = mesTC;
}
public String getDNI() {
	return DNI;
}
public void setDNI(String dNI) {
	DNI = dNI;
}

}
