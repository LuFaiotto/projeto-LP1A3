package br.edu.ifsp.spo.lp1a3.projeto.war.classes;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

public class Tabuleiro {

	int diceSet;
	ArrayList<Continente> continentes = new ArrayList<>();
//Grafo dos territ�rios
//Array List de continentes e um continente Array List de pa�ses e um pa�s um Array List de conex�es
//String l = "Brasil; Argentina; Venezuela; Arg�lia";
//String paises = l.split(';');
//Como guardar a informa��o de onde est�o? Par Ordenado - Trio (tem ou n�o, qual player, qtos exercitos ele tem)
	
//M�todo
	//An�lise da rolagem
	//"Matar" o ex�rcito - Retorna pe�as do player, perdidas ou ganhas
	public void loadGameConf(){
		Map<Integer, Pais> mapa = new HashMap<Integer, Pais>();
		continentes.add(new Continente("Am�rica Do Norte", new int [] {1,2,3,4,5,6,7,8,9}));
		mapa.put(1, new Pais("Alaska", new int [] {2, 3, 37}));
		mapa.put(2, new Pais("Mackenzie", new int [] {3, 4, 6}));
		mapa.put(3, new Pais("Vancouver", new int [] {1, 2, 4}));
		mapa.put(4, new Pais("Ottawa", new int [] {2, 3, 5, 7, 8}));
		mapa.put(5, new Pais("Labrador", new int [] {4, 6, 8}));
		mapa.put(6, new Pais("Groel�ndia", new int [] {2, 5, 21}));
		mapa.put(7, new Pais("Calif�rnia", new int [] {3, 4, 8, 9}));
		mapa.put(8, new Pais("Nova York", new int [] {4, 5, 7, 9}));
		mapa.put(9, new Pais("M�xico", new int [] {7, 8, 10}));
		
		continentes.add(new Continente("Am�rica do Sul", new int [] {10, 11, 12, 13}));
		
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
