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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;
import mx.pliis.empresas_sindicatos.dto.CentroTrabajoDTO;
import mx.pliis.empresas_sindicatos.dto.EmpleadoDTO;
import mx.pliis.empresas_sindicatos.dto.EmpresaDTO;
import mx.pliis.empresas_sindicatos.dto.LogImportacionDTO;
import mx.pliis.empresas_sindicatos.dto.Mensaje;
import mx.pliis.empresas_sindicatos.negocio.servicios.centro_trabajo.CentroTrabajoService;
import mx.pliis.empresas_sindicatos.negocio.servicios.empleado.EmpleadoService;
import mx.pliis.empresas_sindicatos.negocio.servicios.empresa.EmpresaService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/empresas")
@Log4j2
public class EmpresaRestController {
	@Autowired
	private EmpresaService empresaService;
	@Autowired
	private CentroTrabajoService centroTrabajoService;
	@Autowired
	private EmpleadoService empleadoService;

	@GetMapping(value = "/catalogo", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<List<EmpresaDTO>> getAllEmpresas(@RequestHeader HttpHeaders headers) {
		HttpStatus estado = HttpStatus.OK;
		List<EmpresaDTO> listaEmpresaVO = empresaService.getAllEmpresas();

		ResponseEntity<List<EmpresaDTO>> retorno = new ResponseEntity<>(listaEmpresaVO, estado);

		return retorno;

	}

	@GetMapping(value = "/existe", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> existsEmpresaById(@RequestParam("idEmpresa") Integer idEmpresa) {
		HttpStatus estado = HttpStatus.OK;
		Boolean existe = false;

		try {
			existe = empresaService.existeEmpresaById(idEmpresa);

		} catch (Exception e) {
			estado = HttpStatus.CONFLICT;
			log.error("Excepcion: %s", e.getLocalizedMessage());
			return new ResponseEntity<>(new Mensaje(e.getLocalizedMessage()), estado);
		}

		return new ResponseEntity<>(existe, estado);

	}

	@GetMapping(value = "/empleado", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> existeEmpleado(@RequestParam("idEmpresa") Integer idEmpresa,
			@RequestParam("numeroEmpleado") String numeroEmpleado) {
		HttpStatus estado = HttpStatus.OK;
		EmpleadoDTO empleado = null;

		try {
			empleado = empresaService.getEmpleadoPorEmpresaNumeroEmpleado(idEmpresa, numeroEmpleado);
			if (empleado != null)
				return new ResponseEntity<>(empleado, estado);

		} catch (Exception e) {
			estado = HttpStatus.CONFLICT;
			log.error("Excepcion: %s", e.getLocalizedMessage());
			String msg = "Ocurrió un error: " + e.getLocalizedMessage();
			return new ResponseEntity<>(new Mensaje(msg), estado);
		}

		return null;

	}

	@GetMapping(value = "/centro_trabajo/existe", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> existeCentroTrabajoById(
			@RequestParam("idCentroTrabajo") Integer idCentroTrabajo) {
		HttpStatus estado = HttpStatus.OK;
		Boolean existe = false;

		try {
			existe = centroTrabajoService.existeCentroTrabajonById(idCentroTrabajo);

		} catch (Exception e) {
			estado = HttpStatus.CONFLICT;
			String msg = "Ocurrió un error: " + e.getLocalizedMessage();
			log.error("Excepcion: %s", e.getLocalizedMessage());
			return new ResponseEntity<>(new Mensaje(msg), estado);
		}

		return new ResponseEntity<>(existe, estado);

	}

	@GetMapping(value = "/centrosTrabajo", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> getCentrosTrabajoByIdEMpresa(@RequestParam("idEmpresa") Integer idEmpresa) {
		HttpStatus estado = HttpStatus.OK;
		List<CentroTrabajoDTO> listaCentrosTrabajoDTO = new ArrayList<>();

		try {
			listaCentrosTrabajoDTO = empresaService.getCentrosTrabajo(idEmpresa);

		} catch (Exception e) {
			estado = HttpStatus.CONFLICT;
			String msg = "Ocurrió un error: " + e.getLocalizedMessage();
			log.error("Excepcion: %s", e.getLocalizedMessage());
			return new ResponseEntity<>(new Mensaje(msg), estado);
		}

		return new ResponseEntity<>(listaCentrosTrabajoDTO, estado);

	}

	@GetMapping(value = "/emailsDelegados", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<List<String>> getEmailsDelegados(
			@RequestParam("idCentroTrabajo") Integer idCentroTrabajo) {
		HttpStatus estado = HttpStatus.OK;

		List<String> listaEmails = new ArrayList<>();

		try {
			listaEmails = empresaService.getEmailsDelegados(idCentroTrabajo);

		} catch (Exception e) {
			HttpHeaders responseHeaders = new HttpHeaders();
			listaEmails = new ArrayList<>();
			estado = HttpStatus.INTERNAL_SERVER_ERROR;
			responseHeaders.set("Mensaje", "Ocurrió un error: " + e.getLocalizedMessage());
			log.error("Excepcion: %s", e.getLocalizedMessage());
			return new ResponseEntity<>(listaEmails, responseHeaders, estado);
		}

		return new ResponseEntity<>(listaEmails, estado);

	}

	@GetMapping(value = "/empresaByCentroTrabajo", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> getEmpresaByIdCentroTrabajo(
			@RequestParam("idCentroTrabajo") Integer idCentroTrabajo) {
		HttpStatus estado = HttpStatus.OK;
		Integer idEmpresa = Integer.MIN_VALUE;

		try {
			idEmpresa = centroTrabajoService.getEmpresaByCentroTrabajo(idCentroTrabajo);

		} catch (Exception e) {
			HttpHeaders responseHeaders = new HttpHeaders();
			estado = HttpStatus.INTERNAL_SERVER_ERROR;
			responseHeaders.set("Mensaje", "Ocurrió un error: " + e.getLocalizedMessage());
			log.error("Excepcion: %s", e.getLocalizedMessage());
			return new ResponseEntity<>(Integer.MIN_VALUE, responseHeaders, estado);
		}

		return new ResponseEntity<>(idEmpresa, estado);
	}

	@GetMapping(value = "/importaDatos", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<List<LogImportacionDTO>> importaDatos() {
		HttpStatus estado = HttpStatus.OK;

		try {
			this.empresaService.importaDatos();
			List<LogImportacionDTO> dtoList = this.empresaService.getResultadosImportacion();
			return new ResponseEntity<>(dtoList, HttpStatus.OK);
		} catch (Exception e) {
			HttpHeaders responseHeaders = new HttpHeaders();
			estado = HttpStatus.INTERNAL_SERVER_ERROR;
			responseHeaders.set("Mensaje", "Ocurrió un error: " + e.getLocalizedMessage());
			log.error("Excepcion: %s", e.getLocalizedMessage());
			return new ResponseEntity<>(new ArrayList<>(), responseHeaders, estado);
		}

	}
	
	@GetMapping(value = "/empleadoPorNumero", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> getEmpleado(@RequestParam("numeroEmpleado") String numeroEmpleado) {
		
		EmpleadoDTO emp = empleadoService.obtenerEmpleado(numeroEmpleado);

		if(emp != null)
			return new ResponseEntity<>(emp, HttpStatus.OK);
		
		return new ResponseEntity<>(new Mensaje("No se encontro el empleado por el número proporcionado"), HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value = "/empleadoPorCurpYidEmpresa", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> getEmpleadoPorCurpAndIdEmpresa(@RequestParam("curp") String curp, @RequestParam("idEmpresa") Integer idEmpresa) {
		
		EmpleadoDTO emp = empleadoService.obtenerEmpleadoPorCurpYIdEmpresa(curp,idEmpresa);

		if(emp != null)
			return new ResponseEntity<>(emp, HttpStatus.OK);
		
		return new ResponseEntity<>(new Mensaje("No se encontro el empleado con la curp y empresa proporcionado"), HttpStatus.NOT_FOUND);
	}
	
	

}
