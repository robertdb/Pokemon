package fiuba.algo3.modelo;

import java.util.EnumMap;
import java.util.List;
import java.util.Set;

import fiuba.algo3.modelo.ataques.Ataque;
import fiuba.algo3.modelo.ataques.NombreDelAtaque;
import fiuba.algo3.modelo.estadosDeAlgomon.ContextoEstado;
import fiuba.algo3.modelo.estadosDeAlgomon.Efecto;
import fiuba.algo3.modelo.excepciones.AtaqueNoPertenecienteAAlgomonException;
import fiuba.algo3.modelo.tiposDeAlgomon.Tipo;

public class Algomon {

	private EnumMap<NombreDelAtaque, Ataque> ataques;
	private String nombreAlgomon;
	private Tipo tipoAlgomon;
	private Salud salud;
	private ContextoEstado estado;
	
	public Algomon(String nombre, Tipo tipo, EnumMap<NombreDelAtaque, Ataque> ataques, Salud salud) {
		
		this.nombreAlgomon = nombre;
		this.tipoAlgomon = tipo;
		this.ataques = ataques;
		this.salud = salud;
		this.estado = new ContextoEstado();
		
	}

	public double atacar(Algomon atacado, NombreDelAtaque nombreDelAtaque) {
		
		estado.aplicarEfectos(this);
		
		Ataque ataque = this.ataques.get(nombreDelAtaque);
		 
		if( ataque == null)
			throw new AtaqueNoPertenecienteAAlgomonException();
	
		return ataque.atacar(this, atacado);
		 
	}
	
	public Tipo tipoDeAlgomon(){
		 return tipoAlgomon;
	}

	public void reducirSalud(double danio) {
		
		salud.reducirVida(danio);
		
	}

	public int salud() {
		
		return salud.vida();
		
	}
	
	public int saludOriginal(){
		
		return salud.vidaOriginal();
		
	}

	public void aumentoDeSalud(double aumentoDeVida) {
		
		salud.aumentarVida(aumentoDeVida);
		
	}

	public void alterarEstado(Efecto efecto) {
		
		this.estado.nuevoEfecto(efecto);
		
	}

	public void aumentarAtaques() {
		
		estado.aplicarEfectos(this);
		
		for (Ataque ataque : this.ataques.values()) {
		    
			ataque.aumentarAtaques();
		
		}
		
	}

	public void aplicarRestaurador() {
		
		this.estado.aplicarNormalizador(this);
		
	}
	
	public void aplicarElementoAlaSalud(int aumentoDeVida) {
		
		estado.aplicarEfectos(this);
		
		this.aumentoDeSalud(aumentoDeVida);
		
	}

	public Set<NombreDelAtaque> getAtaques() {
		// TODO Auto-generated method stub
		return ataques.keySet();
	}

	public boolean estaMuerto() {
		
		return this.salud.terminada();
		
	}

}
