package co.edu.co.lilfac.businesslogic.businesslogic.impl;

import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.businesslogic.businesslogic.CategoriaProductoBusinessLogic;
import co.edu.co.lilfac.businesslogic.businesslogic.assembler.categoriaproducto.entity.CategoriaProductoEntityAssembler;
import co.edu.co.lilfac.businesslogic.businesslogic.domain.CategoriaProductoDomain;
import co.edu.co.lilfac.crosscutting.excepciones.BusinessLogicLilfacException;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilTexto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;
import co.edu.co.lilfac.entity.CategoriaEntity;
import co.edu.co.lilfac.entity.CategoriaProductoEntity;
import co.edu.co.lilfac.entity.ProductoEntity;

public class CategoriaProductoBusinessLogicImpl implements CategoriaProductoBusinessLogic {

	private DAOFactory factory;
	
	public CategoriaProductoBusinessLogicImpl(DAOFactory factory) {
		this.factory = factory;
	}
	
	private void validarIntegridadInformacionCategoriaProducto(CategoriaProductoDomain categoriaProducto) throws LilfacException{
		validarIntegridadNombreProducto(categoriaProducto.getProducto().getNombre());
		validarIntegridadNombreCategoria(categoriaProducto.getCategoria().getNombre());
		validarProductoExistente(categoriaProducto.getProducto().getId());
		validarCategoriaExistente(categoriaProducto.getCategoria().getId());
	}
	
	private void validarIntegridadNombreProducto(String nombreProducto) throws LilfacException {
		if (UtilTexto.getInstance().esNula(nombreProducto)) {
			throw BusinessLogicLilfacException.reportar("El nombre del producto no puede ser un valor nulo");
		}
		if (UtilTexto.getInstance().estaVacia(nombreProducto)) {
			throw BusinessLogicLilfacException.reportar("el nombre de el producto es un campo obligatorio");
		}
		if (UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombreProducto).length() > 100) {
			throw BusinessLogicLilfacException.reportar("el nombre de el producto supera los 100 caracteres");
		}
		if (!UtilTexto.getInstance().ContieneSoloLetrasEspacios(nombreProducto)) {
			throw BusinessLogicLilfacException.reportar("el nombre de el producto solo puede contener letras y espacios");
		}
	}
	
	private void validarIntegridadNombreCategoria(String nombreCategoria) throws LilfacException {
		if (UtilTexto.getInstance().esNula(nombreCategoria)) {
			throw BusinessLogicLilfacException.reportar("El nombre de la categoria no puede ser un valor nulo");
		}
		if (UtilTexto.getInstance().estaVacia(nombreCategoria)) {
			throw BusinessLogicLilfacException.reportar("el nombre de la categoria es un campo obligatorio");
		}
		if (UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombreCategoria).length() > 100) {
			throw BusinessLogicLilfacException.reportar("el nombre de la categoria supera los 100 caracteres");
		}
		if (!UtilTexto.getInstance().ContieneSoloLetrasEspacios(nombreCategoria)) {
			throw BusinessLogicLilfacException.reportar("el nombre de la categoria solo puede contener letras y espacios");
		}
	}
	
	private void validarProductoExistente(UUID id) throws LilfacException {
		var filtro = new ProductoEntity();
		filtro.setId(id);
		var listaResultados = factory.getProductoDAO().listByFIlter(filtro);
		if (listaResultados.isEmpty()) {
			throw BusinessLogicLilfacException.reportar("producto no existente");
		}
	}
	
	private void validarCategoriaExistente(UUID id) throws LilfacException {
		var filtro = new CategoriaEntity();
		filtro.setId(id);
		var listaResultados = factory.getCategoriaDAO().listByFIlter(filtro);
		if (listaResultados.isEmpty()) {
			throw BusinessLogicLilfacException.reportar("categoria no existente");
		}
	}
	
	private UUID generarIdentificadorNuevoCategoriaProducto() throws LilfacException {
		
		UUID nuevoId;
		var existeId = false;
		
		do {
			nuevoId = UtilUUID.generarNuevoUUID();
			var categoriaProducto = factory.getCategoriaProductoDAO().listById(nuevoId);
			existeId = !UtilUUID.esValorDefecto(categoriaProducto.getId());
		} while (existeId);
		
		return nuevoId;
	}
	
	@Override
	public void registrarNuevaCategoriaProducto(CategoriaProductoDomain categoriaProducto) throws LilfacException {
		validarIntegridadInformacionCategoriaProducto(categoriaProducto);
		var id = generarIdentificadorNuevoCategoriaProducto();
		var categoriaProductoDomainACrear = new CategoriaProductoDomain(id, categoriaProducto.getProducto(), categoriaProducto.getCategoria());
		var categoriaProdcutoEntity = CategoriaProductoEntityAssembler.getInstance().toEntity(categoriaProductoDomainACrear);
		factory.getCategoriaProductoDAO().create(categoriaProdcutoEntity);
	}

	@Override
	public void modificarCategoriaProductoExistente(UUID id, CategoriaProductoDomain categoriaProducto) throws LilfacException {
		var categoriaProdcutoEntity = CategoriaProductoEntityAssembler.getInstance().toEntity(categoriaProducto);
		factory.getCategoriaProductoDAO().update(id, categoriaProdcutoEntity);
	}

	@Override
	public void darBajaDefinitivamenteCategoriaProductoExistente(UUID id) throws LilfacException {
		factory.getCategoriaProductoDAO().delete(id);
	}

	@Override
	public CategoriaProductoDomain consultarCategoriaProductoPorId(UUID id) throws LilfacException {
		var categoriaProductoEntity = factory.getCategoriaProductoDAO().listById(id);
		return CategoriaProductoEntityAssembler.getInstance().toDomain(categoriaProductoEntity);
	}

	@Override
	public List<CategoriaProductoDomain> consultarCategoriasProducto(CategoriaProductoDomain filtro) throws LilfacException {
		
		var categoriaProductoFilter = CategoriaProductoEntityAssembler.getInstance().toEntity(filtro);
		List<CategoriaProductoEntity> categoriaProductoEntities = factory.getCategoriaProductoDAO().listByFIlter(categoriaProductoFilter);
		return CategoriaProductoEntityAssembler.getInstance().toDomain(categoriaProductoEntities);
	}

}
