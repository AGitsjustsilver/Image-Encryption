package com.ag.brain.ui.menu;

import com.ag.brain.ImgEnConstants;

import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class AppMenu extends MenuBar{
	
	public AppMenu(Stage s){
		this.setWidth(ImgEnConstants.WIDTH);
		Menu file = new Menu("File");
			MenuItem settings = new MenuItem("Settings");


			MenuItem exit = new MenuItem("Exit");
			exit.setOnAction(event -> {
				s.close();
			});
		file.getItems().addAll(settings, exit);

		Menu in = new Menu("Input");
			MenuItem text = new MenuItem("Text");


			MenuItem img = new MenuItem("Image");
		in.getItems().addAll(text, img);

		Menu out = new Menu("Output");
			MenuItem imgO = new MenuItem("Image");
		out.getItems().add(imgO);

		this.getMenus().addAll(file, in, out);
	}

}