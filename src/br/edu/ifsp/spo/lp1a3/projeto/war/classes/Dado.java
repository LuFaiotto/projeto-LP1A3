package br.edu.ifsp.spo.lp1a3.projeto.war.classes;

import java.util.Random;

public class Dado {

	private int numLados;

	//Construtor
	public Dado(int lados) {
		setNumLados(lados);
	}
	
	//Getters e Setters
	public int getNumLados() {
		return this.numLados;
	}

	public void setNumLados(int numLados) {
		this.numLados = numLados;
	}
	
	//Métodos
	public int rolarDado() {
		int valorDado = new Random().nextInt(getNumLados());
		return valorDado + 1;
	}
	
}
