package fiuba.algo3.test;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import fiuba.algo3.modelo.Algomon;
import fiuba.algo3.modelo.Salud;
import fiuba.algo3.modelo.estadosDeAlgomon.Dormido;
import fiuba.algo3.modelo.estadosDeAlgomon.Efecto;
import fiuba.algo3.modelo.estadosDeAlgomon.Quemado;
import fiuba.algo3.modelo.excepciones.AtacarDormidoNoPuedeRealizarseException;
import fiuba.algo3.modelo.tiposDeAlgomon.Tipo;
import fiuba.algo3.modelo.tiposDeAlgomon.TipoPlanta;

public class DormidoTest {

	@Test(expected = AtacarDormidoNoPuedeRealizarseException .class)
	public void testEfectoDormirProduceUnaExcepcion(){
	
		Algomon venusaur = new Algomon("Venusaur", new TipoPlanta(), null, new Salud(400));
		
		Efecto dormido = new Dormido();
		
		dormido.aplicarEfecto(venusaur);
		
	}
	
}
