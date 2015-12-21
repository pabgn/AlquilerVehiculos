package persistencia.dto;

import models.Categoria;
import models.Sucursal;

public class CocheDTO {
		private String matricula;
		private float kmsActuales;

		private int sucursal;
		private String categoria;
		
		public CocheDTO(String matricula, float kmsActuales, int sucursal, String categoria){
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
		public int getSucursal() {
			return sucursal;
		}
		public void setSucursal(int sucursal) {
			this.sucursal = sucursal;
		}
		public String getCategoria() {
			return categoria;
		}
		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}

}
