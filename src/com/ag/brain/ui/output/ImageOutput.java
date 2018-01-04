package com.ag.brain.ui.output;

import com.ag.brain.IEUtils;
import com.ag.brain.crypt.Encrypt;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class ImageOutput extends GridPane{
	
	private static ImageView viewer;

	public ImageOutput(){
//		this.setGridLinesVisible(true);
		viewer = new ImageView();
		viewer.setFitHeight(300);
		viewer.setFitWidth(400);
		viewer.setSmooth(false);
		this.setColumnSpan(viewer, 2);
		this.add(viewer, 0, 0);

		Button saveImage = new Button("Download");
			saveImage.setOnMouseClicked(event -> {
				IEUtils.saveToFile(viewer.getImage());	
			});
		this.add(saveImage, 0, 1);
	}

	public static void setImage(Image i){
		viewer.setImage(i);
	}

}