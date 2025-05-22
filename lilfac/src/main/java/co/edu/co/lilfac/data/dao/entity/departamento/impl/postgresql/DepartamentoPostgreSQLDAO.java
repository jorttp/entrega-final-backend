package co.edu.co.lilfac.data.dao.entity.departamento.impl.postgresql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.crosscutting.excepciones.DataLilfacException;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;
import co.edu.co.lilfac.data.dao.entity.departamento.DepartamentoDAO;
import co.edu.co.lilfac.entity.DepartamentoEntity;
import co.edu.co.lilfac.entity.PaisEntity;

public class DepartamentoPostgreSQLDAO implements DepartamentoDAO{
	
	private Connection conexion;
	
	public DepartamentoPostgreSQLDAO(Connection conexion) {
		this.conexion=conexion;
	}

	@Override
	public void create(DepartamentoEntity entity) throws LilfacException {
		var sentenciaSQL = new StringBuilder();
		
		sentenciaSQL.append("INSERT INTO Departamento (id, nombre, pais) VALUES (?, ?, ?)");
		
		try(var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())){
			
			sentenciaPreparada.setObject(1, entity.getId());
			sentenciaPreparada.setString(2, entity.getNombre());
			sentenciaPreparada.setObject(3, entity.getPais().getId());
			sentenciaPreparada.executeUpdate();
			
		} catch (SQLException exception) {
			var mensajeUsuario="Se ha presentado un problema tratando de registrar la información de un nuevo departamento";
			var mensajeTecnico="Se presentó una excepción de tipo SQLexception tratando de hacer un INSERT en la tabla Departamento,  para tener más detalles revise el log de errores";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de registrar la información de un nuevo departamento";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un INSERT en la tabla Departamento";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}
		
	}

	@Override
	public List<DepartamentoEntity> listByFIlter(DepartamentoEntity filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DepartamentoEntity> listAll() throws LilfacException {
	    List<DepartamentoEntity> listaDepartamentos = new ArrayList<>();
	    var sentenciaSQL = new StringBuilder();

	    sentenciaSQL.append("SELECT D.id, D.nombre, P.nombre AS nombre_pais FROM Departamento D JOIN Pais P ON D.pais = P.id");

	    try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString());
	         var resultados = sentenciaPreparada.executeQuery()) {

	        while (resultados.next()) {
	            var departamento = new DepartamentoEntity();
	            departamento.setId(UtilUUID.convertirAUUID(resultados.getString("id")));
	            departamento.setNombre(resultados.getString("nombre"));

	            var pais = new PaisEntity();
	            pais.setNombre(resultados.getString("nombre_pais"));
	            departamento.setPais(pais);

	            listaDepartamentos.add(departamento);
	        }

	    } catch (SQLException exception) {
	        var mensajeUsuario = "Se ha presentado un problema tratando de consultar la información de los departamentos";
	        var mensajeTecnico = "Se presentó una excepción de tipo SQLexception tratando de hacer un SELECT en la tabla Departamento";
	        throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
	    } catch (Exception exception) {
	        var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de consultar la información de los departamentos";
	        var mensajeTecnico = "Excepción NO CONTROLADA al hacer SELECT en la tabla Departamento";
	        throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
	    }

	    return listaDepartamentos;
	}

	@Override
	public DepartamentoEntity listById(UUID id) throws LilfacException {
		var departamentoEntityRetorno=new DepartamentoEntity();
		var sentenciaSQL = new StringBuilder();
		
		sentenciaSQL.append("SELECT D.id, D.nombre, P.nombre AS nombre_pais FROM Departamento D JOIN Pais P ON D.pais = P.id WHERE D.id = ?");
		
		try(var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())){
			
			sentenciaPreparada.setObject(1, id);
			
			try (var cursorResultados = sentenciaPreparada.executeQuery()){
				
				if (cursorResultados.next()) {
					departamentoEntityRetorno.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
					departamentoEntityRetorno.setNombre(cursorResultados.getString("nombre"));
					var pais = new PaisEntity();
					pais.setNombre(cursorResultados.getString("nombre_pais"));
					departamentoEntityRetorno.setPais(pais);
				}
				
			}
			
		} catch (SQLException exception) {
			var mensajeUsuario="Se ha presentado un problema tratando de consultar la información del departamento con el identificador deseado";
			var mensajeTecnico="Se presentó una excepción de tipo SQLexception tratando de hacer un SELECT en la tabla Departamento,  para tener más detalles revise el log de errores";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de consultar la información del departamento con el identificador deseado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un SELECT en la tabla Departamento";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}
		
		return departamentoEntityRetorno;
	}

	@Override
	public void update(UUID id, DepartamentoEntity entity) throws LilfacException {
		var sentenciaSQL = new StringBuilder();
		
		sentenciaSQL.append("UPDATE Departamento SET nombre = ?, SET pais = ? WHERE id = ?");
		
		try(var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())){
			
			sentenciaPreparada.setString(1, entity.getNombre());
			sentenciaPreparada.setObject(2, entity.getPais().getId());
			sentenciaPreparada.setObject(3, id);
			sentenciaPreparada.executeUpdate();
			
		} catch (SQLException exception) {
			var mensajeUsuario="Se ha presentado un problema tratando de actualizar la información de un departamento con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción de tipo SQLexception tratando de hacer un UPDATE en la tabla Departamento,  para tener más detalles revise el log de errores";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de actualizar la información de un departaento con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un UPDATE en la tabla Departamento";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}
		
	}

	@Override
	public void delete(UUID id) throws LilfacException {
		var sentenciaSQL = new StringBuilder();
		
		sentenciaSQL.append("DELETE FROM Departamento WHERE id = ?");
		
		try(var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())){
			
			sentenciaPreparada.setObject(1, id);
			sentenciaPreparada.executeUpdate();
			
		} catch (SQLException exception) {
			var mensajeUsuario="Se ha presentado un problema tratando de eliminar la información de un departamento con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción de tipo SQLexception tratando de hacer un DELETE en la tabla Departamento,  para tener más detalles revise el log de errores";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de eliminar la información de un departamento con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un DELETE en la tabla Departamento";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}
		
	}

}
