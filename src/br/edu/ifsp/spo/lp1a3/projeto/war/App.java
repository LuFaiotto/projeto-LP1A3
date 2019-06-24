package br.edu.ifsp.spo.lp1a3.projeto.war;


import java.io.IOException;

import br.edu.ifsp.spo.lp1a3.projeto.war.classes.GameConf;
import br.edu.ifsp.spo.lp1a3.projeto.war.classes.Partida;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;;

public class App extends Application{
	private static Stage stage = null;	
	public static Partida partida = null;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Parent root = FXMLLoader.load(getClass().getResource("AppFx.fxml"));
		
		primaryStage.setScene(new Scene(root));
		primaryStage.setTitle("War");
		setStage(primaryStage);
		primaryStage.show();
		
	}
	
	public static void changeScene(Scene scene) throws IOException{
		getStage().setScene(scene);
		getStage().show();
	}
	public static void main(String[] args) {	
		GameConf.loadMapConf();
		launch(args);
	}

	public static Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		App.stage = stage;
	}

}
