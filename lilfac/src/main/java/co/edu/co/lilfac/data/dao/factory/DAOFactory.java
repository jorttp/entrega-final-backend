package co.edu.co.lilfac.data.dao.factory;

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
	
	public static DAOFactory getFactory(Factory factory) {
		
		switch (factory) {
		case POSTGRE_SQL: {
			return new PostgreSQLDAOFactory();
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + factory);
		}
		
	}
			
	protected abstract void abrirConexion();
	public abstract void iniciarTransaccion();
	public abstract void confirmarTransaccion();
	public abstract void cancelarTransaccion();
	public abstract void cerrarConexion();
	
	public abstract CategoriaDAO getCategoriaDAO();
	public abstract CategoriaProductoDAO getCategoriaProductoDAO();
	public abstract CiudadDAO getCiudadDAO();
	public abstract ClienteDAO getClienteDAO();
	public abstract CostoAdicionalDAO getCostoAdicionalDAO();
	public abstract DepartamentoDAO getDepartamentoDAO();
	public abstract EmpleadoDAO getEmpleadoDAO();
	public abstract EmpresaDAO getEmpresaDAO();
	public abstract EntregaDAO getEntregaDAO();
	public abstract FacturaDAO getFacturaDAO();
	public abstract HistorialCostoDAO getHistorialCostoDAO();
	public abstract InventarioDAO getInventarioDAO();
	public abstract PaisDAO getPaisDAO();
	public abstract PedidoDAO getPedidoDAO();
	public abstract ProductoDAO getProductoDAO();
	public abstract ProductoPedidoDAO getProductoPedidoDAO();
	public abstract RecepcionDAO getRecepcionDAO();

}
