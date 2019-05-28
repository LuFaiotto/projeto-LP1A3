package br.edu.ifsp.spo.lp1a3.projeto.war.classes;

import java.util.Random;

public class Dado {

	static int diceSet = Partida.diceset;
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
