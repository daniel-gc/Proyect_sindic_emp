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
@Table(name = "cargo_delegado")
@NamedQueries({
    @NamedQuery(name = "CargoDelegadoEntity.findAll", query = "SELECT c FROM CargoDelegadoEntity c"),
    @NamedQuery(name = "CargoDelegadoEntity.findByIdCargoDelegado", query = "SELECT c FROM CargoDelegadoEntity c WHERE c.idCargoDelegado = :idCargoDelegado"),
    @NamedQuery(name = "CargoDelegadoEntity.findByNombre", query = "SELECT c FROM CargoDelegadoEntity c WHERE c.nombre = :nombre")})
public class CargoDelegadoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cargo_delegado")
    private Integer idCargoDelegado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCargoDelegado", fetch = FetchType.LAZY)
    private Collection<DelegadoEntity> delegadoEntityCollection;

    public CargoDelegadoEntity() {
    }

    public CargoDelegadoEntity(Integer idCargoDelegado) {
        this.idCargoDelegado = idCargoDelegado;
    }

    public CargoDelegadoEntity(Integer idCargoDelegado, String nombre) {
        this.idCargoDelegado = idCargoDelegado;
        this.nombre = nombre;
    }

    public Integer getIdCargoDelegado() {
        return idCargoDelegado;
    }

    public void setIdCargoDelegado(Integer idCargoDelegado) {
        this.idCargoDelegado = idCargoDelegado;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCargoDelegado != null ? idCargoDelegado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CargoDelegadoEntity)) {
            return false;
        }
        CargoDelegadoEntity other = (CargoDelegadoEntity) object;
        if ((this.idCargoDelegado == null && other.idCargoDelegado != null) || (this.idCargoDelegado != null && !this.idCargoDelegado.equals(other.idCargoDelegado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.pliis.empresas_sindicatos.persistencia.hibernate.entity.CargoDelegadoEntity[ idCargoDelegado=" + idCargoDelegado + " ]";
    }
    
}
