package com.ag.brain.ui.input;

import com.ag.brain.IEUtils;
import com.ag.brain.crypt.Crypt;
import com.ag.brain.crypt.Encrypt;

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

	// private static Crypt c;

	public TextInput(){
		this.setVgap(5.0);
		this.setHgap(5.0);
		// this.setGridLinesVisible(true);

		TextField fileName = new TextField();
			fileName.setPromptText("File name here");
		this.setHalignment(fileName, HPos.LEFT);
		this.setColumnSpan(fileName, 2);

		ComboBox<String> fileExtention = new ComboBox<String>();
			fileExtention.getItems().addAll("png", "jpg", "gif", "bmp");
			fileExtention.setValue("png");
		this.add(fileExtention, 2, 0);

		TextArea input = new TextArea();
			input.setPromptText("Message to decrypt");
		this.setColumnSpan(input,2);

		Text warn = new Text();
			warn.setFill(Color.RED);
		this.setHalignment(warn, HPos.CENTER);
		this.add(warn, 1,2);

		Button b1 = new Button("Encrypt");
			b1.setOnMouseClicked(event -> {
				if((fileName.getText().isEmpty())||(input.getText().isEmpty())){
					warn.setText("Missing fields.");
				}else{
					IEUtils.setFileName(fileName.getText());
					IEUtils.setFileType(fileExtention.getValue());
					String mess = input.getText();
					Crypt c = new Encrypt(mess);
					IEUtils.imOut.setImage(c.resultImg());
					warn.setText("");//last operation
				}
			}); 

		this.addColumn(0, fileName, input, b1);

	}

}