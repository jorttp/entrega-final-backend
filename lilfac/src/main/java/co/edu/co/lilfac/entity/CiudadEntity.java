package co.edu.co.lilfac.entity;
import java.util.UUID;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilTexto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;

public final class CiudadEntity {
	
	private UUID id;
	private String nombre;
	private DepartamentoEntity departamento;
	private boolean objetoVacio;
	
	public CiudadEntity() {
		setId(UtilUUID.obtenerValorDefecto());
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());
		setDepartamento(DepartamentoEntity.obtenerValorDefecto());
	}
	
	public CiudadEntity(final UUID id) {
		setId(id);
		setNombre(UtilTexto.getInstance().obtenerValorDefecto());	
		setDepartamento(DepartamentoEntity.obtenerValorDefecto());
	}
		
	public CiudadEntity(final UUID id, final String nombre, final DepartamentoEntity departamento) {
		setId(id);
		setNombre(nombre);	
		setDepartamento(departamento);
	}
	
	public static CiudadEntity obtenerValorDefecto() {
		return new CiudadEntity();
	}
	
	public static CiudadEntity obtenerValorDefecto(final CiudadEntity ciudad ) {
		return UtilObjeto.getInstance().obtenerValorDefecto(ciudad, obtenerValorDefecto());
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

	public DepartamentoEntity getDepartamento() {
		return departamento;
	}

	public void setDepartamento(final DepartamentoEntity departamento) {
		this.departamento = DepartamentoEntity.obtenerValorDefecto(departamento);
	}
	public boolean isObjetoVacio() {
		return objetoVacio;
	}

}
