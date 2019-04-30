package br.edu.ifsp.spo.lp1a3.projeto.war.classes;

import java.util.Collection;
//import java.util.HashMap;
import java.util.HashSet;
//import java.util.Map;

public class Pais {
	
	private String nome;
	private boolean status;
	private Player player;
	private int qtdExercito;
	private Collection<Pais> conexoes = new HashSet<>();
	
//	public Pais(String nome, boolean status, Player player, Collection<Pais> conexoes) {
//		super();
//		this.nome = nome;
//		this.status = status;
//		this.player = player;
//		this.conexoes = conexoes;
//	}
	
	/*Map<Integer, String> mapa = new HashMap<Integer, String>();
	
	mapa.put(1, "Argentina"); 
	mapa.put(2, "Brasil");
	mapa.put(3, "Colômbia");
	
	//System.out.println(mapa);
	
	System.out.println(mapa.get(1));*/
	
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
	public Collection<Pais> getConexoes() {
		return conexoes;
	}
	
}
