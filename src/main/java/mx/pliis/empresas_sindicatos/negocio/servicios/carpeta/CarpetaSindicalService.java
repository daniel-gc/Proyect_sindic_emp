package mx.pliis.empresas_sindicatos.negocio.servicios.carpeta;

import java.util.List;

import mx.pliis.empresas_sindicatos.dto.CarpetaSindicalDTO;

public interface CarpetaSindicalService {
	public List<CarpetaSindicalDTO> getCarpetaSindical(Integer arqIdUsuario);
}
