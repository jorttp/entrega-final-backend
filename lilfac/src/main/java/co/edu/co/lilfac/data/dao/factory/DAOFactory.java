package co.edu.co.lilfac.data.dao.factory;

import co.edu.co.lilfac.crosscutting.excepciones.DataLilfacException;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.data.dao.entity.categoria.CategoriaDAO;
import co.edu.co.lilfac.data.dao.entity.categoriaproducto.CategoriaProductoDAO;
import co.edu.co.lilfac.data.dao.entity.ciudad.CiudadDAO;
import co.edu.co.lilfac.data.dao.entity.cliente.ClienteDAO;
import co.edu.co.lilfac.data.dao.entity.costoadicional.CostoAdicionalDAO;
import co.edu.co.lilfac.data.dao.entity.departamento.DepartamentoDAO;
import co.edu.co.lilfac.data.dao.entity.empleado.EmpleadoDAO;
import co.edu.co.lilfac.data.dao.entity.empresa.EmpresaDAO;
import co.edu.co.lilfac.data.dao.entity.entrega.EntregaDAO;
import co.edu.co.lilfac.data.dao.entity.factura.FacturaDAO;
import co.edu.co.lilfac.data.dao.entity.historialcosto.HistorialCostoDAO;
import co.edu.co.lilfac.data.dao.entity.inventario.InventarioDAO;
import co.edu.co.lilfac.data.dao.entity.pais.PaisDAO;
import co.edu.co.lilfac.data.dao.entity.pedido.PedidoDAO;
import co.edu.co.lilfac.data.dao.entity.producto.ProductoDAO;
import co.edu.co.lilfac.data.dao.entity.productopedido.ProductoPedidoDAO;
import co.edu.co.lilfac.data.dao.entity.recepcion.RecepcionDAO;
import co.edu.co.lilfac.data.dao.factory.postgresql.PostgreSQLDAOFactory;

public abstract class DAOFactory {
	
	public static DAOFactory getFactory(Factory factory) throws LilfacException {
		
		switch (factory) {
		case POSTGRE_SQL: {
			return new PostgreSQLDAOFactory();
		}
		default:
			var mensajeUsuario="Se ha presentado un problema tratando de obtener la información de la fuente de datos contra la que se llevaran a cabo las operaciones";
			var mensajeTecnico="Se solicito la factoria"+factory+"pero no esta implementada";
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico);
		}
		
	}
			
	protected abstract void abrirConexion()throws LilfacException;
	public abstract void iniciarTransaccion()throws LilfacException;
	public abstract void confirmarTransaccion()throws LilfacException;
	public abstract void cancelarTransaccion()throws LilfacException;
	public abstract void cerrarConexion()throws LilfacException;
	
	public abstract CategoriaDAO getCategoriaDAO()throws LilfacException;
	public abstract CategoriaProductoDAO getCategoriaProductoDAO()throws LilfacException;
	public abstract CiudadDAO getCiudadDAO()throws LilfacException;
	public abstract ClienteDAO getClienteDAO()throws LilfacException;
	public abstract CostoAdicionalDAO getCostoAdicionalDAO()throws LilfacException;
	public abstract DepartamentoDAO getDepartamentoDAO()throws LilfacException;
	public abstract EmpleadoDAO getEmpleadoDAO()throws LilfacException;
	public abstract EmpresaDAO getEmpresaDAO()throws LilfacException;
	public abstract EntregaDAO getEntregaDAO()throws LilfacException;
	public abstract FacturaDAO getFacturaDAO()throws LilfacException;
	public abstract HistorialCostoDAO getHistorialCostoDAO()throws LilfacException;
	public abstract InventarioDAO getInventarioDAO()throws LilfacException;
	public abstract PaisDAO getPaisDAO()throws LilfacException;
	public abstract PedidoDAO getPedidoDAO()throws LilfacException;
	public abstract ProductoDAO getProductoDAO()throws LilfacException;
	public abstract ProductoPedidoDAO getProductoPedidoDAO()throws LilfacException;
	public abstract RecepcionDAO getRecepcionDAO()throws LilfacException;

}
