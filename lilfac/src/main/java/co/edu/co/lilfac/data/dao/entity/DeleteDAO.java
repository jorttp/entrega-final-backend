package co.edu.co.lilfac.data.dao.entity;

import java.util.UUID;

import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;

public interface DeleteDAO<ID> {

	void delete(UUID id)throws LilfacException;
	

}
