package org.feliz.almacen.api.dao;

import javax.sql.DataSource;

public interface IFactoryDAO {
	IClienteDAO getClienteDAO();
	ITrabajadorDAO getTrabajadorDAO();
	IProductoDAO getProductoDAO();
	ICompraDAO getCompraDAO();

	DataSource getDataSource();
}
