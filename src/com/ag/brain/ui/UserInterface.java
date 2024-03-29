package com.ag.brain.ui;

import com.ag.brain.IEUtils;
import com.ag.brain.ui.menu.AppMenu;

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
		g.setVgap(5);
		this.setTopNode(IEUtils.textIn);
		this.setBotNode(IEUtils.imOut);

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
		g.getChildren().removeAll(topNode);
		topNode = t;
		g.add(topNode, 0, 0);
	}

	public static void setBotNode(Node b){
		g.getChildren().removeAll(botNode);		
		botNode = b;
		g.add(botNode, 0, 1);
	}
}