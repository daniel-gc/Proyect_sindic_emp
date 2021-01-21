package mx.pliis.empresas_sindicatos.negocio.servicios.familiarbeneficiario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import mx.pliis.empresas_sindicatos.dto.EmpleadoDTO;
import mx.pliis.empresas_sindicatos.dto.FamiliarBeneficiarioDTO;
import mx.pliis.empresas_sindicatos.negocio.utils.FamiliarBeneficiarioUtilComponent;
import mx.pliis.empresas_sindicatos.persistencia.hibernate.entity.EmpleadoEntity;
import mx.pliis.empresas_sindicatos.persistencia.hibernate.entity.FamiliarBeneficiarioEntity;
import mx.pliis.empresas_sindicatos.persistencia.hibernate.entity.RelacionFamiliarEntity;
import mx.pliis.empresas_sindicatos.persistencia.hibernate.entity.SexoEntity;
import mx.pliis.empresas_sindicatos.persistencia.hibernate.repository.EmpleadoEntityRepository;
import mx.pliis.empresas_sindicatos.persistencia.hibernate.repository.FamiliarBeneficiarioRepository;
import mx.pliis.empresas_sindicatos.persistencia.hibernate.repository.RelacionFamiliarEntityRepository;
import mx.pliis.empresas_sindicatos.persistencia.hibernate.repository.SexoEntityRepository;

@Service
@RequiredArgsConstructor
@Log4j2
public class FamiliarBeneficiarioServiceImpl implements FamiliarBeneficiarioService{
	
	@Autowired
	private SexoEntityRepository sexoEntityRepository;

		@Autowired
	    private  RelacionFamiliarEntityRepository relacionFamiliarEntityRepository;
		
	    @Autowired
	    private  FamiliarBeneficiarioRepository familiarBeneficiarioRepository;
		
	    @Autowired
	    private  FamiliarBeneficiarioUtilComponent familiarBeneficiarioUtilComponent;
	    
	    @Autowired
	    private EmpleadoEntityRepository empleadoEntityRepository;
	    
	    

	@Override
	@Transactional(readOnly = true)
	public List<FamiliarBeneficiarioDTO> getFamiliaresBeneficiario(Integer idEmpleado) {
				
		var empEntity = empleadoEntityRepository.findById(idEmpleado);
		
		if(empEntity.isEmpty()) {
			return new ArrayList<>();
		}
		
		var familiaresBeneficiario = familiarBeneficiarioRepository.findFamBeneficiarioByIdEmpleado(empEntity.get().getIdEmpleado(),1);
		
		if(familiaresBeneficiario.isEmpty()) {
			return new ArrayList<>();
		}
		
		var familiaresBeneficiarios = familiaresBeneficiario.get();
		var familiaresBeneficiarioDTO = this.familiarBeneficiarioUtilComponent.copyFromEntityList(familiaresBeneficiarios);

		return familiaresBeneficiarioDTO;
	}

