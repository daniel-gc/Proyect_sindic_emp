package mx.pliis.empresas_sindicatos.negocio.servicios.familiarbeneficiario;

import java.util.List;

import mx.pliis.empresas_sindicatos.dto.FamiliarBeneficiarioDTO;


public interface FamiliarBeneficiarioService {
	
	List<FamiliarBeneficiarioDTO> getFamiliaresBeneficiario(Integer idEmpleado);
	
	Long saveFamiliarBeneficiario(FamiliarBeneficiarioDTO nuevoFamiiarBeneficiarioDTO);
	
	Boolean updateFamiliar(FamiliarBeneficiarioDTO nuevoFamiiarBeneficiarioDTO);
	
	Boolean deleteFamiliarBeneficiario(Integer idFamiliarBeneficiario);
	
}
