package models;

public class Coche {
private String matricula;
private float kmsActuales;

private Sucursal sucursal;
private Categoria categoria;

public Coche(String matricula, float kmsActuales, Sucursal sucursal, Categoria categoria){
	this.matricula = matricula;
	this.kmsActuales = kmsActuales;
	this.sucursal = sucursal;
	this.categoria = categoria;
}

public String getMatricula() {
	return matricula;
}
public void setMatricula(String matricula) {
	this.matricula = matricula;
}
public float getKmsActuales() {
	return kmsActuales;
}
public void setKmsActuales(float kmsActuales) {
	this.kmsActuales = kmsActuales;
}
public Sucursal getSucursal() {
	return sucursal;
}
public void setSucursal(Sucursal sucursal) {
	this.sucursal = sucursal;
}
public Categoria getCategoria() {
	return categoria;
}
public void setCategoria(Categoria categoria) {
	this.categoria = categoria;
}

}
