package br.edu.ifsp.spo.lp1a3.projeto.war.controllers;

import java.io.IOException;
import java.util.ArrayList;

import br.edu.ifsp.spo.lp1a3.projeto.war.App;
import br.edu.ifsp.spo.lp1a3.projeto.war.classes.Player;
import br.edu.ifsp.spo.lp1a3.projeto.war.classes.Tabuleiro;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class IniciandoPartidaController {

	@FXML
    private TextField intext;

    @FXML
    private Button setBt;

    @FXML
    private Label label;

    @FXML
    private Label erroMsg;
    
    @FXML
    private Text labelText;
    
    private int dice = 0;
    private int pNum = 0;
    ArrayList<Player> players = new ArrayList<>();
    
	public void setarGame(ActionEvent event) throws IOException {
    	switch(labelText.getText()){
    	case "Digite a quantidade de lados do dado!":
    		setarDice();
    	break;
    	
    	case "Digite a quantidade de Players!" :
    		qtdPlayers();
    	break;

    	}
    }
    
    private void qtdPlayers() {
    	try {
			if(Integer.parseInt(intext.getText()) >= 2
					&& Integer.parseInt(intext.getText()) <=42) {
				int pNum = Integer.parseInt(intext.getText());
				erroMsg.setText("");
				intext.clear();
				this.pNum = pNum;
				mudarEventBotao();
				intext.setOnAction(setBt.getOnAction());
			}	else {
				erroMsg.setText("Minimo 2 players, máximo 42");
				intext.clear();
			}
		}	catch(Exception e) {
			erroMsg.setText("VOCÊ DEVE DIGITAR UM NÚMERO");
			intext.clear();
		}
	}

	public void setarDice() {
    	try {
			if(Integer.parseInt(intext.getText()) >= 4
					&& Integer.parseInt(intext.getText()) <=100) {
				this.dice = Integer.parseInt(intext.getText());
				erroMsg.setText("");
				intext.clear();
				labelText.setText("Digite a quantidade de Players!");
				
			}	else {
				erroMsg.setText("DEVE SER ENTRE 4 E 100");
				intext.clear();
			}
		}	catch(Exception e) {
			erroMsg.setText("VOCÊ DEVE DIGITAR UM NÚMERO");
			intext.clear();
		}
    }

    public void mudarEventBotao() throws IOException, InterruptedException { 		
    	labelText.setText("Nick player ");
    	
    	//LAMBDA FUNCTION PRA MUDAR O EVENTO DO BOTÃO
    	setBt.setOnAction((event) -> {
    		try {
    			if(intext.getText().isBlank() || intext.getText().isEmpty()) {
    				erroMsg.setText("Está em branco");
    			}	else {
    				this.players.add(new Player(intext.getText()));
            		intext.clear();
            		erroMsg.setText("");
    			}
    		}	catch(Exception e){
    			
    		}
    		if(this.players.size() == this.pNum){
    			try {
					partidaStart();
				} catch (IOException e) {
					e.printStackTrace();
				}
    		}
  		});	   	
    }
    
    public void partidaStart() throws IOException{
    	try {	
			App.partida = Tabuleiro.iniciarPartida(getPlayers(), getDice());
			System.out.println(App.partida);
			GameMapController gmc = new GameMapController();
			gmc.buildScreen();
		} catch (IOException e) {
			e.printStackTrace();
		}
    } 
    
    public int getDice() {
		return dice;
	}

	public void setDice(int dice) {
		this.dice = dice;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

}
