package br.edu.ifsp.spo.lp1a3.projeto.war.classes;

import java.util.Random;

public class Dado {

	private int diceSet;
	//M�todos
	public int rolarDado() {
		int valorDado = new Random().nextInt(getNumLados());
		return valorDado + 1;
	}

	//Construtor
	public Dado(int lados) {
		setNumLados(lados);
	}	
	//Getters e Setters
	public int getNumLados() {
		return this.diceSet;	
	}
	public void setNumLados(int numLados) {
		this.diceSet = numLados;
	}
	
}
