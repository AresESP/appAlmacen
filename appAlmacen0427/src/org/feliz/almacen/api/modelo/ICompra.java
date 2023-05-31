package org.feliz.almacen.api.modelo;

import java.sql.Date;

public interface ICompra {
	public String getIdCompra();
	public String getIdVendedor();
	public String getIdCliente();
	public Date getFechaCompra();
	public double getPrecioTotal();
}
