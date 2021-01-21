package mx.pliis.empresas_sindicatos.dto;

import java.util.Collection;

import lombok.Data;

@Data
public class DelegadoDTO {
	private Integer idDelegado;
	private String nombre;
	private Boolean activo;
	private Collection<CentroTrabajoDTO> centroTrabajoDTOCollection;
	private SindicatoDTO sindicato;


}
