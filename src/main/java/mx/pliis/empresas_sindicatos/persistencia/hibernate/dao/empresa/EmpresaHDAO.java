package mx.pliis.empresas_sindicatos.persistencia.hibernate.dao.empresa;

import java.util.List;

import mx.pliis.empresas_sindicatos.persistencia.hibernate.entity.EmpresaEntity;

public interface EmpresaHDAO {
	public List<EmpresaEntity> getAllEmpresas();

}
