package br.edu.ifsp.spo.lp1a3.projeto.war.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import br.edu.ifsp.spo.lp1a3.projeto.war.App;
import br.edu.ifsp.spo.lp1a3.projeto.war.classes.GameConf;
import br.edu.ifsp.spo.lp1a3.projeto.war.classes.Pais;
import br.edu.ifsp.spo.lp1a3.projeto.war.classes.Partida;
import br.edu.ifsp.spo.lp1a3.projeto.war.classes.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class GameMapController implements Initializable {
	
	@FXML
    private Text paisSelect; 
	
	  @FXML
	  private Text playerName;

	  @FXML
	  private Text exercitoPlayer;

	  @FXML
	  private Text paisesPlayer;
  
	  @FXML
	  private Button brMovimentar;

	  @FXML
	  private Button btGuerrilhar;

	  @FXML
	  private Button btFinalizar;
	  
	  @FXML
	  private TextField inputPlayer;
	
	  Partida partida = null;
	  
	  Pais paisSelecionado = null;
	
	  public static Player jogando = null;
	
	public void getPais(ActionEvent event) {
		
		Button b = (Button)event.getSource();
		int id;
		id = Integer.parseInt(b.getId().replaceAll("[^0-9.]", ""));
		if(GameConf.mapa.get(id).getPlayer().equals(jogando))
			paisSelecionado = GameConf.mapa.get(id);
	}
	
	public void finalizarJogada() throws InterruptedException {
		jogando.jogar(false);
	}
	
	public void guerrilhar() {
		if()
	}
	
	public void jogar () throws InterruptedException {
		
	}
	
	public void getInt(ActionEvent e) {
		
	}
	public void rodada() {
		
	}
	
	public void fortalecer() {
		
	}
	
	public void atulizarTela(Player jogando) {
		playerName.setText(jogando.getNamePlayer());
		exercitoPlayer.setText("" + jogando.getExercitosLivres());
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.partida = App.partida;
		
		atulizarTela(jogando)
	}
	

}
