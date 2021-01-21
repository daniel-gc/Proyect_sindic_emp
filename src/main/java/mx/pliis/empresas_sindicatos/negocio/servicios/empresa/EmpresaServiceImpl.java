package mx.pliis.empresas_sindicatos.negocio.servicios.empresa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.pliis.empresas_sindicatos.dto.CentroTrabajoDTO;
import mx.pliis.empresas_sindicatos.dto.EmpleadoDTO;
import mx.pliis.empresas_sindicatos.dto.EmpresaDTO;
import mx.pliis.empresas_sindicatos.dto.LogImportacionDTO;
import mx.pliis.empresas_sindicatos.negocio.utils.CentroTrabajoEntityUtil;
import mx.pliis.empresas_sindicatos.negocio.utils.EmpleadoEntityUtil;
import mx.pliis.empresas_sindicatos.negocio.utils.EmpresaEntityUtil;
import mx.pliis.empresas_sindicatos.persistencia.hibernate.entity.CentroTrabajoEntity;
import mx.pliis.empresas_sindicatos.persistencia.hibernate.entity.EmpleadoEntity;
import mx.pliis.empresas_sindicatos.persistencia.hibernate.entity.EmpresaEntity;
import mx.pliis.empresas_sindicatos.persistencia.hibernate.entity.LogImportacionEntity;
import mx.pliis.empresas_sindicatos.persistencia.hibernate.repository.CentroTrabajoEntityRepository;
import mx.pliis.empresas_sindicatos.persistencia.hibernate.repository.EmpleadoEntityRepository;
import mx.pliis.empresas_sindicatos.persistencia.hibernate.repository.EmpresaEntityRepository;

@Service
public class EmpresaServiceImpl implements EmpresaService {
	@Autowired
	private EntityManager entityManager;
	@Autowired
	private EmpresaEntityUtil empresaUtil;
	@Autowired
	private EmpresaEntityRepository empresaRepository;
	@Autowired
	private EmpleadoEntityRepository empleadoRepository;
	@Autowired
	private EmpleadoEntityUtil empleadoUtil;
	@Autowired
	private CentroTrabajoEntityRepository centroTrabajoRepository;
	@Autowired
	private CentroTrabajoEntityUtil centroTrabajoEntityUtil;

	@Override
	@Transactional(readOnly = true)
	public List<EmpresaDTO> getAllEmpresas() {
		List<EmpresaDTO> listaEmpresasDTO = new ArrayList<>();

		List<EmpresaEntity> listaEmpresasEntity = empresaRepository.findAll();
		listaEmpresasDTO = empresaUtil.copyFromEntityList(listaEmpresasEntity);

		return listaEmpresasDTO;
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existeEmpresaById(Integer idEmpresa) {
		return empresaRepository.existsById(idEmpresa);
	}

	@Override
	@Transactional(readOnly = true)
	public EmpleadoDTO getEmpleadoPorEmpresaNumeroEmpleado(Integer idEmpresa, String numeroEmpleado) {
		EmpleadoDTO dto = new EmpleadoDTO();

		Optional<EmpleadoEntity> ent = empleadoRepository.getEmpleadoPorEmpresaNumeroEmpleado(idEmpresa,
				numeroEmpleado);

		ent.ifPresent(val -> {
			empleadoUtil.copyFromEntityToDTO(val, dto);
		});

		return ent.isPresent() ? dto : null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<CentroTrabajoDTO> getCentrosTrabajo(Integer idEmpresa) {
		List<CentroTrabajoDTO> listaRet = new ArrayList<>();
		List<CentroTrabajoEntity> listaCentrosTrabajo = new ArrayList<>();
		Optional<EmpresaEntity> empresaEntityOpt = empresaRepository.findById(idEmpresa);

		if (empresaEntityOpt.isPresent()) {
			listaCentrosTrabajo = centroTrabajoRepository.findByIdEmpresa(empresaEntityOpt.get());
			listaRet = centroTrabajoEntityUtil.copyFromEntitiesToDTOs(listaCentrosTrabajo);
		}

		return listaRet;
	}

	@Override
	@Transactional(readOnly = true)
	public List<String> getEmailsDelegados(Integer idCentroTrabajo) {
		List<String> listaEmails = new ArrayList<>();

		centroTrabajoRepository.findById(idCentroTrabajo).ifPresent(cT -> {
			if (!cT.getDelegadoEntityCollection().isEmpty()) {
				cT.getDelegadoEntityCollection().forEach(delegado -> {
					listaEmails.add(delegado.getEmail());
				});
			}
		});
		return listaEmails;
	}

	@Override
	@Transactional(readOnly = false)
	public void importaDatos() {
		Query query = this.entityManager.createNativeQuery(" CALL public.emp_main() ");
		query.executeUpdate();
	}

	@Override
	@Transactional(readOnly = true)
	public List<LogImportacionDTO> getResultadosImportacion() {
		Query query = this.entityManager.createNativeQuery(
				"SELECT * " + "		FROM public.log_importacion li "
						+ "		WHERE li.momento BETWEEN date(now()) AND now() " + "		ORDER BY li.momento DESC ",
				LogImportacionEntity.class);
		List<LogImportacionEntity> entList = query.getResultList();

		return this.empresaUtil.copyFromLogEntityList(entList);
	}

}
