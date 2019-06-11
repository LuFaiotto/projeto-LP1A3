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
	
	//TODO: Verificar validação do método getNumLados da classe Dado.
	public void atacar(Pais atacante, Pais atacado, int qtdExercito) {
		int valorRetornado;
		boolean resultadoFinal = false;
		
		if(validarConexao(atacado) && validarAtaque(qtdExercito)) {
			for(int i = 0; i < qtdExercito; i++) {
				valorRetornado = Tabuleiro.compareRolagemDados(Dado.diceSet);
				if(valorRetornado == 1) {
					atacado.setQtdExercito(atacado.getQtdExercito() - 1);
					System.out.println("Vitória. Um exército oponente foi destruído.");
				} else if (valorRetornado == 0){
					atacante.setQtdExercito(atacante.getQtdExercito() - 1);
					System.out.println("Empate. Um exército seu foi destruído.");
				} else {
					atacante.setQtdExercito(atacante.getQtdExercito() - 1);
					System.out.println("Derrota. Um exército seu foi destruído.");
				}
				
				//Valida se o atacado ainda possui exército
				if(atacado.getQtdExercito() == 0) {
					i = qtdExercito;
					resultadoFinal = true;
				}
			}
			
			Tabuleiro.validarVencedor(resultadoFinal);
		}
	}
	
	public String movimentarExercito(Pais paisFuturo, int qtdExercito) {
		if(validarConexao(paisFuturo) && qtdExercito < this.getQtdExercito()) {
			this.setQtdExercito(this.getQtdExercito() - qtdExercito);
			paisFuturo.setQtdExercito(paisFuturo.getQtdExercito() + qtdExercito);
			return "Exército movimentado com sucesso";
		}
		return "Não é possível realizar essa movimentação";
	}
	
	
	
//VALIDAÇÕES
	public boolean validarConexao(Pais atacado) {
		for(Pais pais: this.getPaisesConexoes()) {
			if(pais.equals(atacado)) {
				return true;
			}
		}
		return false;
	}
	//Método que valida se o atacante possui estrutura para cometer o ataque
	//O que fazer: Avaliar se a quantidade de exércitos escolhidos está, no máximo, com a quantidade de
	//exércitos posicionados no país de ataque - 1 (exército base)
	public boolean validarAtaque(int qtdExercito) {
		if(qtdExercito > this.getQtdExercito()) {
			return true;
		}
		System.out.println("Você não possui exército suficiente em " + this.getNome() + " para atacar.");
		return false;
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
		return "Pais " + this.getNome() + " Dominador: " + this.getPlayer().getNamePlayer();	
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