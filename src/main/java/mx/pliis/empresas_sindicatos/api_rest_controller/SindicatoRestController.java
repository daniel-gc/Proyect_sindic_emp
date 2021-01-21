package mx.pliis.empresas_sindicatos.api_rest_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import mx.pliis.empresas_sindicatos.dto.Mensaje;
import mx.pliis.empresas_sindicatos.negocio.servicios.sindicato.SindicatoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/sindicatos")
public class SindicatoRestController {
	@Autowired
	private SindicatoService sindicatoService;

	@GetMapping(value = "/existe", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> existsSindicatoById(@RequestParam("idSindicato") Integer idSindicato) {
		HttpStatus estado = HttpStatus.OK;
		Boolean existe = false;

		try {
			existe = sindicatoService.existSindicatoById(idSindicato);

		} catch (Exception e) {
			estado = HttpStatus.CONFLICT;
			String msg = "Ocurrió un error: " + e.getLocalizedMessage();
			return new ResponseEntity<Mensaje>(new Mensaje(msg), estado);
		}

		return new ResponseEntity<Boolean>(existe, estado);

	}

}
