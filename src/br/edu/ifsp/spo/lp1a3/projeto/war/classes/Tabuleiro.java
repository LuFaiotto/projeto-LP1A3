package br.edu.ifsp.spo.lp1a3.projeto.war.classes;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

public class Tabuleiro {
	public Dado dice;
	public static ArrayList<Continente> continentes = new ArrayList<>();
	public static Map<Integer, Pais> mapa = new HashMap<>();

	
	public Tabuleiro(int diceSet){
		//loadMapConf();
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
