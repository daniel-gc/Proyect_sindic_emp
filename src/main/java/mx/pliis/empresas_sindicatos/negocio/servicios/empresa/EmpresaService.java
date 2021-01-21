package mx.pliis.empresas_sindicatos.negocio.servicios.empresa;

import java.util.List;

import mx.pliis.empresas_sindicatos.dto.CentroTrabajoDTO;
import mx.pliis.empresas_sindicatos.dto.EmpleadoDTO;
import mx.pliis.empresas_sindicatos.dto.EmpresaDTO;
import mx.pliis.empresas_sindicatos.dto.LogImportacionDTO;

public interface EmpresaService {
	public List<EmpresaDTO> getAllEmpresas();

	public boolean existeEmpresaById(Integer idEmpresa);

	public EmpleadoDTO getEmpleadoPorEmpresaNumeroEmpleado(Integer idEmpresa, String contrato);

	public List<CentroTrabajoDTO> getCentrosTrabajo(Integer idEmpresa);

	public List<String> getEmailsDelegados(Integer idCentroTrabajo);

	public void importaDatos();

	public List<LogImportacionDTO> getResultadosImportacion();

}
