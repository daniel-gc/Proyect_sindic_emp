package mx.pliis.empresas_sindicatos.dto;

import java.util.Date;

import lombok.Data;

@Data
public class FamiliarBeneficiarioDTO {
	
	private Integer idFamBeneficiario;
	private String nombres;
	private String apPaterno;
	private String apMaterno;
    private RelacionFamiliarDTO relacionFamiliar;//PARENTESCO
	private Date fechaNaciomiento;
	private SexoDTO sexo;
	private String curp;
	private String telefono;
	private String email;
	private Date fhCreacion;
	private Date fhModificacion;
	private Integer stActivo;
	private EmpleadoDTO empleado;
	
}
