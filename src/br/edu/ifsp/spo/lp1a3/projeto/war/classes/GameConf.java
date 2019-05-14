package br.edu.ifsp.spo.lp1a3.projeto.war.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

//CARREGA TODAS AS CONFIGURAÇÕES DO JOGO
public class GameConf{
    
	static Random random = new Random();
	
	public static void definirOrdemJogada() {
		
	}
	
	//TODO: Acionar o método posicionar exército da classe Exercito. Verificar se necessário.
	public static void distribuirTerritório(ArrayList<Player> players){
		ArrayList<Integer> vetPais = new ArrayList<>();
		int pQtd = players.size();
		for(int i = 0; i < 42; i++){
			vetPais.add(i + 1);
		}
		Collections.shuffle(vetPais);
		
		for(int p = 0, i = 0; p < players.size(); i = i + 42/pQtd, p++){
			for(int j = i; j < j + (42/ pQtd); j++){
				players.get(p).setPaisesDominados(Tabuleiro.mapa.get(j+1));
			}
		}
	}

	
	//Carrega todas as informações do mapa		
	public static void loadMapConf(){
		Tabuleiro.mapa.put(1, new Pais("Alaska", new int [] {2, 3, 37}));
		Tabuleiro.mapa.put(2, new Pais("Mackenzie", new int [] {3, 4, 6}));
		Tabuleiro.mapa.put(3, new Pais("Vancouver", new int [] {1, 2, 4}));
		Tabuleiro.mapa.put(4, new Pais("Ottawa", new int [] {2, 3, 5, 7, 8}));
		Tabuleiro.mapa.put(5, new Pais("Labrador", new int [] {4, 6, 8}));
		Tabuleiro.mapa.put(6, new Pais("Groelândia", new int [] {2, 5, 21}));
		Tabuleiro.mapa.put(7, new Pais("California", new int [] {3, 4, 8, 9}));
		Tabuleiro.mapa.put(8, new Pais("Nova York", new int [] {4, 5, 7, 9}));
		Tabuleiro.mapa.put(9, new Pais("México", new int [] {7, 8, 10}));
		Tabuleiro.continentes.add(new Continente("América Do Norte", new int [] {1,2,3,4,5,6,7,8,9}));
			
		Tabuleiro.mapa.put(10, new Pais("Venezuela", new int []{9, 11, 12, 13}));
		Tabuleiro.mapa.put(11, new Pais("Peru", new int []{10, 12, 13}));
		Tabuleiro.mapa.put(12, new Pais("Brasil", new int []{10, 11, 13, 16}));
		Tabuleiro.mapa.put(13, new Pais("Argentina", new int []{11, 12}));
		Tabuleiro.continentes.add(new Continente("América do Sul", new int [] {10, 11, 12, 13}));
	
		Tabuleiro.mapa.put(14, new Pais("Madagascar", new int []{15, 19}));
		Tabuleiro.mapa.put(15, new Pais("África do Sul", new int []{14, 17}));
		Tabuleiro.mapa.put(16, new Pais("Argélia", new int []{12, 17, 18, 22}));
		Tabuleiro.mapa.put(17, new Pais("Congo", new int []{15, 16}));
		Tabuleiro.mapa.put(18, new Pais("Egito", new int []{16, 17, 22, 24}));
		Tabuleiro.mapa.put(19, new Pais("Sudão", new int []{14, 15, 16, 17, 18}));
		Tabuleiro.continentes.add(new Continente("África", new int []{14, 15, 16, 17, 18, 19}));
	
		Tabuleiro.mapa.put(20, new Pais("Inglaterra", new int []{21, 22, 23, 25} ));
		Tabuleiro.mapa.put(21, new Pais("Islândia", new int []{6, 20}));
		Tabuleiro.mapa.put(22, new Pais("França", new int []{16, 18, 20, 23, 24}));
		Tabuleiro.mapa.put(23, new Pais("Alemanha", new int []{20, 22, 24}));
		Tabuleiro.mapa.put(24, new Pais("Polônia", new int []{18, 22, 23, 26, 27}));
		Tabuleiro.mapa.put(25, new Pais("Suécia", new int []{20, 26}));
		Tabuleiro.mapa.put(26, new Pais("Moscou", new int []{24, 25, 27, 28, 29}));
		Tabuleiro.continentes.add(new Continente("Europa", new int []{20, 21, 22, 23, 24, 25, 26}));
	
		Tabuleiro.mapa.put(27, new Pais("Oriente Médio", new int []{24, 26, 29, 30}));
		Tabuleiro.mapa.put(28, new Pais("OMSK", new int []{26, 29, 31, 33, 36}));
		Tabuleiro.mapa.put(29, new Pais("Aral", new int []{26, 27, 28, 30, 36}));
		Tabuleiro.mapa.put(30, new Pais("Índia", new int []{27, 29, 34, 36, 39}));
		Tabuleiro.mapa.put(31, new Pais("Dudinka", new int []{28, 32, 33, 35}));
		Tabuleiro.mapa.put(32, new Pais("Tchita", new int []{31, 33, 35, 36, 37}));
		Tabuleiro.mapa.put(33, new Pais("Mongólia", new int []{28, 31, 32, 36}));
		Tabuleiro.mapa.put(34, new Pais("Vietnã", new int []{30, 36, 40}));
		Tabuleiro.mapa.put(35, new Pais("Sibéria", new int []{31, 32, 37}));
		Tabuleiro.mapa.put(36, new Pais("China", new int []{28, 29, 30, 32, 33, 34, 37, 38}));
		Tabuleiro.mapa.put(37, new Pais("Vladvostok", new int []{1, 32, 33, 35, 38}));
		Tabuleiro.mapa.put(38, new Pais("Japão", new int []{36, 37}));
		Tabuleiro.continentes.add(new Continente("Ásia", new int []{27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38}));
	
		Tabuleiro.mapa.put(39, new Pais("Sumatra", new int []{30, 42}));
		Tabuleiro.mapa.put(40, new Pais("Borneo", new int []{34, 41, 42}));
		Tabuleiro.mapa.put(41, new Pais("Nova Guiné", new int []{40, 42}));
		Tabuleiro.mapa.put(42, new Pais("Austrália", new int []{39, 40, 41}));
		Tabuleiro.continentes.add(new Continente("Oceania", new int []{39, 40, 41, 42}));
    	}
}