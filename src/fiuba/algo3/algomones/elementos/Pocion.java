package fiuba.algo3.algomones.elementos;

import fiuba.algo3.algomones.Algomon;
import fiuba.algo3.algomones.excepciones.PocionAgotadaException;

public class Pocion implements Elemento {
	
	private int aumentoDeVida;
	
	private int  posionesRestantes;
	
	public Pocion(){
		
		this.aumentoDeVida = 20;
		
		this.posionesRestantes = 4;
		
	}

	@Override
	public void aplicarElemento(Algomon algomon) {
		
		if(pocionesAgotadas())
			throw new PocionAgotadaException();
		
		algomon.aumentoDeSalud(aumentoDeVida);
		
		posionesRestantes --;
		
	}

	public boolean pocionesAgotadas() {
		
		return posionesRestantes == 0;
	}

}
