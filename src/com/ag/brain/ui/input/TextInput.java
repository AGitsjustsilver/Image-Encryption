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
		// this.setGridLinesVisible(true);

		TextField fileName = new TextField();
			fileName.setPromptText("File name here");
		this.setHalignment(fileName, HPos.LEFT);
		this.setColumnSpan(fileName, 2);

		ComboBox<String> fileExtention = new ComboBox<String>();
			fileExtention.getItems().addAll(".png", ".jpg", ".gif", ".bmp");
			fileExtention.setValue(".png");
		this.add(fileExtention, 2, 0);

		TextArea t = new TextArea();
			t.setPromptText("Message to decrypt");
		this.setColumnSpan(t,2);

		Text warn = new Text();
			warn.setFill(Color.RED);
		this.setHalignment(warn, HPos.CENTER);
		this.add(warn, 1,2);

		Button b1 = new Button("Encrypt");
			b1.setOnMouseClicked(event -> {
				if((fileName.getText().isEmpty())||(t.getText().isEmpty())){
					warn.setText("Missing fields.");
				}else{
					// functionality goes here
					warn.setText("");
				}
			}); 

		this.addColumn(0, fileName, t, b1);

	}

}