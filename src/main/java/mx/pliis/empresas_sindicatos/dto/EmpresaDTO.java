package mx.pliis.empresas_sindicatos.dto;

import java.util.Collection;

import lombok.Data;

@Data
public class EmpresaDTO {

	private Integer idEmpresa;
	private String nombre;
	private String direccion;
	private String emailContacto;
	private String emailRh;
	private Collection<CentroTrabajoDTO> centrosTrabajo;



}
