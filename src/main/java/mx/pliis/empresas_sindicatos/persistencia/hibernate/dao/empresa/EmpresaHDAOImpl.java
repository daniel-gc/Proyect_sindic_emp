package mx.pliis.empresas_sindicatos.persistencia.hibernate.dao.empresa;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mx.pliis.empresas_sindicatos.persistencia.hibernate.entity.EmpresaEntity;
import mx.pliis.empresas_sindicatos.persistencia.hibernate.repository.EmpresaEntityRepository;

@Repository
public class EmpresaHDAOImpl implements EmpresaHDAO {
	@Autowired
	private EntityManager entityManager;

	@Autowired
	private EmpresaEntityRepository empresaRepository;

	@Override
	public List<EmpresaEntity> getAllEmpresas() {
		return empresaRepository.findAll();

	}

}
