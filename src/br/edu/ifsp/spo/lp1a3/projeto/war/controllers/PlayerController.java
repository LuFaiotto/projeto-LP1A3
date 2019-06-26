package br.edu.ifsp.spo.lp1a3.projeto.war.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class PlayerController implements Initializable {
	@FXML
    private Text msg;

    @FXML
    private Button fechar;
	static Stage stage = new Stage();
	static String a = "";
	public void mensagem(String msg){
		try {
			a = msg;
			Parent root = FXMLLoader.load(getClass().getResource("../Warning.fxml"));
			stage.setTitle("Mensagem");
			stage.setScene(new Scene(root));
			stage.show();
		}	catch(Exception exc) {
			exc.printStackTrace();
		}
	}
	@Override
	public void initialize(URL location, ResourceBundle resources){
		msg.setText(a);
	}
	
	   @FXML
	    void close(ActionEvent event) {
		   stage.close();
	    }
	
}
