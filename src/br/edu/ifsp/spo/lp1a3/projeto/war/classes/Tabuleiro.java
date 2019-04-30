package br.edu.ifsp.spo.lp1a3.projeto.war.classes;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

public class Tabuleiro {
	int diceSet;
	ArrayList<Continente> continentes = new ArrayList<>();

	//CARREGA TODAS A CONFIGURAÇÕES DO JOGO
	public void loadGameConf(){
		Map<Integer, Pais> mapa = new HashMap<Integer, Pais>();
		continentes.add(new Continente("Am�rica Do Norte", new int [] {1,2,3,4,5,6,7,8,9}));
		mapa.put(1, new Pais("Alaska", new int [] {2, 3, 37}));
		mapa.put(2, new Pais("Mackenzie", new int [] {3, 4, 6}));
		mapa.put(3, new Pais("Vancouver", new int [] {1, 2, 4}));
		mapa.put(4, new Pais("Ottawa", new int [] {2, 3, 5, 7, 8}));
		mapa.put(5, new Pais("Labrador", new int [] {4, 6, 8}));
		mapa.put(6, new Pais("Groel�ndia", new int [] {2, 5, 21}));
		mapa.put(7, new Pais("Calif�rnia", new int [] {3, 4, 8, 9}));
		mapa.put(8, new Pais("Nova York", new int [] {4, 5, 7, 9}));
		mapa.put(9, new Pais("M�xico", new int [] {7, 8, 10}));
		
		continentes.add(new Continente("Am�rica do Sul", new int [] {10, 11, 12, 13}));
		mapa.put(10, new Pais("Venezuela", new int []{9, 11, 12, 13}));
		mapa.put(11, new Pais("Peru", new int []{10, 12, 13}));
		mapa.put(12, new Pais("Brasil", new int []{10, 11, 13, 16}));
		mapa.put(13, new Pais("Argentina", new int []{11, 12}));

		continentes.add(new Continente("África", new int []{14, 15, 16, 17, 18, 19}));
		mapa.put(14, new Pais("Madagascar", new int []{15, 19}));
		mapa.put(15, new Pais("África do Sul", new int []{14, 17}));
		mapa.put(16, new Pais("Argélia", new int []{12, 17, 18, 22}));
		mapa.put(17, new Pais("Congo", new int []{15, 16}));
		mapa.put(18, new Pais("Egito", new int []{16, 17, 22, 24}));
		mapa.put(19, new Pais("Sudão", new int []{14, 15, 16, 17, 18}));

		continentes.add(new Continente("Europa", new int []{20, 21, 22, 23, 24, 25, 26}));
		mapa.put(20, new Pais("Inglaterra", new int []{21, 22, 23, 25} ));
		mapa.put(21, new Pais("Islândia", new int []{6, 20}));
		mapa.put(22, new Pais("França", new int []{16, 18, 20, 23, 24}));
		mapa.put(23, new Pais("Alemanha", new int []{20, 22, 24}));
		mapa.put(24, new Pais("Polônia", new int []{18, 22, 23, 26, 27}));
		mapa.put(25, new Pais("Suécia", new int []{20, 26}));
		mapa.put(26, new Pais("Moscou", new int []{24, 25, 27, 28, 29}));

		continentes.add(new Continente("Ásia", new int[]{27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37}));
		mapa.put(27, new Pais("Oriente Médio", new int[]{24, 26, 29, 30}));
		mapa.put(28, new Pais("OMSK", new int[]{26, 29, 31, 33, 36}));
		mapa.put(29, new Pais("Aral", new int[]{26, 27, 28, 30, 36}));
		mapa.put(30, new Pais("Índia", new int[]{27, 29, 34, 36, 39}));
		mapa.put(31, new Pais("Dudinka", new int[]{28, 32, 33, 35}));
		mapa.put(32, new Pais("Tchita", new int[]{31, 33, 35, 36, 37}));
		mapa.put(33, new Pais("Mongólia", new int[]{32}));
		mapa.put(34, new Pais("Vietnã", new int[]{}));
		mapa.put(35, new Pais("Sibéria", new int[]{}));
		mapa.put(36, new Pais("China", new int[]{}));
		mapa.put(37, new Pais("Vladvostok", new int[]{}));
		mapa.put(38, new Pais("Japão", new int[]{36, 37}));

	}

	
	
//	public Tabuleiro() {
//		
//	}
	
	public Tabuleiro(Partida partida){
        this.diceSet = partida.getDiceset();
    }

    public String compararRolagem(){
        Dado dice = new Dado(6);
        int resultP1 = dice.rolarDado();
        int resultP2 = dice.rolarDado();
        System.out.println("Dado 1: " + resultP1 + " Dado 2: " + resultP2);
        if(resultP1 > resultP2){
            return "Venceu";
        }   else if(resultP1 == resultP2){
            return "Empatou";
        }   else{
            return "Perdeu";
        }
    }
    
    public static int compareRolagemDados(int ladosDado) {
    	Dado dado = new Dado(ladosDado);
    	int result1 = dado.rolarDado();
    	int result2 = dado.rolarDado();
    	if(result1 > result2) {
    		return 1;
    	} else if(result1 == result2) {
    		return 0;
    	}
    	return -1;
    }
}
