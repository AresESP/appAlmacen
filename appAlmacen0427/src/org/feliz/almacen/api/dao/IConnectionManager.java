package org.feliz.almacen.api.dao;

import javax.sql.DataSource;

public interface IConnectionManager {
	public boolean setDataSource(DataSource dataSource);
}
