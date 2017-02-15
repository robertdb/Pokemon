package fiuba.algo3.algomones.ataques;

import fiuba.algo3.algomones.Algomon;
import fiuba.algo3.algomones.estadosDeAlgomon.Dormido;
import fiuba.algo3.algomones.estadosDeAlgomon.Efecto;

public class AtaqueCanto extends AtaqueEspecial {

	public AtaqueCanto(Ataque ataque) {
		
		super(ataque);
	
	}

	@Override
	public double atacar(Algomon atacante, Algomon atacado) {
		
		Efecto efecto = new Dormido();
		
		atacado.alterarEstado(efecto);
		
		return ataque.atacar(atacante, atacado);
		
	}

}
