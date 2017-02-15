package fiuba.algo3.algomones.elementos;

import fiuba.algo3.algomones.Algomon;
import fiuba.algo3.algomones.excepciones.RestauradorAgotadoException;

public class Restaurador implements Elemento {

	private int restauradoresRestantes;
	
	public Restaurador(){
		
		this.restauradoresRestantes = 3;
		
	}
	@Override
	public void aplicarElemento(Algomon algomon) {
		
		if(restauradoresAgotados())
			throw new RestauradorAgotadoException();
		
		algomon.aplicarRestaurador();
		
		restauradoresRestantes -=1;

	}
	
	private boolean restauradoresAgotados() {
		
		return restauradoresRestantes == 0;
		
	}
	@Override
	public boolean elementoCaducado() {
		// TODO Auto-generated method stub
		return false;
	}

}
