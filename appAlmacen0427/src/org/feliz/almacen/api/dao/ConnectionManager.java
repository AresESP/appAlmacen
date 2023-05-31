package org.feliz.almacen.api.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

public abstract class ConnectionManager implements IConnectionManager{
	protected DataSource dataSource = null;
	private Connection connection = null;
	
	@Override
	public boolean setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		return this.dataSource != null;
	}
	
	protected boolean setConnection(Connection connection) {
		this.connection = connection;
		return this.connection != null;
	}
	
	protected Connection getConnection() {
		try {
			if(this.connection == null || this.connection.isClosed()) {
				this.setConnection(this.dataSource.getConnection());
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.connection;
	}	
	
	public DataSource getDataSource() {
		return this.dataSource;
	}	
}
