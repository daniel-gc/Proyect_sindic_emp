/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pliis.empresas_sindicatos.persistencia.hibernate.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "lugar_trabajo")
@NamedQueries({
    @NamedQuery(name = "LugarTrabajoEntity.findAll", query = "SELECT l FROM LugarTrabajoEntity l"),
    @NamedQuery(name = "LugarTrabajoEntity.findByIdLugarTrabajo", query = "SELECT l FROM LugarTrabajoEntity l WHERE l.idLugarTrabajo = :idLugarTrabajo"),
    @NamedQuery(name = "LugarTrabajoEntity.findByNombre", query = "SELECT l FROM LugarTrabajoEntity l WHERE l.nombre = :nombre")})
public class LugarTrabajoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_lugar_trabajo")
    private Integer idLugarTrabajo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLugarTrabajo", fetch = FetchType.LAZY)
    private Collection<EmpleadoEntity> empleadoEntityCollection;
    @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EmpresaEntity idEmpresa;

    public LugarTrabajoEntity() {
    }

    public LugarTrabajoEntity(Integer idLugarTrabajo) {
        this.idLugarTrabajo = idLugarTrabajo;
    }

    public LugarTrabajoEntity(Integer idLugarTrabajo, String nombre) {
        this.idLugarTrabajo = idLugarTrabajo;
        this.nombre = nombre;
    }

    public Integer getIdLugarTrabajo() {
        return idLugarTrabajo;
    }

    public void setIdLugarTrabajo(Integer idLugarTrabajo) {
        this.idLugarTrabajo = idLugarTrabajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<EmpleadoEntity> getEmpleadoEntityCollection() {
        return empleadoEntityCollection;
    }

    public void setEmpleadoEntityCollection(Collection<EmpleadoEntity> empleadoEntityCollection) {
        this.empleadoEntityCollection = empleadoEntityCollection;
    }

    public EmpresaEntity getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(EmpresaEntity idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLugarTrabajo != null ? idLugarTrabajo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LugarTrabajoEntity)) {
            return false;
        }
        LugarTrabajoEntity other = (LugarTrabajoEntity) object;
        if ((this.idLugarTrabajo == null && other.idLugarTrabajo != null) || (this.idLugarTrabajo != null && !this.idLugarTrabajo.equals(other.idLugarTrabajo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.pliis.empresas_sindicatos.persistencia.hibernate.entity.LugarTrabajoEntity[ idLugarTrabajo=" + idLugarTrabajo + " ]";
    }
    
}
