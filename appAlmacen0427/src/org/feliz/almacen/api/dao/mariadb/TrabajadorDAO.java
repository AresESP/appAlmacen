package org.feliz.almacen.api.dao.mariadb;

import java.sql.Connection;
import java.util.List;

import org.feliz.almacen.api.dao.ConnectionManager;
import org.feliz.almacen.api.dao.ITrabajadorDAO;
import org.feliz.almacen.api.modelo.ITrabajador;

public class TrabajadorDAO extends ConnectionManager implements ITrabajadorDAO {

	@Override
	public boolean update(ITrabajador instance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long save(ITrabajador entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ITrabajador> findByID(String String) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(ITrabajador instance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getSueldoAnual(ITrabajador instance) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ITrabajador> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ITrabajador> findByExample(ITrabajador instance) {
		// TODO Auto-generated method stub
		return null;
	}



}
