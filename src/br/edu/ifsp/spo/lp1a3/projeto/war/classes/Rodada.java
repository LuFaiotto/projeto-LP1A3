package br.edu.ifsp.spo.lp1a3.projeto.war.classes;

public class Rodada {
	
	private int ladosDado;
	private Player player;
	
	public Rodada(int numLados, Player player) {
		setPlayer(player);
	}
	
	public void iniciarRodada() {
		
	}
	
//	//Adicionar um ex�rcito a um pa�s que j� possui o ex�rcito base
//		public void adicionarExercito(Player player, Pais pais, int qtdExercito) {
//			//Valida se o ex�rcito base � o mesmo do player
//			//Se sim:
//			pais.setQtdExercito(pais.getQtdExercito() + qtdExercito);
//			System.out.println(qtdExercito + " adicionados ao pa�s " + pais.getNome());
//			//Sen�o:
//			System.out.println("Voc� n�o pode adicionar ex�rcito em um pa�s de outro player.");
//		}
	
	//TODO: Fazer a validação se o player tem permissão para fazer o movimento
	public void adicionarExercito(Pais pais, int qtdExercito) {
		//Validação se o exéricito base é o mesmo do player
		//Se sim:
		pais.setQtdExercito(pais.getQtdExercito() + qtdExercito);
		System.out.println(qtdExercito + " adicionados ao pa�s " + pais.getNome());
		//Senão:
		System.out.println("Voc� n�o pode adicionar ex�rcito em um pa�s de outro player.");
	}
	
//	//Método utilizado ao conquistar um território ou ao querer movimentar exércitos entre países
//		public String movimentarExercito(Pais paisAtual, Pais paisFuturo, int qtdExercito) {
//			if(validarConexao() && qtdExercito < paisAtual.getQtdExercito()) {
//				paisAtual.setQtdExercito(paisAtual.getQtdExercito() - qtdExercito);
//				paisFuturo.setQtdExercito(paisFuturo.getQtdExercito() + qtdExercito);
//				return "Exército movimentado com sucesso";
//			}
//			return "Não é possível realizar essa movimentação";
//		}
	
	public String movimentarExercito(Pais paisAtual, Pais paisFuturo, int qtdExercito) {
		return "";
	}

	@SuppressWarnings("unused")
	private Player getPlayer() {
		return player;
	}

	private void setPlayer(Player player) {
		this.player = player;
	}

}
