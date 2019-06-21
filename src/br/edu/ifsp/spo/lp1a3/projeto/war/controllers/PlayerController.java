package br.edu.ifsp.spo.lp1a3.projeto.war.controllers;

import br.edu.ifsp.spo.lp1a3.projeto.war.classes.Partida;
import br.edu.ifsp.spo.lp1a3.projeto.war.classes.Player;
import br.edu.ifsp.spo.lp1a3.projeto.war.classes.Tabuleiro;
import java.util.Scanner;


public class PlayerController {
	public static void atacar(Player p) {
		p.getPaisesDominados().get(1).atacar(p.getPaisesDominados().get(1).getPaisesConexoes().get(1), 3);
	}

	public static int opcaoPlayer() {
		Scanner input = new Scanner(System.in);
		int op;
		System.out.println("Escolha uma opção:");
		System.out.println("1. Para atacar.");
		System.out.println("2. Para movimentar tropas.");
		System.out.println("3. Para finalizar a rodada.");
		op = input.nextInt();
		input.nextLine();
		return op;
	}
	
}
