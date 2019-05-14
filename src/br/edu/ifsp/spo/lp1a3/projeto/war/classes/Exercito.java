package br.edu.ifsp.spo.lp1a3.projeto.war.classes;

import java.util.ArrayList;

//Classe n�o ser� utilizada. Movimentar os m�todos para as outras classes
//TODO: Verificar em qual classe esses m�todos ficariam melhor. Ou até mesmo pensar se ele está bom nesse local mesmo
public class Exercito {

	//Ao atacar, o player vai receber de onde ele pode atacar, onde ele pode atacar, qos ex�rcitos e escolhe qtos quer utilizar
	//Método atacar - retorna Booleano - gera rolagem de dados - recebe local do ataque
	//Movimentar
	//Posicionar
	//TODO: Implementar os testes desses métodos em ExercitoTest.java
	
	private int ladoDados = 6; //Configura��o de quantidade de lados
	
	//Posicionar o ex�rcito base no territ�rio
	//Utilizar apenas quando for o in�cio do jogo
	//TODO: Esse método está atrelado ao método de distribuir territórios na classe GameConf
	public void posicionarExercito(Pais pais) {
		if(pais.getQtdExercito() == 0) {
			pais.setQtdExercito(1);
		} else {
			System.out.println("Já existe um exército locado neste país. Tente em outro país");
		}
	}
	
	//Adicionar um ex�rcito a um pa�s que j� possui o ex�rcito base
	public void adicionarExercito(Player player, Pais pais, int qtdExercito) {
		//Valida se o ex�rcito base � o mesmo do player
		//TODO: Fazer a valida��o se o player tem permiss�o de colocar ex�rcito no pa�s escolhido.
		//Se sim:
		pais.setQtdExercito(pais.getQtdExercito() + qtdExercito);
		System.out.println(qtdExercito + " adicionados ao pa�s " + pais.getNome());
		//Sen�o:
		System.out.println("Voc� n�o pode adicionar ex�rcito em um pa�s de outro player.");
	}
	
	//Método utilizado ao conquistar um território ou ao querer movimentar exércitos entre países
	public String movimentarExercito(Pais paisAtual, Pais paisFuturo, int qtdExercito) {
		if(validarConexao() && qtdExercito < paisAtual.getQtdExercito()) {
			paisAtual.setQtdExercito(paisAtual.getQtdExercito() - qtdExercito);
			paisFuturo.setQtdExercito(paisFuturo.getQtdExercito() + qtdExercito);
			return "Exército movimentado com sucesso";
		}
		return "Não é possível realizar essa movimentação";
	}
	
	//TODO: Verificar se não há possibilidade de diminuir o método
	//TODO: Verificar a funcionalidade do método externamente
	public void atacar(Pais atacante, Pais atacado, int qtdExercito) {
		int valorRetornado;
		//Valida��o se pode ou n�o atacar - Ver se possui exercito locado no pa�s e se o pa�s a atacar est� aos arredores
		if(validarConexao() && atacante.getQtdExercito() > 1) {
			//Ataque. Rolagem de dados. Considerar player 1 como o atacante
			for(int i = 0; i <= qtdExercito; i++) {
				//Rolagem de dados, recebendo o retorno do m�todo
				valorRetornado = Tabuleiro.compareRolagemDados(ladoDados);
				//Melhorar esse m�todo
				if(atacante.getQtdExercito() > 1 && valorRetornado == 1 && atacado.getQtdExercito() > 0) {
					atacado.setQtdExercito(atacado.getQtdExercito() - 1);
					System.out.println("Vit�ria. Um ex�rcito oponente foi destru�do.");
				} else if(valorRetornado == 0){
					atacante.setQtdExercito(atacante.getQtdExercito() - 1);
					System.out.println("Empate. Um ex�rcito seu foi destru�do.");
				} else {
					atacante.setQtdExercito(atacante.getQtdExercito() - 1);
					System.out.println("Derrota. Um ex�rcito seu foi destru�do.");
				}
			}
		}
		
		/*if(atacado.getQtdExercito() == 0 && atacante.getQtdExercito() > 1) {
			movimentarExercito(atacante, atacado, 1);
		}*/
		
		//Observa��o: Talvez criar um m�todo separado para fazer as opera��es abaixo
		//TODO: Verificar se precisa dessa parte aqui ou se o m�todo movimentarExercito j� faz
		if(atacado.getQtdExercito() == 0) {
			if(atacante.getQtdExercito() > 1) {
				movimentarExercito(atacante, atacado, 1);
			}else {
				System.out.println("Voc� n�o possui ex�rcito suficiente para locar no novo territ�rio.");
				//Nesse momento, o player pode selecionar um ex�rcito de outro territ�rio dele para ficar no territ�rio
				//Ver melhor forma de implementar isso.
			}
		}		
	}
	
	//Objetivo: Método que verifica se o país remetente possui conexão com o país escolhido
	//Observações: Por enquanto, est� sem par�metros, por�m, futuramente, receber� o pa�s de agora e o destino
	//TODO: Implementar a valida��o de acordo com o que foi decidido
	public boolean validarConexao() {
		//Teste para verificar funcionamento do método; Desconsiderar posteriormente
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
