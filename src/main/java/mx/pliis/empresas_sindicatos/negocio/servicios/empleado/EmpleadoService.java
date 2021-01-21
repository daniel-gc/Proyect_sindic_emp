package mx.pliis.empresas_sindicatos.negocio.servicios.empleado;

import mx.pliis.empresas_sindicatos.dto.EmpleadoDTO;

public interface EmpleadoService {
	
	EmpleadoDTO obtenerEmpleado(String numeroEmpleado);
	
	EmpleadoDTO obtenerEmpleadoPorCurpYIdEmpresa(String curp, Integer idEmpresa);

}
