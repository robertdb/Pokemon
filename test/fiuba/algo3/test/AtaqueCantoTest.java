package fiuba.algo3.test;

import static org.junit.Assert.*;

import java.util.EnumMap;

import org.junit.Test;

import fiuba.algo3.modelo.Algomon;
import fiuba.algo3.modelo.Salud;
import fiuba.algo3.modelo.ataques.Ataque;
import fiuba.algo3.modelo.ataques.AtaqueCanto;
import fiuba.algo3.modelo.ataques.AtaqueSimple;
import fiuba.algo3.modelo.ataques.NombreDelAtaque;
import fiuba.algo3.modelo.excepciones.AtacarDormidoNoPuedeRealizarseException;
import fiuba.algo3.modelo.tiposDeAlgomon.TipoAgua;
import fiuba.algo3.modelo.tiposDeAlgomon.TipoFuego;
import fiuba.algo3.modelo.tiposDeAlgomon.TipoNormal;

public class AtaqueCantoTest {

	@Test
	public void testAtacarConCantoYelAtacadoNoPuedeAtacarDurante3Turnos() {
		
		//Se crea un algomon personalizado con fogonazo.
		
		Ataque canto = new AtaqueCanto(new AtaqueSimple(new TipoNormal(), 0, 4));
		EnumMap<NombreDelAtaque, Ataque> ataques = new EnumMap<NombreDelAtaque, Ataque >(NombreDelAtaque.class);
		ataques.put(NombreDelAtaque.CANTO,canto);
		Algomon chansey = new Algomon("Chansey", new TipoFuego(), ataques , new Salud(400));
		
		// Se crea un algomon personalizado.
		Ataque ataqueRapido = new AtaqueSimple(new TipoNormal(), 10 , 16 );
		EnumMap<NombreDelAtaque, Ataque> ataquesNormal = new EnumMap<NombreDelAtaque, Ataque >(NombreDelAtaque.class);
		ataquesNormal.put(NombreDelAtaque.ATAQUE_RAPIDO, ataqueRapido);
		Algomon blastoise = new Algomon("Blastoise", new TipoAgua(), ataquesNormal, new Salud(400));
		
		chansey.atacar(blastoise, NombreDelAtaque.CANTO);
		
		try{
			
			blastoise.atacar(chansey, NombreDelAtaque.ATAQUE_RAPIDO);
		
		}catch(AtacarDormidoNoPuedeRealizarseException exception){}
		
		try{
			
			blastoise.atacar(chansey, NombreDelAtaque.ATAQUE_RAPIDO);
		
		}catch(AtacarDormidoNoPuedeRealizarseException exception){}
		
		try{
			
			blastoise.atacar(chansey, NombreDelAtaque.ATAQUE_RAPIDO);
		
		}catch(AtacarDormidoNoPuedeRealizarseException exception){}
		
		assertEquals(400,chansey.salud(),0.001D);
		
		blastoise.atacar(chansey, NombreDelAtaque.ATAQUE_RAPIDO);
		
		assertEquals(390,chansey.salud(),0.001D);

		
	}
}
