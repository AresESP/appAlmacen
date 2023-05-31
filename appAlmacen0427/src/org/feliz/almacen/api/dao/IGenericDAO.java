package org.feliz.almacen.api.dao;

import java.util.List;

public interface IGenericDAO<T, ID> extends IConnectionManager{
	public boolean update(T instance);
	public long save(T entity);
	public List<T> findByID(ID String);
	public boolean delete(T instance);
	public List<T> getAll();
	public List<T> findByExample(T instance);
}
