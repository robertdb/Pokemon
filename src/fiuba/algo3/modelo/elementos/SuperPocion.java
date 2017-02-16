package fiuba.algo3.modelo.elementos;

import fiuba.algo3.modelo.Algomon;
import fiuba.algo3.modelo.excepciones.PocionAgotadaException;
import fiuba.algo3.modelo.excepciones.SuperPocionAgotadaException;

public class SuperPocion implements Elemento {

	Elemento pocionSimple;

	
	public SuperPocion(){
		
		this.pocionSimple = new Pocion();
		
	}
	
	@Override
	public void aplicarElemento(Algomon algomon) {
		
		
		try{
			this.pocionSimple.aplicarElemento(algomon);
			this.pocionSimple.aplicarElemento(algomon);
		}
		catch(PocionAgotadaException e){
			
				throw new SuperPocionAgotadaException();
			
			}
			
	}

	@Override
	public boolean elementoCaducado() {
		// TODO Auto-generated method stub
		return false;
	}

}


