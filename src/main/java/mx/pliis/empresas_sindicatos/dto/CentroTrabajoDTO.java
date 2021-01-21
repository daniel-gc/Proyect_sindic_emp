package mx.pliis.empresas_sindicatos.dto;

import java.util.Collection;

import lombok.Data;

@Data
public class CentroTrabajoDTO {
	private Integer idCentroTrabajo;
	private String nombre;
	private Collection<DelegadoDTO> delegados;
	private Integer idEmpresa;
	private Integer idRegion;


}