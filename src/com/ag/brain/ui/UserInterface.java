package com.ag.brain.ui;

import com.ag.brain.ImgEnConstants;
import com.ag.brain.ui.input.TextInput;
import com.ag.brain.ui.menu.AppMenu;
import com.ag.brain.ui.output.ImageOutput;

import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class UserInterface extends BorderPane{

	private AppMenu menu;
	private GridPane g;
	private static Node topNode;
	private static Node botNode;

	public UserInterface(Stage s){
		menu = new AppMenu(s);
		//default IO
		topNode = new TextInput();
		botNode = new ImageOutput();

		super.setCenter(getG());
		super.setTop(menu);
	}

	public GridPane getG(){
		return g;
	}

	public Node getTopNode(){
		return topNode;
	}

	public Node getBotNode(){
		return botNode;
	}

	public static void setTopNode(Node t){
		topNode = t;
	}

	public static void setBotNode(Node b){
		botNode = b;
	}
}