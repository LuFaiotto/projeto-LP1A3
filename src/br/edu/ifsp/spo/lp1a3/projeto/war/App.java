package br.edu.ifsp.spo.lp1a3.projeto.war;

import br.edu.ifsp.spo.lp1a3.projeto.war.classes.*;

public class App {

	public static void main(String[] args) {
		
//		Dado dadoTeste = new Dado(6);
//		
//		System.out.println(dadoTeste.rolarDado(6));
		
//		Dado dadoTeste = new Dado(6);

		//dice compare
		Tabuleiro tabuleiro = new Tabuleiro(6);
		System.out.println(tabuleiro.comprarRolagem());
		int venceu = 0, perdeu = 0, empatou = 0;
		for(int i = 0; i < 100; i ++){

			if(tabuleiro.comprarRolagem().equals("Venceu")){
				venceu++;
			}	else if(tabuleiro.comprarRolagem().equals("Empatou")) {
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
