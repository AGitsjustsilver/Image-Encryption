package com.ag.brain.ui.input;

import com.ag.brain.IEUtils;

import java.io.File;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

public class ImageInput extends GridPane{

	private FileChooser fc;
	private static File f;

	public ImageInput(){
		fc = new FileChooser();
		Text t = new Text("no file selected");
		this.add(t, 0, 0);

		Button b = new Button("Choose Image");
		Button b1 = new Button("Encrypt");
		b1.setDisable(true);
			b.setOnAction(event -> {
				f = fc.showOpenDialog(null);
				if (f != null) {
					t.setText(f.getName());
					b1.setDisable(false);
				}else{
					IEUtils.errorDisplay("You must choose an image.");
				}
			});
			b1.setOnAction(event -> {
				//TODO 
			});
		this.add(b, 1, 0);
		this.add(b1, 2, 0);

	}

}

