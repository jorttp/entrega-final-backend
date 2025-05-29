package co.edu.co.lilfac.data.dao.entity.empleado.impl.postgresql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.crosscutting.excepciones.DataLilfacException;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;
import co.edu.co.lilfac.data.dao.entity.empleado.EmpleadoDAO;
import co.edu.co.lilfac.entity.EmpleadoEntity;

public class EmpleadoPostgreSQLDAO implements EmpleadoDAO{
	
	private Connection conexion;
	
	public EmpleadoPostgreSQLDAO(Connection conexion) {
		this.conexion=conexion;
	}

	@Override
	public void create(EmpleadoEntity entity) throws LilfacException {
		var sentenciaSQL = new StringBuilder();
		
		sentenciaSQL.append("INSERT INTO empleado (id, nombre, apellido, cedula, telefono, correo) VALUES (?, ?, ?, ?, ?, ?)");
		
		try(var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())){
			
			sentenciaPreparada.setObject(1, entity.getId());
			sentenciaPreparada.setString(2, entity.getNombre());
			sentenciaPreparada.setString(3, entity.getApellido());
			sentenciaPreparada.setInt(4, entity.getCedula());
			sentenciaPreparada.setInt(5, entity.getTelefono());
			sentenciaPreparada.setString(6, entity.getCorreo());
			sentenciaPreparada.executeUpdate();
			
		} catch (SQLException exception) {
			var mensajeUsuario="Se ha presentado un problema tratando de registrar la información de un nuevo empleado";
			var mensajeTecnico="Se presentó una excepción de tipo SQLexception tratando de hacer un INSERT en la tabla Empleado,  para tener más detalles revise el log de errores";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de registrar la información de un nuevo empleado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un INSERT en la tabla Empleado";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}
		
	}

	@Override
	public List<EmpleadoEntity> listByFIlter(EmpleadoEntity filter) throws LilfacException {
		var listaEmpleados = new java.util.ArrayList<EmpleadoEntity>();
		var sentenciaSQL = new StringBuilder();
		sentenciaSQL.append("SELECT id, nombre, apellido, cedula, telefono, correo FROM empleado WHERE 1=1");
		
		if (filter != null) {
			if (filter.getId() != null) {
				sentenciaSQL.append(" AND id = ?");
			}
			if (filter.getNombre() != null && !filter.getNombre().isBlank()) {
				sentenciaSQL.append(" AND nombre LIKE ?");
			}
			if (filter.getApellido() != null && !filter.getApellido().isBlank()) {
				sentenciaSQL.append(" AND apellido LIKE ?");
			}
			if (filter.getCedula() != null) {
				sentenciaSQL.append(" AND cedula = ?");
			}
			if (filter.getTelefono() != null) {
				sentenciaSQL.append(" AND telefono = ?");
			}
			if (filter.getCorreo() != null && !filter.getCorreo().isBlank()) {
				sentenciaSQL.append(" AND correo LIKE ?");
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
				if (filter.getApellido() != null && !filter.getApellido().isBlank()) {
					sentenciaPreparada.setString(indiceParametro++, "%" + filter.getApellido() + "%");
				}
				if (filter.getCedula() != null) {
					sentenciaPreparada.setInt(indiceParametro++, filter.getCedula());
				}
				if (filter.getTelefono() != null) {
					sentenciaPreparada.setInt(indiceParametro++, filter.getTelefono());
				}
				if (filter.getCorreo() != null && !filter.getCorreo().isBlank()) {
					sentenciaPreparada.setString(indiceParametro++, "%" + filter.getCorreo() + "%");
				}
			}
			
			try (var cursorResultados = sentenciaPreparada.executeQuery()) {
				
				while (cursorResultados.next()) {
		            var empleado = new EmpleadoEntity();
		            empleado.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
		            empleado.setNombre(cursorResultados.getString("nombre"));
		            empleado.setApellido(cursorResultados.getString("apellido"));
		            empleado.setCedula(cursorResultados.getInt("cedula"));
		            empleado.setTelefono(cursorResultados.getInt("telefono"));
		            empleado.setCorreo(cursorResultados.getString("correo"));

		            listaEmpleados.add(empleado);
				}
			}
			
		} catch (SQLException exception) {
			var mensajeUsuario = "Se ha presentado un problema tratando de consultar los empleados con los filtros deseados.";
			var mensajeTecnico = "Se presentó una excepción SQLException ejecutando SELECT con filtros en la tabla Empleado.";

			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
			
		} catch (Exception exception) {
			var mensajeUsuario = "Se ha presentado un problema inesperado tratando de consultar los empleados con los filtros deseados.";
			var mensajeTecnico = "Se presentó una excepción NO CONTROLADA ejecutando SELECT con filtros en la tabla Empleado.";

			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}
		
		return listaEmpleados;
	}

