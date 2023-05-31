package appAlmacen0427;

import static org.junit.Assert.*;

import org.feliz.almacen.api.MotorApiServicioNegocio;
import org.junit.Test;

public class TestMotorApiServicioNegocio {

	@Test
	public void test() {
		MotorApiServicioNegocio api = new MotorApiServicioNegocio();
		assertNotNull("MotorApi devuelve nulo", api.listaClientes());
		assertTrue(api.listaClientes().size()>0);
	}

}
