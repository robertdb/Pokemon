package fiuba.algo3.modelo.ataques;

import fiuba.algo3.modelo.Algomon;
import fiuba.algo3.modelo.estadosDeAlgomon.Dormido;
import fiuba.algo3.modelo.estadosDeAlgomon.Efecto;

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
