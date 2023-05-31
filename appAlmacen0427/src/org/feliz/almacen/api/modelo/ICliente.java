package org.feliz.almacen.api.modelo;

public interface ICliente {
	public String getClienteId();
	public String getNif();
	public String getTelefono();
	public String getNombre();
	public String getApelido1();
	public String getApelido2();
	public String toString();
	
	public void setClienteId(String id);
}
