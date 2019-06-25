package br.edu.ifsp.spo.lp1a3.projeto.war.classes;

import java.util.ArrayList;
import java.util.Iterator;



public class Rodada extends Thread {
	private int rodada;
	private ArrayList<Player> players;
	int index = -1;
	
	public Rodada(ArrayList<Player> players, int rodada) {
		setRodada(rodada);
		setPlayer(players);
	}
	
	public void iniciarRodada()  {
		Tabuleiro.distribuirExercito(players);	
	}
	
	public Player proximo() {
		if(++index == players.size()) {
			System.out.println("index " + index);
		return null;
		}
		else
		return players.get(index);
	}
//	public void posicionarExercito(Pais pais, int qtdExercito) {
//		pais.setQtdExercito(pais.getQtdExercito() + qtdExercito);
//	}
	
	//Desabilitar um player quando ele perde todos os territ�rios
	public void desabilitarPlayer() {
		for(Player player: players) {
			if(!player.isStatusPlayer()) {
				players.remove(player);
			}
		}
	}
	//Objetivo: Verificar se o player possui territórios ligado a ele
//	public boolean validarPlayer(Player player) {
//		if(player.getPaisesDominados().size() > 0) {
//			return true;
//		}
//		return false;
//	}

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
