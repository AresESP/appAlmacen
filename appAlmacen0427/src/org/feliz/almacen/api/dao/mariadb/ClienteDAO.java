package org.feliz.almacen.api.dao.mariadb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.feliz.almacen.api.dao.ConnectionManager;
import org.feliz.almacen.api.dao.IClienteDAO;
import org.feliz.almacen.api.modelo.Cliente;
import org.feliz.almacen.api.modelo.ICliente;

public class ClienteDAO extends ConnectionManager implements IClienteDAO {
	private static final String DELETE_SQL = "DELETE from cliente where idCliente=?";
	private static final String SELECT_SQL = "SELECT * from cliente";
	private static final String SELECT_SQL_WHERE = "SELECT * from cliente where idCliente=?";
	private static final String UPDATE_SQL = "UPDATE cliente set nif=?, telefono=?, nombre=?, apellido1=?, apellido2=? where idCliente=?";
	private static final String INSERT_SQL = "INSERT into cliente(nombre, apellido1, apellido2, nif, telefono) values(?, ?, ?, ?, ?)";
	
	private static final String CLASS_NAME = ClienteDAO.class.getCanonicalName();
	
	private static final Logger logger = Logger.getLogger("ClienteDAO_Logger");
	
	@Override
	public boolean update(ICliente instance) {
		logger.entering(CLASS_NAME, "update", instance);
		boolean result = false;
		try (
			Connection connection = this.getConnection();
			PreparedStatement statement = connection.prepareStatement(UPDATE_SQL);
		){
			if (connection != null) {
				logger.info("Connection is not null and statement has been made");
				statement.setString(1, instance.getNif());
				statement.setString(2, instance.getTelefono());
				statement.setString(3, instance.getNombre());
				statement.setString(4, instance.getApelido1());
				statement.setString(5, instance.getApelido2());
				statement.setString(6, instance.getClienteId());
				if (statement.executeUpdate() == 1) {
					logger.fine("SQL Update has been successfully executed");
					result = true;
				}		
			}
		} catch (SQLException e) {
			logger.severe("Unnable to execute the update, connection or statement may be null. 'Telefono' or 'DNI' may already exist in database");
		}
		return result;
	}

	@Override
	public long save(ICliente entity) {
		long result = -1;
		try {
			Connection connection = this.getConnection();
			if (connection != null) {
				PreparedStatement statement = connection
						.prepareStatement(INSERT_SQL, PreparedStatement.RETURN_GENERATED_KEYS);
				statement.setString(1, entity.getNombre());
				statement.setString(2, entity.getApelido1());
				statement.setString(3, entity.getApelido2());
				statement.setString(4, entity.getNif());
				statement.setString(5, entity.getTelefono());
				if(statement.executeUpdate() == 1) {
					ResultSet resultSet = statement.getGeneratedKeys();
					resultSet.next();
					result = resultSet.getLong("insert_id");
					resultSet.close();			
				}
				statement.close();
				connection.close();				
			}	
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<ICliente> findByID(String String) {
		List<ICliente> resultado = new ArrayList<>();
		try {
			Connection connection = this.getConnection();
			if (connection != null) {
				PreparedStatement statement = 
						connection.prepareStatement(SELECT_SQL_WHERE);
				statement.setLong(1, Long.parseLong(String));
				ResultSet resultSet = statement.executeQuery();
				resultSet.beforeFirst();
				while(resultSet.next()) {
					resultado.add(
							new Cliente(
									resultSet.getString(1),
									resultSet.getString(2),
									resultSet.getString(3),
									resultSet.getString(4),
									resultSet.getString(5),
									resultSet.getString(6)
									)
							);
				}
				resultSet.close();
				statement.close();
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Unable to read results");
		}		
		return resultado;
	}

	@Override
	public boolean delete(ICliente instance) {
		boolean result = false;
		try {
			Connection connection = this.getConnection();
			PreparedStatement statement = connection
					.prepareStatement(DELETE_SQL);
			statement.setLong(1, Long.parseLong(instance.getClienteId()));
			result = statement.executeUpdate() == 1;
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;	
	}

	@Override
	public double getFacturacionAnual(int year) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ICliente> getAll() {
		List<ICliente> resultado = new ArrayList<>();
		try {
			Connection connection = this.getConnection();
			if (connection != null) {
				PreparedStatement statement = 
						connection.prepareStatement(SELECT_SQL);
				ResultSet resultSet = statement.executeQuery();
				resultSet.beforeFirst();
				while(resultSet.next()) {
					resultado.add(
							new Cliente(
									resultSet.getString(1),
									resultSet.getString(2),
									resultSet.getString(3),
									resultSet.getString(4),
									resultSet.getString(5),
									resultSet.getString(6)
									)
							);
				}
				resultSet.close();
				statement.close();
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Unable to read results");
		}		
		return resultado;
	}

	@Override
	public List<ICliente> findByExample(ICliente instance) {
		Connection connection = this.getConnection();
		if(connection != null) {
			try {
				String sqlSentence = "SELECT * from cliente where";
				
				//Completamos el where con los campos no nulos
				sqlSentence = sqlSentence + 
						(instance.getClienteId() != null ? sqlSentence+" idCliente=? AND" : "");
				sqlSentence = sqlSentence + 
						(instance.getNif() != null ? sqlSentence+" DNI=? AND" : "");
				sqlSentence = sqlSentence + 
						(instance.getNombre() != null ? sqlSentence+" nombre=? AND" : "");
				sqlSentence = sqlSentence + 
						(instance.getApelido1() != null ? sqlSentence+" apellido1=? AND" : "");	
				sqlSentence = sqlSentence + 
						(instance.getApelido2() != null ? sqlSentence+" apellido2=? AND" : "(apellido2 like '%' OR apellido2=null)");				
				sqlSentence = sqlSentence + 
						(instance.getTelefono() != null ? sqlSentence+" telefono=?" : "");
				
				//Si nos ha quedado un AND al final lo borramos
				if(sqlSentence.substring(sqlSentence.length()-3).equals("AND")) {
					sqlSentence = sqlSentence.substring(0, sqlSentence.length()-3);
				}
				
				PreparedStatement statement = connection.prepareStatement(sqlSentence);
				
				statement.execute(sqlSentence);
				ResultSet results = statement.getResultSet();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
}
