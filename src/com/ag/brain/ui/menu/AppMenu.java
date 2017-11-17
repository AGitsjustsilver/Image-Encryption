package com.ag.brain.ui.menu;

import com.ag.brain.ImgEnConstants;
import com.ag.brain.ui.UserInterface;
import com.ag.brain.ui.input.TextInput;
import com.ag.brain.ui.input.ImageInput;
import com.ag.brain.ui.output.ImageOutput;

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
				text.setOnAction(event -> {
					UserInterface.setTopNode(new TextInput());
				});

			MenuItem img = new MenuItem("Image");
				img.setOnAction(event ->{
					UserInterface.setTopNode(new ImageInput());
				});

		in.getItems().addAll(text, img);

		Menu out = new Menu("Output");
			MenuItem imgO = new MenuItem("Image");
				imgO.setOnAction(event -> {
					UserInterface.setBotNode(new ImageOutput());
				});

		out.getItems().add(imgO);

		this.getMenus().addAll(file, in, out);
	}

}