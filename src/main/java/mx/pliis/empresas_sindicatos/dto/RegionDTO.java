package mx.pliis.empresas_sindicatos.dto;

import java.util.Collection;

import lombok.Data;

@Data
public class RegionDTO {
	private Integer idRegion;
	private String nombre;
	private Collection<CentroTrabajoDTO> centrosTrabajo;

}
