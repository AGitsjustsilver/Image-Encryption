package com.ag.main;

import com.ag.brain.ImgEnConstants;
import com.ag.brain.ui.UserInterface;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.stage.Stage;

import com.ag.brain.*;

public class Main extends Application {
	public void start(Stage pStage){
		Scene s = new Scene(new UserInterface(pStage), ImgEnConstants.WIDTH,ImgEnConstants.HEIGHT);
		pStage.setScene(s);
		pStage.setTitle("Image Encryption");
		pStage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}