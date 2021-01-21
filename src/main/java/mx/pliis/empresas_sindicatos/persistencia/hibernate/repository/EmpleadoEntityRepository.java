package mx.pliis.empresas_sindicatos.persistencia.hibernate.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mx.pliis.empresas_sindicatos.persistencia.hibernate.entity.EmpleadoEntity;

@Repository
public interface EmpleadoEntityRepository extends JpaRepository<EmpleadoEntity, Integer> {

	@Query("SELECT e FROM EmpleadoEntity e WHERE e.rfc = :rfc AND e.idEmpresa.idEmpresa = :idEmpresa ")
	Optional<EmpleadoEntity> getEmpleadoPorEmpresaRfc(@Param("idEmpresa") Integer idEmpresa,
			@Param("rfc") String rfc);

	@Query("SELECT e FROM EmpleadoEntity e WHERE e.numeroEmpleado = :numeroEmpleado AND e.idEmpresa.idEmpresa = :idEmpresa ")
	Optional<EmpleadoEntity> getEmpleadoPorEmpresaNumeroEmpleado(@Param("idEmpresa") Integer idEmpresa,
			@Param("numeroEmpleado") String numeroEmpleado);
	
	@Query("SELECT e FROM EmpleadoEntity e WHERE e.numeroEmpleado = :numeroEmpleado")
	Optional<EmpleadoEntity> getEmpleadoPorNumeroEmpleado(@Param("numeroEmpleado") String numeroEmpleado);
	
	@Query("SELECT e FROM EmpleadoEntity e WHERE e.curp = :curp AND e.idEmpresa.idEmpresa = :idEmpresa ")
	Optional<EmpleadoEntity> obtenerEmpleadoPorCurpYIdEmpresa(
			@Param("curp") String curp,@Param("idEmpresa") Integer idEmpresa);
}
