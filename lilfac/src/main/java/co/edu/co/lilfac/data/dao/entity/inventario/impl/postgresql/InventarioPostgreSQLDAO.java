package co.edu.co.lilfac.data.dao.entity.inventario.impl.postgresql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.crosscutting.excepciones.DataLilfacException;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;
import co.edu.co.lilfac.data.dao.entity.inventario.InventarioDAO;
import co.edu.co.lilfac.entity.EmpresaEntity;
import co.edu.co.lilfac.entity.HistorialCostoEntity;
import co.edu.co.lilfac.entity.InventarioEntity;
import co.edu.co.lilfac.entity.ProductoEntity;

public class InventarioPostgreSQLDAO implements InventarioDAO{
	
	private Connection conexion;
	
	public InventarioPostgreSQLDAO(Connection conexion) {
		this.conexion=conexion;
	}


	@Override
	public void create(InventarioEntity entity) throws LilfacException {
		var sentenciaSQL = new StringBuilder();
		
		sentenciaSQL.append("INSERT INTO Inventario (id, totalUnidades, unidadesAlquiladas, unidadesAfectadas, UnidadesDisponibles, empresa, producto, histotialCosto) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
		
		try(var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())){
			
			sentenciaPreparada.setObject(1, entity.getId());
			sentenciaPreparada.setInt(2, entity.getTotalUnidades());
			sentenciaPreparada.setInt(3, entity.getUnidadesAlquiladas());
			sentenciaPreparada.setInt(4, entity.getUnidadesAfectadas());
			sentenciaPreparada.setInt(5,  entity.getUnidadesDisponibles());
			sentenciaPreparada.setObject(6,  entity.getEmpresa().getId());
			sentenciaPreparada.setObject(7,  entity.getProducto().getId());
			sentenciaPreparada.setObject(8,  entity.getHistorialCosto().getId());
			sentenciaPreparada.executeUpdate();
			
		} catch (SQLException exception) {
			var mensajeUsuario="Se ha presentado un problema tratando de registrar la información de un nuevo inventario";
			var mensajeTecnico="Se presentó una excepción de tipo SQLexception tratando de hacer un INSERT en la tabla Inventario,  para tener más detalles revise el log de errores";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de registrar la información de un nuevo inventario";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un INSERT en la tabla Inventario";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}	
	}

	@Override
	public List<InventarioEntity> listByFIlter(InventarioEntity filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InventarioEntity> listAll() throws LilfacException {
	    List<InventarioEntity> listaInventario = new ArrayList<>();
	    var sentenciaSQL = new StringBuilder();

	    sentenciaSQL.append("SELECT I.id, I.totalUnidades, I.unidadesAlquiladas, I.unidadesAfectadas, I.UnidadesDisponibles, E.nombre AS nombre_empresa, P.nombre AS nombre_producto, H.costo AS costo FROM Inventario I JOIN Empresa E ON I.empresa = E.id JOIN Producto P ON I.producto = P.id JOIN HistorialCosto H ON I.historialCosto = H.id");

	    try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString());
	         var resultados = sentenciaPreparada.executeQuery()) {

	        while (resultados.next()) {
	            var inventario = new InventarioEntity();
	            inventario.setId(UtilUUID.convertirAUUID(resultados.getString("id")));
	            inventario.setTotalUnidades(resultados.getInt("totalUnidades"));
	            inventario.setUnidadesAlquiladas(resultados.getInt("unidadesAlquiladas"));
	            inventario.setUnidadesAfectadas(resultados.getInt("unidadesAfectadas"));
	            inventario.setUnidadesDisponibles(resultados.getInt("unidadesDisponibles"));

	            var empresa = new EmpresaEntity();
	            empresa.setNombre(resultados.getString("nombre_empresa"));
	            inventario.setEmpresa(empresa);

	            var producto = new ProductoEntity();
	            producto.setNombre(resultados.getString("nombre_producto"));
	            inventario.setProducto(producto);

	            var historialCosto = new HistorialCostoEntity();
	            historialCosto.setCosto(resultados.getInt("costo"));
	            inventario.setHistorialCosto(historialCosto);

	            listaInventario.add(inventario);
	        }

	    } catch (SQLException exception) {
	        var mensajeUsuario = "Se ha presentado un problema tratando de consultar la información del inventario";
	        var mensajeTecnico = "Se presentó una excepción de tipo SQLexception tratando de hacer un SELECT en la tabla Inventario";
	        throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
	    } catch (Exception exception) {
	        var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de consultar la información del inventario";
	        var mensajeTecnico = "Excepción NO CONTROLADA al hacer SELECT en la tabla Inventario";
	        throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
	    }

