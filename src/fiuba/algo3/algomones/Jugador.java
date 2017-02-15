package fiuba.algo3.algomones;

import java.util.EnumMap;
import java.util.List;
import java.util.Set;

import fiuba.algo3.algomones.elementos.Elemento;
import fiuba.algo3.algomones.elementos.TipoElemento;
import fiuba.algo3.algomones.excepciones.AtacarDormidoNoPuedeRealizarseException;
import fiuba.algo3.algomones.excepciones.NoSePuedenIngresarMasAlgomonesError;

public class Jugador {
	
	EnumMap<EspecieAlgomon, Algomon> algomones;
	
	EnumMap<TipoElemento,Elemento> elementos;
	
	private Algomon algomonActual;
	
	private final int cantidadDeAlgomonesMaxima;

	public Jugador() {
		
		algomones = new EnumMap<EspecieAlgomon,Algomon >(EspecieAlgomon.class);
		
		elementos = cargarElementos();
		
		algomonActual = null;
		
		cantidadDeAlgomonesMaxima = 3;
		
	}

	private EnumMap<TipoElemento, Elemento> cargarElementos() {
		EnumMap<TipoElemento,Elemento> elementos = new EnumMap<TipoElemento,Elemento>(TipoElemento.class);
		
		elementos.put(TipoElemento.POCION, TipoElemento.POCION.nuevo());
		elementos.put(TipoElemento.SUPERPOCION, TipoElemento.SUPERPOCION.nuevo());
		elementos.put(TipoElemento.VITAMINA, TipoElemento.VITAMINA.nuevo());
		elementos.put(TipoElemento.RESTAURADOR, TipoElemento.RESTAURADOR.nuevo());
		return elementos;
	}

	public Algomon statusAlgomonActual() {
		// TODO Auto-generated method stub
		return algomonActual;
	}

	public void elegirAlgomon(EspecieAlgomon charmander) {
		algomonActual = algomones.get(charmander);
		
	}

	public Set<TipoElemento> getElementos() {
		
		return elementos.keySet();
	}

	public Set<EspecieAlgomon> getAlgomones() {
		
		return algomones.keySet();
	}

	public Set<NombreDelAtaque> getAtaqueAlgomon() {
		// TODO Auto-generated method stub
		return algomonActual.getAtaques();
	}
	public void aplicarElemento(TipoElemento element){
		Elemento  elemento = elementos.get(element);
		elemento.aplicarElemento(algomonActual);
	}
	public void aplicarAtaque(NombreDelAtaque ataque,Jugador jugador2){
		algomonActual.atacar(jugador2.algomonActual, ataque);
	}

	public void ingresarAlgomon(EspecieAlgomon nombreAlgomon, Algomon algomon) {
		
		if(algomones.size() == cantidadDeAlgomonesMaxima )
			throw new NoSePuedenIngresarMasAlgomonesError();
		
		if (algomones.isEmpty()){
			algomonActual = algomon;
		}
		
		algomones.put(nombreAlgomon, algomon);
		
	}

}
