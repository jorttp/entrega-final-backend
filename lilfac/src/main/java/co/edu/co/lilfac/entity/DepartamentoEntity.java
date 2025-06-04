package co.edu.co.lilfac.entity;
import java.util.UUID;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilTexto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;

public final class DepartamentoEntity {
	
	private UUID id;
	private String nombre;
	private PaisEntity pais;
	private boolean objetoVacio;
	
	public DepartamentoEntity() {
		setId(UtilUUID.obtenerValorDefecto());
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
		setPais(PaisEntity.obtenerValorDefecto());
	}
	
	public DepartamentoEntity(final UUID id) {
		setId(id);
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());	
		setPais(PaisEntity.obtenerValorDefecto());
	}
		
	public DepartamentoEntity(final UUID id, final String nombre, final PaisEntity pais) {
		setId(id);
		setNombre(nombre);	
		setPais(pais);
	}
	
	public static DepartamentoEntity obtenerValorDefecto() {
		return new DepartamentoEntity();
	}
	
	public static DepartamentoEntity obtenerValorDefecto(final DepartamentoEntity departamento ) {
		return UtilObjeto.getInstance().obtenerValorDefecto(departamento, obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombre);
	}

	public PaisEntity getPais() {
		return pais;
	}

	public void setPais(final PaisEntity pais) {
		this.pais = PaisEntity.obtenerValorDefecto(pais);
	}
	public boolean isObjetoVacio() {
		return objetoVacio;
	}
	

}
