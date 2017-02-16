package fiuba.algo3.modelo.jugadores;

import java.util.EnumMap;

import fiuba.algo3.modelo.Algomon;
import fiuba.algo3.modelo.ataques.NombreDelAtaque;
import fiuba.algo3.modelo.elementos.Elemento;
import fiuba.algo3.modelo.elementos.TipoElemento;
import fiuba.algo3.modelo.excepciones.JugadorNoTieneUnAlgomonParaJugarError;
import fiuba.algo3.modelo.excepciones.NoSePuedeAplicarUnElementoSiNoEsElTurnoDelJugadorError;
import fiuba.algo3.modelo.excepciones.NoSePuedeAtacarConAlgomonSiNoEsElTurnoDelJugadorError;
import fiuba.algo3.modelo.excepciones.NoSePuedeCambiarAlAlgomonSiNoEsElTurnoDelJugadorError;

public class JugadorPasivo implements EstadoJugador {

	private Algomon algomonActual;
	
	@Override
	public void cambiarAlgomon(Algomon algomon){
		
		throw new NoSePuedeCambiarAlAlgomonSiNoEsElTurnoDelJugadorError();

	}

	@Override
	public void atacarConAlgomonActivo(NombreDelAtaque ataque, Jugador jugadorPasivo){
		
		throw new NoSePuedeAtacarConAlgomonSiNoEsElTurnoDelJugadorError();

	}

	@Override
	public void aplicarElemento(Elemento elemento){
		
		throw new NoSePuedeAplicarUnElementoSiNoEsElTurnoDelJugadorError();

	}
	
	@Override
	public void setAlgomonActual(Algomon actual){
		
		algomonActual = actual;
		
	}
	
	@Override
	public Algomon getAlgomonActual(){
		
		if(algomonActual == null)
			throw new JugadorNoTieneUnAlgomonParaJugarError();
		
		return algomonActual;
		
	}

}
