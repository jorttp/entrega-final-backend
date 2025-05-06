package co.edu.co.lilfac.entity;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;

public class EmpleadoEntity extends UsuarioEntity {
	
	public EmpleadoEntity() {
		super();
	}
	
	public EmpleadoEntity(final int id, final String nombre, final String apellido, final int cedula, final int telefono, final String correo) {
		super(id, nombre, apellido, cedula, telefono, correo);
	}
	
	public static EmpleadoEntity obtenerValorDefecto() {
		return new EmpleadoEntity();
	}
	
	public static EmpleadoEntity obtenerValorDefecto(final EmpleadoEntity cliente ) {
		return UtilObjeto.getInstance().obtenerValorDefecto(cliente, new EmpleadoEntity());
	}
		
}
