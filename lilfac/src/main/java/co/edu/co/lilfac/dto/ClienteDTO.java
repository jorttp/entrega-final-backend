package co.edu.co.lilfac.dto;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilTexto;

public class ClienteDTO extends UsuarioDTO {
	private String direccionResidencia;
	private CiudadDTO ciudad;
	
	public ClienteDTO() {
		super();
		setDireccionResidencia(UtilTexto.getInstance().obtenerValorDefecto());
		setCiudad(CiudadDTO.obtenerValorDefecto());
	}
	
	public ClienteDTO(final int id, final String nombre, final String apellido, final int cedula, final int telefono, final String correo, final String direccion) {
		super(id, nombre, apellido, cedula, telefono, correo);
		setDireccionResidencia(direccion);
		setCiudad(ciudad);
	}
	
	public static ClienteDTO obtenerValorDefecto() {
		return new ClienteDTO();
	}
	
	public static ClienteDTO obtenerValorDefecto(final ClienteDTO cliente ) {
		return UtilObjeto.getInstance().obtenerValorDefecto(cliente, new ClienteDTO());
	}

	public String getDireccionResidencia() {
		return direccionResidencia;
	}

	public void setDireccionResidencia(String direccionResidencia) {
		this.direccionResidencia = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(direccionResidencia);
	}

	public CiudadDTO getCiudad() {
		return ciudad;
	}

	public void setCiudad(CiudadDTO ciudad) {
		this.ciudad = CiudadDTO.obtenerValorDefecto(ciudad);
	}
		
}
