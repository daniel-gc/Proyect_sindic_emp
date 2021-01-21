package mx.pliis.empresas_sindicatos.negocio.utils;

import org.springframework.stereotype.Component;

import mx.pliis.empresas_sindicatos.dto.RegionDTO;
import mx.pliis.empresas_sindicatos.persistencia.hibernate.entity.RegionEntity;

@Component
public class RegionEntityUtil {
	public RegionDTO copyRegionData(RegionEntity entidad) {
		RegionDTO nuevaRegionVO = new RegionDTO();

		nuevaRegionVO.setCentrosTrabajo(null);
		nuevaRegionVO.setIdRegion(entidad.getIdRegion());
		nuevaRegionVO.setNombre(entidad.getNombre());

		return nuevaRegionVO;

	}

}
