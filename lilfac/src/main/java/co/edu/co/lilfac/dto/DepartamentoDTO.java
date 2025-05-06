package co.edu.co.lilfac.dto;
import java.util.UUID;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilTexto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;

public final class DepartamentoDTO {
	
	private UUID id;
	private String nombre;
	private PaisDTO pais;
	
	public DepartamentoDTO() {
		setId(UtilUUID.obtenerValorDefecto());
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
		setPais(PaisDTO.obtenerValorDefecto());
	}
	
	public DepartamentoDTO(final UUID id) {
		setId(id);
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());	
		setPais(PaisDTO.obtenerValorDefecto());
	}
		
	public DepartamentoDTO(final UUID id, final String nombre, final PaisDTO pais) {
		setId(id);
		setNombre(nombre);	
		setPais(pais);
	}
	
	public static DepartamentoDTO obtenerValorDefecto() {
		return new DepartamentoDTO();
	}
	
	public static DepartamentoDTO obtenerValorDefecto(final DepartamentoDTO departamento ) {
		return UtilObjeto.getInstance().obtenerValorDefecto(departamento, new DepartamentoDTO());
	}

	public UUID getId() {
		return id;
	}

	public DepartamentoDTO setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		return this;
	}

	public String getNombre() {
		return nombre;
	}

	public DepartamentoDTO setNombre(final String nombre) {
		this.nombre = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombre);
		return this;
	}

	public PaisDTO getPais() {
		return pais;
	}

	public DepartamentoDTO setPais(final PaisDTO pais) {
		this.pais = PaisDTO.obtenerValorDefecto(pais);
		return this;
	}

	

}
