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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "region")
@NamedQueries({
    @NamedQuery(name = "RegionEntity.findAll", query = "SELECT r FROM RegionEntity r"),
    @NamedQuery(name = "RegionEntity.findByIdRegion", query = "SELECT r FROM RegionEntity r WHERE r.idRegion = :idRegion"),
    @NamedQuery(name = "RegionEntity.findByNombre", query = "SELECT r FROM RegionEntity r WHERE r.nombre = :nombre")})
public class RegionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_region")
    private Integer idRegion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "idRegion", fetch = FetchType.LAZY)
    private Collection<CentroTrabajoEntity> centroTrabajoEntityCollection;

    public RegionEntity() {
    }

    public RegionEntity(Integer idRegion) {
        this.idRegion = idRegion;
    }

    public RegionEntity(Integer idRegion, String nombre) {
        this.idRegion = idRegion;
        this.nombre = nombre;
    }

    public Integer getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Integer idRegion) {
        this.idRegion = idRegion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<CentroTrabajoEntity> getCentroTrabajoEntityCollection() {
        return centroTrabajoEntityCollection;
    }

    public void setCentroTrabajoEntityCollection(Collection<CentroTrabajoEntity> centroTrabajoEntityCollection) {
        this.centroTrabajoEntityCollection = centroTrabajoEntityCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRegion != null ? idRegion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegionEntity)) {
            return false;
        }
        RegionEntity other = (RegionEntity) object;
        if ((this.idRegion == null && other.idRegion != null) || (this.idRegion != null && !this.idRegion.equals(other.idRegion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.pliis.empresas_sindicatos.persistencia.hibernate.entity.RegionEntity[ idRegion=" + idRegion + " ]";
    }
    
}
