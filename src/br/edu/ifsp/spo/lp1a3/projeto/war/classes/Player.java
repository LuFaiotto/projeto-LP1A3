package br.edu.ifsp.spo.lp1a3.projeto.war.classes;

import java.util.ArrayList;
import java.util.HashSet;

public class Player {
	//Deve suportar n jogadores
	//TODO: Verificar mais métodos relacionados a classe
	//TODO: Criar os testes de Player em PlayerTest.java
	
	private String namePlayer;
	private boolean statusPlayer;
	
	//TODO: Talvez não seja a melhor abordagem para cor, já que está estático. Verificar se há algo melhor
	private String cor;

	//TODO: Verificar se é possível utilizar esse HashSet dentro da própria classe
	private HashSet<Player> players = new HashSet<>();
	private int exercitosLivres;
	private ArrayList<Pais> paisDominado = new ArrayList<>();
	
	//TODO: Verificar o construtor. Será mesmo que o player precisa indicar qual é a sua cor? Talvez coloque algum array de cores, enfim
	public Player(String nome, int exercitosLivres, String cor) {
		setNamePlayer(nome);
		setStatusPlayer(true);
		setExercitosLivres(exercitosLivres);
		setCor(cor);
	}
	
	//Desabilitar um player quando ele perde todos os territ�rios
	public void desabilitarPlayer(Player player) {
		if(!validaPlayer()) {
			System.out.println("Game Over para " + player.getNamePlayer());
			players.remove(player);
		}
	}
	
	//Objetivo: Verificar se o player possui territórios ligado a ele
	//TODO: Implementar o método de validação de player de acordo com o jogo
	public boolean validaPlayer() {
		//Se possui territ�rios, return true
		return false;
	}
	
	//Getters e Setters
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
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
	public int getExercitosLivres() {
		return exercitosLivres;
	}
	public void setExercitosLivres(int exercitosLivres) {
		this.exercitosLivres = exercitosLivres;
	}
	public void setPaisesDominados(Pais paisDominado) {
		this.paisDominado.add(paisDominado);
		paisDominado.setStatus(true);
		paisDominado.setCor(this.cor);
		paisDominado.setPlayer(this);
	}
	public ArrayList<Pais> getPaisesDominados() {
		return paisDominado;
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
	public String toString() {
		return "Player: " + namePlayer + ", Exercitos Livres: " + exercitosLivres + ", Paises Dominados: "
				+ paisDominado.toString();
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
