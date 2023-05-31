package org.feliz.almacen.api.dao.mariadb;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDataSource;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.feliz.almacen.api.configuracion.ConfigApp;
import org.feliz.almacen.api.dao.IClienteDAO;
import org.feliz.almacen.api.dao.ICompraDAO;
import org.feliz.almacen.api.dao.IProductoDAO;
import org.feliz.almacen.api.dao.ITrabajadorDAO;
import org.feliz.almacen.api.dao.ProducerAbstractFactoryDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class MariaDBFactoryDAO extends ProducerAbstractFactoryDAO{
	Logger logger = LoggerFactory.getLogger(MariaDBFactoryDAO.class);
	
	@Override
	public IClienteDAO getClienteDAO() {
		IClienteDAO resultado = new ClienteDAO();
		resultado.setDataSource(getDataSource());
		return resultado;
	}

	@Override
	public ITrabajadorDAO getTrabajadorDAO() {
		ITrabajadorDAO resultado = new TrabajadorDAO();
		resultado.setDataSource(getDataSource());
		return resultado;
	}

	@Override
	public IProductoDAO getProductoDAO() {
		IProductoDAO resultado = new ProductoDAO();
		resultado.setDataSource(getDataSource());
		return resultado;
	}

	@Override
	public ICompraDAO getCompraDAO() {
		ICompraDAO resultado = new CompraDAO();
		resultado.setDataSource(getDataSource());
		return resultado;
	}
	
	@Override
	public DataSource getDataSource() {
		ConfigApp config = ConfigApp.getInstance();
		DataSource dataSource = null;
		if (config.isDataBaseWebServerPool()) {
			try {
				Context initCtx = new InitialContext();
				Context envCtx = (Context) initCtx.lookup("java:comp/env");
				dataSource = (DataSource)envCtx.lookup("java:comp/env/jdbc/AlmacenDB");
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		} else {
			ConnectionFactory connectionFactory = 
					new DriverManagerConnectionFactory(
							config.getDataBaseConnectionURI(),
							config.getDataBaseUser(),
							config.getDataBaseUserPwd());
			PoolableConnectionFactory poolableConnectionFactory =
					new PoolableConnectionFactory(connectionFactory, null);
			ObjectPool<PoolableConnection> connectionPool =
					new GenericObjectPool<>(poolableConnectionFactory);
			poolableConnectionFactory.setPool(connectionPool);
			dataSource = new PoolingDataSource<PoolableConnection>(connectionPool);
		}
		return dataSource;
	}
}
