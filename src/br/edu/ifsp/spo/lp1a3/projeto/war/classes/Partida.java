package br.edu.ifsp.spo.lp1a3.projeto.war.classes;

import java.util.ArrayList;

public class Partida {
	public int playersQtd;
	private Dado dice;
	private int rodadaNum = 0; 
	private ArrayList<Player> players = new ArrayList<>();
	
	public Partida(ArrayList<Player> players, int diceset) {
		setPlayers(players);
		this.dice = new Dado(diceset);
		this.rodadaNum = 0;
	}
	
	//TODO Implementar rodadas
	public void iniciarRodadas(){
		while(true) {
			Rodada rodada = new Rodada(players, ++rodadaNum);
			rodada.iniciarRodada();
		}
	}
	
	
//Getters e Setters
	public int getPlayersQtd() {
		return playersQtd;
	}
	
	public void setPlayersQtd(int playersQtd) {
		this.playersQtd = playersQtd;
	}
	
	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	public Dado getDice() {
		return this.dice;
	}

	public void setDice(Dado dice) {
		this.dice = dice;
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