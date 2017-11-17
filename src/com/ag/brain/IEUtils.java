package com.ag.brain;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class IEUtils{

	public static void errorDisplay(String message){
		Stage p = new Stage();

		Group g = new Group();
		Text t = new Text(message);

		g.getChildren().add(t);

		Scene s = new Scene(g, 150, 50);

		p.setScene(s);
		p.setTitle("Error");
		p.show();
	}


}