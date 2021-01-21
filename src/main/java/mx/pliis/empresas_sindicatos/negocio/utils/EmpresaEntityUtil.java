package mx.pliis.empresas_sindicatos.negocio.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;
import mx.pliis.empresas_sindicatos.dto.EmpresaDTO;
import mx.pliis.empresas_sindicatos.dto.LogImportacionDTO;
import mx.pliis.empresas_sindicatos.persistencia.hibernate.entity.EmpresaEntity;
import mx.pliis.empresas_sindicatos.persistencia.hibernate.entity.LogImportacionEntity;

@Component
@Log4j2
public class EmpresaEntityUtil {
	@Autowired
	private CentroTrabajoEntityUtil centroTrabajoEntityUtil;

	public List<EmpresaDTO> copyFromEntityList(List<EmpresaEntity> listaEntidades) {
		List<EmpresaDTO> listaEmpresaDTO = new ArrayList<>();
		listaEntidades.forEach(elem -> {
			listaEmpresaDTO.add(copyFromEntity(elem));
		});
		return listaEmpresaDTO;

	}

	public EmpresaDTO copyFromEntity(EmpresaEntity entidad) {
		EmpresaDTO nuevaEmpresaDTO = new EmpresaDTO();
		nuevaEmpresaDTO.setDireccion(entidad.getDireccion());
		nuevaEmpresaDTO.setCentrosTrabajo(centroTrabajoEntityUtil
				.copyFromEntitiesToDTOs(
						entidad.getCentroTrabajoEntityCollection().stream().collect(Collectors.toList())));
		nuevaEmpresaDTO.setEmailContacto(entidad.getEmailContacto());
		nuevaEmpresaDTO.setEmailRh(entidad.getEmailRh());
		nuevaEmpresaDTO.setIdEmpresa(entidad.getIdEmpresa());
		nuevaEmpresaDTO.setNombre(entidad.getNombre());
		return nuevaEmpresaDTO;
	}

	public LogImportacionDTO copyFromLogEntity(LogImportacionEntity ent) {
		LogImportacionDTO dto = new LogImportacionDTO();

		try {
			BeanUtils.copyProperties(dto, ent);
		} catch (IllegalAccessException | InvocationTargetException e) {
			log.error("Ocurrió el siguiente error al tranformar desde LogImportacionEntity a su DTO: {}",
					e.getLocalizedMessage());
		}

		return dto;
	}

	public List<LogImportacionDTO> copyFromLogEntityList(List<LogImportacionEntity> entList) {
		List<LogImportacionDTO> dtoList = new ArrayList<>();

		for (LogImportacionEntity ent : entList) {
			LogImportacionDTO dto = this.copyFromLogEntity(ent);
			dtoList.add(dto);
		}

		return dtoList;
	}

}
