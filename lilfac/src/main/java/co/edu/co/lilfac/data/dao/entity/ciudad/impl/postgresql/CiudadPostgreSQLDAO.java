package co.edu.co.lilfac.data.dao.entity.ciudad.impl.postgresql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.crosscutting.excepciones.DataLilfacException;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;
import co.edu.co.lilfac.data.dao.entity.ciudad.CiudadDAO;
import co.edu.co.lilfac.entity.CiudadEntity;
import co.edu.co.lilfac.entity.DepartamentoEntity;

public class CiudadPostgreSQLDAO implements CiudadDAO{
	
	private Connection conexion;
	
	public CiudadPostgreSQLDAO(Connection conexion) {
		this.conexion=conexion;
	}

	@Override
	public void create(CiudadEntity entity) throws LilfacException {
		var sentenciaSQL = new StringBuilder();
		
		sentenciaSQL.append("INSERT INTO ciudad (id, nombre, departamento) VALUES (?, ?, ?)");
		
		try(var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())){
			
			sentenciaPreparada.setObject(1, entity.getId());
			sentenciaPreparada.setString(2, entity.getNombre());
			sentenciaPreparada.setObject(3, entity.getDepartamento().getId());
			sentenciaPreparada.executeUpdate();
			
		} catch (SQLException exception) {
			var mensajeUsuario="Se ha presentado un problema tratando de registrar la información de una nueva ciudad";
			var mensajeTecnico="Se presentó una excepción de tipo SQLexception tratando de hacer un INSERT en la tabla Ciudad,  para tener más detalles revise el log de errores";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de registrar la información de una nueva ciudad";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un INSERT en la tabla Ciudad";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}
		
	}

	@Override
	public List<CiudadEntity> listByFIlter(CiudadEntity filter) throws LilfacException {
		var listaCiudades = new java.util.ArrayList<CiudadEntity>();
		var sentenciaSQL = new StringBuilder();
		sentenciaSQL.append("SELECT C.id, C.nombre, D.nombre AS nombre_departamento FROM ciudad C JOIN departamento D ON C.departamento = D.id WHERE 1=1");
		
		if (filter != null) {
			if (filter.getId() != null) {
				sentenciaSQL.append(" AND C.id = ?");
			}
			if (filter.getNombre() != null && !filter.getNombre().isBlank()) {
				sentenciaSQL.append(" AND C.nombre LIKE ?");
			}
			if (filter.getDepartamento() != null) {
				sentenciaSQL.append(" AND D.nombre = ?");
			}
		}
		
		try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
			
			var indiceParametro = 1;
			
			if (filter != null) {
				if (filter.getId() != null) {
					sentenciaPreparada.setObject(indiceParametro++, filter.getId());
				}
				if (filter.getNombre() != null && !filter.getNombre().isBlank()) {
					sentenciaPreparada.setString(indiceParametro++, "%" + filter.getNombre() + "%");

				}
				if (filter.getDepartamento() != null) {
					sentenciaPreparada.setObject(indiceParametro++, filter.getDepartamento().getNombre());
				}
			}
			
			try (var cursorResultados = sentenciaPreparada.executeQuery()) {
				
				while (cursorResultados.next()) {
					var ciudad = new CiudadEntity();
					ciudad.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
					ciudad.setNombre(cursorResultados.getString("nombre"));
					
					var departamento = new DepartamentoEntity();
		            departamento.setNombre(cursorResultados.getString("nombre_departamento"));
		            ciudad.setDepartamento(departamento);
					
					listaCiudades.add(ciudad);
				}
			}
			
		} catch (SQLException exception) {
			var mensajeUsuario = "Se ha presentado un problema tratando de consultar las ciudades con los filtros deseados.";
			var mensajeTecnico = "Se presentó una excepción SQLException ejecutando SELECT con filtros en la tabla Ciudad.";

			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
			
		} catch (Exception exception) {
			var mensajeUsuario = "Se ha presentado un problema inesperado tratando de consultar las ciudades con los filtros deseados.";
			var mensajeTecnico = "Se presentó una excepción NO CONTROLADA ejecutando SELECT con filtros en la tabla Ciudad.";

			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}
		
		return listaCiudades;
	}

	@Override
	public List<CiudadEntity> listAll() throws LilfacException {
	    List<CiudadEntity> listaCiudades = new ArrayList<>();
	    var sentenciaSQL = new StringBuilder();

	    sentenciaSQL.append("SELECT C.id, C.nombre, D.nombre AS nombre_departamento "
	    		+ "FROM ciudad C JOIN departamento D ON C.departamento = D.id");

	    try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString());
	         var resultados = sentenciaPreparada.executeQuery()) {

	        while (resultados.next()) {
	            var ciudad = new CiudadEntity();
	            ciudad.setId(UtilUUID.convertirAUUID(resultados.getString("id")));
	            ciudad.setNombre(resultados.getString("nombre"));

	            var departamento = new DepartamentoEntity();
	            departamento.setNombre(resultados.getString("nombre_departamento"));
	            ciudad.setDepartamento(departamento);

	            listaCiudades.add(ciudad);
	        }

	    } catch (SQLException exception) {
	        var mensajeUsuario = "Se ha presentado un problema tratando de consultar la información de las ciudades";
	        var mensajeTecnico = "Se presentó una excepción de tipo SQLexception tratando de hacer un SELECT en la tabla Ciudad";
	        throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
	    } catch (Exception exception) {
	        var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de consultar la información de las ciudades";
	        var mensajeTecnico = "Excepción NO CONTROLADA al hacer SELECT en la tabla Ciudad";
	        throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
	    }

	    return listaCiudades;
	}

	@Override
	public CiudadEntity listById(UUID id) throws LilfacException {
		var ciudadEntityRetorno=new CiudadEntity();
		var sentenciaSQL = new StringBuilder();
		
		sentenciaSQL.append("SELECT C.id, C.nombre, D.nombre AS nombre_departamento FROM ciudad C JOIN departamento D ON C.departamento = D.id WHERE C.id = ?");
		
		try(var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())){
			
			sentenciaPreparada.setObject(1, id);
			
			try (var cursorResultados = sentenciaPreparada.executeQuery()){
				
				if (cursorResultados.next()) {
					ciudadEntityRetorno.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
					ciudadEntityRetorno.setNombre(cursorResultados.getString("nombre"));
					var departamento = new DepartamentoEntity();
					departamento.setNombre(cursorResultados.getString("nombre_departamento"));
					ciudadEntityRetorno.setDepartamento(departamento);
				}
				
			}
			
		} catch (SQLException exception) {
			var mensajeUsuario="Se ha presentado un problema tratando de consultar la información de la ciudad con el identificador deseado";
			var mensajeTecnico="Se presentó una excepción de tipo SQLexception tratando de hacer un SELECT en la tabla Ciudad,  para tener más detalles revise el log de errores";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de consultar la información de la ciudad con el identificador deseado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un SELECT en la tabla Ciudad";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}
		
		return ciudadEntityRetorno;
	}

	@Override
	public void update(UUID id, CiudadEntity entity) throws LilfacException {
		var sentenciaSQL = new StringBuilder();
		
		sentenciaSQL.append("UPDATE ciudad SET nombre = ?,  departamento = ? WHERE id = ?");
		
		try(var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())){
			
			sentenciaPreparada.setString(1, entity.getNombre());
			sentenciaPreparada.setObject(2, entity.getDepartamento().getId());
			sentenciaPreparada.setObject(3, id);
			sentenciaPreparada.executeUpdate();
			
		} catch (SQLException exception) {
			var mensajeUsuario="Se ha presentado un problema tratando de actualizar la información de una ciudad con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción de tipo SQLexception tratando de hacer un UPDATE en la tabla Ciudad,  para tener más detalles revise el log de errores";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de actualizar la información de una ciudad con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un UPDATE en la tabla Ciudad";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}
		
	}

	@Override
	public void delete(UUID id) throws LilfacException {
		var sentenciaSQL = new StringBuilder();
		
		sentenciaSQL.append("DELETE FROM ciudad WHERE id = ?");
		
		try(var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())){
			
			sentenciaPreparada.setObject(1, id);
			sentenciaPreparada.executeUpdate();
			
		} catch (SQLException exception) {
			var mensajeUsuario="Se ha presentado un problema tratando de eliminar la información de una ciudad con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción de tipo SQLexception tratando de hacer un DELETE en la tabla Ciudad,  para tener más detalles revise el log de errores";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de eliminar la información de una ciudad con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un DELETE en la tabla Ciudad";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}
		
	}

}
