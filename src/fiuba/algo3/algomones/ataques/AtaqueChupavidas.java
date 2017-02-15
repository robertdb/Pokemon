package fiuba.algo3.algomones.ataques;

import fiuba.algo3.algomones.Algomon;

public class AtaqueChupavidas extends AtaqueEspecial {
	
	private double factorDeIncremento;
		
	public AtaqueChupavidas(Ataque ataque) {
		
		super(ataque);
		
		this.factorDeIncremento = 0.3;
		
	}

	@Override
	public double atacar(Algomon atacante, Algomon atacado) {

		double danio = ataque.atacar(atacante, atacado);
		
		double aumentoDeVida = danio * factorDeIncremento;
		
		atacante.aumentoDeSalud(aumentoDeVida);
		
		return danio;
		
	}

}
