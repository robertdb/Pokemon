package fiuba.algo3.modelo.jugadores;

import fiuba.algo3.modelo.Algomon;
import fiuba.algo3.modelo.ataques.NombreDelAtaque;
import fiuba.algo3.modelo.elementos.Elemento;

public interface EstadoJugador {
	

	public void cambiarAlgomon(Algomon actual);
		
	public void atacarConAlgomonActivo(NombreDelAtaque ataque, Jugador jugadorPasivo);
	
	public void aplicarElemento(Elemento elemento);
	
	public void setAlgomonActual(Algomon actual);
	
	public Algomon getAlgomonActual();
	
}
