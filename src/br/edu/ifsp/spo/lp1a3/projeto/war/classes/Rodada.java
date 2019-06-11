package br.edu.ifsp.spo.lp1a3.projeto.war.classes;

import java.util.ArrayList;

public class Rodada {
	private int rodada;
	private ArrayList<Player> players;
	
	public Rodada(ArrayList<Player> players, int rodada) {
		setRodada(rodada);
		setPlayer(players);
	}
	
	public void iniciarRodada() {
		
	}
	
	public void posicionarExercito(Pais pais, int qtdExercito) {
		pais.setQtdExercito(pais.getQtdExercito() + qtdExercito);
	}
	
	//Desabilitar um player quando ele perde todos os territ�rios
	public void desabilitarPlayer(Player player) {
		if(!validarPlayer(player)) {
			System.out.println("Game Over para " + player.getNamePlayer());
			players.remove(player);
		}
	}
	//Objetivo: Verificar se o player possui territórios ligado a ele
	//TODO: Implementar o método de validação de player de acordo com o jogo
	public boolean validarPlayer(Player player) {
		if(player.getPaisesDominados().size() > 0) {
			return true;
		}
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