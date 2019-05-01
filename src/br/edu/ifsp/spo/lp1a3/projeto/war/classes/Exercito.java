package br.edu.ifsp.spo.lp1a3.projeto.war.classes;

import java.util.ArrayList;

//Classe não será utilizada. Movimentar os métodos para as outras classes
//TODO: Verificar em qual classe esses métodos ficariam melhor
public class Exercito {

	//Ao atacar, o player vai receber de onde ele pode atacar, onde ele pode atacar, qos exércitos e escolhe qtos quer utilizar
	//Método atacar - retorna Booleano - gera rolagem de dados - recebe local do ataque
	//Movimentar
	//Posicionar
	
	private int ladoDados = 6; //Configuração de quantidade de lados
	
	//Posicionar o exército base no território
	//Utilizar apenas quando for o início do jogo
	public void posicionarExercito(Pais pais) {
		if(pais.getQtdExercito() == 0) {
			pais.setQtdExercito(1);
		} else {
			System.out.println("Já existe um exército locado neste país. Tente em outro país");
		}
	}
	
	//Adicionar um exército a um país que já possui o exército base
	public void adicionarExercito(Player player, Pais pais, int qtdExercito) {
		//Valida se o exército base é o mesmo do player
		//TODO: Fazer a validação se o player tem permissão de colocar exército no país escolhido.
		//Se sim:
		pais.setQtdExercito(pais.getQtdExercito() + qtdExercito);
		System.out.println(qtdExercito + " adicionados ao país " + pais.getNome());
		//Senão:
		System.out.println("Você não pode adicionar exército em um país de outro player.");
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
	
	public void atacar(Pais atacante, Pais atacado, int qtdExercito) {
		int valorRetornado;
		//Validação se pode ou não atacar - Ver se possui exercito locado no país e se o país a atacar está aos arredores
		if(validarConexao() && atacante.getQtdExercito() > 1) {
			//Ataque. Rolagem de dados. Considerar player 1 como o atacante
			for(int i = 0; i <= qtdExercito; i++) {
				//Rolagem de dados, recebendo o retorno do método
				valorRetornado = Tabuleiro.compareRolagemDados(ladoDados);
				//Melhorar esse método
				if(atacante.getQtdExercito() > 1 && valorRetornado == 1 && atacado.getQtdExercito() > 0) {
					atacado.setQtdExercito(atacado.getQtdExercito() - 1);
					System.out.println("Vitória. Um exército oponente foi destruído.");
				} else if(valorRetornado == 0){
					atacante.setQtdExercito(atacante.getQtdExercito() - 1);
					System.out.println("Empate. Um exército seu foi destruído.");
				} else {
					atacante.setQtdExercito(atacante.getQtdExercito() - 1);
					System.out.println("Derrota. Um exército seu foi destruído.");
				}
			}
		}
		
		/*if(atacado.getQtdExercito() == 0 && atacante.getQtdExercito() > 1) {
			movimentarExercito(atacante, atacado, 1);
		}*/
		
		//Observação: Talvez criar um método separado para fazer as operações abaixo
		//TODO: Verificar se precisa dessa parte aqui ou se o método movimentarExercito já faz
		if(atacado.getQtdExercito() == 0) {
			if(atacante.getQtdExercito() > 1) {
				movimentarExercito(atacante, atacado, 1);
			}else {
				System.out.println("Você não possui exército suficiente para locar no novo território.");
				//Nesse momento, o player pode selecionar um exército de outro território dele para ficar no território
				//Ver melhor forma de implementar isso.
			}
		}		
	}
	
	//Método que verifica se o país remetente possui conexão com o país escolhido
	//Por enquanto, está sem parâmetros, porém, futuramente, receberá o país de agora e o destino
	//TODO: Conversa sobre a implementação dos países no sistema
	//TODO: Implementar a validação de acordo com o que foi decidido
	public boolean validarConexao() {
		//Teste; Desconsiderar posteriormente
		ArrayList<String> conexoes = new ArrayList<String>();
		String paisAAtacar = "Argentina";
		
		conexoes.add("Argentina");
		conexoes.add("Venezuela");
		conexoes.add("Peru");
		
		//Se houver possibilidade de ataque, retorna true. Verificar o paï¿½s do qual deseja atacar e quais as conexï¿½es dele
		for(String pais: conexoes) {
			if(pais.equalsIgnoreCase(paisAAtacar)) {
				return true;
			}
		}
		return false;
	}
	
}
