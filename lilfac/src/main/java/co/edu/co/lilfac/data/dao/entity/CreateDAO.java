package co.edu.co.lilfac.data.dao.entity;

import co.edu.co.lilfac.crosscutting.excepciones.LilfacException;

public interface CreateDAO<E> {
	
	void create(E entity)throws LilfacException;

}
