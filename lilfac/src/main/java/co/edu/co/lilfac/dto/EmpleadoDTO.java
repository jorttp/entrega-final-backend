package co.edu.co.lilfac.dto;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;

public class EmpleadoDTO extends UsuarioDTO {
	
	public EmpleadoDTO() {
		super();
	}
	
	public EmpleadoDTO(final int id, final String nombre, final String apellido, final int cedula, final int telefono, final String correo) {
		super(id, nombre, apellido, cedula, telefono, correo);
	}
	
	public static EmpleadoDTO obtenerValorDefecto() {
		return new EmpleadoDTO();
	}
	
	public static EmpleadoDTO obtenerValorDefecto(final EmpleadoDTO cliente ) {
		return UtilObjeto.getInstance().obtenerValorDefecto(cliente, new EmpleadoDTO());
	}
		
}
