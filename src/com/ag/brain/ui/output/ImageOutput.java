package com.ag.brain.ui.output;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class ImageOutput extends GridPane{
	
	private static ImageView viewer;

	public ImageOutput(){
		viewer = new ImageView();
		this.setColumnSpan(viewer, 2);
		this.add(viewer, 0, 0);

		Button saveImage = new Button("Download");
		this.add(saveImage, 1, 0);
	}

	public static void setImage(Image i){
		viewer.setImage(i);
	}

}