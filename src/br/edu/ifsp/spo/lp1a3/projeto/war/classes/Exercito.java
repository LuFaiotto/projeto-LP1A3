package br.edu.ifsp.spo.lp1a3.projeto.war.classes;

import java.util.ArrayList;

public class Exercito {

	//Ao atacar, o player vai receber de onde ele pode atacar, onde ele pode atacar, qos exércitos e escolhe qtos quer utilizar
	//Método atacar - retorna Booleano - gera rolagem de dados - recebe local do ataque
	//Movimentar
	//Posicionar
	
	public void movimentarExercito() {
		
	}
	
	public int posicionarExercito(Player player, Exercito exercito) {
		return 0;
	}
	
	public int atacar(Pais pais) {
		//Validação se pode ou não atacar - chama dentro desse método
		if(validarAtaque()) {
			//ataque. Rolagem de dados
			return 1;
		}
		return 0;
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