	@Override
	@Transactional(readOnly = false)
	public Long saveFamiliarBeneficiario(FamiliarBeneficiarioDTO nuevoFamiiarBeneficiarioDTO) {
		
		FamiliarBeneficiarioEntity famBeneficiarioEnt = this.familiarBeneficiarioUtilComponent.copyFromFamimiliarDTO(nuevoFamiiarBeneficiarioDTO);
				
		var relacionFamOptional = relacionFamiliarEntityRepository.findById(nuevoFamiiarBeneficiarioDTO.getRelacionFamiliar().getIdRelacionFamiliar());
		
		RelacionFamiliarEntity relacionFamiliarEntity = null;
		if (relacionFamOptional.isPresent()) {
			famBeneficiarioEnt.setRelacionFamiliar(relacionFamOptional.get());
		} else {
			return -1L;
		}
		
		var empOptionalEntity = empleadoEntityRepository.findById(nuevoFamiiarBeneficiarioDTO.getEmpleado().getIdEmpleado());
		
		if(empOptionalEntity.isEmpty())
			return -1L;
		
		
		try {
			var dateCurrent = new Date();
			famBeneficiarioEnt.setIdEmpleado(empOptionalEntity.get());
			famBeneficiarioEnt.setFhCreacion(dateCurrent);
			famBeneficiarioEnt.setFhModificacion(dateCurrent);
			famBeneficiarioEnt.setStActivo(1);
			famBeneficiarioEnt = familiarBeneficiarioRepository.save(famBeneficiarioEnt);
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		return famBeneficiarioEnt.getIdFamiliarBeneficiario().longValue();
	}

	@Override
	@Transactional(readOnly = false)
	public Boolean updateFamiliar(FamiliarBeneficiarioDTO updateFamiiarBeneficiarioDTO) {
		
		var beneficiario = this.familiarBeneficiarioRepository.findById(updateFamiiarBeneficiarioDTO.getIdFamBeneficiario());
		if(beneficiario.isEmpty()) {
			//log.error("El familiar del beneficiario no se ecnontro.");
			throw new IllegalArgumentException("El familiar del beneficiario no se ecnontro.");
		}
		
		
		String nombreOld = beneficiario.get().getNombres().isEmpty() ? "" : beneficiario.get().getNombres();
		String apPaternoOld = beneficiario.get().getApPaterno().isEmpty() ? "" : beneficiario.get().getApPaterno();
		String apMaternoOld = beneficiario.get().getApMaterno().isEmpty() ? "" : beneficiario.get().getApMaterno();
		String nombreCompletoOld = nombreOld.toUpperCase().trim() + apPaternoOld.toUpperCase().trim() + apMaternoOld.toUpperCase().trim();
		
		String nombreNew = updateFamiiarBeneficiarioDTO.getNombres().isEmpty() ? "" : updateFamiiarBeneficiarioDTO.getNombres();
		String apPaternoNew = updateFamiiarBeneficiarioDTO.getApPaterno().isEmpty() ? "" : updateFamiiarBeneficiarioDTO.getApPaterno();
		String apMaternoNew = updateFamiiarBeneficiarioDTO.getApMaterno().isEmpty() ? "" : updateFamiiarBeneficiarioDTO.getApMaterno();
		String nombreCompletoNew = nombreNew.toUpperCase().trim() + apPaternoNew.toUpperCase().trim() + apMaternoNew.toUpperCase().trim();
		
		
		
		FamiliarBeneficiarioEntity famBeneficiarioEnt = this.familiarBeneficiarioUtilComponent.copyFromFamimiliarDTO(updateFamiiarBeneficiarioDTO);
		
		RelacionFamiliarEntity relacionFamiliarEntity = null;
		if (relacionFamiliarEntityRepository.findById(updateFamiiarBeneficiarioDTO.getRelacionFamiliar().getIdRelacionFamiliar()).isPresent()) {
			relacionFamiliarEntity = relacionFamiliarEntityRepository.findById(updateFamiiarBeneficiarioDTO.getRelacionFamiliar().getIdRelacionFamiliar())
					.get();
			famBeneficiarioEnt.setRelacionFamiliar(relacionFamiliarEntity);
		} else {
			return false;
		}
		
		var empEntity = empleadoEntityRepository.findById(updateFamiiarBeneficiarioDTO.getEmpleado().getIdEmpleado());
		
		if(empEntity.isEmpty()) {
			return false;
		}
		
		if(!nombreCompletoNew.equalsIgnoreCase(nombreCompletoOld))
			famBeneficiarioEnt.setUltimoNombre(nombreOld.concat(" ").concat(apPaternoOld).concat(" ").concat(apMaternoOld));
		
		
		famBeneficiarioEnt.setFhCreacion(beneficiario.get().getFhCreacion());
		famBeneficiarioEnt.setStActivo(beneficiario.get().getStActivo());
		famBeneficiarioEnt.setFhModificacion(new Date());
		famBeneficiarioEnt.setIdEmpleado(empEntity.get());
		famBeneficiarioEnt = familiarBeneficiarioRepository.save(famBeneficiarioEnt);
		
		return true;
	}

	@Override
	@Transactional(readOnly = false)
	public Boolean deleteFamiliarBeneficiario(Integer idFamiliarBeneficiario) {

		Optional<FamiliarBeneficiarioEntity> opcionalFamBenEntity = familiarBeneficiarioRepository.findById(idFamiliarBeneficiario.intValue());
		FamiliarBeneficiarioEntity famBeneficiarioEntity = opcionalFamBenEntity.get();
		
		
		if (opcionalFamBenEntity.isPresent()) {
			famBeneficiarioEntity.setStActivo(0);
			famBeneficiarioEntity.setFhModificacion(new Date());
			familiarBeneficiarioRepository.save(famBeneficiarioEntity);
			return true;
		}
		return false;
	}
	


}
