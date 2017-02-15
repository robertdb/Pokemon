package fiuba.algo3.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import fiuba.algo3.algomones.Algomon;
import fiuba.algo3.algomones.EspecieAlgomon;
import fiuba.algo3.algomones.ataques.NombreDelAtaque;
import fiuba.algo3.algomones.elementos.Elemento;
import fiuba.algo3.algomones.elementos.TipoElemento;
import fiuba.algo3.algomones.excepciones.CantidadDeAtaquesAgotadosException;
import fiuba.algo3.algomones.excepciones.JugadorNoTieneUnAlgomonParaJugarError;
import fiuba.algo3.algomones.excepciones.NoSePuedeAplicarUnElementoSiNoEsElTurnoDelJugadorError;
import fiuba.algo3.algomones.excepciones.NoSePuedeAtacarConAlgomonSiNoEsElTurnoDelJugadorError;
import fiuba.algo3.algomones.excepciones.NoSePuedeCambiarAlAlgomonSiNoEsElTurnoDelJugadorError;
import fiuba.algo3.algomones.excepciones.NoSePuedenIngresarMasAlgomonesError;
import fiuba.algo3.algomones.jugadores.Jugador;
import fiuba.algo3.algomones.jugadores.JugadorPasivo;

public class jugadorTest {

	
	@Test(expected = NoSePuedenIngresarMasAlgomonesError.class)
	public void testJugadorNoPuedeTenerAlgomones() {
		
		Jugador jugador = new Jugador("pepe");
		
		jugador.ingresarAlgomon(EspecieAlgomon.RATTATA);
		jugador.ingresarAlgomon(EspecieAlgomon.CHARMANDER);
		jugador.ingresarAlgomon(EspecieAlgomon.BULBASOUR);
		jugador.ingresarAlgomon(EspecieAlgomon.CHANSEY);
		
		jugador.cambiarAlgomon(EspecieAlgomon.CHARMANDER);
			
	}
	
	@Test(expected = NoSePuedeCambiarAlAlgomonSiNoEsElTurnoDelJugadorError.class)
	public void testNoSePuedeCambiarAlAlgomonSiNoEsElTurnoDelJugadorError() {
			
		Jugador jugador = new Jugador("pepe");
		
		jugador.ingresarAlgomon(EspecieAlgomon.RATTATA);
		jugador.ingresarAlgomon(EspecieAlgomon.CHARMANDER);
		jugador.ingresarAlgomon(EspecieAlgomon.BULBASOUR);
		
		jugador.cambiarAlgomon(EspecieAlgomon.CHARMANDER);
				
	}
	
	@Test(expected = NoSePuedeAtacarConAlgomonSiNoEsElTurnoDelJugadorError.class)
	public void testNoSePuedeAtacarConAlgomonSiNoEsElTurnoDelJugadorError() {
			
		Jugador jugador = new Jugador("pepe");
		
		jugador.ingresarAlgomon(EspecieAlgomon.RATTATA);
		jugador.ingresarAlgomon(EspecieAlgomon.CHARMANDER);
		jugador.ingresarAlgomon(EspecieAlgomon.BULBASOUR);
		
		jugador.atacarConAlgomonActivo(NombreDelAtaque.ATAQUE_RAPIDO, new Jugador("juan"));
				
	}
	
	@Test(expected = NoSePuedeAplicarUnElementoSiNoEsElTurnoDelJugadorError.class)
	public void testNoSePuedeAplicarUnElementoSiNoEsElTurnoDelJugadorError() {
			
		Jugador jugador = new Jugador("pepe");
		
		jugador.ingresarAlgomon(EspecieAlgomon.RATTATA);
		jugador.ingresarAlgomon(EspecieAlgomon.CHARMANDER);
		jugador.ingresarAlgomon(EspecieAlgomon.BULBASOUR);
		
		jugador.aplicarElemento(TipoElemento.SUPERPOCION);
				
	}
	
	@Test(expected = JugadorNoTieneUnAlgomonParaJugarError .class)
	public void testJugadorNoTieneUnAlgomonParaJugarError () {
			
		Jugador jugador = new Jugador("pepe");
		
		jugador.esSuTurno();
		
		jugador.aplicarElemento(TipoElemento.SUPERPOCION);
				
	}
	
	
	
	
	
	

}
