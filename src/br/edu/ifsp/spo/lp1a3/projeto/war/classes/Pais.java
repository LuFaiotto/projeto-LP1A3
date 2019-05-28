package br.edu.ifsp.spo.lp1a3.projeto.war.classes;

import java.util.ArrayList;
import java.util.Arrays;

public class Pais {
	private String nome;
	private boolean status;
	private Player player;
	private int qtdExercito;
	private int [] conexoes;
	private String cor;


	public Pais(String nome, int[] conexoes) {
		this.nome = nome;
		this.status = false;
		this.player = null;
		this.conexoes = conexoes;
		setQtdExercito(0);
		setCor("Sem cor");
	}
	
//GETTERS AND SETTERS
	public String getNome() {
		return nome;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public boolean isStatus() {
		return status;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player p){
		this.player = p;
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
	public Pais getConexaoPorReferencia(int ref){
		for(int i = 0; i < conexoes.length; i++){
			if(ref == conexoes[i]){
				return GameConf.mapa.get(ref);
			}
		}
		return null;
	}
	public ArrayList<Pais> getPaisesConexoes() {
		ArrayList<Pais> paises = new ArrayList<>();
		for(int i : conexoes){
			paises.add(GameConf.mapa.get(i));
		}
		return paises;
	}
	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}


//OVERRIDES
	@Override
	public String toString() {
		if(status == true)
			return "Pais " + getNome() + ", Dominador: " + getPlayer() + ", Fronteiras: " + Arrays.toString(getConexoes());
		else 
			return  "Pais " + getNome() + ", Ocupação: " + isStatus() +  ", Fronteiras: " + Arrays.toString(getConexoes());
 
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(conexoes);
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
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
		if (!Arrays.equals(conexoes, other.conexoes))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
	

	
