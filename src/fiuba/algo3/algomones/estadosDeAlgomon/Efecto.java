package fiuba.algo3.algomones.estadosDeAlgomon;

import fiuba.algo3.algomones.Algomon;

public interface Efecto {
	
	public void aplicarEfecto(Algomon algomon);

	public void agregar(ContextoEstado contextoEstado);
}
