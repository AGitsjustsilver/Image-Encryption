package com.ag.brain.crypt;

import javafx.scene.image.*;
import javafx.scene.paint.Color;

/*
*			 W
*	___________________	
*	******************* 
*	*                 *	|
*	*                 *	|
*	*                 *	|L
*	*                 *	|
*	*                 *	|
*	******************* 
**/

public abstract class Crypt{

	private String inMess
	private Image inImg;
	private ImageFactory iF;// might be temporary 
	private static PixelWriter pW;
	private static PixelReader pR;
	private Double l;
	private Double w;
	private Color[][] pic;

	public Crypt(String in){
		inMess = in;
		calcBounds();
	}

	public Crypt(Image i){
		inImg = (WritableImage) i;
		inMess = "";
		calcBounds();
	}

	public void calcBounds(){
		// message
		if(inMess.isEmpty()){
			//4:3 aspect ratio
			int len = inMess.length();
			int numOfColors = len / 3;
			int numOfUnpaired = len % 3;
			w = new Double(Math.floor((numOfColors+((numOfUnpaired%3 != 0)? 1:0))/(4/3.0))+1);
			l = new Double(Math.floor((4/3.0) * w)+1);
			pic = new Color[l.intValue()][w.intValue()];
		}else if(){ // image
			w = inImg.getWidth();
			h = inImg.getHeight();

		}
	}

	public static void setAllBlank(){
		for (int row = 0;row < pic.length; row++) {
			for (int col = 0;col < pic[row].length; col++) {
				pic[row][col] = Color.web("FFFFFF");
			}
		}
	}



}