package br.edu.ifsp.spo.lp1a3.projeto.war.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import java.lang.Object;

import br.edu.ifsp.spo.lp1a3.projeto.war.classes.GameConf;
import br.edu.ifsp.spo.lp1a3.projeto.war.classes.Pais;
import br.edu.ifsp.spo.lp1a3.projeto.war.classes.Tabuleiro;


public class PaisTest{
	
	//1. Configuração
	//2. Execução
	//3. Asserção
	@Test
	public void pais_deve_ser_instanciado_corretamente(){
		//1. Configuração
		String testNome = "Pais teste";
		int [] testConexoes = {1, 2, 3};
		//2. Execução
		Pais p = new Pais(testNome, testConexoes);
		//3. Asserção
		assertEquals(p.getClass(), Pais.class);
		assertNotNull(p);
		assertEquals(testNome, p.getNome());
		assertEquals(testConexoes, p.getConexoes());
		assertEquals(p.getPlayer(), null);
		assertEquals(p.getQtdExercito(), 0);
		assertEquals(p.isStatus(), false);
	}
	
	@Test
	public void deve_retornar_conexao_por_referencia() {
		//1. Configuração
		GameConf.loadMapConf();
		String testNome = "Pais teste";
		int [] testConexoes = {1, 2, 3};
		//2. Execução
		Pais p = new Pais(testNome, testConexoes);
		//3. Asserção
		assertEquals(p.getConexaoPorReferencia(1), Tabuleiro.mapa.get(1));
	}
	
	@Test
	public void nao_deve_retornar_conexao_por_referencia_invalida() {
		//1. Configuração
		GameConf.loadMapConf();
		String testNome = "Pais teste";
		int [] testConexoes = {1, 2, 3};
		//2. Execução
		Pais p = new Pais(testNome, testConexoes);
		//3. Asserção
		assertEquals(p.getConexaoPorReferencia(4), null);
	}
	
	
	@Test
	public void deve_retornar_paises_conexoes() {
		//1. Configuração
		GameConf.loadMapConf();
		String testNome = "Pais teste";
		int [] testConexoes = {1, 2, 3};
		//2. Execução
		Pais p = new Pais(testNome, testConexoes);
		//3. Asserção
		System.out.println(p.getPaisesConexoes().toString());
	}
	
	@Test
	public void hash_code_e_equals_deve_retornar_true() {
		//1. Configuração
		String testNome = "Pais teste";
		int [] testConexoes = {1, 2, 3};
		//2. Execução
		Pais p1 = new Pais(testNome, testConexoes);
		Pais p2 = new Pais(testNome, testConexoes);
		//3. Asserção
		assertEquals(p1.hashCode(), p2.hashCode());
		assertEquals(p1.toString(), p2.toString());
		assertTrue(p1.equals(p2));
	}
	
	@Test
	public void hash_code_e_equals_deve_retornar_false() {
		//1. Configuração
		String testNome = "Pais teste";
		String testNome2 = "Pais teste2";
		int [] testConexoes = {1, 2, 3};
		int [] testConexoes2 = {2, 3};
		//2. Execução
		Pais p1 = new Pais(testNome, testConexoes);
		Pais p2 = new Pais(testNome2, testConexoes);
		Pais p3 = new Pais(testNome, testConexoes2);
		Pais p4 = null;
		Pais p5 = new Pais(null, testConexoes);
		Object p6 = new Object();
		//3. Asserção
		assertNotEquals(p1.hashCode(), p2.hashCode());
		assertNotEquals(p1.toString(), p2.toString());
		assertFalse(p1.equals(p2));
		assertFalse(p1.equals(p3));
		assertFalse(p1.equals(p4));
		assertFalse(p1.equals(p5));
		assertFalse(p5.equals(p1));
		assertFalse(p5.equals(p6));
	}
	
}
