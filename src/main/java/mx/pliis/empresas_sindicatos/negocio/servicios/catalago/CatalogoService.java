package mx.pliis.empresas_sindicatos.negocio.servicios.catalago;

import java.util.List;
import mx.pliis.empresas_sindicatos.dto.CatalogoDTO;

public interface CatalogoService {

    public List<CatalogoDTO> getCatalogoByCd(String cdCatalogo);
    
}
