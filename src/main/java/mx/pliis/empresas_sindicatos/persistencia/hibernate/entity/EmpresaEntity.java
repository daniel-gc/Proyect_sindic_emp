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
@Table(name = "empresa")
@NamedQueries({
    @NamedQuery(name = "EmpresaEntity.findAll", query = "SELECT e FROM EmpresaEntity e"),
    @NamedQuery(name = "EmpresaEntity.findByIdEmpresa", query = "SELECT e FROM EmpresaEntity e WHERE e.idEmpresa = :idEmpresa"),
    @NamedQuery(name = "EmpresaEntity.findByNombre", query = "SELECT e FROM EmpresaEntity e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "EmpresaEntity.findByDireccion", query = "SELECT e FROM EmpresaEntity e WHERE e.direccion = :direccion"),
    @NamedQuery(name = "EmpresaEntity.findByEmailContacto", query = "SELECT e FROM EmpresaEntity e WHERE e.emailContacto = :emailContacto"),
    @NamedQuery(name = "EmpresaEntity.findByEmailRh", query = "SELECT e FROM EmpresaEntity e WHERE e.emailRh = :emailRh")})
public class EmpresaEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_empresa")
    private Integer idEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 500)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 100)
    @Column(name = "email_contacto")
    private String emailContacto;
    @Size(max = 100)
    @Column(name = "email_rh")
    private String emailRh;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpresa", fetch = FetchType.LAZY)
    private Collection<CentroTrabajoEntity> centroTrabajoEntityCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpresa", fetch = FetchType.LAZY)
    private Collection<DeptoTrabajoEntity> deptoTrabajoEntityCollection;
    @OneToMany(mappedBy = "idEmpresa", fetch = FetchType.LAZY)
    private Collection<EmpleadoEntity> empleadoEntityCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpresa", fetch = FetchType.LAZY)
    private Collection<PuestoTrabajoEntity> puestoTrabajoEntityCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpresa", fetch = FetchType.LAZY)
    private Collection<LugarTrabajoEntity> lugarTrabajoEntityCollection;

    public EmpresaEntity() {
    }

    public EmpresaEntity(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public EmpresaEntity(Integer idEmpresa, String nombre) {
        this.idEmpresa = idEmpresa;
        this.nombre = nombre;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmailContacto() {
        return emailContacto;
    }

    public void setEmailContacto(String emailContacto) {
        this.emailContacto = emailContacto;
    }

    public String getEmailRh() {
        return emailRh;
    }

    public void setEmailRh(String emailRh) {
        this.emailRh = emailRh;
    }

    public Collection<CentroTrabajoEntity> getCentroTrabajoEntityCollection() {
        return centroTrabajoEntityCollection;
    }

    public void setCentroTrabajoEntityCollection(Collection<CentroTrabajoEntity> centroTrabajoEntityCollection) {
        this.centroTrabajoEntityCollection = centroTrabajoEntityCollection;
    }

    public Collection<DeptoTrabajoEntity> getDeptoTrabajoEntityCollection() {
        return deptoTrabajoEntityCollection;
    }

    public void setDeptoTrabajoEntityCollection(Collection<DeptoTrabajoEntity> deptoTrabajoEntityCollection) {
        this.deptoTrabajoEntityCollection = deptoTrabajoEntityCollection;
    }

    public Collection<EmpleadoEntity> getEmpleadoEntityCollection() {
        return empleadoEntityCollection;
    }

    public void setEmpleadoEntityCollection(Collection<EmpleadoEntity> empleadoEntityCollection) {
        this.empleadoEntityCollection = empleadoEntityCollection;
    }

    public Collection<PuestoTrabajoEntity> getPuestoTrabajoEntityCollection() {
        return puestoTrabajoEntityCollection;
    }

    public void setPuestoTrabajoEntityCollection(Collection<PuestoTrabajoEntity> puestoTrabajoEntityCollection) {
        this.puestoTrabajoEntityCollection = puestoTrabajoEntityCollection;
    }

    public Collection<LugarTrabajoEntity> getLugarTrabajoEntityCollection() {
        return lugarTrabajoEntityCollection;
    }

    public void setLugarTrabajoEntityCollection(Collection<LugarTrabajoEntity> lugarTrabajoEntityCollection) {
        this.lugarTrabajoEntityCollection = lugarTrabajoEntityCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpresa != null ? idEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpresaEntity)) {
            return false;
        }
        EmpresaEntity other = (EmpresaEntity) object;
        if ((this.idEmpresa == null && other.idEmpresa != null) || (this.idEmpresa != null && !this.idEmpresa.equals(other.idEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.pliis.empresas_sindicatos.persistencia.hibernate.entity.EmpresaEntity[ idEmpresa=" + idEmpresa + " ]";
    }
    
}
