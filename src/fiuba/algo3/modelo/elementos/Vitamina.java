package fiuba.algo3.modelo.elementos;

import fiuba.algo3.modelo.Algomon;
import fiuba.algo3.modelo.excepciones.VitaminaAgotadaException;

public class Vitamina implements Elemento {

	private int vitaminasRestantes;
	
	public Vitamina(){
		
		this.vitaminasRestantes = 5;
		
	}
	
	@Override
	public void aplicarElemento(Algomon algomon) {
		

		if(vitaminasAgotadas())
			throw new VitaminaAgotadaException ();
		
		algomon.aumentarAtaques();
		
		vitaminasRestantes -= 1;

	}

	private boolean vitaminasAgotadas() {
		
		return vitaminasRestantes == 0;
	}

	@Override
	public boolean elementoCaducado() {
		// TODO Auto-generated method stub
		return false;
	}

}
