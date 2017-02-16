package fiuba.algo3.test;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.modelo.Algomon;
import fiuba.algo3.modelo.Salud;
import fiuba.algo3.modelo.estadosDeAlgomon.Dormido;
import fiuba.algo3.modelo.estadosDeAlgomon.Efecto;
import fiuba.algo3.modelo.estadosDeAlgomon.Quemado;
import fiuba.algo3.modelo.excepciones.AtacarDormidoNoPuedeRealizarseException;
import fiuba.algo3.modelo.tiposDeAlgomon.Tipo;
import fiuba.algo3.modelo.tiposDeAlgomon.TipoPlanta;

public class QuemadoTest {

	@Test
	public void testEfectoQuemadoQuita10PorcientoDeVidaOriginal(){

		Efecto quemado = new Quemado();
		
		Salud salud = new Salud(400);
		
		Algomon venusaur = new Algomon("Venusaur", new TipoPlanta(), null, salud);
		
		quemado.aplicarEfecto(venusaur);
		
		assertEquals(360,venusaur.salud(),0.001D);
				
	}
	
	

}
