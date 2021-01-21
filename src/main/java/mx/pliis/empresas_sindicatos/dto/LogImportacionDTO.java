package mx.pliis.empresas_sindicatos.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class LogImportacionDTO {

	private Long idLogImportacion;
	private LocalDateTime momento;
	private String motivo;
	private String texto;
}
