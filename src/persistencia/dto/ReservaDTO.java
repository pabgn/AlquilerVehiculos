package persistencia.dto;

import java.time.LocalDate;

public class ReservaDTO {
	private int id;
	private LocalDate fechaRecogida;
	private LocalDate fechaDevolucion;
	private String modalidadAlquiler;
	private String dniCliente;
	private String nombreCategoria;
	private int idSucursalRecogida;
	private int idSucursalDevolucion;
	
	public ReservaDTO(int id, LocalDate fechaRecogida,
			LocalDate fechaDevolucion, String modalidadAlquiler,
			String nombreCategoria, String dniCliente,  int idSucursalRecogida,
			int idSucursalDevolucion) {
		super();
		this.id = id;
		this.fechaRecogida = fechaRecogida;
		this.fechaDevolucion = fechaDevolucion;
		this.modalidadAlquiler = modalidadAlquiler;
		this.dniCliente = dniCliente;
		this.nombreCategoria = nombreCategoria;
		this.idSucursalRecogida = idSucursalRecogida;
		this.idSucursalDevolucion = idSucursalDevolucion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public void setFechaDevolucion(LocalDate fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public String getModalidadAlquiler() {
		return modalidadAlquiler;
	}

	public void setModalidadAlquiler(String modalidadAlquiler) {
		this.modalidadAlquiler = modalidadAlquiler;
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
