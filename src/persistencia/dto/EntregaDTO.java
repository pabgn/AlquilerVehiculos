package persistencia.dto;

import java.time.LocalDate;

public class EntregaDTO {
	private int id;
	private LocalDate fecha;
	private String tipoSeguro;
	private float kms;
	private float combustible;
	private String cocheAsignado;
	private String empleadoRealiza;
	
	public EntregaDTO(int id, LocalDate fecha,
			String tipoSeguro, float kms, float combustible, String cocheAsignado, String empleadoRealiza) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.setTipoSeguro(tipoSeguro);
		this.setKms(kms);
		this.setCombustible(combustible);
		this.setCocheAsignado(cocheAsignado);
		this.setEmpleadoRealiza(empleadoRealiza);

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getTipoSeguro() {
		return tipoSeguro;
	}

	public void setTipoSeguro(String tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
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

	public String getCocheAsignado() {
		return cocheAsignado;
	}

	public void setCocheAsignado(String cocheAsignado) {
		this.cocheAsignado = cocheAsignado;
	}

	public String getEmpleadoRealiza() {
		return empleadoRealiza;
	}

	public void setEmpleadoRealiza(String empleadoRealiza) {
		this.empleadoRealiza = empleadoRealiza;
	}

	
	
}
