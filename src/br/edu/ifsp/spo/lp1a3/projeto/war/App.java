package br.edu.ifsp.spo.lp1a3.projeto.war;

import br.edu.ifsp.spo.lp1a3.projeto.war.classes.*;

public class App {
	public static void main(String[] args) {
		GameConf.loadMapConf();
		Partida p;
		p = Tabuleiro.iniciarPartida();
		System.out.println(p.getPlayers());
		for(Player player : p.getPlayers()) {
			System.out.println(player.getPaisesDominados());;
		}
	}
}
