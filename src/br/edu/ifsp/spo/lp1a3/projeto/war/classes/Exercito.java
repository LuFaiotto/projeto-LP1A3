package br.edu.ifsp.spo.lp1a3.projeto.war.classes;

import java.util.ArrayList;

// Classe não será utilizada. Movimentar os métodos para as outras classes
public class Exercito {

	//Ao atacar, o player vai receber de onde ele pode atacar, onde ele pode atacar, qos exércitos e escolhe qtos quer utilizar
	//Método atacar - retorna Booleano - gera rolagem de dados - recebe local do ataque
	//Movimentar
	//Posicionar
	
	private int ladoDados = 6; //Configuração de quantidade de lados
	
	public String movimentarExercito(Pais paisAtual, Pais paisFuturo, int qtdExercito) {
		if(validarAtaque() && qtdExercito < paisAtual.getQtdExercito()) {
			paisAtual.setQtdExercito(paisAtual.getQtdExercito() - qtdExercito);
			paisFuturo.setQtdExercito(paisFuturo.getQtdExercito() + qtdExercito);
			return "Exército movimentado com sucesso";
		}
		return "Não é possível realizar essa movimentação";
	}
	
	//Ainda não implementado
	public int posicionarExercito(Pais pais) {
		return 0;
	}
	
	public void atacar(Pais atacante, Pais atacado, int qtdExercito) {
		int valorRetornado;
		//Validação se pode ou não atacar - Ver se possui exercito locado no país e se o país a atacar está aos arredores
		if(validarAtaque() && atacante.getQtdExercito() > 1) {
			//Ataque. Rolagem de dados. Considerar player 1 como o atacante
			for(int i = 0; i <= qtdExercito; i++) {
				//Rolagem de dados, recebendo o retorno do método
				valorRetornado = Tabuleiro.compareRolagemDados(ladoDados);
				//Melhorar esse método
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
		
		//Se houver possibilidade de ataque, retorna true. Verificar o país do qual deseja atacar e quais as conexões dele
		for(String pais: conexoes) {
			if(pais.equalsIgnoreCase(paisAAtacar)) {
				return true;
			}
		}
		return false;
	}
	
}
