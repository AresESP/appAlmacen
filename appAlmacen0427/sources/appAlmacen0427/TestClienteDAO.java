package appAlmacen0427;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.feliz.almacen.api.dao.IClienteDAO;
import org.feliz.almacen.api.dao.mariadb.MariaDBFactoryDAO;
import org.feliz.almacen.api.modelo.Cliente;
import org.feliz.almacen.api.modelo.ICliente;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestClienteDAO {
	public static DataSource dataSource;
	public static IClienteDAO clienteDAO;
	public static ICliente clientePrueba;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		MariaDBFactoryDAO mariaDB = new MariaDBFactoryDAO();
		dataSource = mariaDB.getDataSource();
		clienteDAO = mariaDB.getClienteDAO();
		clienteDAO.setDataSource(dataSource);
		clientePrueba = new Cliente(null, "Test", "Test", "Test", "000000000", "000000000");
	}

	@Test
	public void test() {
		long idCliente = clienteDAO.save(clientePrueba);
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * from cliente where idCliente=?");
			statement.setLong(1, idCliente);
			ResultSet result = statement.executeQuery();
			result.next();
			assertEquals("Nombre en cliente distinto al introducido", clientePrueba.getNombre(), result.getString("nombre"));
			assertEquals("Apellido1 en cliente distinto al introducido", clientePrueba.getApelido1(), result.getString("apellido1"));
			assertEquals("Apellido2 en cliente distinto al introducido", clientePrueba.getApelido2(), result.getString("apellido2"));
			assertEquals("NIF en cliente distinto al introducido", clientePrueba.getNif(), result.getString("DNI"));
			assertEquals("Telefono en cliente distinto al introducido", clientePrueba.getTelefono(), result.getString("telefono"));
			result.close();
			statement.close();
			statement = connection.prepareStatement("DELETE from cliente where idCliente=?");
			statement.setLong(1, idCliente);
			assertTrue(statement.executeUpdate() == 1);
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
