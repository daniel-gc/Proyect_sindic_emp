package mx.pliis.empresas_sindicatos.persistencia.hibernate.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.pliis.empresas_sindicatos.persistencia.hibernate.entity.RelacionFamiliarEntity;


public interface RelacionFamiliarEntityRepository extends JpaRepository<RelacionFamiliarEntity, Integer> {
	Optional<List<RelacionFamiliarEntity>> findByIncluida(Boolean incluida);
}
