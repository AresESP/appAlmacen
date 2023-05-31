package org.feliz.almacen.api.modelo;

public class Cliente implements ICliente{
	private String clienteId, nombre, apelido1, apelido2, nif, telefono;

	public Cliente(String clienteId, String nombre, String apelido1, String apelido2, String nif, String telefono) {
		this.clienteId = clienteId;
		this.nombre = nombre;
		this.apelido1 = apelido1;
		this.apelido2 = apelido2;
		this.nif = nif;
		this.telefono = telefono;
	}

	public String getClienteId() {
		return clienteId;
	}

	@Override
	public void setClienteId(String clienteId) {
		this.clienteId = clienteId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApelido1() {
		return apelido1;
	}

	public void setApelido1(String apelido1) {
		this.apelido1 = apelido1;
	}

	public String getApelido2() {
		return apelido2;
	}

	public void setApelido2(String apelido2) {
		this.apelido2 = apelido2;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Cliente [clienteId=" + clienteId + ", nombre=" + nombre + ", apelido1=" + apelido1 + ", apelido2="
				+ apelido2 + ", nif=" + nif + ", telefono=" + telefono + "]";
	}
}
