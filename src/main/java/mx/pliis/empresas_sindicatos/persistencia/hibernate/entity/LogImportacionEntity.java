package mx.pliis.empresas_sindicatos.persistencia.hibernate.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the log_importacion database table.
 * 
 */
@Entity
@Table(name = "log_importacion")
@NamedQuery(name = "LogImportacionEntity.findAll", query = "SELECT l FROM LogImportacionEntity l")
public class LogImportacionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_log_importacion", unique = true, nullable = false)
	private Long idLogImportacion;

	@Column(nullable = false)
	private LocalDateTime momento;

	@Column(nullable = false, length = 50)
	private String motivo;

	@Column(nullable = false, length = 1000)
	private String texto;

	public LogImportacionEntity() {
	}

	public Long getIdLogImportacion() {
		return this.idLogImportacion;
	}

	public void setIdLogImportacion(Long idLogImportacion) {
		this.idLogImportacion = idLogImportacion;
	}

	public LocalDateTime getMomento() {
		return this.momento;
	}

	public void setMomento(LocalDateTime momento) {
		this.momento = momento;
	}

	public String getMotivo() {
		return this.motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}