package org.feliz.almacen.api.dao.mariadb;

import java.sql.Connection;
import java.util.List;

import org.feliz.almacen.api.dao.ConnectionManager;
import org.feliz.almacen.api.dao.IProductoDAO;
import org.feliz.almacen.api.modelo.IProducto;

public class ProductoDAO extends ConnectionManager implements IProductoDAO {

	@Override
	public boolean update(IProducto instance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long save(IProducto entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<IProducto> findByID(String String) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(IProducto instance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IProducto getMasRentable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IProducto> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IProducto> findByExample(IProducto instance) {
		// TODO Auto-generated method stub
		return null;
	}



}
