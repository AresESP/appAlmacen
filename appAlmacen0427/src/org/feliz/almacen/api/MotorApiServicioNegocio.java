package org.feliz.almacen.api;

import java.util.List;

import javax.sql.DataSource;

import org.feliz.almacen.api.dao.IClienteDAO;
import org.feliz.almacen.api.dao.ProducerAbstractFactoryDAO;
import org.feliz.almacen.api.modelo.ICliente;

public class MotorApiServicioNegocio {
	private static IClienteDAO clienteDAO = ProducerAbstractFactoryDAO.getFactoryDAO().getClienteDAO();
	
	public MotorApiServicioNegocio() {}
	
	public MotorApiServicioNegocio(DataSource dataSource) {
		clienteDAO.setDataSource(dataSource);
	}
	
	public List<ICliente> getClientesById(String id) {
		List<ICliente> clientes= clienteDAO.findByID(id);
		return clientes;
	}
	
	public long saveCliente(ICliente cliente) {
		long idCliente = clienteDAO.save(cliente);
		cliente.setClienteId(String.valueOf(idCliente));
		return idCliente;
	}

	public List<ICliente> listaClientes() {
		List<ICliente> clientes = clienteDAO.getAll();
		return clientes;
	}
	
	public boolean updateCliente(ICliente cliente) {
		return clienteDAO.update(cliente);
	}
	
	public boolean borrarCliente(String idCliente) {
		return clienteDAO.delete(clienteDAO.findByID(idCliente).get(0));		
	}
	
	public void setDataSource(DataSource dataSource) {
		clienteDAO.setDataSource(dataSource);		
	}
}
