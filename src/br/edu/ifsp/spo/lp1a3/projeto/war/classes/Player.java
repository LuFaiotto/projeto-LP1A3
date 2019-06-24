package br.edu.ifsp.spo.lp1a3.projeto.war.classes;

import java.util.ArrayList;

import br.edu.ifsp.spo.lp1a3.projeto.war.App;
import br.edu.ifsp.spo.lp1a3.projeto.war.controllers.GameMapController;
import br.edu.ifsp.spo.lp1a3.projeto.war.controllers.PlayerController;

public class Player {
	
	private String namePlayer;
	private boolean statusPlayer;
	private String cor;
	private int exercitosLivres;
	private ArrayList<Pais> paisesDominados = new ArrayList<>();
	
	public Player(String nome) {
		setNamePlayer(nome);
		setStatusPlayer(true);
	}

	public void jogar(boolean jogando) throws InterruptedException{
		while(jogando){
			wait();
		}
		return;
	}
	
	public void adicionarExercito(Pais pais, int qtdExercito) {
		if(this.equals(pais.getPlayer())) {
			pais.setQtdExercito(pais.getQtdExercito() + qtdExercito);
			System.out.println(qtdExercito + " adicionados ao pa�s " + pais.getNome());
		} else {
			System.out.println("Voc� n�o pode adicionar ex�rcito em um pa�s de outro player.");
		}		
	}
	

	//TODO: M�todo n�o est� totalmente implementado. Interfer�ncia de interface gr�fica
	public void fortalecerTerritorios(Pais pais, int qtdExercitos) {
		System.out.println("Voc� possui " + getExercitosLivres() + "para adicionar ao jogo.");
		while(getExercitosLivres() != 0) {
			//Seleciona o pa�s que o player quer adicionar e a qtd
			if(qtdExercitos > getExercitosLivres()) {
				System.out.println("Quantidade de ex�rcitos inv�lida.");
			} else {
				adicionarExercito(pais, qtdExercitos);
				setExercitosLivres(getExercitosLivres()-qtdExercitos);
			}
		}
	}
	
	
	//Getters e Setters
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getNamePlayer() {
		return namePlayer;
	}

	public void setNamePlayer(String namePlayer) {
		this.namePlayer = namePlayer;
	}

	public boolean isStatusPlayer() {
		return statusPlayer;
	}

	public void setStatusPlayer(boolean statusPlayer) {
		this.statusPlayer = statusPlayer;
	}	
	public int getExercitosLivres() {
		return exercitosLivres;
	}
	public void setExercitosLivres(int exercitosLivres) {
		this.exercitosLivres = exercitosLivres;
	}
	public void setPaisesDominados(Pais paisDominado) {
		this.paisesDominados.add(paisDominado);
		paisDominado.setPlayer(this);

	}
	public ArrayList<Pais> getPaisesDominados() {
		return paisesDominados;
	}



	//Overrides
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((namePlayer == null) ? 0 : namePlayer.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Player: " + namePlayer + ", Exercitos Livres: " + exercitosLivres;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (namePlayer == null) {
			if (other.namePlayer != null)
				return false;
		} else if (!namePlayer.equals(other.namePlayer))
			return false;
		return true;
	}
}
