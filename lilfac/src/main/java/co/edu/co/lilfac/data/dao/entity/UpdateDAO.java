package co.edu.co.lilfac.data.dao.entity;

public interface UpdateDAO<E, ID> {
	
	void update(ID id, E entity);

}
