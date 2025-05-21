package co.edu.co.lilfac.data.dao.entity.recepcion.impl.postgresql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.crosscutting.excepciones.DataLilfacException;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;
import co.edu.co.lilfac.data.dao.entity.recepcion.RecepcionDAO;
import co.edu.co.lilfac.entity.CiudadEntity;
import co.edu.co.lilfac.entity.EmpleadoEntity;
import co.edu.co.lilfac.entity.EntregaEntity;
import co.edu.co.lilfac.entity.RecepcionEntity;

public class RecepcionPostgreSQLDAO implements RecepcionDAO{
	
	private Connection conexion;
	
	public RecepcionPostgreSQLDAO(Connection conexion) {
		this.conexion=conexion;
	}

	@Override
	public void create(RecepcionEntity entity) throws LilfacException {
		var sentenciaSQL = new StringBuilder();
		
		sentenciaSQL.append("INSERT INTO Recepcion (id, entrega, fecha, estado, direccion, ciudad, empleado) VALUES (?, ?, ?, ?, ?, ?, ?)");
		
		try(var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())){
			
			sentenciaPreparada.setObject(1, entity.getId());
			sentenciaPreparada.setObject(2,  entity.getEntrega().getId());
			sentenciaPreparada.setString(3, entity.getFecha());
			sentenciaPreparada.setString(4, entity.getEstado());
			sentenciaPreparada.setString(5, entity.getDireccion());
			sentenciaPreparada.setObject(6, entity.getCiudad().getId());
			sentenciaPreparada.setObject(7, entity.getEmpleado().getId());
			
			sentenciaPreparada.executeUpdate();
			
		} catch (SQLException exception) {
			var mensajeUsuario="Se ha presentado un problema tratando de registrar la información de una nueva recepción";
			var mensajeTecnico="Se presentó una excepción de tipo SQLexception tratando de hacer un INSERT en la tabla Recepcion,  para tener más detalles revise el log de errores";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de registrar la información de una nueva recepción";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un INSERT en la tabla Recepcion";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}
	}

	@Override
	public List<RecepcionEntity> listByFIlter(RecepcionEntity filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RecepcionEntity> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RecepcionEntity listById(UUID id) throws LilfacException {
		var recepcionEntityRetorno=new RecepcionEntity();
		var sentenciaSQL = new StringBuilder();
		
		sentenciaSQL.append("SELECT R.id, E.id AS entrega, R.fecha, R.estado, R.direccion, C.nombre AS nombre_ciudad, EM.nombre AS nombre_empleado FROM Recepcion R JOIN Entrega E ON R.entrega = E.id JOIN Ciudad C ON R.ciudad = C.id JOIN Empleado EM ON R.empleado = EM.id WHERE R.id = ?");
		
		try(var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())){
			
			sentenciaPreparada.setObject(1, id);
			
			try (var cursorResultados = sentenciaPreparada.executeQuery()){
				
				if (cursorResultados.next()) {
					recepcionEntityRetorno.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
					recepcionEntityRetorno.setFecha(cursorResultados.getString("fecha"));
					recepcionEntityRetorno.setEstado(cursorResultados.getString("estado"));
					recepcionEntityRetorno.setDireccion(cursorResultados.getString("direccion"));
					
					var entrega = new EntregaEntity();
					entrega.setId(UtilUUID.convertirAUUID(cursorResultados.getString("entrega")));
					recepcionEntityRetorno.setEntrega(entrega);
	
					var ciudad = new CiudadEntity();
					ciudad.setNombre(cursorResultados.getString("nombre_ciudad"));
					recepcionEntityRetorno.setCiudad(ciudad);
					
					var empleado = new EmpleadoEntity();
					empleado.setNombre(cursorResultados.getString("nombre_empleado"));
					recepcionEntityRetorno.setEmpleado(empleado);
					
				}
				
			}
			
		} catch (SQLException exception) {
			var mensajeUsuario="Se ha presentado un problema tratando de consultar la información de la recepcion con el identificador deseado";
			var mensajeTecnico="Se presentó una excepción de tipo SQLexception tratando de hacer un SELECT en la tabla Recepcion,  para tener más detalles revise el log de errores";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de consultar la información de la recepcion con el identificador deseado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un SELECT en la tabla Recepcion";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}
		
		return recepcionEntityRetorno;
	}

	@Override
	public void update(UUID id, RecepcionEntity entity) throws LilfacException {
		var sentenciaSQL = new StringBuilder();
		
		sentenciaSQL.append("UPDATE Recepcion SET  entrega = ?, fecha = ?, estado = ?, direccion = ?, ciudad = ?, empleado = ? WHERE id = ?");
		
		try(var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())){
			
			sentenciaPreparada.setObject(1, entity.getEntrega().getId());
			sentenciaPreparada.setString(2, entity.getFecha());
			sentenciaPreparada.setString(3,  entity.getEstado());
			sentenciaPreparada.setString(4,  entity.getDireccion());
			sentenciaPreparada.setObject(5,  entity.getCiudad().getId());
			sentenciaPreparada.setObject(6,  entity.getEmpleado().getId());
			sentenciaPreparada.setObject(7, id);
			
		} catch (SQLException exception) {
			var mensajeUsuario="Se ha presentado un problema tratando de actualizar la información de una Recepcion con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción de tipo SQLexception tratando de hacer un UPDATE en la tabla Recepcion,  para tener más detalles revise el log de errores";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de actualizar la información de una Recepcion con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un UPDATE en la tabla Recepcion";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}
	}

	@Override
	public void delete(UUID id) throws LilfacException {
		var sentenciaSQL = new StringBuilder();
		
		sentenciaSQL.append("DELETE FROM Recepcion WHERE id = ?");
		
		try(var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())){
			
			sentenciaPreparada.setObject(1, id);
			
		} catch (SQLException exception) {
			var mensajeUsuario="Se ha presentado un problema tratando de eliminar la información de una Recepcion con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción de tipo SQLexception tratando de hacer un DELETE en la tabla Recepcion,  para tener más detalles revise el log de errores";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de eliminar la información de una Recepcion pedido con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un DELETE en la tabla Recepcion";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}
	}

}
