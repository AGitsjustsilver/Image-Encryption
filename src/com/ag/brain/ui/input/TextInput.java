package com.ag.brain.ui.input;

import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class TextInput extends GridPane{
	
	/**
	*	Structure
	* 	area to put what you want to call your file
	*	area to choose file extention png, jpg, gif, or bmp
	*	area to put message that the user chooses to encrypt
	**/
	public TextInput(){
		this.setVgap(5.0);
		this.setHgap(5.0);
		this.setGridLinesVisible(true);

		TextField fileName = new TextField();
			fileName.setPromptText("File name here");
		this.setColumnSpan(fileName, 2);
		this.add(fileName, 0, 0);

		ComboBox<String> fileExtention = new ComboBox<String>();
			fileExtention.getItems().addAll(".png", ".jpg", ".gif", ".bmp");
			fileExtention.setValue(".png");
		this.setHalignment(fileExtention, HPos.RIGHT); 
		this.add(fileExtention, 2, 0);

		TextArea t = new TextArea();
			t.setPromptText("Message to decrypt");
		this.setColumnSpan(t,3);
		this.add(t, 0, 1);

		Text warn = new Text();
			warn.setFill(Color.RED);
		this.add(warn, 2,2);

		Button b1 = new Button("Encrypt");
			b1.setOnMouseClicked(event -> {
				if((fileName.getText().isEmpty())||(t.getText().isEmpty())){
					warn.setText("Missing fields.");
				}else{
					// functionality goes here
					warn.setText("");
				}
			}); 
		this.add(b1, 0, 2);

	}

}