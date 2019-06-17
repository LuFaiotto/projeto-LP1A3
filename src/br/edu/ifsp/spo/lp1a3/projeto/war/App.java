package br.edu.ifsp.spo.lp1a3.projeto.war;

import br.edu.ifsp.spo.lp1a3.projeto.war.classes.*;

public class App {

	public static Partida p = null;
	public static void main(String[] args) {
		GameConf.loadMapConf();
		p = Tabuleiro.iniciarPartida();
	}
}
