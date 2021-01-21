package mx.pliis.empresas_sindicatos.negocio.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import mx.pliis.empresas_sindicatos.dto.EmpleadoDTO;
import mx.pliis.empresas_sindicatos.dto.FamiliarBeneficiarioDTO;
import mx.pliis.empresas_sindicatos.dto.RelacionFamiliarDTO;
import mx.pliis.empresas_sindicatos.dto.SexoDTO;
import mx.pliis.empresas_sindicatos.persistencia.hibernate.entity.FamiliarBeneficiarioEntity;

@Component
@Log4j2
@RequiredArgsConstructor
public class FamiliarBeneficiarioUtilComponent {
	
	@Autowired
	EmpleadoEntityUtil empleadoEntityUtil;
	
	public FamiliarBeneficiarioDTO copyFromFamEntity(FamiliarBeneficiarioEntity ent) {
		FamiliarBeneficiarioDTO dto = new FamiliarBeneficiarioDTO();

		
		
		RelacionFamiliarDTO relacionFamiliarDTO = new RelacionFamiliarDTO();
		relacionFamiliarDTO.setIdRelacionFamiliar(ent.getRelacionFamiliar().getIdRelacionFamiliar());
		relacionFamiliarDTO.setNombre(ent.getRelacionFamiliar().getNombre());
		
		SexoDTO sexoDTO = new SexoDTO();
		sexoDTO.setIdSexo(ent.getSexo());
		
		EmpleadoDTO empDTO = new EmpleadoDTO();
		empleadoEntityUtil.copyFromEntityToDTO(ent.getIdEmpleado(), empDTO);
		
		dto.setIdFamBeneficiario(ent.getIdFamiliarBeneficiario());
		dto.setNombres(ent.getNombres());
		dto.setApMaterno(ent.getApMaterno());
		dto.setApPaterno(ent.getApPaterno());
		dto.setEmail(ent.getEmail());
		dto.setRelacionFamiliar(relacionFamiliarDTO);
		dto.setFechaNaciomiento(ent.getFechaNacimiento());	
		dto.setSexo(sexoDTO);
		dto.setCurp(ent.getCurp());
		dto.setTelefono(ent.getTelefono());
		dto.setEmail(ent.getEmail());
		dto.setEmpleado(empDTO);
		dto.setFhCreacion(ent.getFhCreacion());
		dto.setFhModificacion(ent.getFhModificacion());
		
		return dto;
	}

	public List<FamiliarBeneficiarioDTO> copyFromEntityList(List<FamiliarBeneficiarioEntity> entList) {
		var dtoList = new ArrayList<FamiliarBeneficiarioDTO>();

		for (FamiliarBeneficiarioEntity ent : entList) {
			var dto = this.copyFromFamEntity(ent);
			dtoList.add(dto);
		}

		return dtoList;
	}
	
	public FamiliarBeneficiarioEntity copyFromFamimiliarDTO(FamiliarBeneficiarioDTO dto) {
		FamiliarBeneficiarioEntity ent = new FamiliarBeneficiarioEntity();

		ent.setIdFamiliarBeneficiario(dto.getIdFamBeneficiario());
		ent.setNombres(dto.getNombres());
		ent.setApMaterno(dto.getApMaterno());
		ent.setApPaterno(dto.getApPaterno());
		ent.setEmail(dto.getEmail());
		ent.setFechaNacimiento(dto.getFechaNaciomiento());
		ent.setCurp(dto.getCurp());
		ent.setTelefono(dto.getTelefono());
		ent.setEmail(dto.getEmail());
		ent.setSexo(dto.getSexo().getIdSexo());
		ent.setFolio(dto.getEmpleado().getNumeroEmpleado());
		return ent;
	}

}
