package br.edu.ifsp.spo.lp1a3.projeto.war.classes;

import java.util.ArrayList;

// Classe n�o ser� utilizada. Movimentar os m�todos para as outras classes
public class Exercito {

	//Ao atacar, o player vai receber de onde ele pode atacar, onde ele pode atacar, qos ex�rcitos e escolhe qtos quer utilizar
	//M�todo atacar - retorna Booleano - gera rolagem de dados - recebe local do ataque
	//Movimentar
	//Posicionar
	
	private int ladoDados = 6; //Configura��o de quantidade de lados
	
	public String movimentarExercito(Pais paisAtual, Pais paisFuturo, int qtdExercito) {
		if(validarAtaque() && qtdExercito < paisAtual.getQtdExercito()) {
			paisAtual.setQtdExercito(paisAtual.getQtdExercito() - qtdExercito);
			paisFuturo.setQtdExercito(paisFuturo.getQtdExercito() + qtdExercito);
			return "Ex�rcito movimentado com sucesso";
		}
		return "N�o � poss�vel realizar essa movimenta��o";
	}
	
	//Ainda n�o implementado
	public int posicionarExercito(Pais pais) {
		return 0;
	}
	
	public void atacar(Pais atacante, Pais atacado, int qtdExercito) {
		int valorRetornado;
		//Valida��o se pode ou n�o atacar - Ver se possui exercito locado no pa�s e se o pa�s a atacar est� aos arredores
		if(validarAtaque() && atacante.getQtdExercito() > 1) {
			//Ataque. Rolagem de dados. Considerar player 1 como o atacante
			for(int i = 0; i <= qtdExercito; i++) {
				//Rolagem de dados, recebendo o retorno do m�todo
				valorRetornado = Tabuleiro.compareRolagemDados(ladoDados);
				//Melhorar esse m�todo
				if(atacante.getQtdExercito() > 1 && valorRetornado == 1 && atacado.getQtdExercito() > 0) {
					atacado.setQtdExercito(atacado.getQtdExercito() - 1);
				} else if (valorRetornado == 0) {
					atacante.setQtdExercito(atacante.getQtdExercito() - 1);
				} else {
					atacante.setQtdExercito(atacante.getQtdExercito() - 1);
				}
			}
		}
		
		if(atacado.getQtdExercito() == 0 && atacante.getQtdExercito() > 1) {
			movimentarExercito(atacante, atacado, 1);
		}
	}
	
	public boolean validarAtaque() {
		//Teste; Desconsiderar posteriormente
		ArrayList<String> conexoes = new ArrayList<String>();
		String paisAAtacar = "Argentina";
		
		conexoes.add("Argentina");
		conexoes.add("Venezuela");
		conexoes.add("Peru");
		
		//Se houver possibilidade de ataque, retorna true. Verificar o pa�s do qual deseja atacar e quais as conex�es dele
		for(String pais: conexoes) {
			if(pais.equalsIgnoreCase(paisAAtacar)) {
				return true;
			}
		}
		return false;
	}
	
}
