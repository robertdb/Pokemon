package fiuba.algo3.algomones.ataques;

import fiuba.algo3.algomones.Algomon;
import fiuba.algo3.algomones.estadosDeAlgomon.Efecto;
import fiuba.algo3.algomones.estadosDeAlgomon.Quemado;

public class AtaqueFogonazo extends AtaqueEspecial {

	
	public AtaqueFogonazo(Ataque ataque) {
		
		super(ataque);
		
	}

	@Override
	public double atacar(Algomon atacante, Algomon atacado) {
		
		Efecto efecto = new Quemado();
		
		atacado.alterarEstado(efecto);
		
		return ataque.atacar(atacante, atacado);
		
	}

}
