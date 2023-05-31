package org.feliz.almacen.api.configuracion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigApp extends Configuration {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(ConfigApp.class);

	static ConfigApp instance;

	/**
	 * 
	 */
	public ConfigApp() {
		// TODO Auto-generated constructor stub
	}

	public static final ConfigApp getInstance() {

		logger.debug("Inicio");

		if (instance == null) {
			instance = new ConfigApp();

			String mruta = System.getProperty(APP_CONFIG_FILE_KEY, PATH_CONFIGURATION);
			
						
			logger.info("mruta: " + mruta);

			instance.loadProperties(mruta);

		}

		logger.debug("Final");

		return instance;
	}

	public String getDataBaseUserPwd() {

		return getProperty(DB_USER_PWD);
	}

	public String getDataBaseUser() {

		return getProperty(DB_USER);
	}

	public String getDataBaseConnectionURI() {

		return getProperty(DB_CONNECTION_URI);
	}

	public boolean isDataBaseWebServerPool() {

		return getPropertyBoolean(DB_CONNECTION_WEB_SERVER_DS, "false");
		

	}

	public boolean isModCLI() {
		return getPropertyBoolean(KEY_MOD_CLI, String.valueOf(DEFAULT_MOD_CLI));
	}

	public void setModCLI(boolean mod) {

		setPropertyString(KEY_MOD_CLI, String.valueOf(mod));
	}

}
