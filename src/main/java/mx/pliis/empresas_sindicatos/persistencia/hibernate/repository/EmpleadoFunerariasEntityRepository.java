package mx.pliis.empresas_sindicatos.persistencia.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.pliis.empresas_sindicatos.persistencia.hibernate.entity.EmpleadoFunerariasEntity;

@Repository
public interface EmpleadoFunerariasEntityRepository extends JpaRepository<EmpleadoFunerariasEntity, Integer>{

}
