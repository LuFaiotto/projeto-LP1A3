package br.edu.ifsp.spo.lp1a3.projeto.war;

import java.util.HashMap;
import java.util.Map;

import br.edu.ifsp.spo.lp1a3.projeto.war.classes.*;

public class App {

	public void loadGameConf() {
		
		Map<Integer, Pais> mapa = new HashMap<Integer, Pais>();
		Continente americaDoNorte = new Continente("América Do Norte", new int [] {1,2,3,4,5,6,7,8,9});
		mapa.put(1, new Pais("Alaska", new int [] {2, 3, 37}));
		mapa.put(2, new Pais("Mackenzie", new int [] {3, 4, 6}));
		mapa.put(3, new Pais("Vancouver", new int [] {1, 2, 4}));
		mapa.put(4, new Pais("Ottawa", new int [] {2, 3, 7, 8}));
		mapa.put(5, new Pais("Labrador", new int [] {}));
		mapa.put(6, new Pais("Groelândia", new int [] {}));
		mapa.put(7, new Pais("Califórnia", new int [] {}));
		mapa.put(8, new Pais("Nova York", new int [] {}));
		mapa.put(9, new Pais("México", new int [] {}));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
