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
		for(@SuppressWarnings("unused") Player player: players) {
			
			desabilitarPlayer();
		}
	}
	
//	public void posicionarExercito(Pais pais, int qtdExercito) {
//		pais.setQtdExercito(pais.getQtdExercito() + qtdExercito);
//	}
	
	//Desabilitar um player quando ele perde todos os territï¿½rios
	public void desabilitarPlayer() {
		for(Player player: players) {
			if(!player.isStatusPlayer()) {
				players.remove(player);
			}
		}
	}
	//Objetivo: Verificar se o player possui territÃ³rios ligado a ele
//	public boolean validarPlayer(Player player) {
//		if(player.getPaisesDominados().size() > 0) {
//			return true;
//		}
//		return false;
//	}
	
//	//Objetivo: Verificar se o player possui o domínio de um continente inteiro
//	public boolean verificarDominio(Player player) {
//		int flag = 0;
//		Continente continente = new Continente();
//		ArrayList<Pais> paises = continente.getPaisesArray();
//		for(Pais pais: paises) {
//			if(pais.getPlayer().equals(player)) {
//				flag++;
//			}
//		}
//		
//		if(paises.size() == flag) {
//			return true;
//		}
//		
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
