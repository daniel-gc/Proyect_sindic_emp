package mx.pliis.empresas_sindicatos.dto;

import lombok.Data;

@Data
public class FamiliarBeneficiarioCsvDTO {

	private Integer idUnico;
	private String nombre;
	private String apPaterno;
	private String apMaterno;
	private String fhNacimiento;
	private String edad;
	private String inicioVigencia;
	private String finVigencia;
	private String genero;
	
	public Integer getIdUnico() {
		return idUnico;
	}
	public void setIdUnico(Integer idUnico) {
		this.idUnico = idUnico;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApPaterno() {
		return apPaterno;
	}
	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}
	public String getApMaterno() {
		return apMaterno;
	}
	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}
	public String getFhNacimiento() {
		return fhNacimiento;
	}
	public void setFhNacimiento(String fhNacimiento) {
		this.fhNacimiento = fhNacimiento;
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	public String getInicioVigencia() {
		return inicioVigencia;
	}
	public void setInicioVigencia(String inicioVigencia) {
		this.inicioVigencia = inicioVigencia;
	}
	public String getFinVigencia() {
		return finVigencia;
	}
	public void setFinVigencia(String finVigencia) {
		this.finVigencia = finVigencia;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
}
