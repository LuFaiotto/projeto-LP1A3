package br.edu.ifsp.spo.lp1a3.projeto.war.controllers;

import java.util.ArrayList;

import br.edu.ifsp.spo.lp1a3.projeto.war.classes.Partida;
import br.edu.ifsp.spo.lp1a3.projeto.war.classes.Player;
import br.edu.ifsp.spo.lp1a3.projeto.war.classes.Tabuleiro;
import java.util.Scanner;

public class PartidaController {
	public static Partida iniciarJogo(ArrayList<Player> players, int diceSet) {	
		return Tabuleiro.iniciarPartida(players, diceSet);	
	}
	

	
}
