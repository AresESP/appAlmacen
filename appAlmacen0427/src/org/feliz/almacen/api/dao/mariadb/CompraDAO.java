package org.feliz.almacen.api.dao.mariadb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.feliz.almacen.api.dao.ConnectionManager;
import org.feliz.almacen.api.dao.ICompraDAO;
import org.feliz.almacen.api.modelo.ICompra;

public class CompraDAO extends ConnectionManager implements ICompraDAO {

	
	@Override
	public boolean update(ICompra instance) {
		boolean result = false;
		try {
			Connection connection = this.getConnection();
			if (connection != null) {
				PreparedStatement statement = connection
						.prepareStatement("UPDATE compra set fechaCompra=?, precioTotal=?");
				statement.setDate(1, instance.getFechaCompra());
				statement.setDouble(2, instance.getPrecioTotal());
				result = statement.executeUpdate() == 1;
				connection.close();				
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;
	}

	@Override
	public long save(ICompra entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ICompra> findByID(String String) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(ICompra instance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double getTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ICompra> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ICompra> findByExample(ICompra instance) {
		// TODO Auto-generated method stub
		return null;
	}
}
