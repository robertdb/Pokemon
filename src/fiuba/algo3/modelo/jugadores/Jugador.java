package fiuba.algo3.modelo.jugadores;

import java.util.EnumMap;
import java.util.List;
import java.util.Set;

import fiuba.algo3.modelo.Algomon;
import fiuba.algo3.modelo.EspecieAlgomon;
import fiuba.algo3.modelo.Juego;
import fiuba.algo3.modelo.ataques.NombreDelAtaque;
import fiuba.algo3.modelo.elementos.Elemento;
import fiuba.algo3.modelo.elementos.TipoElemento;
import fiuba.algo3.modelo.excepciones.AtacarDormidoNoPuedeRealizarseException;
import fiuba.algo3.modelo.excepciones.JugadorNoTieneEseAlgomonError;
import fiuba.algo3.modelo.excepciones.JugadorYaPerdioNoPuedeJugadorError;
import fiuba.algo3.modelo.excepciones.NoSePuedenIngresarMasAlgomonesError;

public class Jugador {
	
	private EnumMap<EspecieAlgomon, Algomon> algomones;
	
	private EnumMap<TipoElemento,Elemento> elementos;
	
	private Algomon algomonActual;
	
	private final int cantidadDeAlgomonesMaxima = 3;
	
	private String nombre;
	
	private EstadoJugador estado;
	
	public Jugador(String nombre) {
		
		nombre = nombre;
		
		algomones = new EnumMap<EspecieAlgomon,Algomon >(EspecieAlgomon.class);
		
		elementos = cargarElementos();
			
		estado = new JugadorPasivo();
		
	}

	private EnumMap<TipoElemento, Elemento> cargarElementos() {
		EnumMap<TipoElemento,Elemento> elementos = new EnumMap<TipoElemento,Elemento>(TipoElemento.class);
		
		elementos.put(TipoElemento.POCION, TipoElemento.POCION.nuevo());
		elementos.put(TipoElemento.SUPERPOCION, TipoElemento.SUPERPOCION.nuevo());
		elementos.put(TipoElemento.VITAMINA, TipoElemento.VITAMINA.nuevo());
		elementos.put(TipoElemento.RESTAURADOR, TipoElemento.RESTAURADOR.nuevo());
		return elementos;
	}

	public void ingresarAlgomon(EspecieAlgomon especie) {
		
		if(algomones.size() == cantidadDeAlgomonesMaxima )
			throw new NoSePuedenIngresarMasAlgomonesError();
		
		Algomon algomon = especie.nuevo();
		
		if (algomones.isEmpty()){
			
			estado.setAlgomonActual(algomon);
			
		}
		
		algomones.put(especie, especie.nuevo());
			
	}
	
	public void esSuTurno(){
		
		Algomon actual = estado.getAlgomonActual();
		
		estado = new JugadorActivo();
		
		estado.setAlgomonActual(actual);
		
	}
	
	public void cambiarAlgomon(EspecieAlgomon especieAlgomon, Juego juego) {
			
		algomonActual = algomones.get(especieAlgomon);
		if(algomonActual == null)
			throw new JugadorNoTieneEseAlgomonError();
		
		estado.cambiarAlgomon(algomonActual);
		
		juego.jugadaTerminada();
		
	}
	
	public boolean algomonesParaPelear() {
		
		return this.algomones.size() > 0;
		
	}

	public void atacarConAlgomonActivo(NombreDelAtaque ataque,Jugador jugador, Juego juego){
		
		estado.atacarConAlgomonActivo(ataque, jugador);
		
		if(estado.getAlgomonActual().estaMuerto())
			algomones.values().remove(estado.getAlgomonActual());
		
		if(jugador.getAlgomonActual().estaMuerto())
			algomones.values().remove(estado.getAlgomonActual());
		
		juego.jugadaTerminada();
		
	}
	
	public void aplicarElemento(TipoElemento element, Juego juego){
		
		Elemento elemento = elementos.get(element);
			
		estado.aplicarElemento(elemento);
		
		if(elemento.elementoCaducado())
			elementos.values().remove(elemento);
		
		juego.jugadaTerminada();
		
	}

	public Algomon getAlgomonActual() {
		
		return estado.getAlgomonActual();
		
	}

}
