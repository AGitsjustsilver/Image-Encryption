package com.ag.brain.ui;

import com.ag.brain.ImgEnConstants;
import com.ag.brain.ui.menu.AppMenu;

import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;

public class UserInterface extends FlowPane{

	public UserInterface(Stage s){

		this.getChildren().add(new AppMenu(s));
	}

	public void setTopItem(){

	}

	public void setBotItem(){

	}
}