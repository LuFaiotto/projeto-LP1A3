package br.edu.ifsp.spo.lp1a3.projeto.war.classes;
import br.edu.ifsp.spo.lp1a3.projeto.war.classes.Partida;
import java.util.ArrayList;
import java.util.Collections;
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
			
		players = Tabuleiro.definirOrdemJogada(players, diceSet);
		distribuirTerritorio(players);
		return (new Partida(players, diceSet));
	}
	
	
	
	public static void distribuirExercito(ArrayList<Player> players) {
		for(Player player: players) {
			int qtdPaisesDominados = player.getPaisesDominados().size();
			int resultDivisao = qtdPaisesDominados / 2;
			
			//No caso do player possuir um territ�rio
			if(resultDivisao == 0) {
				resultDivisao = 1;
			}	
			player.setExercitosLivres(player.getExercitosLivres() + resultDivisao);
		}
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
	
	//TODO: Acionar o método posicionar exército da classe Exercito. Verificar se necessário.
	public static void distribuirTerritorio(ArrayList<Player> players){
		//ArrayList para embaralhar os países
		ArrayList<Integer> vetPais = new ArrayList<>();
		int pQtd = players.size();	
		//Embaralhando os países
		for(int i = 1; i <= 42; i++){
			vetPais.add(i);
		}
		Collections.shuffle(vetPais);
		
		//Distribuindo territórios
		if(42 % pQtd == 0) {
			int flag = 0;
			for(int p = 0; p < players.size(); p++){
				for(int j = flag; j < flag + 42/pQtd; j++){
					players.get(p).setPaisesDominados(GameConf.mapa.get(vetPais.get(j)));
				}
				flag = flag + 42/pQtd;
			}
		}	else {
				int flag = 0;
				for(int p = 0; p < players.size(); p++){
					for(int j = flag; j < flag + (int)42/pQtd; j++){
						players.get(p).setPaisesDominados(GameConf.mapa.get(vetPais.get(j)));
					}
					flag = flag + 42/pQtd;
				}
				for(int i = (int)42/ pQtd; i < 42; i++){
					GameConf.mapa.get(vetPais.get(i)).setQtdExercito(10);
					GameConf.mapa.get(vetPais.get(i)).setCor("Neutro");
				}
			}
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
	
	//Desabilitar um player quando ele perde todos os territ�rios
	public static boolean gameOver(Player player) {
		if(player.getPaisesDominados().size() > 0) {
			System.out.println("Game Over para " + player.getNamePlayer());
			player.setStatusPlayer(false);
			return false;
		}
		return true;
	}
	
	//Objetivo: Verificar se o player possui o dom�nio de um continente inteiro
	public static boolean verificarDominio(Player player) {
		int flag = 0;
		Continente continente = new Continente();
		ArrayList<Pais> paises = continente.getPaisesArray();
		for(Pais pais: paises) {
			if(pais.getPlayer().equals(player)) {
				flag++;
			}
		}
		
		if(paises.size() == flag) {
			return true;
		}
		
		return false;
	}
}
