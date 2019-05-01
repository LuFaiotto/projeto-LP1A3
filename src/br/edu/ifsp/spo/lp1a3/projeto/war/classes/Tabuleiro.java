package br.edu.ifsp.spo.lp1a3.projeto.war.classes;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

public class Tabuleiro {
	public Dado dice;
	public ArrayList<Continente> continentes = new ArrayList<>();
	public static Map<Integer, Pais> mapa = new HashMap<Integer, Pais>();

<<<<<<< HEAD
	//CARREGA TODAS A CONFIGURAÃ‡Ã•ES DO JOGO
	public void loadMapConf(){
		continentes.add(new Continente("Amï¿½rica Do Norte", new int [] {1,2,3,4,5,6,7,8,9}));
=======
	//CARREGA TODAS A CONFIGURAÇÕES DO JOGO
	public void loadGameConf(){
		Map<Integer, Pais> mapa = new HashMap<Integer, Pais>();
		continentes.add(new Continente("América Do Norte", new int [] {1,2,3,4,5,6,7,8,9}));
>>>>>>> 164f472e2c0b36a1016b4dca1c00672144c13220
		mapa.put(1, new Pais("Alaska", new int [] {2, 3, 37}));
		mapa.put(2, new Pais("Mackenzie", new int [] {3, 4, 6}));
		mapa.put(3, new Pais("Vancouver", new int [] {1, 2, 4}));
		mapa.put(4, new Pais("Ottawa", new int [] {2, 3, 5, 7, 8}));
		mapa.put(5, new Pais("Labrador", new int [] {4, 6, 8}));
<<<<<<< HEAD
		mapa.put(6, new Pais("Groelï¿½ndia", new int [] {2, 5, 21}));
		mapa.put(7, new Pais("Califï¿½rnia", new int [] {3, 4, 8, 9}));
		mapa.put(8, new Pais("Nova York", new int [] {4, 5, 7, 9}));
		mapa.put(9, new Pais("Mï¿½xico", new int [] {7, 8, 10}));
		
		continentes.add(new Continente("Amï¿½rica do Sul", new int [] {10, 11, 12, 13}));
=======
		mapa.put(6, new Pais("Groelândia", new int [] {2, 5, 21}));
		mapa.put(7, new Pais("Califórnia", new int [] {3, 4, 8, 9}));
		mapa.put(8, new Pais("Nova York", new int [] {4, 5, 7, 9}));
		mapa.put(9, new Pais("México", new int [] {7, 8, 10}));
		
		continentes.add(new Continente("América do Sul", new int [] {10, 11, 12, 13}));
>>>>>>> 164f472e2c0b36a1016b4dca1c00672144c13220
		mapa.put(10, new Pais("Venezuela", new int []{9, 11, 12, 13}));
		mapa.put(11, new Pais("Peru", new int []{10, 12, 13}));
		mapa.put(12, new Pais("Brasil", new int []{10, 11, 13, 16}));
		mapa.put(13, new Pais("Argentina", new int []{11, 12}));

		continentes.add(new Continente("Ã�frica", new int []{14, 15, 16, 17, 18, 19}));
		mapa.put(14, new Pais("Madagascar", new int []{15, 19}));
		mapa.put(15, new Pais("Ã�frica do Sul", new int []{14, 17}));
		mapa.put(16, new Pais("ArgÃ©lia", new int []{12, 17, 18, 22}));
		mapa.put(17, new Pais("Congo", new int []{15, 16}));
		mapa.put(18, new Pais("Egito", new int []{16, 17, 22, 24}));
		mapa.put(19, new Pais("SudÃ£o", new int []{14, 15, 16, 17, 18}));

		continentes.add(new Continente("Europa", new int []{20, 21, 22, 23, 24, 25, 26}));
		mapa.put(20, new Pais("Inglaterra", new int []{21, 22, 23, 25} ));
		mapa.put(21, new Pais("IslÃ¢ndia", new int []{6, 20}));
		mapa.put(22, new Pais("FranÃ§a", new int []{16, 18, 20, 23, 24}));
		mapa.put(23, new Pais("Alemanha", new int []{20, 22, 24}));
		mapa.put(24, new Pais("PolÃ´nia", new int []{18, 22, 23, 26, 27}));
		mapa.put(25, new Pais("SuÃ©cia", new int []{20, 26}));
		mapa.put(26, new Pais("Moscou", new int []{24, 25, 27, 28, 29}));

		continentes.add(new Continente("Ã�sia", new int []{27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37}));
		mapa.put(27, new Pais("Oriente MÃ©dio", new int []{24, 26, 29, 30}));
		mapa.put(28, new Pais("OMSK", new int []{26, 29, 31, 33, 36}));
		mapa.put(29, new Pais("Aral", new int []{26, 27, 28, 30, 36}));
		mapa.put(30, new Pais("Ã�ndia", new int []{27, 29, 34, 36, 39}));
		mapa.put(31, new Pais("Dudinka", new int []{28, 32, 33, 35}));
		mapa.put(32, new Pais("Tchita", new int []{31, 33, 35, 36, 37}));
		mapa.put(33, new Pais("MongÃ³lia", new int []{28, 31, 32, 36}));
		mapa.put(34, new Pais("VietnÃ£", new int []{30, 36, 40}));
		mapa.put(35, new Pais("SibÃ©ria", new int []{31, 32, 37}));
		mapa.put(36, new Pais("China", new int []{28, 29, 30, 32, 33, 34, 37, 38}));
		mapa.put(37, new Pais("Vladvostok", new int []{1, 32, 33, 35, 38}));
		mapa.put(38, new Pais("JapÃ£o", new int []{36, 37}));

		continentes.add(new Continente("Oceania", new int []{39, 40, 41, 42}));
		mapa.put(39, new Pais("Sumatra", new int []{30, 42}));
		mapa.put(40, new Pais("Borneo", new int []{34, 41, 42}));
		mapa.put(41, new Pais("Nova GuinÃ©", new int []{40, 42}));
		mapa.put(42, new Pais("AustrÃ¡lia", new int []{39, 40, 41}));
	}
	
	public Tabuleiro(int diceSet){
		loadMapConf();
    }

    public String compararRolagem(){
        Dado dice = new Dado(6);
        int resultP1 = dice.rolarDado();
        int resultP2 = dice.rolarDado();
        System.out.println("Dado 1: " + resultP1 + " Dado 2: " + resultP2);
        if(resultP1 > resultP2){
            return "Venceu" + resultP1;
        }   else if(resultP1 == resultP2){
            return "Empatou";
        }   else{
            return "Perdeu";
        }
    }
    
    //Versão Luana para o método acima (auxiliar nos métodos da classe Exercito
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
