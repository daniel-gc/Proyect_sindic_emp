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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "delegado")
@NamedQueries({
    @NamedQuery(name = "DelegadoEntity.findAll", query = "SELECT d FROM DelegadoEntity d"),
    @NamedQuery(name = "DelegadoEntity.findByIdDelegado", query = "SELECT d FROM DelegadoEntity d WHERE d.idDelegado = :idDelegado"),
    @NamedQuery(name = "DelegadoEntity.findByNombres", query = "SELECT d FROM DelegadoEntity d WHERE d.nombres = :nombres"),
    @NamedQuery(name = "DelegadoEntity.findByActivo", query = "SELECT d FROM DelegadoEntity d WHERE d.activo = :activo"),
    @NamedQuery(name = "DelegadoEntity.findByApellidoPaterno", query = "SELECT d FROM DelegadoEntity d WHERE d.apellidoPaterno = :apellidoPaterno"),
    @NamedQuery(name = "DelegadoEntity.findByApellidoMaterno", query = "SELECT d FROM DelegadoEntity d WHERE d.apellidoMaterno = :apellidoMaterno"),
    @NamedQuery(name = "DelegadoEntity.findByEmail", query = "SELECT d FROM DelegadoEntity d WHERE d.email = :email"),
    @NamedQuery(name = "DelegadoEntity.findByArqIdUsuario", query = "SELECT d FROM DelegadoEntity d WHERE d.arqIdUsuario = :arqIdUsuario"),
    @NamedQuery(name = "DelegadoEntity.findByCurp", query = "SELECT d FROM DelegadoEntity d WHERE d.curp = :curp"),
    @NamedQuery(name = "DelegadoEntity.findByRfc", query = "SELECT d FROM DelegadoEntity d WHERE d.rfc = :rfc")})
public class DelegadoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_delegado")
    private Integer idDelegado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "activo")
    private Boolean activo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "apellido_paterno")
    private String apellidoPaterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "apellido_materno")
    private String apellidoMaterno;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "arq_id_usuario")
    private int arqIdUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "curp")
    private String curp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "rfc")
    private String rfc;
    @JoinTable(name = "delegado_centro_trabajo", joinColumns = {
        @JoinColumn(name = "id_delegado", referencedColumnName = "id_delegado")}, inverseJoinColumns = {
        @JoinColumn(name = "id_centro_trabajo", referencedColumnName = "id_centro_trabajo")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<CentroTrabajoEntity> centroTrabajoEntityCollection;
    @JoinColumn(name = "id_cargo_delegado", referencedColumnName = "id_cargo_delegado")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CargoDelegadoEntity idCargoDelegado;
    @OneToMany(mappedBy = "subordinadoDe", fetch = FetchType.LAZY)
    private Collection<DelegadoEntity> delegadoEntityCollection;
    @JoinColumn(name = "subordinado_de", referencedColumnName = "id_delegado")
    @ManyToOne(fetch = FetchType.LAZY)
    private DelegadoEntity subordinadoDe;
    @JoinColumn(name = "id_sexo", referencedColumnName = "id_sexo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SexoEntity idSexo;
    @JoinColumn(name = "id_sindicato", referencedColumnName = "id_sindicato")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SindicatoEntity idSindicato;

    public DelegadoEntity() {
    }

    public DelegadoEntity(Integer idDelegado) {
        this.idDelegado = idDelegado;
    }

    public DelegadoEntity(Integer idDelegado, String nombres, String apellidoPaterno, String apellidoMaterno, String email, int arqIdUsuario, String curp, String rfc) {
        this.idDelegado = idDelegado;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.email = email;
        this.arqIdUsuario = arqIdUsuario;
        this.curp = curp;
        this.rfc = rfc;
    }

    public Integer getIdDelegado() {
        return idDelegado;
    }

    public void setIdDelegado(Integer idDelegado) {
        this.idDelegado = idDelegado;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getArqIdUsuario() {
        return arqIdUsuario;
    }

    public void setArqIdUsuario(int arqIdUsuario) {
        this.arqIdUsuario = arqIdUsuario;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public Collection<CentroTrabajoEntity> getCentroTrabajoEntityCollection() {
        return centroTrabajoEntityCollection;
    }

    public void setCentroTrabajoEntityCollection(Collection<CentroTrabajoEntity> centroTrabajoEntityCollection) {
        this.centroTrabajoEntityCollection = centroTrabajoEntityCollection;
    }

    public CargoDelegadoEntity getIdCargoDelegado() {
        return idCargoDelegado;
    }

    public void setIdCargoDelegado(CargoDelegadoEntity idCargoDelegado) {
        this.idCargoDelegado = idCargoDelegado;
    }

    public Collection<DelegadoEntity> getDelegadoEntityCollection() {
        return delegadoEntityCollection;
    }

    public void setDelegadoEntityCollection(Collection<DelegadoEntity> delegadoEntityCollection) {
        this.delegadoEntityCollection = delegadoEntityCollection;
    }

    public DelegadoEntity getSubordinadoDe() {
        return subordinadoDe;
    }

    public void setSubordinadoDe(DelegadoEntity subordinadoDe) {
        this.subordinadoDe = subordinadoDe;
    }

    public SexoEntity getIdSexo() {
        return idSexo;
    }

    public void setIdSexo(SexoEntity idSexo) {
        this.idSexo = idSexo;
    }

    public SindicatoEntity getIdSindicato() {
        return idSindicato;
    }

    public void setIdSindicato(SindicatoEntity idSindicato) {
        this.idSindicato = idSindicato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDelegado != null ? idDelegado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DelegadoEntity)) {
            return false;
        }
        DelegadoEntity other = (DelegadoEntity) object;
        if ((this.idDelegado == null && other.idDelegado != null) || (this.idDelegado != null && !this.idDelegado.equals(other.idDelegado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.pliis.empresas_sindicatos.persistencia.hibernate.entity.DelegadoEntity[ idDelegado=" + idDelegado + " ]";
    }
    
}
