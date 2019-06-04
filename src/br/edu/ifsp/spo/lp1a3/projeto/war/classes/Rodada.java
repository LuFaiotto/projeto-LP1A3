package br.edu.ifsp.spo.lp1a3.projeto.war.classes;

import br.edu.ifsp.spo.lp1a3.projeto.war.classes.Partida;

import java.util.ArrayList;

public class Rodada {
	private int rodada;
	private ArrayList<Player> players;
	
	public Rodada(ArrayList<Player> players, int rodada) {
		setRodada(rodada);
		setPlayer(players);
		iniciarRodada();
	}
	
	public void iniciarRodada() {
		
	}
	
	public void posicionarExercito(Pais pais) {
		
	}
	
	//Desabilitar um player quando ele perde todos os territ�rios
	public void desabilitarPlayer(Player player) {
		if(!validarPlayer()) {
			System.out.println("Game Over para " + player.getNamePlayer());
			players.remove(player);
			Partida.this.setPlayers(players);
		}
	}
	//Objetivo: Verificar se o player possui territórios ligado a ele
	//TODO: Implementar o método de validação de player de acordo com o jogo
	public boolean validarPlayer() {
		//Se possui territ�rios, return true
		return false;
	}

	@SuppressWarnings("unused")
	private ArrayList<Player> getPlayer() {
		return players;
	}

	private void setPlayer(ArrayList<Player> player) {
		this.players = player;
	}

	public int getRodada() {
		return rodada;
	}

	public void setRodada(int rodada) {
		this.rodada = rodada;
	}
}
