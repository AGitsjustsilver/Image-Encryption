package com.ag.brain.ui.menu;

import com.ag.brain.IEUtils;
import com.ag.brain.ui.UserInterface;

import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class AppMenu extends MenuBar{

	
	
	public AppMenu(Stage s){
		this.setWidth(IEUtils.WIDTH);
		Menu file = new Menu("File");
			MenuItem exit = new MenuItem("Exit");
			exit.setOnAction(event -> {
				s.close();
			});

		file.getItems().addAll(exit);

		Menu in = new Menu("Input");
			MenuItem text = new MenuItem("Text");
				text.setOnAction(event -> {
					IEUtils.textIn.setVisible(true);
					UserInterface.setTopNode(IEUtils.textIn);
					IEUtils.imIn.setVisible(false);
				});

			MenuItem img = new MenuItem("File");
				img.setOnAction(event ->{
					IEUtils.imIn.setVisible(true);
					UserInterface.setTopNode(IEUtils.imIn);
					IEUtils.textIn.setVisible(false);

				});

		in.getItems().addAll(text, img);

		Menu out = new Menu("Output");
			MenuItem imgO = new MenuItem("Image");
				imgO.setOnAction(event -> {
					UserInterface.setBotNode(IEUtils.imOut);
				});
			MenuItem textO = new MenuItem("Text");
				textO.setOnAction(event ->{
					UserInterface.setBotNode(IEUtils.textOut);
				});

		out.getItems().addAll(imgO, textO);

		this.getMenus().addAll(file, in, out);
	}

}