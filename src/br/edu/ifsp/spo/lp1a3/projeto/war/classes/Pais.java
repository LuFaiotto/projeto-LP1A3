package br.edu.ifsp.spo.lp1a3.projeto.war.classes;

import java.util.ArrayList;
import java.util.Arrays;
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


	//OVERRIDE
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + qtdExercito;
		return result;
	}

	@Override
	public String toString() {
		return "Pais " + nome + ", Ocupação: " + status + ", Dominador: " + player + ", Fronteiras: " + Arrays.toString(conexoes);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pais other = (Pais) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (qtdExercito != other.qtdExercito)
			return false;
		return true;
	}
	
}
