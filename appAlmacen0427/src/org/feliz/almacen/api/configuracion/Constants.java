package org.feliz.almacen.api.configuracion;

import java.io.Serializable;

public interface Constants extends Serializable{
	public static final String PATH_CONFIGURATION = "configuration.properties";
	public static final String APP_CONFIG_FILE_KEY = "appConfigFile";	
	
	public static final String DB_USER = "root";
	public static final String DB_USER_PWD = "1234";
	public static final String DB_CONNECTION_URI = "jdbc:mariadb://localhost:3306/";
	public static final String DB_CONNECTION_WEB_SERVER_DS = "database.DB_CONNECTION_WEB_SERVER_DS";
	public static String KEY_MOD_CLI = "Mod_CLI";
	public static boolean DEFAULT_MOD_CLI = false;
}
