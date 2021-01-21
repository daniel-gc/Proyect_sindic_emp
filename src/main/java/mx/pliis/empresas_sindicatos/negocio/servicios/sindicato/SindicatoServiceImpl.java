package mx.pliis.empresas_sindicatos.negocio.servicios.sindicato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.pliis.empresas_sindicatos.persistencia.hibernate.repository.SindicatoEntityRepository;

@Service
public class SindicatoServiceImpl implements SindicatoService {
	@Autowired
	private SindicatoEntityRepository sindicatoRepository;

	@Override
	@Transactional(readOnly = true)
	public boolean existSindicatoById(Integer idSindicato) {
		return sindicatoRepository.existsById(idSindicato);

	}

}
