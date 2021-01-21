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
@Table(name = "sindicato")
@NamedQueries({
    @NamedQuery(name = "SindicatoEntity.findAll", query = "SELECT s FROM SindicatoEntity s"),
    @NamedQuery(name = "SindicatoEntity.findByIdSindicato", query = "SELECT s FROM SindicatoEntity s WHERE s.idSindicato = :idSindicato"),
    @NamedQuery(name = "SindicatoEntity.findByNombre", query = "SELECT s FROM SindicatoEntity s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "SindicatoEntity.findByDescripcion", query = "SELECT s FROM SindicatoEntity s WHERE s.descripcion = :descripcion"),
    @NamedQuery(name = "SindicatoEntity.findByDireccion", query = "SELECT s FROM SindicatoEntity s WHERE s.direccion = :direccion")})
public class SindicatoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sindicato")
    private Integer idSindicato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 500)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 500)
    @Column(name = "direccion")
    private String direccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSindicato", fetch = FetchType.LAZY)
    private Collection<DelegadoEntity> delegadoEntityCollection;

    public SindicatoEntity() {
    }

    public SindicatoEntity(Integer idSindicato) {
        this.idSindicato = idSindicato;
    }

    public SindicatoEntity(Integer idSindicato, String nombre) {
        this.idSindicato = idSindicato;
        this.nombre = nombre;
    }

    public Integer getIdSindicato() {
        return idSindicato;
    }

    public void setIdSindicato(Integer idSindicato) {
        this.idSindicato = idSindicato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
        hash += (idSindicato != null ? idSindicato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SindicatoEntity)) {
            return false;
        }
        SindicatoEntity other = (SindicatoEntity) object;
        if ((this.idSindicato == null && other.idSindicato != null) || (this.idSindicato != null && !this.idSindicato.equals(other.idSindicato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.pliis.empresas_sindicatos.persistencia.hibernate.entity.SindicatoEntity[ idSindicato=" + idSindicato + " ]";
    }
    
}
