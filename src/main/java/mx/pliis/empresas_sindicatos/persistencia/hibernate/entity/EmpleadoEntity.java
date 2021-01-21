/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pliis.empresas_sindicatos.persistencia.hibernate.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Basic;
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
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "empleado")
@NamedQueries({
    @NamedQuery(name = "EmpleadoEntity.findAll", query = "SELECT e FROM EmpleadoEntity e"),
    @NamedQuery(name = "EmpleadoEntity.findByIdEmpleado", query = "SELECT e FROM EmpleadoEntity e WHERE e.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "EmpleadoEntity.findByContrato", query = "SELECT e FROM EmpleadoEntity e WHERE e.contrato = :contrato"),
    @NamedQuery(name = "EmpleadoEntity.findByNombre", query = "SELECT e FROM EmpleadoEntity e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "EmpleadoEntity.findBySueldo", query = "SELECT e FROM EmpleadoEntity e WHERE e.sueldo = :sueldo"),
    @NamedQuery(name = "EmpleadoEntity.findByFechaNacimiento", query = "SELECT e FROM EmpleadoEntity e WHERE e.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "EmpleadoEntity.findByFechaAntiguedad", query = "SELECT e FROM EmpleadoEntity e WHERE e.fechaAntiguedad = :fechaAntiguedad"),
    @NamedQuery(name = "EmpleadoEntity.findByRfc", query = "SELECT e FROM EmpleadoEntity e WHERE e.rfc = :rfc"),
    @NamedQuery(name = "EmpleadoEntity.findByCurp", query = "SELECT e FROM EmpleadoEntity e WHERE e.curp = :curp"),
    @NamedQuery(name = "EmpleadoEntity.findByNumeroSs", query = "SELECT e FROM EmpleadoEntity e WHERE e.numeroSs = :numeroSs"),
    @NamedQuery(name = "EmpleadoEntity.findByNumeroEmpleado", query = "SELECT e FROM EmpleadoEntity e WHERE e.numeroEmpleado = :numeroEmpleado")})
@NamedStoredProcedureQuery(name = "empMain", procedureName = "emp_main")
public class EmpleadoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_empleado")
    private Integer idEmpleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "contrato")
    private String contrato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sueldo")
	private BigDecimal sueldo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_nacimiento")
	private LocalDate fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_antiguedad")
	private LocalDate fechaAntiguedad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "rfc")
    private String rfc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "curp")
    private String curp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "numero_ss")
    private String numeroSs;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "numero_empleado")
	private String numeroEmpleado;
    @JoinColumn(name = "id_depto_trabajo", referencedColumnName = "id_depto_trabajo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private DeptoTrabajoEntity idDeptoTrabajo;
    @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa")
    @ManyToOne(fetch = FetchType.LAZY)
    private EmpresaEntity idEmpresa;
    @JoinColumn(name = "id_lugar_trabajo", referencedColumnName = "id_lugar_trabajo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private LugarTrabajoEntity idLugarTrabajo;
    @JoinColumn(name = "id_puesto_trabajo", referencedColumnName = "id_puesto_trabajo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PuestoTrabajoEntity idPuestoTrabajo;
    @JoinColumn(name = "id_sexo", referencedColumnName = "id_sexo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SexoEntity idSexo;

    public EmpleadoEntity() {
    }

    public EmpleadoEntity(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

	public EmpleadoEntity(Integer idEmpleado, String contrato, String nombre, BigDecimal sueldo,
			LocalDate fechaNacimiento,
			LocalDate fechaAntiguedad, String rfc, String curp, String numeroSs) {
        this.idEmpleado = idEmpleado;
        this.contrato = contrato;
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaAntiguedad = fechaAntiguedad;
        this.rfc = rfc;
        this.curp = curp;
        this.numeroSs = numeroSs;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

	public BigDecimal getSueldo() {
        return sueldo;
    }

	public void setSueldo(BigDecimal sueldo) {
        this.sueldo = sueldo;
    }

	public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

	public LocalDate getFechaAntiguedad() {
        return fechaAntiguedad;
    }

	public void setFechaAntiguedad(LocalDate fechaAntiguedad) {
        this.fechaAntiguedad = fechaAntiguedad;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getNumeroSs() {
        return numeroSs;
    }

    public void setNumeroSs(String numeroSs) {
        this.numeroSs = numeroSs;
    }

	public String getNumeroEmpleado() {
		return numeroEmpleado;
	}

	public void setNumeroEmpleado(String numeroEmpleado) {
		this.numeroEmpleado = numeroEmpleado;
	}

	public DeptoTrabajoEntity getIdDeptoTrabajo() {
        return idDeptoTrabajo;
    }

    public void setIdDeptoTrabajo(DeptoTrabajoEntity idDeptoTrabajo) {
        this.idDeptoTrabajo = idDeptoTrabajo;
    }

    public EmpresaEntity getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(EmpresaEntity idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public LugarTrabajoEntity getIdLugarTrabajo() {
        return idLugarTrabajo;
    }

    public void setIdLugarTrabajo(LugarTrabajoEntity idLugarTrabajo) {
        this.idLugarTrabajo = idLugarTrabajo;
    }

    public PuestoTrabajoEntity getIdPuestoTrabajo() {
        return idPuestoTrabajo;
    }

    public void setIdPuestoTrabajo(PuestoTrabajoEntity idPuestoTrabajo) {
        this.idPuestoTrabajo = idPuestoTrabajo;
    }

    public SexoEntity getIdSexo() {
        return idSexo;
    }

    public void setIdSexo(SexoEntity idSexo) {
        this.idSexo = idSexo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpleado != null ? idEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpleadoEntity)) {
            return false;
        }
        EmpleadoEntity other = (EmpleadoEntity) object;
        if ((this.idEmpleado == null && other.idEmpleado != null) || (this.idEmpleado != null && !this.idEmpleado.equals(other.idEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.pliis.empresas_sindicatos.persistencia.hibernate.entity.EmpleadoEntity[ idEmpleado=" + idEmpleado + " ]";
    }
    
}
