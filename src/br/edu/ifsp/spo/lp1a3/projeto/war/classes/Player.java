package br.edu.ifsp.spo.lp1a3.projeto.war.classes;

import java.util.HashSet;

public class Player {
	//Deve suportar n jogadores
	
	private String namePlayer;
	private boolean statusPlayer;
	private HashSet<Player> players = new HashSet<>();
	
	public Player(String nome) {
		setNamePlayer(nome);
		setStatusPlayer(true);
	}
	
	//Desabilitar um player quando ele perde todos os territórios
	public void desabilitarPlayer(Player player) {
		if(!validaPlayer()) {
			System.out.println("Game Over para " + player.getNamePlayer());
			players.remove(player);
		}
	}
	
	//Verifica se o player possui territórios ligado a ele
	//TODO: Implementar o método de validação de player
	public boolean validaPlayer() {
		//Se possui territórios, return true
		return false;
	}
	
	//Getters e Setters
	public String getNamePlayer() {
		return namePlayer;
	}

	public void setNamePlayer(String namePlayer) {
		this.namePlayer = namePlayer;
	}

	public boolean isStatusPlayer() {
		return statusPlayer;
	}

	public void setStatusPlayer(boolean statusPlayer) {
		this.statusPlayer = statusPlayer;
	}

	public HashSet<Player> getPlayers() {
		return players;
	}

	public void setPlayers(HashSet<Player> players) {
		this.players = players;
	}

	//Overrides
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((namePlayer == null) ? 0 : namePlayer.hashCode());
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
		Player other = (Player) obj;
		if (namePlayer == null) {
			if (other.namePlayer != null)
				return false;
		} else if (!namePlayer.equals(other.namePlayer))
			return false;
		return true;
	}
	
}
