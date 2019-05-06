package br.edu.ifsp.spo.lp1a3.projeto.war.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.edu.ifsp.spo.lp1a3.projeto.war.classes.Continente;
import br.edu.ifsp.spo.lp1a3.projeto.war.classes.Tabuleiro;

class TabuleiroTest {
		// 1. ConfiguraÃ§Ã£o
		// 2. ExecuÃ§Ã£o
		// 3. AsserÃ§Ã£o
	@Test
	void load_game_conf_deve_carregar_o_mapa() {
		//1. Configuração
		Tabuleiro t = new Tabuleiro(6);
		//2. Execução
		
		//3. Asserção
	}
	
	@Test
	void deve_retornar_continentes(){
		// 1. ConfiguraÃ§Ã£o
		Tabuleiro t = new Tabuleiro(6);
		// 2. ExecuÃ§Ã£o
		for(Continente continente : t.continentes){
			System.out.println(continente.toString());
		}
	}
	
	@Test
	void deve_retornar_paises_continente() {
		//1. Configuração
		Tabuleiro t = new Tabuleiro(6);
		//2. Execução
		for(Continente continente : t.continentes){
			System.out.println(continente.getPaises().toString());
		}
		//3. Asserção
	}

}
