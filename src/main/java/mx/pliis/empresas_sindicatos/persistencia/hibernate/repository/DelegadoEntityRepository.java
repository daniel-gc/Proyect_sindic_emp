package mx.pliis.empresas_sindicatos.persistencia.hibernate.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.pliis.empresas_sindicatos.persistencia.hibernate.entity.DelegadoEntity;

@Repository
public interface DelegadoEntityRepository extends JpaRepository<DelegadoEntity, Integer> {
	Optional<DelegadoEntity> findByarqIdUsuario(Integer arqIdUsuario);
}
