package com.ag.brain;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class IEUtils{

	public static void errorDisplay(String message){
		Stage p = new Stage();

		GridPane g = new GridPane();
		g.setAlignment(Pos.CENTER);
		Text t = new Text(message);
		g.add(t, 0, 0);

		Scene s = new Scene(g, 200, 80);

		p.setScene(s);
		p.setTitle("Error");
		p.show();
	}


}