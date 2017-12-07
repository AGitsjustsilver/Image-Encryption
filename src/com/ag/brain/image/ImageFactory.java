package com.ag.brain.image;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

/**
*	The purpose of the ImageFactory class is to create the image that is the result of the encryption
*	
* 	more deeply, the ImageFactory is used in both the encryption and decryption classes.
*
**/
public class ImageFactory{

	private WritableImage imageRes;
	private PixelWriter pWrite;


	public ImageFactory(){
		imageRes = new WritableImage();
		pWrite = imageRes.getPixelWriter();
	}


	public static Image getFinalImage(){
		return imageRes;
	}


}

