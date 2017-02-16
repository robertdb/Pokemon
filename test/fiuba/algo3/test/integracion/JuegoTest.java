package fiuba.algo3.test.integracion;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.modelo.EspecieAlgomon;
import fiuba.algo3.modelo.Juego;
import fiuba.algo3.modelo.ataques.NombreDelAtaque;
import fiuba.algo3.modelo.jugadores.Jugador;

public class JuegoTest {

	@Test
	public void testPartidaCompleta() {
	
		Jugador player1 = new Jugador("player 1");
		
		Jugador player2 = new Jugador("player 2");
		
		player1.ingresarAlgomon(EspecieAlgomon.BULBASOUR);
		
		player2.ingresarAlgomon(EspecieAlgomon.SQUIRTLE);
		
		player1.ingresarAlgomon(EspecieAlgomon.CHANSEY);
		
		player2.ingresarAlgomon(EspecieAlgomon.JIGGLYPUFF);
		
		player1.ingresarAlgomon(EspecieAlgomon.RATTATA);
		
		player2.ingresarAlgomon(EspecieAlgomon.CHARMANDER);
		
		Juego juego = Juego.getInstance();
		
		juego.ingresarJugador(player1);
		
		juego.ingresarJugador(player2);
		
		juego.comenzarJuego();
		
		juego.getJugadorActual().atacarConAlgomonActivo(NombreDelAtaque.ATAQUE_RAPIDO, 
														juego.getJugadorRival(), juego);
		
		
		juego.getJugadorActual().atacarConAlgomonActivo(NombreDelAtaque.ATAQUE_RAPIDO, 
														juego.getJugadorRival(), juego);
		
		
		juego.getJugadorActual().atacarConAlgomonActivo(NombreDelAtaque.ATAQUE_RAPIDO, 
														juego.getJugadorRival(), juego);
		
		juego.getJugadorActual().atacarConAlgomonActivo(NombreDelAtaque.ATAQUE_RAPIDO, 
														juego.getJugadorRival(), juego);
	
	}

}
