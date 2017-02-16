package fiuba.algo3.modelo.ataques;

import fiuba.algo3.modelo.Algomon;

public interface Ataque {
	
	public double atacar(Algomon atacante, Algomon atacado );

	public void aumentarAtaques();
	
}
