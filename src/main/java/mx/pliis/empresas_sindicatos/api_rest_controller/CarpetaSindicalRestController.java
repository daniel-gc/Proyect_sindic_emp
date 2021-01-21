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
import mx.pliis.empresas_sindicatos.negocio.servicios.carpeta.CarpetaSindicalService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/carpeta_sindical")
public class CarpetaSindicalRestController {
	@Autowired
	private CarpetaSindicalService carpetaSindicalService;


	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<List<CarpetaSindicalDTO>> existsEmpresaById(
			@RequestParam("arqIdUsuario") Integer arqIdUsuario) {
		HttpStatus estado = HttpStatus.OK;
		HttpHeaders responseHeaders = new HttpHeaders();
		List<CarpetaSindicalDTO> listaRet = new ArrayList<>();

		try {
			listaRet = carpetaSindicalService.getCarpetaSindical(arqIdUsuario);
		} catch (Exception e) {
			listaRet = new ArrayList<>();
			estado = HttpStatus.INTERNAL_SERVER_ERROR;
			String msg = "Ocurrió un error: " + e.getLocalizedMessage();
			responseHeaders.set("Mensaje", msg);
			return new ResponseEntity<List<CarpetaSindicalDTO>>(listaRet, responseHeaders, estado);
		}

		return new ResponseEntity<List<CarpetaSindicalDTO>>(listaRet, estado);

	}

}
