package fiuba.algo3.algomones.jugadores;

import java.util.EnumMap;

import fiuba.algo3.algomones.Algomon;
import fiuba.algo3.algomones.ataques.NombreDelAtaque;
import fiuba.algo3.algomones.elementos.Elemento;
import fiuba.algo3.algomones.elementos.TipoElemento;
import fiuba.algo3.algomones.excepciones.JugadorNoTieneUnAlgomonParaJugarError;
import fiuba.algo3.algomones.excepciones.NoSePuedeAplicarUnElementoSiNoEsElTurnoDelJugadorError;
import fiuba.algo3.algomones.excepciones.NoSePuedeAtacarConAlgomonSiNoEsElTurnoDelJugadorError;
import fiuba.algo3.algomones.excepciones.NoSePuedeCambiarAlAlgomonSiNoEsElTurnoDelJugadorError;

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
