package br.edu.ifsp.spo.lp1a3.projeto.war.classes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import br.edu.ifsp.spo.lp1a3.projeto.war.classes.Tabuleiro;
import br.edu.ifsp.spo.lp1a3.projeto.war.classes.Pais;

@SuppressWarnings("unused")
public class Continente {
	private String nome;
	private int[] paises;
	private ArrayList<Pais> pais = new ArrayList<>();
	
	public Continente(String nome, int [] paises) {
		setNome(nome);
		setPaises(paises);
	}
	
	
	
//GETTERS; SETTERS; OVERRIDES
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Pais getPaises() {
		for(int pais : paises){
			for(int i = 1; i < Tabuleiro.mapa.size(); i++){	
				return Tabuleiro.mapa.get(pais);
			}
		}
		return null;
	}
	public void setPaises(int[] paises) {
		for(int i : paises){
			pais.add(Tabuleiro.mapa.get(paises));
		}
	}

//OVERRIDES
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((paises == null) ? 0 : paises.hashCode());
		return result;
	}
	@Override
	public String toString() {
		return "Continente: " + nome + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Continente other = (Continente) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (paises == null) {
			if (other.paises != null)
				return false;
		} else if (!paises.equals(other.paises))
			return false;
		return true;
	}
	
}
