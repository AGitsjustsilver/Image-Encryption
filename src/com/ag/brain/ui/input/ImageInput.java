package com.ag.brain.ui.input;

import com.ag.brain.IEUtils;
import com.ag.brain.crypt.Encrypt;

import java.io.File;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

public class ImageInput extends GridPane{

	private FileChooser fc;
	private static File f;

	public ImageInput(){
		this.setVgap(5);
		this.setHgap(5);

		Text t0 = new Text("Submit a .txt File to encrypt");
		this.add(t0,0,0);

		fc = new FileChooser();
		Text t1 = new Text("no file selected");
		this.add(t1, 0, 1);
		this.setRowSpan(t1,2);

		Button b = new Button("Choose Image");
		Button b1 = new Button("Encrypt");
		b1.setDisable(true);
		Button b2 = new Button("Decrypt");
		b2.setDisable(true);
			b.setOnAction(event -> {
				f = fc.showOpenDialog(null);
				if (f != null) {
					t1.setText(f.getName());
					switch(IEUtils.isProperFile(f.getName())){
						case 0:
							b1.setDisable(false);
							b2.setDisable(true);
							break;
						case 1:
							b2.setDisable(false);
							b1.setDisable(true);
							break;
						default:
							IEUtils.errorDisplay("Your file must be .png, .gif, .jpeg, .bmp, or .txt");
							break;
					}
				}else{
					IEUtils.errorDisplay("You must choose a file.");
				}
			});
			b1.setOnAction(event -> {
				//TODO 
			});
			b2.setOnAction(event -> {
				//TODO
			});
		this.add(b, 1, 1);
		this.setRowSpan(b,2);
		this.add(b1, 2, 1);
		this.add(b2, 2, 2);

	}

}

