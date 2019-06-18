package br.edu.ifsp.spo.lp1a3.projeto.war;

import java.util.ArrayList;
import java.util.Scanner;

import br.edu.ifsp.spo.lp1a3.projeto.war.classes.*;
import br.edu.ifsp.spo.lp1a3.projeto.war.controllers.*;;

public class App {

	public static Partida p = null;
	public static void main(String[] args) {
		
		GameConf.loadMapConf();
		//TESTE DO JOGO
		
		//AQUI PEGA INFORMAÇÃO PRA INSTANCIAR PARTIDA
		ArrayList<Player> players = new ArrayList<>();
		int qtdP = 0;
		int diceSet = 0;
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
			
		System.out.println("Digite o número de lados do dado: ");
		diceSet = input.nextInt();
		input.nextLine();
		
		System.out.println("Digite a quantidade de players:");
		qtdP = input.nextInt();
		input.nextLine();
			
		for(int i = 0; i < qtdP; i++) {
			System.out.println("Insira seu Nickname: ");
			String nome = input.nextLine();
			players.add(new Player(nome));
		}
		
		//CHAMANDO O CONTROLLER
		p = PartidaController.iniciarJogo(players, diceSet);
		p.iniciarRodadas();
		
		
	}
}
