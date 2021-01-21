package mx.pliis.empresas_sindicatos.persistencia.hibernate.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "empleado_funerarias")
public class EmpleadoFunerariasEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2250648820732706948L;

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_empleado_funerarias")
    private Integer idUserFunerarias;
	
	@JoinColumn(name = "id_cat", referencedColumnName = "id_cat", insertable = false, updatable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private CatalogoEntity catalogoEntity;
		
	@Column(name = "id_empleado")
    private Integer idEmpleado;

	/**
	 * @return the idUserFunerarias
	 */
	public Integer getIdUserFunerarias() {
		return idUserFunerarias;
	}

	/**
	 * @param idUserFunerarias the idUserFunerarias to set
	 */
	public void setIdUserFunerarias(Integer idUserFunerarias) {
		this.idUserFunerarias = idUserFunerarias;
	}

	/**
	 * @return the catalogoEntity
	 */
	public CatalogoEntity getCatalogoEntity() {
		return catalogoEntity;
	}

	/**
	 * @param catalogoEntity the catalogoEntity to set
	 */
	public void setCatalogoEntity(CatalogoEntity catalogoEntity) {
		this.catalogoEntity = catalogoEntity;
	}

	public Integer getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	

	
}
