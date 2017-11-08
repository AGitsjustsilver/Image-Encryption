package com.ag.main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.stage.Stage;

import com.ag.brain.*;

public class Main extends Application {
	public void start(Stage pStage){

		Group g = new Group();

		Scene s = new Scene(g, 500,500);

		pStage.setScene(s);
		pStage.setTitle("Image test class");
		pStage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}