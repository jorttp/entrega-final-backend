package co.edu.co.lilfac.data.dao.factory.postgresql;

import java.sql.Connection;

import co.edu.co.lilfac.data.dao.entity.categoria.CategoriaDAO;
import co.edu.co.lilfac.data.dao.entity.categoria.impl.postgresql.CategoriaPostgreSQLDAO;
import co.edu.co.lilfac.data.dao.entity.categoriaproducto.CategoriaProductoDAO;
import co.edu.co.lilfac.data.dao.entity.categoriaproducto.impl.postgresql.CategoriaProductoPostgreSQLDAO;
import co.edu.co.lilfac.data.dao.entity.ciudad.CiudadDAO;
import co.edu.co.lilfac.data.dao.entity.ciudad.impl.postgresql.CiudadPostgreSQLDAO;
import co.edu.co.lilfac.data.dao.entity.cliente.ClienteDAO;
import co.edu.co.lilfac.data.dao.entity.cliente.impl.postgresql.ClientePostgreSQLDAO;
import co.edu.co.lilfac.data.dao.entity.costoadicional.CostoAdicionalDAO;
import co.edu.co.lilfac.data.dao.entity.costoadicional.impl.postgresql.CostoAdicionalPostgreSQLDAO;
import co.edu.co.lilfac.data.dao.entity.departamento.DepartamentoDAO;
import co.edu.co.lilfac.data.dao.entity.departamento.impl.postgresql.DepartamentoPostgreSQLDAO;
import co.edu.co.lilfac.data.dao.entity.empleado.EmpleadoDAO;
import co.edu.co.lilfac.data.dao.entity.empleado.impl.postgresql.EmpleadoPostgreSQLDAO;
import co.edu.co.lilfac.data.dao.entity.empresa.EmpresaDAO;
import co.edu.co.lilfac.data.dao.entity.empresa.impl.postgresql.EmpresaPostgreSQLDAO;
import co.edu.co.lilfac.data.dao.entity.entrega.EntregaDAO;
import co.edu.co.lilfac.data.dao.entity.entrega.impl.postgresql.EntregaPostgreSQLDAO;
import co.edu.co.lilfac.data.dao.entity.factura.FacturaDAO;
import co.edu.co.lilfac.data.dao.entity.factura.impl.postgresql.FacturaPostgreSQLDAO;
import co.edu.co.lilfac.data.dao.entity.historialcosto.HistorialCostoDAO;
import co.edu.co.lilfac.data.dao.entity.historialcosto.impl.postgresql.HistorialCostoPostgreSQLDAO;
import co.edu.co.lilfac.data.dao.entity.inventario.InventarioDAO;
import co.edu.co.lilfac.data.dao.entity.inventario.impl.postgresql.InventarioPostgreSQLDAO;
import co.edu.co.lilfac.data.dao.entity.pais.PaisDAO;
import co.edu.co.lilfac.data.dao.entity.pais.impl.postgresql.PaisPostgreSQLDAO;
import co.edu.co.lilfac.data.dao.entity.pedido.PedidoDAO;
import co.edu.co.lilfac.data.dao.entity.pedido.impl.postgresql.PedidoPostgreSQLDAO;
import co.edu.co.lilfac.data.dao.entity.producto.ProductoDAO;
import co.edu.co.lilfac.data.dao.entity.producto.impl.postgresql.ProductoPostgreSQLDAO;
import co.edu.co.lilfac.data.dao.entity.productopedido.ProductoPedidoDAO;
import co.edu.co.lilfac.data.dao.entity.productopedido.impl.postgresql.ProductoPedidoPostgreSQLDAO;
import co.edu.co.lilfac.data.dao.entity.recepcion.RecepcionDAO;
import co.edu.co.lilfac.data.dao.entity.recepcion.impl.postgresql.RecepcionPostgreSQLDAO;
import co.edu.co.lilfac.data.dao.factory.DAOFactory;

public class PostgreSQLDAOFactory extends DAOFactory{
	
	private Connection conexion;
	
	public PostgreSQLDAOFactory () {
		abrirConexion();
	}

	@Override
	protected void abrirConexion() {
		conexion=null;
		
	}

	@Override
	public void iniciarTransaccion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void confirmarTransaccion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelarTransaccion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cerrarConexion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CategoriaDAO getCategoriaDAO() {
		return new CategoriaPostgreSQLDAO(conexion);
	}

	@Override
	public CategoriaProductoDAO getCategoriaProductoDAO() {
		return new CategoriaProductoPostgreSQLDAO(conexion);
	}

	@Override
	public CiudadDAO getCiudadDAO() {
		return new CiudadPostgreSQLDAO(conexion);
	}

	@Override
	public ClienteDAO getClienteDAO() {
		return new ClientePostgreSQLDAO(conexion);
	}

	@Override
	public CostoAdicionalDAO getCostoAdicionalDAO() {
		return new CostoAdicionalPostgreSQLDAO(conexion);
	}

	@Override
	public DepartamentoDAO getDepartamentoDAO() {
		return new DepartamentoPostgreSQLDAO(conexion);
	}

	@Override
	public EmpleadoDAO getEmpleadoDAO() {
		return new EmpleadoPostgreSQLDAO(conexion);
	}

	@Override
	public EmpresaDAO getEmpresaDAO() {
		return new EmpresaPostgreSQLDAO(conexion);
	}

	@Override
	public EntregaDAO getEntregaDAO() {
		return new EntregaPostgreSQLDAO(conexion);
	}

	@Override
	public FacturaDAO getFacturaDAO() {
		return new FacturaPostgreSQLDAO(conexion);
	}

	@Override
	public HistorialCostoDAO getHistorialCostoDAO() {
		return new HistorialCostoPostgreSQLDAO(conexion);
	}

	@Override
	public InventarioDAO getInventarioDAO() {
		return new InventarioPostgreSQLDAO(conexion);
	}

	@Override
	public PaisDAO getPaisDAO() {
		return new PaisPostgreSQLDAO(conexion);
	}

	@Override
	public PedidoDAO getPedidoDAO() {
		return new PedidoPostgreSQLDAO(conexion);
	}

	@Override
	public ProductoDAO getProductoDAO() {
		return new ProductoPostgreSQLDAO(conexion);
	}

	@Override
	public ProductoPedidoDAO getProductoPedidoDAO() {
		return new ProductoPedidoPostgreSQLDAO(conexion);
	}

	@Override
	public RecepcionDAO getRecepcionDAO() {
		return new RecepcionPostgreSQLDAO(conexion);
	}

}
