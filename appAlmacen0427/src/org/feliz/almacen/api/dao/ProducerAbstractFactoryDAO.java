package org.feliz.almacen.api.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.feliz.almacen.api.dao.mariadb.MariaDBFactoryDAO;

public abstract class ProducerAbstractFactoryDAO  implements IFactoryDAO{	
	private enum FactoryDAO{MARIADB, POSTGRE, MYSQL};
	
	public static IFactoryDAO getFactoryDAO() throws IllegalArgumentException {
		FactoryDAO whichFactoryDAO = getPropertieFactoryDAO();
		switch (whichFactoryDAO) {
			case MARIADB:
				return new MariaDBFactoryDAO();
				
			/*case POSTGRE:
				factoryDAO = new PostgreFactoryDAO;	
				
			case MYSQL:
				factoryDAO = new MySQLFactoryDAO;*/
			default:
				return new MariaDBFactoryDAO();
		}
	}
	
	private static FactoryDAO getPropertieFactoryDAO() {
		Properties config = new Properties();
		try {
			config.load(new FileInputStream("resources\\config.props"));
			return FactoryDAO.valueOf(config.getProperty("FactoryDAO"));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return FactoryDAO.MARIADB;
	}
}
