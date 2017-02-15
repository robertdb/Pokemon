package fiuba.algo3.algomones.jugadores;

import fiuba.algo3.algomones.Algomon;
import fiuba.algo3.algomones.ataques.NombreDelAtaque;
import fiuba.algo3.algomones.elementos.Elemento;

public interface EstadoJugador {
	

	public void cambiarAlgomon(Algomon actual);
		
	public void atacarConAlgomonActivo(NombreDelAtaque ataque, Jugador jugadorPasivo);
	
	public void aplicarElemento(Elemento elemento);
	
	public void setAlgomonActual(Algomon actual);
	
	public Algomon getAlgomonActual();
	
}
