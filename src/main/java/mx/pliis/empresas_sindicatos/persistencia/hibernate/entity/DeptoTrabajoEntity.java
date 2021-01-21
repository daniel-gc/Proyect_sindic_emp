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
@Table(name = "depto_trabajo")
@NamedQueries({
    @NamedQuery(name = "DeptoTrabajoEntity.findAll", query = "SELECT d FROM DeptoTrabajoEntity d"),
    @NamedQuery(name = "DeptoTrabajoEntity.findByIdDeptoTrabajo", query = "SELECT d FROM DeptoTrabajoEntity d WHERE d.idDeptoTrabajo = :idDeptoTrabajo"),
    @NamedQuery(name = "DeptoTrabajoEntity.findByNombre", query = "SELECT d FROM DeptoTrabajoEntity d WHERE d.nombre = :nombre")})
public class DeptoTrabajoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_depto_trabajo")
    private Integer idDeptoTrabajo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EmpresaEntity idEmpresa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDeptoTrabajo", fetch = FetchType.LAZY)
    private Collection<EmpleadoEntity> empleadoEntityCollection;

    public DeptoTrabajoEntity() {
    }

    public DeptoTrabajoEntity(Integer idDeptoTrabajo) {
        this.idDeptoTrabajo = idDeptoTrabajo;
    }

    public DeptoTrabajoEntity(Integer idDeptoTrabajo, String nombre) {
        this.idDeptoTrabajo = idDeptoTrabajo;
        this.nombre = nombre;
    }

    public Integer getIdDeptoTrabajo() {
        return idDeptoTrabajo;
    }

    public void setIdDeptoTrabajo(Integer idDeptoTrabajo) {
        this.idDeptoTrabajo = idDeptoTrabajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public EmpresaEntity getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(EmpresaEntity idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Collection<EmpleadoEntity> getEmpleadoEntityCollection() {
        return empleadoEntityCollection;
    }

    public void setEmpleadoEntityCollection(Collection<EmpleadoEntity> empleadoEntityCollection) {
        this.empleadoEntityCollection = empleadoEntityCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDeptoTrabajo != null ? idDeptoTrabajo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeptoTrabajoEntity)) {
            return false;
        }
        DeptoTrabajoEntity other = (DeptoTrabajoEntity) object;
        if ((this.idDeptoTrabajo == null && other.idDeptoTrabajo != null) || (this.idDeptoTrabajo != null && !this.idDeptoTrabajo.equals(other.idDeptoTrabajo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.pliis.empresas_sindicatos.persistencia.hibernate.entity.DeptoTrabajoEntity[ idDeptoTrabajo=" + idDeptoTrabajo + " ]";
    }
    
}
