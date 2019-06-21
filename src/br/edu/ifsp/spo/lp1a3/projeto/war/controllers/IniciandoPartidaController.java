package br.edu.ifsp.spo.lp1a3.projeto.war.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
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
    
    private int dice;
    
    public void setarGame(ActionEvent event) {
    	switch(labelText.getText()){
    	case "Digite a quantidade de lados do dado!":
    		try {
    			if(Integer.parseInt(intext.getText()) >= 4
    					&& Integer.parseInt(intext.getText()) <=100) {
    				this.dice = Integer.parseInt(intext.getText());
    				erroMsg.setText("");
    				intext.clear();
    				labelText.setText("Digite a quantidade de Players!");
    				
    			}	else {
    				erroMsg.setText("DEVE SER ENTRE 4 E 100");
    				intext.undo();
    			}
    		}	catch(Exception e) {
    			erroMsg.setText("VOCÊ DEVE DIGITAR UM NÚMERO");
    			intext.clear();
    		}
    	break;
    	
    	case "Digite a quantidade de Players!" :
    		try {
    			if(Integer.parseInt(intext.getText()) >= 2
    					&& Integer.parseInt(intext.getText()) <=42) {
    				this.dice = Integer.parseInt(intext.getText());
    				
    			}	else {
    				erroMsg.setText("Minimo 2 players, máximo 42");
    				intext.undo();
    			}
    		}	catch(Exception e) {
    			erroMsg.setText("VOCÊ DEVE DIGITAR UM NÚMERO");
    			intext.clear();
    		}
    	break;
    	}
    }
    
    public void setarPlayers() {
    	
    }
    
}
