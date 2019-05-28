package br.edu.ifsp.spo.lp1a3.projeto.war.classes;

import java.util.LinkedHashSet;

public class Rodada {
	
	private LinkedHashSet<Player> players;
	
	public Rodada(LinkedHashSet<Player> players) {
		setPlayer(players);
	}
	
	public void iniciarRodada() {
		
	}
	
	public void posicionarExercito(Pais pais) {
		
	}
	
	//TODO: Fazer a validação se o player tem permissão para fazer o movimento
	public void adicionarExercito(Pais pais, int qtdExercito) {
		//Validação se o exército base é o mesmo do player
		//Se sim:
		pais.setQtdExercito(pais.getQtdExercito() + qtdExercito);
		System.out.println(qtdExercito + " adicionados ao pa�s " + pais.getNome());
		//Senão:
		System.out.println("Voc� n�o pode adicionar ex�rcito em um pa�s de outro player.");
	}
	
	public String movimentarExercito(Pais paisAtual, Pais paisFuturo, int qtdExercito) {
		if(validarConexao(paisAtual, paisFuturo) && qtdExercito < paisAtual.getQtdExercito()) {
			paisAtual.setQtdExercito(paisAtual.getQtdExercito() - qtdExercito);
			paisFuturo.setQtdExercito(paisFuturo.getQtdExercito() + qtdExercito);
			return "Exército movimentado com sucesso";
		}
		return "Não é possível realizar essa movimentação";
	}
	
	//TODO: Verificar validação do método getNumLados da classe Dado.
	public void atacar(Pais atacante, Pais atacado, int qtdExercito) {
		int valorRetornado;
		boolean resultadoFinal = false;
		
		if(validarConexao(atacante, atacado) && validarAtaque(atacante, qtdExercito)) {
			for(int i = 0; i < qtdExercito; i++) {
				valorRetornado = Tabuleiro.compareRolagemDados(Dado.diceSet);
				if(valorRetornado == 1) {
					atacado.setQtdExercito(atacado.getQtdExercito() - 1);
					System.out.println("Vitória. Um exército oponente foi destruído.");
				} else if (valorRetornado == 0){
					atacante.setQtdExercito(atacante.getQtdExercito() - 1);
					System.out.println("Empate. Um exército seu foi destruído.");
				} else {
					atacante.setQtdExercito(atacante.getQtdExercito() - 1);
					System.out.println("Derrota. Um exército seu foi destruído.");
				}
				
				//Valida se o atacado ainda possui exército
				if(atacado.getQtdExercito() == 0) {
					i = qtdExercito;
					resultadoFinal = true;
				}
			}
			
			validarVencedor(resultadoFinal);
		}
	}
	
	//Método que valida se o atacante possui estrutura para cometer o ataque
	//O que fazer: Avaliar se a quantidade de exércitos escolhidos está, no máximo, com a quantidade de
	//exércitos posicionados no país de ataque - 1 (exército base)
	public boolean validarAtaque(Pais pais, int qtdExercito) {
		if(qtdExercito > pais.getQtdExercito()) {
			return true;
		}
		System.out.println("Você não possui exército suficiente em " + pais.getNome() + " para atacar.");
		return false;
	}
	
	public boolean validarConexao(Pais atacante, Pais atacado) {
		for(Pais pais: atacante.getPaisesConexoes()) {
			if(pais.equals(atacado)) {
				return true;
			}
		}
		return false;
	}
	
	//TODO: Implementar o método
	public void validarVencedor(boolean resultFinal) {
		if(resultFinal) {
			System.out.println("Vitória. Parabéns! Um exército seu será alocado no país conquistado.");
		} else {
			System.out.println("Derrota. O oponente defendeu o território.");
		}
	}
	//Desabilitar um player quando ele perde todos os territ�rios
	public void desabilitarPlayer(Player player) {
		if(!validarPlayer()) {
			System.out.println("Game Over para " + player.getNamePlayer());
			players.remove(player);
		}
	}
	//Objetivo: Verificar se o player possui territórios ligado a ele
	//TODO: Implementar o método de validação de player de acordo com o jogo
	public boolean validarPlayer() {
		//Se possui territ�rios, return true
		return false;
	}

	@SuppressWarnings("unused")
	private LinkedHashSet<Player> getPlayer() {
		return players;
	}

	private void setPlayer(LinkedHashSet<Player> player) {
		this.players = player;
	}
}