	    return listaInventario;
	}

	@Override
	public InventarioEntity listById(UUID id) throws LilfacException {
		var inventarioEntityRetorno=new InventarioEntity();
		var sentenciaSQL = new StringBuilder();
		
		sentenciaSQL.append("SELECT I.id, I.totalUnidades, I.unidadesAlquiladas, I.unidadesAfectadas, I.UnidadesDisponibles, E.nombre AS nombre_empresa, P.nombre AS nombre_producto, H.costo AS costo FROM Inventario I JOIN Empresa E ON I.empresa = E.id JOIN Producto P ON I.producto = P.id JOIN HistorialCosto H ON I.historialCosto = H.id WHERE I.id = ?");
		
		try(var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())){
			
			sentenciaPreparada.setObject(1, id);
			
			try (var cursorResultados = sentenciaPreparada.executeQuery()){
				
				if (cursorResultados.next()) {
					inventarioEntityRetorno.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
					inventarioEntityRetorno.setTotalUnidades(cursorResultados.getInt("totalUnidades"));
					inventarioEntityRetorno.setUnidadesAlquiladas(cursorResultados.getInt("unidadesAlquiladas"));
					inventarioEntityRetorno.setUnidadesAfectadas(cursorResultados.getInt("unidadesAfectadas"));
					inventarioEntityRetorno.setUnidadesDisponibles(cursorResultados.getInt("unidadesDisponibles"));
					
					var empresa = new EmpresaEntity();
					empresa.setNombre(cursorResultados.getString("nombre_empresa"));
					inventarioEntityRetorno.setEmpresa(empresa);
					
					var producto = new ProductoEntity();
					producto.setNombre(cursorResultados.getString("nombre_producto"));
					inventarioEntityRetorno.setProducto(producto);
					
					var historialCosto = new HistorialCostoEntity();
					historialCosto.setCosto(cursorResultados.getFloat("costo"));
					inventarioEntityRetorno.setHistorialCosto(historialCosto);
				}
				
			}
			
		} catch (SQLException exception) {
			var mensajeUsuario="Se ha presentado un problema tratando de consultar la información del inventario con el identificador deseado";
			var mensajeTecnico="Se presentó una excepción de tipo SQLexception tratando de hacer un SELECT en la tabla Inventario,  para tener más detalles revise el log de errores";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de consultar la información del inventario con el identificador deseado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un SELECT en la tabla Inventario";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}
		
		return inventarioEntityRetorno;
	}

	@Override
	public void update(UUID id, InventarioEntity entity) throws LilfacException {
		var sentenciaSQL = new StringBuilder();
		
		sentenciaSQL.append("UPDATE Invetario SET totalUnidades = ?, unidadesAlquiladas = ?, unidadesAfectadas = ?, UnidadesDisponibles = ?, empresa = ?, producto = ?, histotialCosto = ? WHERE id = ?");
		
		try(var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())){
			
			sentenciaPreparada.setInt(1, entity.getTotalUnidades());
			sentenciaPreparada.setInt(2, entity.getUnidadesAlquiladas());
			sentenciaPreparada.setInt(3,  entity.getUnidadesAfectadas());
			sentenciaPreparada.setInt(4,  entity.getUnidadesDisponibles());
			sentenciaPreparada.setObject(5,  entity.getEmpresa().getId());
			sentenciaPreparada.setObject(6,  entity.getProducto().getId());
			sentenciaPreparada.setObject(7,  entity.getHistorialCosto().getId());
			sentenciaPreparada.setObject(8, id);
			sentenciaPreparada.executeUpdate();
			
		} catch (SQLException exception) {
			var mensajeUsuario="Se ha presentado un problema tratando de actualizar la información de un inventario con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción de tipo SQLexception tratando de hacer un UPDATE en la tabla Inventario,  para tener más detalles revise el log de errores";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de actualizar la información de un invetario con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un UPDATE en la tabla Inventario";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}
	}

	@Override
	public void delete(UUID id) throws LilfacException {
		var sentenciaSQL = new StringBuilder();
		
		sentenciaSQL.append("DELETE FROM Inventario WHERE id = ?");
		
		try(var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())){
			
			sentenciaPreparada.setObject(1, id);
			sentenciaPreparada.executeUpdate();
			
		} catch (SQLException exception) {
			var mensajeUsuario="Se ha presentado un problema tratando de eliminar la información de un inventario con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción de tipo SQLexception tratando de hacer un DELETE en la tabla Inventario,  para tener más detalles revise el log de errores";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de eliminar la información de un inventario con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un DELETE en la tabla Inventario";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}
	}

}
