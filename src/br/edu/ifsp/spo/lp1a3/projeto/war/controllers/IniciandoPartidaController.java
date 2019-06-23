package br.edu.ifsp.spo.lp1a3.projeto.war.controllers;

import java.io.IOException;
import java.util.ArrayList;

import br.edu.ifsp.spo.lp1a3.projeto.war.App;
import br.edu.ifsp.spo.lp1a3.projeto.war.classes.Player;
import br.edu.ifsp.spo.lp1a3.projeto.war.classes.Tabuleiro;
import javafx.event.ActionEvent;
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
				setarPlayers();
				
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

    public void setarPlayers() throws IOException, InterruptedException { 		
    	labelText.setText("Nick player ");
    	setBt.setOnAction((event) -> {
    		this.players.add(new Player(intext.getText()));
    		intext.clear();
    		System.out.println(players);
    		System.out.println(pNum);
  		});
    	while(true){
    		wait();
    		if(this.players.size() < this.pNum) {
    			partidaStart();
    		}
    	}
    	
    	
    }
    
   
    
    public void partidaStart() throws IOException{
    	System.out.println(this.players);
    	System.out.println(this.dice);
    	/*App.partida = Tabuleiro.iniciarPartida(this.players, this.dice);
    	Parent root = FXMLLoader.load(getClass().getResource("../PartidaTela.fxml"));
    	App.changeScene(new Scene(root));*/
    } 
}
