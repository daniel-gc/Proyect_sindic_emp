package mx.pliis.empresas_sindicatos.persistencia.hibernate.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "catalogo")
public class CatalogoEntity implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 6769939589476416358L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cat")
    private Integer idCat;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "code")
    private String code;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "value")
    private String value;

    @Basic(optional = false)
    @NotNull
    @Column(name = "num_meses_vigencia_cert")
    private int numMesesVigenciaCert;

    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_certificado")
    private Float precioCertificado;

}
