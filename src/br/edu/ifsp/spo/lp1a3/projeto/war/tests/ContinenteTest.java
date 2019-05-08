package br.edu.ifsp.spo.lp1a3.projeto.war.tests;

import br.edu.ifsp.spo.lp1a3.projeto.war.classes.Continente;
import br.edu.ifsp.spo.lp1a3.projeto.war.classes.GameConf;
import br.edu.ifsp.spo.lp1a3.projeto.war.classes.Pais;
import br.edu.ifsp.spo.lp1a3.projeto.war.classes.Tabuleiro;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Test;


public class ContinenteTest {
	//1. Configuração
	//2. Execução
	//3. Asserção
	@Test
	public void continente_deve_ser_instanciado_corretamente(){
		//1. Configuração
		String nome = "América";
		int [] paisref = {1, 2, 3}; 
		//2. Execução
		Continente c = new Continente(nome, paisref);		
		//3. Asserção
		assertEquals(c.getClass(), Continente.class);
		assertEquals(nome, c.getNome());
		assertEquals(paisref, c.getPaises());
		}
		
	@Test
	public void deve_retornar_a_array_corretamente() {
		//1. Configuração
		GameConf.loadMapConf();
		String nome = "América";
		int [] paisref = {1, 2, 3};
		ArrayList<Pais> arrayPais = new ArrayList<>();
		arrayPais.add(Tabuleiro.mapa.get(1));
		arrayPais.add(Tabuleiro.mapa.get(2));
		arrayPais.add(Tabuleiro.mapa.get(3));
		//2. Execução
		Continente c = new Continente(nome, paisref);
		//3. Asserção
		assertEquals(arrayPais, c.getPaisesArray());
	}
	
	@Test
	public void hash_code_e_equals_deve_retornar_true() {
		//1. Configuração
		String nome = "América";
		int [] paisref = {1, 2, 3};
		//2. Execução
		Continente c1 = new Continente(nome, paisref);
		Continente c2 = new Continente(nome, paisref);
		//3. Asserção
		assertEquals(c1.hashCode(), c2.hashCode());
		assertEquals(c1.toString(), c2.toString());
		assertTrue(c1.equals(c2));
	}
	
	@Test
	public void hash_code_e_equals_deve_retornar_false() {
		//1. Configuração
		String nome1 = "América";
		int [] paisref1 = {1, 2, 3};
		String nome2 = "América do Sul";
		int [] paisref2 = {2, 3};
		//2. Execução
		Continente c1 = new Continente(nome1, paisref1);
		Continente c2 = new Continente(nome2, paisref1);
		Continente c3 = new Continente(nome1, paisref2);
		Continente c4 = null;
		Continente c5 = new Continente(null, paisref1);
		Object p6 = new Object();
		//3. Asserção
		assertNotEquals(c1.hashCode(), c2.hashCode());
		assertNotEquals(c1.toString(), c2.toString());
		assertFalse(c1.equals(c2));
		assertFalse(c1.equals(c3));
		assertFalse(c1.equals(c4));
		assertFalse(c1.equals(c5));
		assertFalse(c5.equals(c1));
		assertFalse(c5.equals(p6));
	}
}
