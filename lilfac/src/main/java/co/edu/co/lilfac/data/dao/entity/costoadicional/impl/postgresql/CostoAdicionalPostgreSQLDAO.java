package co.edu.co.lilfac.data.dao.entity.costoadicional.impl.postgresql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.crosscutting.excepciones.DataLilfacException;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;
import co.edu.co.lilfac.data.dao.entity.costoadicional.CostoAdicionalDAO;
import co.edu.co.lilfac.entity.CostoAdicionalEntity;
import co.edu.co.lilfac.entity.RecepcionEntity;

public class CostoAdicionalPostgreSQLDAO implements CostoAdicionalDAO{
	
	private Connection conexion;
	
	public CostoAdicionalPostgreSQLDAO(Connection conexion) {
		this.conexion=conexion;
	}

	@Override
	public void create(CostoAdicionalEntity entity) throws LilfacException {
		var sentenciaSQL = new StringBuilder();
		
		sentenciaSQL.append("INSERT INTO CostoAdicional (id, valor, descripcion, recepcion) VALUES (?, ?, ?, ?)");
		
		try(var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())){
			
			sentenciaPreparada.setObject(1, entity.getId());
			sentenciaPreparada.setFloat(2, entity.getValor());
			sentenciaPreparada.setString(3, entity.getDescripcion());
			sentenciaPreparada.setObject(4, entity.getRecepcion().getId());
			sentenciaPreparada.executeUpdate();
			
		} catch (SQLException exception) {
			var mensajeUsuario="Se ha presentado un problema tratando de registrar la información de un nuevo costo adicional";
			var mensajeTecnico="Se presentó una excepción de tipo SQLexception tratando de hacer un INSERT en la tabla CostoAdicional,  para tener más detalles revise el log de errores";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de registrar la información de un nuevo costo adicional";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un INSERT en la tabla CostoAdicional";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}
	}

	@Override
	public List<CostoAdicionalEntity> listByFIlter(CostoAdicionalEntity filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CostoAdicionalEntity> listAll() throws LilfacException {
	    List<CostoAdicionalEntity> listaCostosAdicionales = new ArrayList<>();
	    var sentenciaSQL = new StringBuilder();

	    sentenciaSQL.append("SELECT CA.id, CA.valor, CA.descripcion, R.id AS recepcion FROM CostoAdicional CA JOIN Recepcion R ON CA.recepcion = R.id");

	    try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString());
	         var resultados = sentenciaPreparada.executeQuery()) {

	        while (resultados.next()) {
	            var costoAdicional = new CostoAdicionalEntity();
	            costoAdicional.setId(UtilUUID.convertirAUUID(resultados.getString("id")));
	            costoAdicional.setValor(resultados.getFloat("valor"));
	            costoAdicional.setDescripcion(resultados.getString("descripcion"));

	            var recepcion = new RecepcionEntity();
	            recepcion.setId(UtilUUID.convertirAUUID(resultados.getString("recepcion")));
	            costoAdicional.setRecepcion(recepcion);

	            listaCostosAdicionales.add(costoAdicional);
	        }

	    } catch (SQLException exception) {
	        var mensajeUsuario = "Se ha presentado un problema tratando de consultar la información de los costos adicionales";
	        var mensajeTecnico = "Se presentó una excepción de tipo SQLexception tratando de hacer un SELECT en la tabla CostoAdicional";
	        throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
	    } catch (Exception exception) {
	        var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de consultar la información de los costos adicionales";
	        var mensajeTecnico = "Excepción NO CONTROLADA al hacer SELECT en la tabla CostoAdicional";
	        throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
	    }

	    return listaCostosAdicionales;
	}

	@Override
	public CostoAdicionalEntity listById(UUID id) throws LilfacException {
		
		var costoAdicionalEntityRetorno=new CostoAdicionalEntity();
		var sentenciaSQL = new StringBuilder();
		
		sentenciaSQL.append("SELECT CA.id, CA.valor, CA.descripcion, R.id AS recepcion FROM CostoAdicional CA JOIN Recepcion R ON CA.recepcion = R.id WHERE CA.id = ?");
		
		try(var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())){
			
			sentenciaPreparada.setObject(1, id);
			
			try (var cursorResultados = sentenciaPreparada.executeQuery()){
				
				if (cursorResultados.next()) {
					costoAdicionalEntityRetorno.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
					costoAdicionalEntityRetorno.setValor(cursorResultados.getFloat("valor"));
					costoAdicionalEntityRetorno.setDescripcion(cursorResultados.getString("descripcion"));
					
					var recepcion = new RecepcionEntity();
					recepcion.setId(UtilUUID.convertirAUUID(cursorResultados.getString("recepcion")));
					costoAdicionalEntityRetorno.setRecepcion(recepcion);
				}
				
			}
			
		} catch (SQLException exception) {
			var mensajeUsuario="Se ha presentado un problema tratando de consultar la información del costo adicional con el identificador deseado";
			var mensajeTecnico="Se presentó una excepción de tipo SQLexception tratando de hacer un SELECT en la tabla CostoAdicional,  para tener más detalles revise el log de errores";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de consultar la información del costo adicional con el identificador deseado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un SELECT en la tabla CostoAdicional";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}
		
		return costoAdicionalEntityRetorno;
	}

	@Override
	public void update(UUID id, CostoAdicionalEntity entity) throws LilfacException {
		var sentenciaSQL = new StringBuilder();
		
		sentenciaSQL.append("UPDATE CostoAdicional SET valor = ?, descripcion = ?, recepcion = ? WHERE id = ?");
		
		try(var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())){
			
			sentenciaPreparada.setFloat(1, entity.getValor());
			sentenciaPreparada.setString(2,  entity.getDescripcion());
			sentenciaPreparada.setObject(3,  entity.getRecepcion().getId());
			sentenciaPreparada.setObject(4, id);
			sentenciaPreparada.executeUpdate();
			
		} catch (SQLException exception) {
			var mensajeUsuario="Se ha presentado un problema tratando de actualizar la información de un costo adicional con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción de tipo SQLexception tratando de hacer un UPDATE en la tabla CostoAdicional,  para tener más detalles revise el log de errores";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de actualizar la información de un cosot adicional con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un UPDATE en la tabla CostoAdicional";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}
	}

	@Override
	public void delete(UUID id) throws LilfacException {
		var sentenciaSQL = new StringBuilder();
		
		sentenciaSQL.append("DELETE FROM CostoAdicional WHERE id = ?");
		
		try(var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())){
			
			sentenciaPreparada.setObject(1, id);
			sentenciaPreparada.executeUpdate();
			
		} catch (SQLException exception) {
			var mensajeUsuario="Se ha presentado un problema tratando de eliminar la información de un costo adicional con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción de tipo SQLexception tratando de hacer un DELETE en la tabla CostoAdicional,  para tener más detalles revise el log de errores";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de eliminar la información de un costo adicional con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un DELETE en la tabla CostoAdicional";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}
	}

}
