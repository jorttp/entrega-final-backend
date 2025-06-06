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
		validarProductoExistente(categoriaProducto.getProducto().getId());
		validarCategoriaExistente(categoriaProducto.getCategoria().getId());
	}
	
	private void validarProductoExistente(UUID idProducto) throws LilfacException {
		if (UtilUUID.esValorDefecto(idProducto)) {
			throw BusinessLogicLilfacException.reportar("ID no valido");
		}
		
		var producto = factory.getProductoDAO().listById(idProducto);
		if(UtilUUID.esValorDefecto(producto.getId())) {
			throw BusinessLogicLilfacException.reportar("el producto no existe");
		}
	}
	
	private void validarCategoriaExistente(UUID idCategoria) throws LilfacException {
		if (UtilUUID.esValorDefecto(idCategoria)) {
			throw BusinessLogicLilfacException.reportar("ID no valido");
		}
		
		var categoria = factory.getCategoriaDAO().listById(idCategoria);
		if(UtilUUID.esValorDefecto(categoria.getId())) {
			throw BusinessLogicLilfacException.reportar("la categoria no existe");
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
