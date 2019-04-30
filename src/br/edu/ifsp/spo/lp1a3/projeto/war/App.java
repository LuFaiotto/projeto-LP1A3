package br.edu.ifsp.spo.lp1a3.projeto.war;

import br.edu.ifsp.spo.lp1a3.projeto.war.classes.*;

public class App {
	
//	public void iniciarPartida() {
//		Map<Integer, Pais> mapa = new HashMap<Integer, Pais>();
//		mapa.put(1, new Pais());
//	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
//		Dado dadoTeste = new Dado(6);
//		
//		System.out.println(dadoTeste.rolarDado(6));
		
//		Dado dadoTeste = new Dado(6);

		//dice compare
		Partida partida = new Partida(4, 6);
		partida.distribuirTerritorio(4);
		Tabuleiro tabuleiro = new Tabuleiro(partida);
		System.out.println(tabuleiro.compararRolagem());
		int venceu = 0, perdeu = 0, empatou = 0;
		for(int i = 0; i < 100; i ++){

			if(tabuleiro.compararRolagem().equals("Venceu")){
				venceu++;
			}	else if(tabuleiro.compararRolagem().equals("Empatou")) {
				empatou++;
			} else {
				perdeu++;
			}
		}
		System.out.println("ganhou " + venceu);
		System.out.println("perder " + perdeu);
		System.out.println("empatou" + empatou);
	}
}
