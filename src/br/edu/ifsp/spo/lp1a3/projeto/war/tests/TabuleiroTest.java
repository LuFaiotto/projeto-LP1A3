package br.edu.ifsp.spo.lp1a3.projeto.war.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.edu.ifsp.spo.lp1a3.projeto.war.classes.Continente;
import br.edu.ifsp.spo.lp1a3.projeto.war.classes.Tabuleiro;

class TabuleiroTest {
		// 1. Configuração
		// 2. Execução
		// 3. Asserção
	@Test
	void deve_retornar_continentes(){
		// 1. Configuração
		Tabuleiro t = new Tabuleiro(6);
		// 2. Execução
		for(Continente continente : t.continentes){
			System.out.println(continente.toString());
		}
	}

}
