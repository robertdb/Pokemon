package fiuba.algo3.algomones.ataques;

import fiuba.algo3.algomones.Algomon;

public interface Ataque {
	
	public double atacar(Algomon atacante, Algomon atacado );

	public void aumentarAtaques();
	
}
