package co.edu.co.lilfac.data.dao.entity.cliente.impl.postgresql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.crosscutting.excepciones.DataLilfacException;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;
import co.edu.co.lilfac.data.dao.entity.cliente.ClienteDAO;
import co.edu.co.lilfac.entity.CiudadEntity;
import co.edu.co.lilfac.entity.ClienteEntity;

public class ClientePostgreSQLDAO implements ClienteDAO{
	
	private Connection conexion;
	
	public ClientePostgreSQLDAO(Connection conexion) {
		this.conexion=conexion;
	}

	@Override
	public void create(ClienteEntity entity) throws LilfacException {
		var sentenciaSQL = new StringBuilder();
		
		sentenciaSQL.append("INSERT INTO Cliente (id, nombre, apellido, cedula, telefono, correo, direccionResidencia, ciudad) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
		
		try(var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())){
			
			sentenciaPreparada.setObject(1, entity.getId());
			sentenciaPreparada.setString(2, entity.getNombre());
			sentenciaPreparada.setString(3, entity.getApellido());
			sentenciaPreparada.setInt(4, entity.getCedula());
			sentenciaPreparada.setInt(5,  entity.getTelefono());
			sentenciaPreparada.setString(6,  entity.getCorreo());
			sentenciaPreparada.setString(7,  entity.getDireccionResidencia());
			sentenciaPreparada.setObject(8,  entity.getCiudad().getId());
			sentenciaPreparada.executeUpdate();
			
		} catch (SQLException exception) {
			var mensajeUsuario="Se ha presentado un problema tratando de registrar la información de un nuevo cliente";
			var mensajeTecnico="Se presentó una excepción de tipo SQLexception tratando de hacer un INSERT en la tabla Cliente,  para tener más detalles revise el log de errores";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de registrar la información de un nuevo cliente";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un INSERT en la tabla Cliente";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}
		
	}

	@Override
	public List<ClienteEntity> listByFIlter(ClienteEntity filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClienteEntity> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClienteEntity listById(UUID id) throws LilfacException {
		var clienteEntityRetorno=new ClienteEntity();
		var sentenciaSQL = new StringBuilder();
		
		sentenciaSQL.append("SELECT CL.id, CL.nombre, CL.apellido, CL.cedula, CL.telefono, CL.correo, CL.direccionResidencia, C.nombre AS nombre_ciudad FROM Cliente CL JOIN Ciudad C ON CL.ciudad = C.id WHERE CL.id = ?");
		
		try(var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())){
			
			sentenciaPreparada.setObject(1, id);
			
			try (var cursorResultados = sentenciaPreparada.executeQuery()){
				
				if (cursorResultados.next()) {
					clienteEntityRetorno.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
					clienteEntityRetorno.setNombre(cursorResultados.getString("nombre"));
					clienteEntityRetorno.setApellido(cursorResultados.getString("apellido"));
					clienteEntityRetorno.setCedula(cursorResultados.getInt("cedula"));
					clienteEntityRetorno.setTelefono(cursorResultados.getInt("telefono"));
					clienteEntityRetorno.setCorreo(cursorResultados.getString("correo"));
					clienteEntityRetorno.setDireccionResidencia(cursorResultados.getString("direccionResidencia"));
					var ciudad = new CiudadEntity();
					ciudad.setNombre(cursorResultados.getString("nombre_ciudad"));
					clienteEntityRetorno.setCiudad(ciudad);
				}
				
			}
			
		} catch (SQLException exception) {
			var mensajeUsuario="Se ha presentado un problema tratando de consultar la información del cliente con el identificador deseado";
			var mensajeTecnico="Se presentó una excepción de tipo SQLexception tratando de hacer un SELECT en la tabla Cliente,  para tener más detalles revise el log de errores";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de consultar la información del cliente con el identificador deseado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un SELECT en la tabla Cliente";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}
		
		return clienteEntityRetorno;
	}

	@Override
	public void update(UUID id, ClienteEntity entity) throws LilfacException {
		var sentenciaSQL = new StringBuilder();
		
		sentenciaSQL.append("UPDATE Cliente SET nombre = ?, apellido = ?, cedula = ?, telefono = ?, correo = ?, direccionResidencia = ?, ciudad = ? WHERE id = ?");
		
		try(var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())){
			
			sentenciaPreparada.setString(1, entity.getNombre());
			sentenciaPreparada.setString(2, entity.getApellido());
			sentenciaPreparada.setInt(3,  entity.getCedula());
			sentenciaPreparada.setInt(4,  entity.getTelefono());
			sentenciaPreparada.setString(5,  entity.getCorreo());
			sentenciaPreparada.setString(6,  entity.getDireccionResidencia());
			sentenciaPreparada.setObject(7,  entity.getCiudad().getId());
			sentenciaPreparada.setObject(8, id);
			
		} catch (SQLException exception) {
			var mensajeUsuario="Se ha presentado un problema tratando de actualizar la información de un cliente con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción de tipo SQLexception tratando de hacer un UPDATE en la tabla Cliente,  para tener más detalles revise el log de errores";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de actualizar la información de un cliente con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un UPDATE en la tabla Cliente";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}
		
	}

	@Override
	public void delete(UUID id) throws LilfacException {
		var sentenciaSQL = new StringBuilder();
		
		sentenciaSQL.append("DELETE FROM Cliente WHERE id = ?");
		
		try(var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())){
			
			sentenciaPreparada.setObject(1, id);
			
		} catch (SQLException exception) {
			var mensajeUsuario="Se ha presentado un problema tratando de eliminar la información de un cliente con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción de tipo SQLexception tratando de hacer un DELETE en la tabla Cliente,  para tener más detalles revise el log de errores";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de eliminar la información de un cliente con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un DELETE en la tabla Cliente";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}
		
	}

}
