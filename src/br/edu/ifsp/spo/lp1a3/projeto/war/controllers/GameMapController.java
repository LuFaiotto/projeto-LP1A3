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
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class GameMapController implements Initializable {
	
	@FXML
    private Text paisSelect; 
	
	@FXML
    private Text paisSelect2; 

	
	@FXML
	private Text playerName = null;

	@FXML
	private Text exercitoPlayer = null;

	@FXML
	public  Text msg;
	  
	@FXML
	public  Text modeText;

	@FXML
	private  Text paisesPlayer = null;
  
	@FXML
	private Button brMovimentar;
	
	@FXML
	private Button play;

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
	Pais paisSelecionado2 = null;
	
	boolean atacar = false;
	boolean movimentar = false;

	
	//verifica se o player tem exercito pra possicionar e o obriga a fazer
	boolean obrigacao;
	  
	static Player jogador;;
	  
	int exercito = 0;
	
	//NOTE: O BOTÃO MOVIMENTAR ESTÁ COM O PADRÃO ERRADO DE NOME, INVÉS DE BT ESTÁ BR
	
	public void jogando(Player p){
		if(p == null) {
			atacar = false;
			movimentar = false;
			partida.iniciarRodadas();
			jogando(partida.getRodada().proximo());		  
		}
		else {
			atacar = false;
			movimentar = false;
			jogador = p; 
		}
	}
	 
	public void acaoDoPlayer() {
		if(jogador.getExercitosLivres() > 0){
			obrigacao = true;
			btGuerrilhar.setOnAction(null);
			brMovimentar.setOnAction(null);
			inputPlayer.setDisable(false);
			setar.setDisable(false);
			msg.setText("Fortaleça seus territórios, Camarada!");
		}
		else {
			atualizar();
			inputPlayer.setDisable(true);
			setar.setDisable(true);
			obrigacao = false;
			
			btGuerrilhar.setOnAction((event) -> {
				if(paisSelecionado != null) {
					modoAtacar();
				}
				else msg.setText("Selecione um país, camarada!");
			});
			
			brMovimentar.setOnAction((event) -> {
				if(paisSelecionado != null) {
					modoMovimentar();
				}
				else msg.setText("Selecione um país, camarada!");
			});
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
		if(atacar) {
			if(!GameConf.mapa.get(id).getPlayer().equals(jogador)) {
				msg.setText("");
				paisSelecionado2 = GameConf.mapa.get(id);
				paisSelect2.setText(""+paisSelecionado2.toString());
				setar.setDisable(false);
				inputPlayer.setDisable(false);
				play.setVisible(true);
				play.setOnAction(setar.getOnAction());
			}	else
				msg.setText("É seu camarada, parça");
		}
		else if (movimentar) {
			if(GameConf.mapa.get(id).getPlayer().equals(jogador) 
					&& GameConf.mapa.get(id) != paisSelecionado) {
				msg.setText("");
				paisSelecionado2 = GameConf.mapa.get(id);
				paisSelect2.setText(paisSelecionado2.toString());
				setar.setDisable(false);
				inputPlayer.setDisable(false);
				play.setVisible(true);
				play.setOnAction(setar.getOnAction());
			}	else
				msg.setText("País invalido");
		}
		else {	
			play.setVisible(false);
			if(GameConf.mapa.get(id).getPlayer().equals(jogador)) {
				msg.setText("");
				paisSelecionado = GameConf.mapa.get(id);
				paisSelect.setText(paisSelecionado.toString());
			}	else {
				if(obrigacao) {
					msg.setText("País inimigo");
				}
				else {
					paisSelecionado2 = GameConf.mapa.get(id);
					paisSelect2.setText("Inimigo: "+paisSelecionado2.toString());
				}
			}
		}
	}
	  
	public void finalizarJogada() {
		if(obrigacao) 
			msg.setText("Você precisa ao menos fortalecer seus territórios");
		else{
			jogando(partida.getRodada().proximo());
			paisSelecionado = null;
			paisSelecionado2 = null;
			atualizar();
			acaoDoPlayer();
		}
	}
	
	public Pais selecionar(ActionEvent event) {	
		Button b = (Button)event.getSource();
		int id;
		id = Integer.parseInt(b.getId().replaceAll("[^0-9.]", ""));
		return paisSelecionado = GameConf.mapa.get(id);
	}
	
	//Ativa e desativa modo de ataque
	public void modoAtacar() {
		if(atacar) {
			atacar=false;
			modeText.setText("");
			setar.setDisable(true);
		}
		else {
			atacar=true;
			modeText.setText("Modo: atacar");
			movimentar = false;
		}
	}
	
	//Ativa e desativa movimentar
	public void modoMovimentar() {
		if(movimentar) {
			movimentar=false;
			modeText.setText("");
			setar.setDisable(true);
		}
		else {
			movimentar=true;
			modeText.setText("Modo: movimentar");
			atacar = false;
		}
	}
	
	public void getInt(ActionEvent e) {
		try {
			if(obrigacao) {
				obrigarFortalecer();
			}
			else if(movimentar) {
				movimentar();
			}
			else if(atacar) {
				atacar();
			}
		}	catch(Exception exc) {
			msg.setText("Digite um número");
			inputPlayer.clear();
		}
	}
	
	public void atacar() {
		if(Integer.parseInt(inputPlayer.getText()) < paisSelecionado.getQtdExercito()
				&& Integer.parseInt(inputPlayer.getText()) > 0 
				&& Integer.parseInt(inputPlayer.getText()) <=3) {
			paisSelecionado.atacar(paisSelecionado2, Integer.parseInt(inputPlayer.getText()));
		}
	}
	
	public void movimentar() {
		if(Integer.parseInt(inputPlayer.getText()) < paisSelecionado.getQtdExercito()
				&& Integer.parseInt(inputPlayer.getText()) > 0){
			paisSelecionado.movimentarExercito(paisSelecionado2,  Integer.parseInt(inputPlayer.getText()));
		}
		else
			msg.setText("Número inválido");
	}
	public void obrigarFortalecer() {
		if(paisSelecionado != null) {
			if(Integer.parseInt(inputPlayer.getText()) <= jogador.getExercitosLivres()) {
					int qtd = Integer.parseInt(inputPlayer.getText());
					jogador.fortalecerTerritorios(paisSelecionado, qtd);
					msg.setText("Você fortaleceu seu território");
					inputPlayer.clear();
					exercitoPlayer.setText("" + jogador.getExercitosLivres());
					paisSelect.setText(paisSelecionado.toString());
					if(jogador.getExercitosLivres() == 0)
						acaoDoPlayer();
			}
			else
				msg.setText("Número inválido, camarada");
		}
		else {
			msg.setText("Selecione um país");
		}
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
		acaoDoPlayer();
	}

	public void atualizar() {
		play.setVisible(false);
		playerName.setText("" +jogador.getNamePlayer());
		paisesPlayer.setText("" + jogador.getPaisesDominados().size());
		exercitoPlayer.setText("" + jogador.getExercitosLivres());
		msg.setText("");
		if(paisSelecionado != null)
			paisSelect.setText("" +paisSelecionado.toString());
		
	}

}
