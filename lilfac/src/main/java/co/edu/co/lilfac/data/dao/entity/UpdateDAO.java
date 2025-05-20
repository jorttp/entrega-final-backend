package co.edu.co.lilfac.data.dao.entity;

import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;

public interface UpdateDAO<E, ID> {
	
	void update(ID id, E entity)throws LilfacException;

}
