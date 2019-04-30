package br.edu.ifsp.spo.lp1a3.projeto.war.classes;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

public class Tabuleiro {

	int diceSet;
	ArrayList<Continente> continentes = new ArrayList<>();
//Grafo dos territórios
//Array List de continentes e um continente Array List de países e um país um Array List de conexões
//String l = "Brasil; Argentina; Venezuela; Argélia";
//String paises = l.split(';');
//Como guardar a informação de onde estão? Par Ordenado - Trio (tem ou não, qual player, qtos exercitos ele tem)
	
//Método
	//Análise da rolagem
	//"Matar" o exército - Retorna peças do player, perdidas ou ganhas
	public void loadGameConf(){
		Map<Integer, Pais> mapa = new HashMap<Integer, Pais>();
		continentes.add(new Continente("América Do Norte", new int [] {1,2,3,4,5,6,7,8,9}));
		mapa.put(1, new Pais("Alaska", new int [] {2, 3, 37}));
		mapa.put(2, new Pais("Mackenzie", new int [] {3, 4, 6}));
		mapa.put(3, new Pais("Vancouver", new int [] {1, 2, 4}));
		mapa.put(4, new Pais("Ottawa", new int [] {2, 3, 5, 7, 8}));
		mapa.put(5, new Pais("Labrador", new int [] {4, 6, 8}));
		mapa.put(6, new Pais("Groelândia", new int [] {2, 5, 21}));
		mapa.put(7, new Pais("Califórnia", new int [] {3, 4, 8, 9}));
		mapa.put(8, new Pais("Nova York", new int [] {4, 5, 7, 9}));
		mapa.put(9, new Pais("México", new int [] {7, 8, 10}));
		
		continentes.add(new Continente("América do Sul", new int [] {10, 11, 12, 13}));
		
	}

	
	
//	public Tabuleiro() {
//		
//	}
	
	public Tabuleiro(Partida partida){
        this.diceSet = partida.getDiceset();
    }

    public String compararRolagem(){
        Dado dice = new Dado(6);
        int resultP1 = dice.rolarDado();
        int resultP2 = dice.rolarDado();
        System.out.println("Dado 1: " + resultP1 + " Dado 2: " + resultP2);
        if(resultP1 > resultP2){
            return "Venceu";
        }   else if(resultP1 == resultP2){
            return "Empatou";
        }   else{
            return "Perdeu";
        }
    }
}
