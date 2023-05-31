package org.feliz.almacen;

import org.feliz.almacen.api.MotorApiServicioNegocio;

public class ProbaExecucion {
	public static void main(String[] args) {
		MotorApiServicioNegocio api = new MotorApiServicioNegocio();
		System.out.println("Clientes: " + api.getClientesById("1"));
		
	}
}
