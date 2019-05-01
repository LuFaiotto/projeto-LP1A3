package br.edu.ifsp.spo.lp1a3.projeto.war.classes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@SuppressWarnings("unused")
public class Pais {
	
	private String nome;
	private boolean status;
	private Player player;
	private int qtdExercito;
	private int [] conexoes;
	

	public Pais(String nome, int[] conexoes) {
		this.nome = nome;
		this.status = false;
		this.player = null;
		this.conexoes = conexoes;
	}
	
	
	
	public String getNome() {
		return nome;
	}
	public boolean isStatus() {
		return status;
	}
	public Player getPlayer() {
		return player;
	}
	public int getQtdExercito() {
		return qtdExercito;
	}
	public void setQtdExercito(int qtdExercito) {
		this.qtdExercito = qtdExercito;
	}
	public int[] getConexoes() {
		return conexoes;
	}
	
}
