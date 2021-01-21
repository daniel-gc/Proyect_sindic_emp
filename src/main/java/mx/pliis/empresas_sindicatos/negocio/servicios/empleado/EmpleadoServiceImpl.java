package mx.pliis.empresas_sindicatos.negocio.servicios.empleado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.pliis.empresas_sindicatos.dto.EmpleadoDTO;
import mx.pliis.empresas_sindicatos.negocio.utils.EmpleadoEntityUtil;
import mx.pliis.empresas_sindicatos.persistencia.hibernate.repository.EmpleadoEntityRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{

	@Autowired
	private EmpleadoEntityRepository empleadoRepository;
	@Autowired
	private EmpleadoEntityUtil empleadoEntityUtil;
	
	@Override
	@Transactional(readOnly = true)
	public EmpleadoDTO obtenerEmpleado(String numeroEmpleado) {
		
		var empleadoOptional = empleadoRepository.getEmpleadoPorNumeroEmpleado(numeroEmpleado);
		
		if(empleadoOptional.isPresent()) {
			var empleadoEntity = empleadoOptional.get();
			EmpleadoDTO emp = new EmpleadoDTO();
			empleadoEntityUtil.copyFromEntityToDTO(empleadoEntity,emp);
			return emp;	
		}
		
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public EmpleadoDTO obtenerEmpleadoPorCurpYIdEmpresa(String curp, Integer idEmpresa) {
		
		var empleadoOptional = empleadoRepository.obtenerEmpleadoPorCurpYIdEmpresa(curp,idEmpresa);
		
		if(empleadoOptional.isPresent()) {
			var empleadoEntity = empleadoOptional.get();
			EmpleadoDTO emp = new EmpleadoDTO();
			empleadoEntityUtil.copyFromEntityToDTO(empleadoEntity,emp);
			return emp;	
		}
		
		return null;
	}
	
	

}
