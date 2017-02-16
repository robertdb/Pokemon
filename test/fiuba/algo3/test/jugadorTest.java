package fiuba.algo3.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import fiuba.algo3.modelo.Algomon;
import fiuba.algo3.modelo.EspecieAlgomon;
import fiuba.algo3.modelo.Juego;
import fiuba.algo3.modelo.ataques.NombreDelAtaque;
import fiuba.algo3.modelo.elementos.Elemento;
import fiuba.algo3.modelo.elementos.TipoElemento;
import fiuba.algo3.modelo.excepciones.CantidadDeAtaquesAgotadosException;
import fiuba.algo3.modelo.excepciones.JugadorNoTieneUnAlgomonParaJugarError;
import fiuba.algo3.modelo.excepciones.NoSePuedeAplicarUnElementoSiNoEsElTurnoDelJugadorError;
import fiuba.algo3.modelo.excepciones.NoSePuedeAtacarConAlgomonSiNoEsElTurnoDelJugadorError;
import fiuba.algo3.modelo.excepciones.NoSePuedeCambiarAlAlgomonSiNoEsElTurnoDelJugadorError;
import fiuba.algo3.modelo.excepciones.NoSePuedenIngresarMasAlgomonesError;
import fiuba.algo3.modelo.jugadores.Jugador;
import fiuba.algo3.modelo.jugadores.JugadorPasivo;

public class jugadorTest {

	
	@Test(expected = NoSePuedenIngresarMasAlgomonesError.class)
	public void testJugadorNoPuedeTenerAlgomones() {
		
		Jugador jugador = new Jugador("pepe");
		
		jugador.ingresarAlgomon(EspecieAlgomon.RATTATA);
		jugador.ingresarAlgomon(EspecieAlgomon.CHARMANDER);
		jugador.ingresarAlgomon(EspecieAlgomon.BULBASOUR);
		jugador.ingresarAlgomon(EspecieAlgomon.CHANSEY);
		
		jugador.cambiarAlgomon(EspecieAlgomon.CHARMANDER, null);
			
	}
	
	@Test(expected = NoSePuedeCambiarAlAlgomonSiNoEsElTurnoDelJugadorError.class)
	public void testNoSePuedeCambiarAlAlgomonSiNoEsElTurnoDelJugadorError() {
			
		Jugador jugador = new Jugador("pepe");
		
		jugador.ingresarAlgomon(EspecieAlgomon.RATTATA);
		jugador.ingresarAlgomon(EspecieAlgomon.CHARMANDER);
		jugador.ingresarAlgomon(EspecieAlgomon.BULBASOUR);
		
		jugador.cambiarAlgomon(EspecieAlgomon.CHARMANDER, null);
				
	}
	
	@Test(expected = NoSePuedeAtacarConAlgomonSiNoEsElTurnoDelJugadorError.class)
	public void testNoSePuedeAtacarConAlgomonSiNoEsElTurnoDelJugadorError() {
			
		Jugador jugador = new Jugador("pepe");
		
		jugador.ingresarAlgomon(EspecieAlgomon.RATTATA);
		jugador.ingresarAlgomon(EspecieAlgomon.CHARMANDER);
		jugador.ingresarAlgomon(EspecieAlgomon.BULBASOUR);
		
		jugador.atacarConAlgomonActivo(NombreDelAtaque.ATAQUE_RAPIDO, new Jugador("juan"), null);
				
	}
	
	@Test(expected = NoSePuedeAplicarUnElementoSiNoEsElTurnoDelJugadorError.class)
	public void testNoSePuedeAplicarUnElementoSiNoEsElTurnoDelJugadorError() {
			
		Jugador jugador = new Jugador("pepe");
		
		jugador.ingresarAlgomon(EspecieAlgomon.RATTATA);
		jugador.ingresarAlgomon(EspecieAlgomon.CHARMANDER);
		jugador.ingresarAlgomon(EspecieAlgomon.BULBASOUR);
		
		jugador.aplicarElemento(TipoElemento.SUPERPOCION, null);
				
	}
	
	
	
	
	
	
	

}
