package mx.pliis.empresas_sindicatos.negocio.servicios.carpeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.pliis.empresas_sindicatos.dto.CarpetaSindicalDTO;
import mx.pliis.empresas_sindicatos.negocio.utils.CarpetaSindicalUtilComponent;
import mx.pliis.empresas_sindicatos.persistencia.hibernate.entity.DelegadoEntity;
import mx.pliis.empresas_sindicatos.persistencia.hibernate.repository.DelegadoEntityRepository;

@Service
public class CarpetaSindicalServiceImpl implements CarpetaSindicalService {
	@Autowired
	private DelegadoEntityRepository delegadoEntityRepository;
	@Autowired
	private CarpetaSindicalUtilComponent carpetaSindicalUtilComponent;

	@Override
	public List<CarpetaSindicalDTO> getCarpetaSindical(Integer arqIdUsuario) {
		List<CarpetaSindicalDTO> listaRet = new ArrayList<>();

		Optional<DelegadoEntity> delegadoEntityOpt = delegadoEntityRepository.findByarqIdUsuario(arqIdUsuario);
		if (delegadoEntityOpt.isEmpty()) {
			return listaRet;
		}

		DelegadoEntity delegadoEntity = delegadoEntityOpt.get();
		delegadoEntity.getCentroTrabajoEntityCollection().forEach(cT -> {
			CarpetaSindicalDTO dto = carpetaSindicalUtilComponent.copyFromCentroTrabajoEntity(cT);
			listaRet.add(dto);
		});
		
		return listaRet;
	}

}
