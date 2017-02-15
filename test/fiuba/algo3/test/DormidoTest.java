package fiuba.algo3.test;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import fiuba.algo3.algomones.Algomon;
import fiuba.algo3.algomones.Salud;
import fiuba.algo3.algomones.estadosDeAlgomon.Dormido;
import fiuba.algo3.algomones.estadosDeAlgomon.Efecto;
import fiuba.algo3.algomones.estadosDeAlgomon.Quemado;
import fiuba.algo3.algomones.excepciones.AtacarDormidoNoPuedeRealizarseException;
import fiuba.algo3.algomones.tiposDeAlgomon.Tipo;
import fiuba.algo3.algomones.tiposDeAlgomon.TipoPlanta;

public class DormidoTest {

	@Test(expected = AtacarDormidoNoPuedeRealizarseException .class)
	public void testEfectoDormirProduceUnaExcepcion(){
	
		Algomon venusaur = new Algomon("Venusaur", new TipoPlanta(), null, new Salud(400));
		
		Efecto dormido = new Dormido();
		
		dormido.aplicarEfecto(venusaur);
		
	}
	
}
