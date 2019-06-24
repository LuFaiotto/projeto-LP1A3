package br.edu.ifsp.spo.lp1a3.projeto.war.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import br.edu.ifsp.spo.lp1a3.projeto.war.App;
import br.edu.ifsp.spo.lp1a3.projeto.war.classes.GameConf;
import br.edu.ifsp.spo.lp1a3.projeto.war.classes.Partida;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class GameMapController implements Initializable {
	  @FXML
	  private Text playerName;

	  @FXML
	  private Text exercitoPlayer;

	  @FXML
	  private Text exercitoPlayer1;
  
	  @FXML
	  private Button brMovimentar;

	  @FXML
	  private Button btGuerrilhar;

	  @FXML
	  private Button btFinalizar;
	
	Partida partida = null;
	
	
	public void getPais(ActionEvent event) {
		Button b = (Button)event.getSource();
		int id;
		id = Integer.parseInt(b.getId().replaceAll("[^0-9.]", ""));
		System.out.println(GameConf.mapa.get(id).toString());
	}
	
	public void rodada() {
		
	}
	
	public void fortalecer() {
		
	}
	
	
	public void initialize() {
		
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.partida = App.partida;
	}

}
