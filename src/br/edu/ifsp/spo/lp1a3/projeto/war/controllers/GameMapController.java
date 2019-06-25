package br.edu.ifsp.spo.lp1a3.projeto.war.controllers;

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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class GameMapController implements Initializable {
	
	@FXML
    private Text paisSelect; 
	
	  @FXML
	  private static Text playerName;

	  @FXML
	  private static Text exercitoPlayer;

	  @FXML
	  public static Text msg;
	  
	  @FXML
	  public static Text time;

	  @FXML
	  private static Text paisesPlayer;
  
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
	
	  Partida partida = null;
	  
	  Pais paisSelecionado = null;
	  Pais atacar = null;
	  
	  int exercito = 0;
	  
	
	  public static Player jogando = null;
	
	  public void getPais(ActionEvent event) {
		Button b = (Button)event.getSource();
		int id;
		id = Integer.parseInt(b.getId().replaceAll("[^0-9.]", ""));
		if(GameConf.mapa.get(id).getPlayer().equals(jogando))
			paisSelecionado = GameConf.mapa.get(id);
		else
			atacar = GameConf.mapa.get(id);
	  }
	
	 public static void teste(ActionEvent e) {
		
	 }
	  
	public void finalizarJogada() {
		if(proximo(jogando) == null)
			partida.iniciarRodadas();
		else
			jogando = proximo(jogando);
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
	
	public static void atualizarTela() {
		playerName.setText(jogando.getNamePlayer());
		paisesPlayer.setText("" + jogando.getPaisesDominados().size());
		exercitoPlayer.setText("" + jogando.getExercitosLivres());
		msg.setText("");
	}
	public void initialize(Player player){
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.partida = App.partida;
		System.out.println(partida.getPlayers());
		System.out.println("1");
		App.partida.iniciarRodadas();
	}

	public Player proximo(Player player) {
		for(int i = 0; i < partida.getPlayers().size() - 1 ; i++) {
			if(partida.getPlayers().get(i).equals(player)) {
				if(partida.getPlayers().get(i+1) != player)
					return partida.getPlayers().get(i+1);
				else
					return null;
			}
		}
		return null;
	}

	public static void rodada(ArrayList<Player> players) {
		jogando = players.get(0);
		atualizarTela();
		
	}

	public static void jogador(Player player) {
		System.out.println(jogando);
		System.out.println("2");
		
	}
	

}
