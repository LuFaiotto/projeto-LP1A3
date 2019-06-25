package br.edu.ifsp.spo.lp1a3.projeto.war.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import br.edu.ifsp.spo.lp1a3.projeto.war.classes.Continente;
import br.edu.ifsp.spo.lp1a3.projeto.war.classes.GameConf;
import br.edu.ifsp.spo.lp1a3.projeto.war.classes.Player;
import br.edu.ifsp.spo.lp1a3.projeto.war.classes.Tabuleiro;

@SuppressWarnings("unused")
class TabuleiroTest {
	@Test
	public void instanciar_partida() {
		
	}
	@Test
	public void deve_destribuir_territorios_div_inteira() {
			//1. Configuração
			ArrayList<Player> ap = new ArrayList<>();
			Player p1 = new Player("João");
			Player p2 = new Player("Maria");
			Player p3 = new Player("Fulano");
			ap.add(p1);
			ap.add(p2);
			ap.add(p3);

			//2. Execução
			GameConf.loadMapConf();
			Tabuleiro.distribuirTerritorio(ap);
			//3. Asserção
			assertEquals(p1.getPaisesDominados().size(), p2.getPaisesDominados().size());
			assertEquals(p2.getPaisesDominados().size(), p3.getPaisesDominados().size());
			assertNotEquals(p1.getPaisesDominados(), p2.getPaisesDominados());
			assertNotEquals(p2.getPaisesDominados(), p3.getPaisesDominados());
		}
		@Test
		public void deve_destribuir_territorios_div_nao_inteira() {
			//1. Configuração
			ArrayList<Player> ap = new ArrayList<>();
			Player p1 = new Player("João");
			Player p2 = new Player("Maria");
			Player p3 = new Player("Fulano");
			Player p4 = new Player("Beltrano");
			ap.add(p1);
			ap.add(p2);
			ap.add(p3);
			ap.add(p4);
			//2. Execução
			GameConf.loadMapConf();
			Tabuleiro.distribuirTerritorio(ap);
			//3. Asserção
			assertEquals(10, p1.getPaisesDominados().size());
			assertEquals(10, p2.getPaisesDominados().size());
			assertEquals(10, p3.getPaisesDominados().size());
			assertEquals(10, p4.getPaisesDominados().size());
			assertNotEquals(p1.getPaisesDominados(), p2.getPaisesDominados());
			assertNotEquals(p2.getPaisesDominados(), p3.getPaisesDominados());
			assertNotEquals(p3.getPaisesDominados(), p4.getPaisesDominados());
	
		}
}
