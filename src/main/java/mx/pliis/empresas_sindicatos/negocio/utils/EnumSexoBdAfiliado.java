package mx.pliis.empresas_sindicatos.negocio.utils;

public enum EnumSexoBdAfiliado {
	MASCULINO(1,"Masculino"),
	FEMENINO(2,"Femenino"),
	OTRO(3,"Otro"),
	PREFIERO_NO_DECIR(4,"Prefiero no decir");
	
	private Integer idSexo;
	private String nombre;
	
	EnumSexoBdAfiliado(Integer idSexo,String nombre){
		this.idSexo = idSexo;
		this.nombre = nombre;
	}
	
	public Integer getIdSexo() {
		return idSexo;
	}
	public String getNombre() {
		return nombre;
	}

}
