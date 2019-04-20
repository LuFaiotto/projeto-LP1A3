package br.edu.ifsp.spo.lp1a3.projeto.war.classes;

import java.util.LinkedHashSet;

public class Partida {

	public int playersQtd;
	public int territorios = 42;
	private LinkedHashSet<Player> players = new LinkedHashSet<>();
	
	public Partida(int playersQtd) {
		this.playersQtd = playersQtd;
		}
	}
	
	public void destribuirTerritorio(int players) {
	
	}
	
	public void destribuirExercitos(int players) {
	}
}
