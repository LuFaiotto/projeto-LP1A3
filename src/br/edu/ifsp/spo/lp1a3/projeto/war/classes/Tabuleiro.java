package br.edu.ifsp.spo.lp1a3.projeto.war.classes;

public class Tabuleiro {
//Grafo dos territórios
//Array List de continentes e um continente Array List de países e um país um Array List de conexões
//String l = "Brasil; Argentina; Venezuela; Argélia";
//String paises = l.split(';');
//Como guardar a informação de onde estão? Par Ordenado - Trio (tem ou não, qual player, qtos exercitos ele tem)
	
//Método
	//Análise da rolagem
	//"Matar" o exército - Retorna peças do player, perdidas ou ganhas
	
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
