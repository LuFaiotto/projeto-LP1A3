package br.edu.ifsp.spo.lp1a3.projeto.war.classes;

public class Tabuleiro {
//Grafo dos territ�rios
//Array List de continentes e um continente Array List de pa�ses e um pa�s um Array List de conex�es
//String l = "Brasil; Argentina; Venezuela; Arg�lia";
//String paises = l.split(';');
//Como guardar a informa��o de onde est�o? Par Ordenado - Trio (tem ou n�o, qual player, qtos exercitos ele tem)
	
//M�todo
	//An�lise da rolagem
	//"Matar" o ex�rcito - Retorna pe�as do player, perdidas ou ganhas
	
	int diceSet = 6; //Dice game set
	
	public Tabuleiro(int diceSet){
        this.diceSet = diceSet;
    }

    public String comprarRolagem(){
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
