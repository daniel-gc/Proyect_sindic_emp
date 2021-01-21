package mx.pliis.empresas_sindicatos.persistencia.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.pliis.empresas_sindicatos.persistencia.hibernate.entity.SindicatoEntity;

@Repository
public interface SindicatoEntityRepository extends JpaRepository<SindicatoEntity, Integer> {

}
