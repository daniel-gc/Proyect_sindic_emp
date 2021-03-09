package mx.pliis.empresas_sindicatos.dto;

import lombok.Data;

@Data
public class CatalogoDTO {

    private Integer idCat;
    private String code;
    private String nombre;
    private String value;
    private int num_meses_vigencia_cert;
    private Float precio_certificado;

}
