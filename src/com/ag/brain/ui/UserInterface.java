package com.ag.brain.ui;

import com.ag.brain.IEUtils;
import com.ag.brain.ui.input.TextInput;
import com.ag.brain.ui.input.ImageInput;
import com.ag.brain.ui.menu.AppMenu;
import com.ag.brain.ui.output.ImageOutput;

import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class UserInterface extends BorderPane{

	private AppMenu menu;
	private static GridPane g;
	private static Node topNode;
	private static Node botNode;

	public UserInterface(Stage s){
		menu = new AppMenu(s);
		g = new GridPane();
		g.setAlignment(Pos.CENTER);
		// this.setTopNode(new TextInput());
		this.setTopNode(new ImageInput());
		this.setBotNode(new ImageOutput());

		super.setCenter(getG());
		super.setTop(menu);
	}

	private static GridPane getG(){
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
		g.add(topNode, 0, 0);
	}

	public static void setBotNode(Node b){
		botNode = b;
		g.add(botNode, 0, 1);
	}
}