	@Override
	public List<EmpleadoEntity> listAll() throws LilfacException {
	    List<EmpleadoEntity> listaEmpleados = new ArrayList<>();
	    var sentenciaSQL = new StringBuilder();

	    sentenciaSQL.append("SELECT id, nombre, apellido, cedula, telefono, correo FROM empleado");

	    try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString());
	         var resultados = sentenciaPreparada.executeQuery()) {

	        while (resultados.next()) {
	            var empleado = new EmpleadoEntity();
	            empleado.setId(UtilUUID.convertirAUUID(resultados.getString("id")));
	            empleado.setNombre(resultados.getString("nombre"));
	            empleado.setApellido(resultados.getString("apellido"));
	            empleado.setCedula(resultados.getInt("cedula"));
	            empleado.setTelefono(resultados.getInt("telefono"));
	            empleado.setCorreo(resultados.getString("correo"));

	            listaEmpleados.add(empleado);
	        }

	    } catch (SQLException exception) {
	        var mensajeUsuario = "Se ha presentado un problema tratando de consultar la información de los empleados";
	        var mensajeTecnico = "Se presentó una excepción de tipo SQLexception tratando de hacer un SELECT en la tabla Empleado";
	        throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
	    } catch (Exception exception) {
	        var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de consultar la información de los empleados";
	        var mensajeTecnico = "Excepción NO CONTROLADA al hacer SELECT en la tabla Empleado";
	        throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
	    }

	    return listaEmpleados;
	}

	@Override
	public EmpleadoEntity listById(UUID id) throws LilfacException {
		var empleadoEntityRetorno=new EmpleadoEntity();
		var sentenciaSQL = new StringBuilder();
		
		sentenciaSQL.append("SELECT id, nombre, apellido, cedula, telefono, correo FROM empleado WHERE id = ?");
		
		try(var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())){
			
			sentenciaPreparada.setObject(1, id);
			
			try (var cursorResultados = sentenciaPreparada.executeQuery()){
				
				if (cursorResultados.next()) {
					empleadoEntityRetorno.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
					empleadoEntityRetorno.setNombre(cursorResultados.getString("nombre"));
					empleadoEntityRetorno.setApellido(cursorResultados.getString("apellido"));
					empleadoEntityRetorno.setCedula(cursorResultados.getInt("cedula"));
					empleadoEntityRetorno.setTelefono(cursorResultados.getInt("telefono"));
					empleadoEntityRetorno.setCorreo(cursorResultados.getString("correo"));
				}
				
			}
			
		} catch (SQLException exception) {
			var mensajeUsuario="Se ha presentado un problema tratando de consultar la información del empleado con el identificador deseado";
			var mensajeTecnico="Se presentó una excepción de tipo SQLexception tratando de hacer un SELECT en la tabla Empleado,  para tener más detalles revise el log de errores";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de consultar la información del empleado con el identificador deseado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un SELECT en la tabla Empleado";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}
		
		return empleadoEntityRetorno;
	}

	@Override
	public void update(UUID id, EmpleadoEntity entity) throws LilfacException {
		var sentenciaSQL = new StringBuilder();
		
		sentenciaSQL.append("UPDATE empleado SET nombre = ?, apellido = ?, cedula = ?, telefono = ?, correo = ? WHERE id = ?");
		
		try(var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())){
			
			sentenciaPreparada.setString(1, entity.getNombre());
			sentenciaPreparada.setString(2, entity.getApellido());
			sentenciaPreparada.setInt(3, entity.getCedula());
			sentenciaPreparada.setInt(4, entity.getTelefono());
			sentenciaPreparada.setString(5, entity.getCorreo());
			sentenciaPreparada.setObject(6, id);
			sentenciaPreparada.executeUpdate();
			
		} catch (SQLException exception) {
			var mensajeUsuario="Se ha presentado un problema tratando de actualizar la información de un empleado con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción de tipo SQLexception tratando de hacer un UPDATE en la tabla Empleado,  para tener más detalles revise el log de errores";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de actualizar la información de un empleado con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un UPDATE en la tabla Empleado";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}
		
	}

	@Override
	public void delete(UUID id) throws LilfacException {
		var sentenciaSQL = new StringBuilder();
		
		sentenciaSQL.append("DELETE FROM empleado WHERE id = ?");
		
		try(var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())){
			
			sentenciaPreparada.setObject(1, id);
			sentenciaPreparada.executeUpdate();
			
		} catch (SQLException exception) {
			var mensajeUsuario="Se ha presentado un problema tratando de eliminar la información de un empleado con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción de tipo SQLexception tratando de hacer un DELETE en la tabla Empleado,  para tener más detalles revise el log de errores";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de eliminar la información de un empleado con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un DELETE en la tabla Empleado";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}
		
	}

}
