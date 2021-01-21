package mx.pliis.empresas_sindicatos.persistencia.hibernate.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mx.pliis.empresas_sindicatos.persistencia.hibernate.entity.EmpleadoEntity;
import mx.pliis.empresas_sindicatos.persistencia.hibernate.entity.FamiliarBeneficiarioEntity;


@Repository
public interface FamiliarBeneficiarioRepository extends JpaRepository<FamiliarBeneficiarioEntity, Integer>{

	Optional<FamiliarBeneficiarioEntity> findByIdFamiliarBeneficiario(Integer idFamiliarBeneficiario);
	
	@Query("SELECT f FROM FamiliarBeneficiarioEntity f WHERE f.stActivo = :stActivo AND f.idEmpleado.idEmpleado = :empleadoId ")
	Optional<List<FamiliarBeneficiarioEntity>> findFamBeneficiarioByIdEmpleado(Integer empleadoId, Integer stActivo);
	
}
