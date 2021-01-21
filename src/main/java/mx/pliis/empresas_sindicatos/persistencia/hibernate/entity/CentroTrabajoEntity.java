/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pliis.empresas_sindicatos.persistencia.hibernate.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "centro_trabajo")
@NamedQueries({
    @NamedQuery(name = "CentroTrabajoEntity.findAll", query = "SELECT c FROM CentroTrabajoEntity c"),
    @NamedQuery(name = "CentroTrabajoEntity.findByIdCentroTrabajo", query = "SELECT c FROM CentroTrabajoEntity c WHERE c.idCentroTrabajo = :idCentroTrabajo"),
    @NamedQuery(name = "CentroTrabajoEntity.findByNombre", query = "SELECT c FROM CentroTrabajoEntity c WHERE c.nombre = :nombre")})
public class CentroTrabajoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_centro_trabajo")
    private Integer idCentroTrabajo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
	@Column(name = "url")
	private String url;
    @ManyToMany(mappedBy = "centroTrabajoEntityCollection", fetch = FetchType.LAZY)
    private Collection<DelegadoEntity> delegadoEntityCollection;
    @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EmpresaEntity idEmpresa;
    @JoinColumn(name = "id_region", referencedColumnName = "id_region")
    @ManyToOne(fetch = FetchType.LAZY)
    private RegionEntity idRegion;

    public CentroTrabajoEntity() {
    }

    public CentroTrabajoEntity(Integer idCentroTrabajo) {
        this.idCentroTrabajo = idCentroTrabajo;
    }

    public CentroTrabajoEntity(Integer idCentroTrabajo, String nombre) {
        this.idCentroTrabajo = idCentroTrabajo;
        this.nombre = nombre;
    }

    public Integer getIdCentroTrabajo() {
        return idCentroTrabajo;
    }

    public void setIdCentroTrabajo(Integer idCentroTrabajo) {
        this.idCentroTrabajo = idCentroTrabajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<DelegadoEntity> getDelegadoEntityCollection() {
        return delegadoEntityCollection;
    }

    public void setDelegadoEntityCollection(Collection<DelegadoEntity> delegadoEntityCollection) {
        this.delegadoEntityCollection = delegadoEntityCollection;
    }

    public EmpresaEntity getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(EmpresaEntity idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public RegionEntity getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(RegionEntity idRegion) {
        this.idRegion = idRegion;
    }

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idCentroTrabajo != null ? idCentroTrabajo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CentroTrabajoEntity)) {
            return false;
        }
        CentroTrabajoEntity other = (CentroTrabajoEntity) object;
        if ((this.idCentroTrabajo == null && other.idCentroTrabajo != null) || (this.idCentroTrabajo != null && !this.idCentroTrabajo.equals(other.idCentroTrabajo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.pliis.empresas_sindicatos.persistencia.hibernate.entity.CentroTrabajoEntity[ idCentroTrabajo=" + idCentroTrabajo + " ]";
    }
    
}
