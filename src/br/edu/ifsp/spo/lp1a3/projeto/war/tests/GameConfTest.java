package br.edu.ifsp.spo.lp1a3.projeto.war.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Test;

import br.edu.ifsp.spo.lp1a3.projeto.war.classes.GameConf;
import br.edu.ifsp.spo.lp1a3.projeto.war.classes.Player;

public class GameConfTest {
	
	
	//1. Configuração
	//2. Execução
	//3. Asserção
	
	@Test
	public void deve_destribuir_territorios_sem_repeticao() {
		//1. Configuração
		ArrayList<Player> ap = new ArrayList<>();
		Player p1 = new Player("João", 3, "Azul");
		Player p2 = new Player("Maria", 3, "Branco");
		Player p3 = new Player("Fulano", 3, "Vermelho");
		Player p4 = new Player("Ciclano", 3, "Rosa");
		ap.add(p1);
		ap.add(p2);
		ap.add(p3);
		System.out.println(ap.get(0));
		System.out.println(p2);
		System.out.println(p3);

		//ap.add(p4);
		//2. Execução
		GameConf.loadMapConf();
		GameConf.distribuirTerritório(ap);
		//3. Asserção
		System.out.println(ap.get(0));
		System.out.println(p2);
		System.out.println(p3);
	//	System.out.println(p4.getPaisesDominados());
	}
}
