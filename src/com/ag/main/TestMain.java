package com.ag.main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TestMain extends Application{

	private int[][] arrayValues;
	private GridPane g;
	private Integer val;
	private Integer nVal;

	public void start(Stage pStage){
		pStage.setTitle("Testing Class");
		g = new GridPane();

		TextArea t = new TextArea();
		g.add(t, 0, 1);

		Text res = new Text();
		g.add(res, 0, 0);

		Button b = new Button("Do The Thing");
			b.setOnMouseClicked(event -> {
				val = new Integer(t.getText());
				int val2 = val>>1;
				res.setText("The original was " + val + "\n" + "The new value is " + val2);
			});
		g.add(b, 0, 2);

		Scene s = new Scene(g, 500, 500);
		pStage.setScene(s);
		pStage.show();
	}

	public void shift(){
		nVal = new Integer(val<<3);
	}

	public static void main(String [] args){
		launch(args);
	}
}