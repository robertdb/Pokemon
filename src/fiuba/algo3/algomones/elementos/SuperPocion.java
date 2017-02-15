package fiuba.algo3.algomones.elementos;

import fiuba.algo3.algomones.Algomon;
import fiuba.algo3.algomones.excepciones.PocionAgotadaException;
import fiuba.algo3.algomones.excepciones.SuperPocionAgotadaException;

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

}


