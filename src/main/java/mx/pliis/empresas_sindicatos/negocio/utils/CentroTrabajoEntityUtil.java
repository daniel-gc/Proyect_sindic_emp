package mx.pliis.empresas_sindicatos.negocio.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import mx.pliis.empresas_sindicatos.dto.CentroTrabajoDTO;
import mx.pliis.empresas_sindicatos.persistencia.hibernate.entity.CentroTrabajoEntity;

@Component
public class CentroTrabajoEntityUtil {

	public List<CentroTrabajoDTO> copyFromEntitiesToDTOs(List<CentroTrabajoEntity> listaEntidades) {
		List<CentroTrabajoDTO> listaRet = new ArrayList<>();
		listaEntidades.forEach(entidad -> {
			CentroTrabajoDTO centroTrabajoDTO = copyFromEntityToDTO(entidad);
			listaRet.add(centroTrabajoDTO);
		});

		return listaRet;

	}

	public CentroTrabajoDTO copyFromEntityToDTO(CentroTrabajoEntity entidad) {
		CentroTrabajoDTO centroTrabajoDTO = new CentroTrabajoDTO();

		centroTrabajoDTO.setDelegados(null);
		centroTrabajoDTO.setIdEmpresa(entidad.getIdEmpresa().getIdEmpresa());
		centroTrabajoDTO.setIdCentroTrabajo(entidad.getIdCentroTrabajo());
		centroTrabajoDTO.setNombre(entidad.getNombre());
		centroTrabajoDTO.setIdRegion(entidad.getIdRegion() == null ? null : entidad.getIdRegion().getIdRegion());

		return centroTrabajoDTO;

	}

}
