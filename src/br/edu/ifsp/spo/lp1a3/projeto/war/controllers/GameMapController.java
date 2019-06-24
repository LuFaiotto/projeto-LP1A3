package br.edu.ifsp.spo.lp1a3.projeto.war.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import br.edu.ifsp.spo.lp1a3.projeto.war.App;
import br.edu.ifsp.spo.lp1a3.projeto.war.classes.Partida;
import javafx.fxml.Initializable;

public class GameMapController implements Initializable {
	
	Partida partida = null;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.partida = App.partida;
		System.out.println(partida);
	}

}
