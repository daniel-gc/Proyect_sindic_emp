package mx.pliis.empresas_sindicatos.negocio.utils;

import org.springframework.stereotype.Component;

import mx.pliis.empresas_sindicatos.dto.CarpetaSindicalDTO;
import mx.pliis.empresas_sindicatos.persistencia.hibernate.entity.CentroTrabajoEntity;

@Component
public class CarpetaSindicalUtilComponent {

	public CarpetaSindicalDTO copyFromCentroTrabajoEntity(CentroTrabajoEntity ent) {
		CarpetaSindicalDTO dto = new CarpetaSindicalDTO();

		dto.setIdCentroTrabajo(ent.getIdCentroTrabajo());
		dto.setIdEmpresa(ent.getIdEmpresa().getIdEmpresa());
		dto.setNombreCentroTrabajo(ent.getNombre());
		dto.setNombreEmpresa(ent.getIdEmpresa().getNombre());
		dto.setUrl(ent.getUrl());

		return dto;
	}
}
