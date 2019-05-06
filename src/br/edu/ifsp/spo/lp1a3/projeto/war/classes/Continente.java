package br.edu.ifsp.spo.lp1a3.projeto.war.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import br.edu.ifsp.spo.lp1a3.projeto.war.classes.Tabuleiro;
import br.edu.ifsp.spo.lp1a3.projeto.war.classes.Pais;

@SuppressWarnings("unused")
public class Continente {
	private String nome;
	private int[] paises;
	private ArrayList<Pais> pais = new ArrayList<>();
	
	public Continente(String nome, int [] paisesRef) {
		setNome(nome);
		setPaisesRef(paisesRef);
		setPaisesArray(paisesRef);
	}
	
	
	
//GETTERS; SETTERS; OVERRIDES
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setPaisesRef(int [] paisesRef){
		this.paises = paisesRef; 
	}
	
	public Pais getPaises() {
		for(int i = 0; i < this.paises.length; i++){
			return Tabuleiro.mapa.get(paises[i]);
		}
		return null;
	}
	
	public void setPaisesArray(int[] paises) {
		for(int i = 0; i < this.paises.length; i++){
			pais.add(Tabuleiro.mapa.get(paises[i]));
		}
		System.out.println(pais.size());
		for(Pais p : pais) {
			System.out.println("SET TO STRING" + p.toString());
		}
	}
	public Pais getPaisesArray() {
		for(Pais p : pais){
			System.out.println(" pais get " + p.toString());
			return p;
		}
		return null;
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
		return "Continente: " + getNome() + Arrays.toString(paises);
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
