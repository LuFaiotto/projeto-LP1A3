package br.edu.ifsp.spo.lp1a3.projeto.war;

import br.edu.ifsp.spo.lp1a3.projeto.war.classes.Dado;

public class App {

	public static void main(String[] args) {
		
		Dado dadoTeste = new Dado(6);
		
		System.out.println(dadoTeste.rolarDado(6));
	}
}
