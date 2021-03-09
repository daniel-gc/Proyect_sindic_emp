package mx.pliis.empresas_sindicatos.api_rest_controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import mx.pliis.empresas_sindicatos.dto.CarpetaSindicalDTO;
import mx.pliis.empresas_sindicatos.dto.CatalogoDTO;
import mx.pliis.empresas_sindicatos.negocio.servicios.catalago.CatalogoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/catalago")
public class CatalogoRestController {

    @Autowired
    private CatalogoService catalogoService;

    @GetMapping(value = "/cdCatalogo", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<CatalogoDTO>> catalogoByCd(@RequestParam("cdCatalogo") String cdCatalogo) {
        HttpStatus estado = HttpStatus.OK;
        HttpHeaders responseHeaders = new HttpHeaders();
        List<CatalogoDTO> listaCatalogoDTO = new ArrayList<>();

        try {
            listaCatalogoDTO = catalogoService.getCatalogoByCd(cdCatalogo);
        } catch (Exception e) {
            listaCatalogoDTO = new ArrayList<>();
            estado = HttpStatus.INTERNAL_SERVER_ERROR;
            String msg = "Ocurrió un error: " + e.getLocalizedMessage();
            responseHeaders.set("Mensaje", msg);
            return new ResponseEntity<List<CatalogoDTO>>(listaCatalogoDTO, responseHeaders, estado);
        }

        return new ResponseEntity<List<CatalogoDTO>>(listaCatalogoDTO, estado);

    }

}
