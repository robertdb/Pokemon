package fiuba.algo3.modelo.estadosDeAlgomon;

import fiuba.algo3.modelo.Algomon;

public interface Efecto {
	
	public void aplicarEfecto(Algomon algomon);

	public void agregar(ContextoEstado contextoEstado);
}
