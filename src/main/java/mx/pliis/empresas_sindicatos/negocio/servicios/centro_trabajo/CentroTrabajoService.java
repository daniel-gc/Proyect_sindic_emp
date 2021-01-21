package mx.pliis.empresas_sindicatos.negocio.servicios.centro_trabajo;

public interface CentroTrabajoService {
	public boolean existeCentroTrabajonById(Integer idDivision);

	public Integer getEmpresaByCentroTrabajo(Integer idCentroTrabajo);
}
