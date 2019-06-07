package br.edu.ifsp.spo.lp1a3.projeto.war.classes;
import br.edu.ifsp.spo.lp1a3.projeto.war.classes.Partida;
import java.util.ArrayList;
import java.util.Scanner;

public class Tabuleiro {
	public static ArrayList<Continente> continentes = new ArrayList<>();
	public Tabuleiro() {
		
	}
	//Instancia uma partida
	//Instancia e retorna uma partida
		public static Partida iniciarPartida() {
			ArrayList<Player> players = new ArrayList<>();
			int qtdP = 0;
			int diceSet = 0;
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
			
			players = Tabuleiro.definirOrdemJogada(players, diceSet);
			return (new Partida(players, diceSet));
		}
	
	public static void distribuirExercito() {
		
	}
	
	public static ArrayList<Player> definirOrdemJogada(ArrayList<Player> players, int diceSet) {
		ArrayList<Player> playersOrdem = new ArrayList<>();
		for(int i = 0, j = players.size(); i < j; i++){
			if(players.size() > 1){
				if(Tabuleiro.compareRolagemDados(diceSet) >= 0) {
					playersOrdem.add(players.get(0));
					players.remove(0);
				}	else {
				playersOrdem.add(players.get(1));
				players.remove(1);
				}
			}	else {
				playersOrdem.add(players.get(0));
				players.remove(0);
			}
		}
		return playersOrdem;	
	}
	
	public static String definirCorPlayer() {
		
		return null;
	
	}

	public static int compareRolagemDados(int diceSet) {
    	Dado dado = new Dado(diceSet);
    	int result1 = dado.rolarDado();
    	int result2 = dado.rolarDado();
    	System.out.println("Dado 1: " + result1 + " Dado 2: " + result2);
    	if(result1 > result2) {
    		return 1;
    	} else if(result1 == result2) {
    		return 0;
    	}
    	return -1;
    }
//Validações
	//TODO: Implementar o método
	public static void validarVencedor(boolean resultFinal) {
		if(resultFinal) {
			System.out.println("Vitória. Parabéns! Um exército seu será alocado no país conquistado.");
		} else {
			System.out.println("Derrota. O oponente defendeu o território.");
		}
	}
	
}
