package fiuba.algo3.modelo.jugadores;

public enum TipoJugador {
	
	JUGADOR1(0), JUGADOR2(1);

	private TipoJugador rival;
	
	private int indice;
	
	static {
		JUGADOR1.rival = JUGADOR2;
		JUGADOR2.rival = JUGADOR1;
	}
	
	private TipoJugador (int indice) {
		
		this.indice = indice;
	
	}
	
	public TipoJugador  getRival() {
		return rival;
	}

	public int getIndice() {
		return indice;
	}

}
