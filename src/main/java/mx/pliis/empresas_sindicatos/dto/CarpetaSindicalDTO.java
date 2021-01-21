package mx.pliis.empresas_sindicatos.dto;

import lombok.Data;

@Data
public class CarpetaSindicalDTO {
	private Integer idEmpresa;
	private String nombreEmpresa;
	private Integer idCentroTrabajo;
	private String nombreCentroTrabajo;
	private String url;
}
