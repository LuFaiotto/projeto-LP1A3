package br.edu.ifsp.spo.lp1a3.projeto.war.classes;

import java.util.LinkedHashSet;

public class Partida {
	public int playersQtd;
	public int diceset;
	public static int territorios = 42;
	private LinkedHashSet<Player> players = new LinkedHashSet<>();
	
	public Partida(int playersQtd, int diceset) {
		this.playersQtd = playersQtd;
		this.diceset = diceset;
	}
	
	public void distribuirTerritorio(int players) {	
	}
	
	public void distribuirExercitos(int players) {
		
	}
	
	//Getters e Setters
	public int getPlayersQtd() {
		return playersQtd;
	}

	public void setPlayersQtd(int playersQtd) {
		this.playersQtd = playersQtd;
	}

	public int getDiceset() {
		return diceset;
	}

	public void setDiceset(int diceset) {
		this.diceset = diceset;
	}

	public static int getTerritorios() {
		return territorios;
	}

	public static void setTerritorios(int territorios) {
		Partida.territorios = territorios;
	}

	public LinkedHashSet<Player> getPlayers() {
		return players;
	}

	public void setPlayers(LinkedHashSet<Player> players) {
		this.players = players;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((players == null) ? 0 : players.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partida other = (Partida) obj;
		if (players == null) {
			if (other.players != null)
				return false;
		} else if (!players.equals(other.players))
			return false;
		return true;
	}
	
	
}
