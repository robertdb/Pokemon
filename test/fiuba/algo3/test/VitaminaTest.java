package fiuba.algo3.test;

import static org.junit.Assert.*;

import java.util.EnumMap;

import org.junit.Test;

import fiuba.algo3.modelo.Algomon;
import fiuba.algo3.modelo.Salud;
import fiuba.algo3.modelo.ataques.Ataque;
import fiuba.algo3.modelo.ataques.AtaqueFogonazo;
import fiuba.algo3.modelo.ataques.AtaqueSimple;
import fiuba.algo3.modelo.ataques.NombreDelAtaque;
import fiuba.algo3.modelo.elementos.Elemento;
import fiuba.algo3.modelo.elementos.SuperPocion;
import fiuba.algo3.modelo.elementos.Vitamina;
import fiuba.algo3.modelo.excepciones.CantidadDeAtaquesAgotadosException;
import fiuba.algo3.modelo.excepciones.VitaminaAgotadaException;
import fiuba.algo3.modelo.tiposDeAlgomon.TipoAgua;
import fiuba.algo3.modelo.tiposDeAlgomon.TipoFuego;
import fiuba.algo3.modelo.tiposDeAlgomon.TipoNormal;

public class VitaminaTest {

	
	@Test(expected = VitaminaAgotadaException.class)
	public void testAlgomonAgoto5PosionesYnoPuedeUtilizarMasPosiones(){
		
		// Se crea un algomon personalizado.
	    int potenciaAtaqueRapido = 25;
		int cantidadMaximaDeAtaquesAtaqueRapido = 16;
		Ataque ataqueRapido = new AtaqueSimple(new TipoNormal(), potenciaAtaqueRapido , cantidadMaximaDeAtaquesAtaqueRapido );
		EnumMap<NombreDelAtaque, Ataque> ataquesNormal = new EnumMap<NombreDelAtaque, Ataque >(NombreDelAtaque.class);
		ataquesNormal.put(NombreDelAtaque.ATAQUE_RAPIDO, ataqueRapido);
		Salud saludRaticate = new Salud(300);
		Algomon raticate = new Algomon("Raticate", new TipoNormal(), ataquesNormal, saludRaticate);
				
		Elemento vitamina = new Vitamina();
			
		vitamina.aplicarElemento(raticate);
		vitamina.aplicarElemento(raticate);
		vitamina.aplicarElemento(raticate);
		vitamina.aplicarElemento(raticate);
		vitamina.aplicarElemento(raticate);
		assertTrue(true);
		vitamina.aplicarElemento(raticate);
	
	}
	
	@Test
	public void testUsarVitaminaEnAlgomonPermite2AtaquesMas() {
		
		// Se crea un algomon personalizado con fogonazo.
		// El algomon tiene 2 ataques disponibles.
		int cantidadDeAtaques = 2;
		Ataque fogonazo = new AtaqueFogonazo(new AtaqueSimple(new TipoFuego(), 2, cantidadDeAtaques));
		EnumMap<NombreDelAtaque, Ataque> ataques = new EnumMap<NombreDelAtaque, Ataque >(NombreDelAtaque.class);
		ataques.put(NombreDelAtaque.FOGONAZO,fogonazo);
		Algomon charizard = new Algomon("Charizard", new TipoFuego(), ataques , new Salud(400));
		
		// Se crea un algomon personalizado.
		Algomon blastoise = new Algomon("Blastoise", new TipoAgua(), null, new Salud(400));
		
		charizard.atacar(blastoise, NombreDelAtaque.FOGONAZO);
		
		charizard.atacar(blastoise, NombreDelAtaque.FOGONAZO);
		
		try{
			// No se efectua el ataque, se agotaron sus ataques.
			charizard.atacar(blastoise, NombreDelAtaque.FOGONAZO);
			
		}catch(CantidadDeAtaquesAgotadosException e){}
		
		Elemento vitamina = new Vitamina();
		
		vitamina.aplicarElemento(charizard);
		
		// El algomon tiene 2 ataques más.
		charizard.atacar(blastoise, NombreDelAtaque.FOGONAZO);
		charizard.atacar(blastoise, NombreDelAtaque.FOGONAZO);
		assertEquals(396,blastoise.salud(),0.001D);
		
	}
	
	@Test(expected = CantidadDeAtaquesAgotadosException.class)
	public void testUsarVitaminaEnAlgomonNoPuedoAgregarMasAtaquesQueCantidadMaxima() {
		
		// Se crea un algomon personalizado con fogonazo.
		// El algomon tiene 2 ataques disponibles.
		int cantidadDeAtaques = 2;

		Ataque fogonazo = new AtaqueFogonazo(new AtaqueSimple(new TipoFuego(), 2, cantidadDeAtaques ));
		EnumMap<NombreDelAtaque, Ataque> ataques = new EnumMap<NombreDelAtaque, Ataque >(NombreDelAtaque.class);
		ataques.put(NombreDelAtaque.FOGONAZO,fogonazo);
		Algomon charizard = new Algomon("Charizard", new TipoFuego(), ataques , new Salud(400));
		
		// Se crea un algomon personalizado.
		Algomon blastoise = new Algomon("Blastoise", new TipoAgua(), null, new Salud(400));
		
		Elemento vitamina = new Vitamina();
		
		vitamina.aplicarElemento(charizard);
		
		charizard.atacar(blastoise, NombreDelAtaque.FOGONAZO);
		charizard.atacar(blastoise, NombreDelAtaque.FOGONAZO);
		assertEquals(398,blastoise.salud(),0.001D);
		
		// Algomon ya no puede atacar. Agoto sus ataques.
		charizard.atacar(blastoise, NombreDelAtaque.FOGONAZO);
		
	}
	

}
