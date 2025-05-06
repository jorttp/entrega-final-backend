package co.edu.co.lilfac.entity;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilTexto;

public class ClienteEntity extends UsuarioEntity {
	private String direccionResidencia;
	private CiudadEntity ciudad;
	
	public ClienteEntity() {
		super();
		setDireccionResidencia(UtilTexto.getInstance().obtenerValorDefecto());
		setCiudad(CiudadEntity.obtenerValorDefecto());
	}
	
	public ClienteEntity(final int id, final String nombre, final String apellido, final int cedula, final int telefono, final String correo, final String direccion) {
		super(id, nombre, apellido, cedula, telefono, correo);
		setDireccionResidencia(direccion);
	}
	
	public static ClienteEntity obtenerValorDefecto() {
		return new ClienteEntity();
	}
	
	public static ClienteEntity obtenerValorDefecto(final ClienteEntity cliente ) {
		return UtilObjeto.getInstance().obtenerValorDefecto(cliente, new ClienteEntity());
	}

	public String getDireccionResidencia() {
		return direccionResidencia;
	}

	public void setDireccionResidencia(String direccionResidencia) {
		this.direccionResidencia = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(direccionResidencia);
	}

	public CiudadEntity getCiudad() {
		return ciudad;
	}

	public void setCiudad(CiudadEntity ciudad) {
		this.ciudad = CiudadEntity.obtenerValorDefecto(ciudad);
	}
		
}
