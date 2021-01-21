package mx.pliis.empresas_sindicatos.persistencia.hibernate.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mx.pliis.empresas_sindicatos.persistencia.hibernate.entity.CentroTrabajoEntity;
import mx.pliis.empresas_sindicatos.persistencia.hibernate.entity.EmpresaEntity;

@Repository
public interface CentroTrabajoEntityRepository extends JpaRepository<CentroTrabajoEntity, Integer> {

	public List<CentroTrabajoEntity> findByIdEmpresa(EmpresaEntity idEmpresa);

	@Query("	SELECT ct.idEmpresa.idEmpresa " + "	FROM CentroTrabajoEntity ct "
			+ "	WHERE ct.idCentroTrabajo = :idCentroTrabajo ")
	public Integer getIdEmpresaByIdCentroTrabajo(@Param("idCentroTrabajo") Integer idCentroTrabajo);

	@Query("	SELECT ct.idCentroTrabajo " + "	FROM CentroTrabajoEntity ct "
			+ "	WHERE ct.idEmpresa.idEmpresa = :idEmpresa " + " 	AND ct.nombre = :nombreCC  ")
	public Optional<Integer> getByIdEmpresaAndNombre(@Param("idEmpresa") Integer idCentroTrabajo,
			@Param("nombreCC") String nombreCC);
}
