package co.edu.co.lilfac.data.dao.entity.empresa.impl.postgresql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.co.lilfac.crosscutting.excepciones.DataLilfacException;
import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;
import co.edu.co.lilfac.data.dao.entity.empresa.EmpresaDAO;
import co.edu.co.lilfac.entity.CiudadEntity;
import co.edu.co.lilfac.entity.EmpresaEntity;

public class EmpresaPostgreSQLDAO implements EmpresaDAO{
	
	private Connection conexion;
	
	public EmpresaPostgreSQLDAO(Connection conexion) {
		this.conexion=conexion;
	}


	@Override
	public void create(EmpresaEntity entity) throws LilfacException {
		var sentenciaSQL = new StringBuilder();
		
		sentenciaSQL.append("INSERT INTO Empresa (id, nombre, nit, telefono, correo, direccion, ciudad) VALUES (?, ?, ?, ?, ?, ?, ?)");
		
		try(var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())){
			
			sentenciaPreparada.setObject(1, entity.getId());
			sentenciaPreparada.setString(2, entity.getNombre());
			sentenciaPreparada.setInt(3, entity.getNit());
			sentenciaPreparada.setInt(4, entity.getTelefono());
			sentenciaPreparada.setString(5, entity.getCorreo());
			sentenciaPreparada.setString(6, entity.getDireccion());
			sentenciaPreparada.setObject(7, entity.getCiudad().getId());
			sentenciaPreparada.executeUpdate();
			
		} catch (SQLException exception) {
			var mensajeUsuario="Se ha presentado un problema tratando de registrar la información de una nueva empresa";
			var mensajeTecnico="Se presentó una excepción de tipo SQLexception tratando de hacer un INSERT en la tabla Empresa,  para tener más detalles revise el log de errores";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de registrar la información de una nueva empresa";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un INSERT en la tabla Empresa";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}
		
	}

	@Override
	public List<EmpresaEntity> listByFIlter(EmpresaEntity filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmpresaEntity> listAll() throws LilfacException {
	    List<EmpresaEntity> listaEmpresas = new ArrayList<>();
	    var sentenciaSQL = new StringBuilder();

	    sentenciaSQL.append("SELECT E.id, E.nombre, E.nit, E.telefono, E.correo, E.direccion, C.nombre AS nombre_ciudad FROM Empresa E JOIN Ciudad C ON E.ciudad = C.id");

	    try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString());
	         var resultados = sentenciaPreparada.executeQuery()) {

	        while (resultados.next()) {
	            var empresa = new EmpresaEntity();
	            empresa.setId(UtilUUID.convertirAUUID(resultados.getString("id")));
	            empresa.setNit(resultados.getInt("nit"));
	            empresa.setTelefono(resultados.getInt("telefono"));
	            empresa.setCorreo(resultados.getString("correo"));
	            empresa.setDireccion(resultados.getString("direccion"));

	            var ciudad = new CiudadEntity();
	            ciudad.setNombre(resultados.getString("nombre_ciudad"));
	            empresa.setCiudad(ciudad);

	            listaEmpresas.add(empresa);
	        }

	    } catch (SQLException exception) {
	        var mensajeUsuario = "Se ha presentado un problema tratando de consultar la información de las empresas";
	        var mensajeTecnico = "Se presentó una excepción de tipo SQLexception tratando de hacer un SELECT en la tabla Empresa";
	        throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
	    } catch (Exception exception) {
	        var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de consultar la información de las empresas";
	        var mensajeTecnico = "Excepción NO CONTROLADA al hacer SELECT en la tabla Empresa";
	        throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
	    }

	    return listaEmpresas;
	}

	@Override
	public EmpresaEntity listById(UUID id) throws LilfacException {
		var empresaEntityRetorno=new EmpresaEntity();
		var sentenciaSQL = new StringBuilder();
		
		sentenciaSQL.append("SELECT E.id, E.nombre, E.nit, E.telefono, E.correo, E.direccion, C.nombre AS nombre_ciudad FROM Empresa E JOIN Ciudad C ON E.ciudad = C.id WHERE E.id = ?");
		
		try(var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())){
			
			sentenciaPreparada.setObject(1, id);
			
			try (var cursorResultados = sentenciaPreparada.executeQuery()){
				
				if (cursorResultados.next()) {
					empresaEntityRetorno.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
					empresaEntityRetorno.setNombre(cursorResultados.getString("nombre"));
					empresaEntityRetorno.setNit(cursorResultados.getInt("nit"));
					empresaEntityRetorno.setTelefono(cursorResultados.getInt("telefono"));
					empresaEntityRetorno.setCorreo(cursorResultados.getString("correo"));
					empresaEntityRetorno.setDireccion(cursorResultados.getString("direccion"));
					var ciudad = new CiudadEntity();
					ciudad.setNombre(cursorResultados.getString("nombre_ciudad"));
					empresaEntityRetorno.setCiudad(ciudad);
				}
				
			}
			
		} catch (SQLException exception) {
			var mensajeUsuario="Se ha presentado un problema tratando de consultar la información de la empresa con el identificador deseado";
			var mensajeTecnico="Se presentó una excepción de tipo SQLexception tratando de hacer un SELECT en la tabla Empresa,  para tener más detalles revise el log de errores";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de consultar la información de la empresa con el identificador deseado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un SELECT en la tabla Empresa";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}
		
		return empresaEntityRetorno;
	}

	@Override
	public void update(UUID id, EmpresaEntity entity) throws LilfacException {
		var sentenciaSQL = new StringBuilder();
		
		sentenciaSQL.append("UPDATE Empresa SET nombre = ?, nit = ?, telefono = ?, correo = ?, direccion = ?, ciudad = ? WHERE id = ?");
		
		try(var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())){
			
			sentenciaPreparada.setString(1, entity.getNombre());
			sentenciaPreparada.setInt(2, entity.getNit());
			sentenciaPreparada.setInt(3, entity.getTelefono());
			sentenciaPreparada.setString(4, entity.getCorreo());
			sentenciaPreparada.setString(5,  entity.getDireccion());
			sentenciaPreparada.setObject(6, entity.getCiudad().getId());
			sentenciaPreparada.setObject(7, id);
			sentenciaPreparada.executeUpdate();
			
		} catch (SQLException exception) {
			var mensajeUsuario="Se ha presentado un problema tratando de actualizar la información de una empresa con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción de tipo SQLexception tratando de hacer un UPDATE en la tabla Empresa,  para tener más detalles revise el log de errores";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de actualizar la información de una empresa con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un UPDATE en la tabla Empresa";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}
		
	}

	@Override
	public void delete(UUID id) throws LilfacException {
		var sentenciaSQL = new StringBuilder();
		
		sentenciaSQL.append("DELETE FROM Empresa WHERE id = ?");
		
		try(var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())){
			
			sentenciaPreparada.setObject(1, id);
			sentenciaPreparada.executeUpdate();
			
		} catch (SQLException exception) {
			var mensajeUsuario="Se ha presentado un problema tratando de eliminar la información de una empresa con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción de tipo SQLexception tratando de hacer un DELETE en la tabla Empresa,  para tener más detalles revise el log de errores";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}catch (Exception exception) {
			var mensajeUsuario="Se ha presentado un problema INESPERADO tratando de eliminar la información de una empresa con el identificador ingresado";
			var mensajeTecnico="Se presentó una excepción NO CONTROLADA de tipo Exception tratando de hacer un DELETE en la tabla Empresa";
			
			throw DataLilfacException.reportar(mensajeUsuario, mensajeTecnico, exception);
		}
		
	}

}
