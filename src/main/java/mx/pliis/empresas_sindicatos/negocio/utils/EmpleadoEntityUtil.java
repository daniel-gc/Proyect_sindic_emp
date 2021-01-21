package mx.pliis.empresas_sindicatos.negocio.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;
import mx.pliis.empresas_sindicatos.dto.EmpleadoDTO;
import mx.pliis.empresas_sindicatos.persistencia.hibernate.entity.EmpleadoEntity;
import mx.pliis.empresas_sindicatos.persistencia.hibernate.repository.CentroTrabajoEntityRepository;

@Component
@Log4j2
public class EmpleadoEntityUtil {
	@Autowired
	private CentroTrabajoEntityRepository centroTrabajoEntityRepository;

	public void copyFromEntityToDTO(EmpleadoEntity ent, EmpleadoDTO dto) {
		

		
		try {
			BeanUtils.copyProperties(dto, ent);

			Optional<Integer> optInt = centroTrabajoEntityRepository
					.getByIdEmpresaAndNombre(ent.getIdEmpresa().getIdEmpresa(), ent.getIdLugarTrabajo().getNombre());
			if (optInt.isPresent()) {
				dto.setIdLugarTrabajo(optInt.get());
			} else {
				dto.setIdLugarTrabajo(ent.getIdLugarTrabajo().getIdLugarTrabajo());
			}

			dto.setIdDeptoTrabajo(ent.getIdDeptoTrabajo().getIdDeptoTrabajo());
			dto.setIdEmpresa(ent.getIdEmpresa().getIdEmpresa());
			dto.setIdPuestoTrabajo(ent.getIdPuestoTrabajo().getIdPuestoTrabajo());
		} catch (IllegalAccessException | InvocationTargetException e) {
			log.error("Ocurrió el siguiente error en la transformación de EmpleadoEntity a su DTO: {} ",
					e.getLocalizedMessage());

		}
	}
}
