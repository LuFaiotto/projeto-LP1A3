package br.edu.ifsp.spo.lp1a3.projeto.war.classes;

import java.util.LinkedHashSet;

public class Partida {
	public int playersQtd;
	public static int diceset;
	private LinkedHashSet<Player> players = new LinkedHashSet<>();
	
	public Partida(int playersQtd, int diceset) {
		this.playersQtd = playersQtd;
		Partida.diceset = diceset;
	}
	
	public void iniciarPartida(){
		
	}
	
	
//	private void distribuirTerritorio(int players) {
//		
//	}
//	private void distribuirExercitos(int players) {
//		
//	}
	
	
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
		Partida.diceset = diceset;
	}
	public LinkedHashSet<Player> getPlayers() {
		return players;
	}
	public void setPlayers(LinkedHashSet<Player> players) {
		this.players = players;
	}

	//OVERRIDES
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
