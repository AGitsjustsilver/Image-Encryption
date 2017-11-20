package com.ag.brain.ui.input;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

public class TextInput extends GridPane{
	
	/**
	*	Structure
	* 	area to put what you want to call your file
	*	area to choose file extention png, jpg, gif, or bmp
	*	area to put message that the user chooses to encrypt
	**/
	public TextInput(){
		TextArea fileName = new TextArea("File name here");



		TextArea t = new TextArea("Message to decrypt");
		this.setConstraints(t, 0,0, 3, 2);
		this.add(t, 0, 0);

		Button b = new Button("Encrypt");
			b.setOnMouseClicked(event -> {
				
			});
		this.add(b, 2, 2);
	}

}