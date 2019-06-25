package br.edu.ifsp.spo.lp1a3.projeto.war.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import br.edu.ifsp.spo.lp1a3.projeto.war.App;
import br.edu.ifsp.spo.lp1a3.projeto.war.classes.GameConf;
import br.edu.ifsp.spo.lp1a3.projeto.war.classes.Pais;
import br.edu.ifsp.spo.lp1a3.projeto.war.classes.Partida;
import br.edu.ifsp.spo.lp1a3.projeto.war.classes.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class GameMapController implements Initializable {
	
	@FXML
    private Text paisSelect; 
	
	@FXML
	private Text playerName = null;

	@FXML
	private Text exercitoPlayer = null;

	@FXML
	public  Text msg;
	  
	@FXML
	public  Text time;

	@FXML
	private  Text paisesPlayer = null;
  
	@FXML
	private Button brMovimentar;

	@FXML
	private Button btGuerrilhar;

	@FXML
	private Button btFinalizar;
	 
	@FXML
	private Button setar;
	  
	@FXML
	private TextField inputPlayer;
	
	static Partida partida = null;
	  
	Pais paisSelecionado = null;
	Pais atacar = null;
	  
	static Player jogador;;
	  
	int exercito = 0;
	
	//NOTE: O BOTÃO MOVIMENTAR ESTÁ COM O PADRÃO ERRADO DE NOME, INVÉS DE BT ESTÁ BR
	
	public void jogando(Player p){
		if(p == null) {
			partida.iniciarRodadas();
			jogando(partida.getRodada().proximo());		  
		}
		else {
			jogador = p; 
			acaoDoPlayer();
		}
	}
	 
	public void acaoDoPlayer() {
		if(jogador.getExercitosLivres() > 0){
			msg.setText("Fortaleça seus territórios, Camarada!");
			btGuerrilhar.setOnAction(null);
			brMovimentar.setOnAction(null);
		}
	}
	
	
	/*
	 * Foi usado o seguinte método no mapa: Usamos um HashMap com keys de 1 até 42(qtd de países)
	 * cara botão tem seu id no seguinte padrão pX, onde x é o número correspondente do país no map
	 * ao clicar o método abaixo pega apenas o número desse padrão e busca no map e seleciona se for do player.
	 */
	public void getPais(ActionEvent event) {
		Button b = (Button)event.getSource();
		int id;
		id = Integer.parseInt(b.getId().replaceAll("[^0-9.]", ""));
		if(GameConf.mapa.get(id).getPlayer().equals(jogador)) {
			msg.setText("");
			paisSelecionado = GameConf.mapa.get(id);
			paisSelect.setText(paisSelecionado.toString());
		}	else
			msg.setText("O país não é seu!");
	}
	  
	public void finalizarJogada() {
		jogando(partida.getRodada().proximo());
		paisSelecionado = null;
		atacar = null;
		atualizar();	
	}
	
	public void guerrilhar() {
		setar.setDisable(false);
		inputPlayer.setDisable(false);
		if(paisSelecionado != null && atacar != null) {
			while(exercito == 0 && exercito < 0) {
				msg.setText("Quantidade de exercitos");
			}
			paisSelecionado.atacar(atacar, exercito);
		}
	}
	
	public Pais selecionar(ActionEvent event) {	
		Button b = (Button)event.getSource();
		int id;
		id = Integer.parseInt(b.getId().replaceAll("[^0-9.]", ""));
		return paisSelecionado = GameConf.mapa.get(id);
	}
	
	public void jogar () {
		
	}
	
	public void getInt(ActionEvent e) {
		
	}
	
	public void fortalecer() {
		
	}
	
	public void initialize() {
		System.out.println(jogador.getNamePlayer());
		
	}
	public void buildScreen() throws IOException{
		this.partida = App.partida;
		partida.iniciarRodadas();
		jogando(partida.getRodada().proximo());
		Parent root = FXMLLoader.load(getClass().getResource("../GameMap.fxml"));
		Scene scene = new Scene(root);
		App.changeScene(scene);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		playerName.setText("" +jogador.getNamePlayer());
		paisesPlayer.setText("" + jogador.getPaisesDominados().size());
		exercitoPlayer.setText("" + jogador.getExercitosLivres());
		msg.setText("");
	}

	public void atualizar() {
		playerName.setText("" +jogador.getNamePlayer());
		paisesPlayer.setText("" + jogador.getPaisesDominados().size());
		exercitoPlayer.setText("" + jogador.getExercitosLivres());
		msg.setText("");
		paisSelect.setText("");
	}

}
