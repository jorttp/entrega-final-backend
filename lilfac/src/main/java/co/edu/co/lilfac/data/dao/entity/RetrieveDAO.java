package co.edu.co.lilfac.data.dao.entity;

import java.util.List;

public interface RetrieveDAO<E, ID> {
	
	List<E> listByFIlter(E filter);
	
	List<E> listAll();
	
	E listById(ID id);
	

}
