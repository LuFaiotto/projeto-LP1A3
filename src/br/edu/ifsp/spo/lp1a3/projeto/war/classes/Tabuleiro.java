package br.edu.ifsp.spo.lp1a3.projeto.war.classes;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

public class Tabuleiro {
	public static ArrayList<Continente> continentes = new ArrayList<>();
	public static Map<Integer, Pais> mapa = new HashMap<>();


	public static int compareRolagemDados(int ladosDado) {
    	Dado dado = new Dado(ladosDado);
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
	
}
