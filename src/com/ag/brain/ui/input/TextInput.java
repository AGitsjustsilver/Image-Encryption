package com.ag.brain.ui;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

public class TextInput extends GridPane{
	
	public TextInput(){
		TextArea t = new TextArea("Message to decrypt");
		this.setConstraints(t, 0,0, 3, 2);

		Button b = new Button("Encrypt");
			b.setOnMouseClicked(event -> {
				
			});
		this.add(b, 2, 2);
	}

}