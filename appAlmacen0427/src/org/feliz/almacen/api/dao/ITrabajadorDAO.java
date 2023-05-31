package org.feliz.almacen.api.dao;

import org.feliz.almacen.api.modelo.ITrabajador;

public interface ITrabajadorDAO extends IGenericDAO<ITrabajador, String>{
	public double getSueldoAnual(ITrabajador instance);
}
