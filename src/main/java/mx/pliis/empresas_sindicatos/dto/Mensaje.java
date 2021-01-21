package mx.pliis.empresas_sindicatos.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NonNull;

@Data
public class Mensaje {

	@NonNull
	@NotNull
	String mensaje;

	
}
