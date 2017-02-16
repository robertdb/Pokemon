package fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import fiuba.algo3.controlador.interfaz.Ventana;
import fiuba.algo3.modelo.excepciones.AlgomonesDeJugadorMuertosExeption;
import fiuba.algo3.modelo.excepciones.JuegoNecesitaDosJugadoresParaComenzarError;
import fiuba.algo3.modelo.excepciones.NoSePuedenIngresarMasDeDosJugadoresError;
import fiuba.algo3.modelo.jugadores.Jugador;
import fiuba.algo3.modelo.jugadores.TipoJugador;

// Singleton
public class Juego {
	
	
	private static Juego instance = new Juego();
	   
	private List<Jugador> jugadores = new ArrayList<Jugador>();
	   
	private final int maximoDeJugadores = 2;
	
	private TipoJugador jugadorActivo;
	
	private Jugador ganador = null;
 
    private Juego(){}
    
    public static Juego getInstance(){
       return instance;
    }
	   
	public void ingresarJugador(Jugador jugador){
	
		if(jugadores.size() == maximoDeJugadores)
			throw new NoSePuedenIngresarMasDeDosJugadoresError();
		
		jugadores.add(jugador);
		
	}
		
	public void comenzarJuego(){
		
		if(jugadores.size() > maximoDeJugadores)
			throw new  JuegoNecesitaDosJugadoresParaComenzarError();
		
		Random random = new Random();
		
		if (random.nextBoolean()) 
			jugadorActivo = TipoJugador.JUGADOR1;
		else
			jugadorActivo = TipoJugador.JUGADOR1.getRival();
		
		jugadores.get(jugadorActivo.getIndice()).esSuTurno();
			
	}

	public Jugador getJugadorActual(){
		
		return jugadores.get(jugadorActivo.getIndice());
		
	}
	public void jugadaTerminada(){
		
		Jugador rival = jugadores.get(jugadorActivo.getRival().getIndice());
		
		Jugador actual = jugadores.get(jugadorActivo.getIndice());
		
		if(!rival.algomonesParaPelear()){
			
			ganador = actual;
			
		}
		else
		if(!actual.algomonesParaPelear()){
			
			ganador = rival;
		}
		else{
		
			jugadorActivo = jugadorActivo.getRival();
			
			rival.esSuTurno();
		}
	}

	public boolean hayUnGanador() {
		
		return ganador != null;
		
	}
	
	public Jugador obtenerUnGanador(){
		
		return ganador;
		
	}

	public Jugador getJugadorRival() {

		
		return jugadores.get(jugadorActivo.getRival().getIndice());
	
	}
		

}
