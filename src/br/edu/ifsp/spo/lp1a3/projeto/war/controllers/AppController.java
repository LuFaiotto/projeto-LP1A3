package br.edu.ifsp.spo.lp1a3.projeto.war.controllers;

import java.io.IOException;

import br.edu.ifsp.spo.lp1a3.projeto.war.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class AppController {

	public void guerrilhar(ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("../IniciandoPartida.fxml"));
		App.changeScene(new Scene(root));
	}
}
