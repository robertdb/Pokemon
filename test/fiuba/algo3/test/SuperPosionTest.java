package fiuba.algo3.test;

import static org.junit.Assert.*;

import java.util.EnumMap;

import org.junit.Test;

import fiuba.algo3.modelo.Algomon;
import fiuba.algo3.modelo.Salud;
import fiuba.algo3.modelo.ataques.Ataque;
import fiuba.algo3.modelo.ataques.AtaqueSimple;
import fiuba.algo3.modelo.ataques.NombreDelAtaque;
import fiuba.algo3.modelo.elementos.Elemento;
import fiuba.algo3.modelo.elementos.Pocion;
import fiuba.algo3.modelo.elementos.SuperPocion;
import fiuba.algo3.modelo.excepciones.PocionAgotadaException;
import fiuba.algo3.modelo.excepciones.SuperPocionAgotadaException;
import fiuba.algo3.modelo.tiposDeAlgomon.TipoAgua;
import fiuba.algo3.modelo.tiposDeAlgomon.TipoNormal;

public class SuperPosionTest {

	@Test
	public void testUsarSuperPosionEnAlgomonCon40ptsDeDanioRecuperaTodaSuVida() {
		
		// Se crea un algomon personalizado.
		int potenciaCanionDeAgua = 20;
		int cantidadMaximaDeAtaques = 8;
		Ataque canionDeAgua = new AtaqueSimple(new TipoAgua(), potenciaCanionDeAgua , cantidadMaximaDeAtaques);
		EnumMap<NombreDelAtaque, Ataque> _ataques = new EnumMap<NombreDelAtaque, Ataque >(NombreDelAtaque.class);
		_ataques.put(NombreDelAtaque.CANION_DE_AGUA, canionDeAgua);
		Salud saludBlastoise = new Salud(400);
		Algomon blastoise = new Algomon("Blastoise", new TipoAgua(), _ataques , saludBlastoise);
						
				
		// Se crea otro algomon personalizado.
		int potenciaAtaqueRapido = 25;
		int cantidadMaximaDeAtaquesAtaqueRapido = 16;
		Ataque ataqueRapido = new AtaqueSimple(new TipoNormal(), potenciaAtaqueRapido , cantidadMaximaDeAtaquesAtaqueRapido );
		EnumMap<NombreDelAtaque, Ataque> ataquesNormal = new EnumMap<NombreDelAtaque, Ataque >(NombreDelAtaque.class);
		ataquesNormal.put(NombreDelAtaque.ATAQUE_RAPIDO, ataqueRapido);
		Salud saludRaticate = new Salud(300);
		Algomon raticate = new Algomon("Raticate", new TipoNormal(), ataquesNormal, saludRaticate);
				
		int vidaOriginalRaticate  = raticate.salud();
				
		blastoise.atacar(raticate, NombreDelAtaque.CANION_DE_AGUA);
		blastoise.atacar(raticate, NombreDelAtaque.CANION_DE_AGUA);
				
		assertEquals(vidaOriginalRaticate - 40,  raticate.salud() );
				
		Elemento superPosion = new SuperPocion();
				
		superPosion.aplicarElemento(raticate);
				
		assertEquals(vidaOriginalRaticate , raticate.salud() );
				
	}	
	
	
	@Test
	public void testUsarSuperPosionEnAlgomonConVidaSinSerDaniadaNoRecuperaPtsDeVida() {
		
		// Se crea un algomon personalizado.
		int potenciaCanionDeAgua = 20;
		int cantidadMaximaDeAtaques = 8;
		Ataque canionDeAgua = new AtaqueSimple(new TipoAgua(), potenciaCanionDeAgua , cantidadMaximaDeAtaques);
		EnumMap<NombreDelAtaque, Ataque> _ataques = new EnumMap<NombreDelAtaque, Ataque >(NombreDelAtaque.class);
		_ataques.put(NombreDelAtaque.CANION_DE_AGUA, canionDeAgua);
		Salud saludBlastoise = new Salud(400);
		Algomon blastoise = new Algomon("Blastoise", new TipoAgua(), _ataques , saludBlastoise);
						
				
		// Se crea otro algomon personalizado.
		int potenciaAtaqueRapido = 25;
		int cantidadMaximaDeAtaquesAtaqueRapido = 16;
		Ataque ataqueRapido = new AtaqueSimple(new TipoNormal(), potenciaAtaqueRapido , cantidadMaximaDeAtaquesAtaqueRapido );
		EnumMap<NombreDelAtaque, Ataque> ataquesNormal = new EnumMap<NombreDelAtaque, Ataque >(NombreDelAtaque.class);
		ataquesNormal.put(NombreDelAtaque.ATAQUE_RAPIDO, ataqueRapido);
		Salud saludRaticate = new Salud(300);
		Algomon raticate = new Algomon("Raticate", new TipoNormal(), ataquesNormal, saludRaticate);
				
		int vidaOriginalRaticate  = raticate.salud();
				
		Elemento superPosion = new SuperPocion();
		
		superPosion.aplicarElemento(raticate);
				
		assertEquals(vidaOriginalRaticate , raticate.salud() );
	}
		
	
	
	@Test(expected = SuperPocionAgotadaException.class)
	public void testAlgomonAgoto2SuperPosionesYnoPuedeUtilizarMas(){
		
		// Se crea un algomon personalizado.
		int potenciaAtaqueRapido = 25;
		int cantidadMaximaDeAtaquesAtaqueRapido = 16;
		Ataque ataqueRapido = new AtaqueSimple(new TipoNormal(), potenciaAtaqueRapido , cantidadMaximaDeAtaquesAtaqueRapido );
		EnumMap<NombreDelAtaque, Ataque> ataquesNormal = new EnumMap<NombreDelAtaque, Ataque >(NombreDelAtaque.class);
		ataquesNormal.put(NombreDelAtaque.ATAQUE_RAPIDO, ataqueRapido);
		Salud saludRaticate = new Salud(300);
		Algomon raticate = new Algomon("Raticate", new TipoNormal(), ataquesNormal, saludRaticate);
		
		Elemento superPosion = new SuperPocion();
	
		superPosion.aplicarElemento(raticate);
		superPosion.aplicarElemento(raticate);
		assertTrue(true);
		superPosion.aplicarElemento(raticate);
		
	}
	
}
