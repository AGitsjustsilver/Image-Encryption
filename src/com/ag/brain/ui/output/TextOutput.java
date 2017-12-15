package com.ag.brain.ui.output;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class TextOutput extends GridPane{

	private static ScrollPane s;

	public TextOutput(){
		s = new ScrollPane();
		this.add(s, 0, 0);

		Button download = new Button("Download");
		this.add(download, 0, 1);
	}

	public static void setText(String sa){
		Text t = new Text(sa);
		s.setContent(t);
	}

}