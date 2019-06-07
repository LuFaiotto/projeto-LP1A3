package br.edu.ifsp.spo.lp1a3.projeto.war.classes;

import java.util.Random;

public class Dado {
	public static int diceSet;
	

	//Construtor
	public Dado(int diceSet) {
		Dado.diceSet = diceSet;
	}
	//Métodos	
	public int rolarDado() {
		int valorDado = new Random().nextInt(getNumLados());
		return valorDado + 1;
	}

	//Getters e Setters
	public int getNumLados() {
		return Dado.diceSet;	
	}
}
