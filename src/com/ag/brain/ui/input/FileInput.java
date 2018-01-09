package com.ag.brain.ui.input;

import com.ag.brain.IEUtils;
import com.ag.brain.crypt.Crypt;
import com.ag.brain.crypt.Decrypt;
import com.ag.brain.crypt.Encrypt;
import com.ag.brain.ui.UserInterface;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileInput extends GridPane{

	private FileChooser fc;
	private static File f;

	public FileInput(){
		this.setVgap(5);
		this.setHgap(5);

		Text t0 = new Text("Submit a file to encrypt or decrypt");
		this.add(t0,0,0);

		fc = new FileChooser();
		Text t1 = new Text("No file selected");
		this.add(t1, 0, 1);
		this.setRowSpan(t1,2);

		Button b = new Button("Choose File");
		Button b1 = new Button("Encrypt");
		b1.setDisable(true);
		Button b2 = new Button("Decrypt");
		b2.setDisable(true);
			b.setOnAction(event -> {
				f = fc.showOpenDialog(null);
				if (f != null) {
					t1.setText(f.getName());
					switch(IEUtils.isProperFile(f.getName())){
						case 0://Encrypt
							b1.setDisable(false);
							b2.setDisable(true);
                            UserInterface.setBotNode(IEUtils.imOut);
                            break;
						case 1://Decrypt
							b2.setDisable(false);
							b1.setDisable(true);
                            UserInterface.setBotNode(IEUtils.textOut);
							break;
						default:
							IEUtils.errorDisplay("Your file must be .png, .gif, .jpeg, .bmp, or .txt");
							t1.setText("No file selected");
							break;
					}
				}else{
					IEUtils.errorDisplay("You must choose a file.");
				}
			});
			b1.setOnMouseClicked(event -> {//Encryption
				IEUtils.setFileName(f.getName());
				IEUtils.setFileType("png");
				String mess = "";
				try{
					Scanner s = new Scanner(f);
					while(s.hasNext()){
						mess += s.next();
					}
				}catch (FileNotFoundException e){
					e.printStackTrace();
				}
				Crypt c = new Encrypt(mess);
				IEUtils.imOut.setImage(c.resultImg());
			});
			b2.setOnMouseClicked(event -> {//Decryption
                try {
                    Decrypt c = new Decrypt(f);
                    IEUtils.textOut.setText(c.getMessage());
                }catch (IOException e){
                    System.out.println("oof");
                    e.printStackTrace();
                }
			});
		this.add(b, 1, 1);
		this.setRowSpan(b,2);
		this.add(b1, 2, 1);
		this.add(b2, 2, 2);

	}

}

