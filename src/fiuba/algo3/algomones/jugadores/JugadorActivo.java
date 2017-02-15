package fiuba.algo3.algomones.jugadores;

import fiuba.algo3.algomones.Algomon;
import fiuba.algo3.algomones.ataques.NombreDelAtaque;
import fiuba.algo3.algomones.elementos.Elemento;
import fiuba.algo3.algomones.excepciones.JugadorNoTieneUnAlgomonParaJugarError;

public class JugadorActivo implements EstadoJugador {

	private Algomon algomonActual;
	
	@Override
	public void cambiarAlgomon(Algomon algomon) {

		algomonActual = algomon;

	}

	@Override
	public void atacarConAlgomonActivo(NombreDelAtaque ataque, Jugador jugadorPasivo) {
		
		algomonActual.atacar(jugadorPasivo.getAlgomonActual(), ataque);

	}

	@Override
	public void aplicarElemento(Elemento elemento) {
			
		elemento.aplicarElemento(algomonActual);

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
