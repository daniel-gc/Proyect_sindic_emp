package mx.pliis.empresas_sindicatos.negocio.servicios.centro_trabajo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.pliis.empresas_sindicatos.persistencia.hibernate.repository.CentroTrabajoEntityRepository;

@Service
public class CentroTrabajoServiceImpl implements CentroTrabajoService {
	@Autowired
	private CentroTrabajoEntityRepository centroTrabajoRepository;

	@Override
	@Transactional(readOnly = true)
	public boolean existeCentroTrabajonById(Integer idDivision) {

		return centroTrabajoRepository.existsById(idDivision);
	}

	@Override
	public Integer getEmpresaByCentroTrabajo(Integer idCentroTrabajo) {
		return centroTrabajoRepository.getIdEmpresaByIdCentroTrabajo(idCentroTrabajo);
	}

}
