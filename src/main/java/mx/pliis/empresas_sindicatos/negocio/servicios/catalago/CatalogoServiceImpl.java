package mx.pliis.empresas_sindicatos.negocio.servicios.catalago;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.pliis.empresas_sindicatos.dto.CarpetaSindicalDTO;
import mx.pliis.empresas_sindicatos.dto.CatalogoDTO;
import mx.pliis.empresas_sindicatos.persistencia.hibernate.entity.CatalogoEntity;
import mx.pliis.empresas_sindicatos.persistencia.hibernate.entity.DelegadoEntity;
import mx.pliis.empresas_sindicatos.persistencia.hibernate.repository.CatalogoEntityRepository;
import mx.pliis.empresas_sindicatos.utils.comun.ResponseConverter;

@Service
public class CatalogoServiceImpl implements CatalogoService {

    @Autowired
    private CatalogoEntityRepository catalogoEntityRepository;

    @Override
    public List<CatalogoDTO> getCatalogoByCd(String cdCatalogo) {
        List<CatalogoDTO> listaCatalogoDTO = new ArrayList<>();
        List<CatalogoEntity> listCatalogoEntity = catalogoEntityRepository.findByCode(cdCatalogo);
        if (!listCatalogoEntity.isEmpty()) {
            listaCatalogoDTO = ResponseConverter.converterLista(new ArrayList<>(), listCatalogoEntity, CatalogoDTO.class);
        }

        return listaCatalogoDTO;
    }

}
