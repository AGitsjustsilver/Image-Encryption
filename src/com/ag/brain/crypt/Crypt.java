package com.ag.brain.crypt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

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
* 	
* 	we want meta data near the front of the image we are creating to count the shift
* 	
**/

public abstract class Crypt{

	protected final String BLANK = "FF";

	private String inMess;
	private Image inImg;
	//private ImageFactory iF;// might be temporary 
	private static PixelWriter pW;
	private static PixelReader pR;
	private Double l;
	private Double w;
	protected static Color[][] pic;

	public Crypt(String in){
		inMess = in;
		calcBounds();
	}

	public Crypt(File i) throws FileNotFoundException{
		try{
			inImg = new Image(new FileInputStream(i));
			pR = inImg.getPixelReader();
			inMess = "";
			calcBounds();
		}catch (FileNotFoundException fnfe){
			throw new FileNotFoundException("No file was found.");
		}

	}

	public void calcBounds(){
		// message
		if(!(inMess.isEmpty())){
			//4:3 aspect ratio
			int len = inMess.length();
			int numOfColors = len / 3;
			int numOfUnpaired = len % 3;
			w = new Double(Math.floor((numOfColors+((numOfUnpaired%3 != 0)? 1:0))/(4/3.0))+1);
			l = new Double(Math.floor((4/3.0) * w)+1);
			pic = new Color[l.intValue()][w.intValue()];
		}else{ // image
			w = inImg.getWidth();
			l = inImg.getHeight();

		}
	}

	public static void setAllBlank(){
		for (int row = 0;row < pic.length; row++) {
			for (int col = 0;col < pic[row].length; col++) {
				pic[row][col] = Color.web("FFFFFF");
			}
		}
	}

	public String getMess(){
		return inMess;
	}

	public Double getLength(){
		return l;
	}

	public Double getWidth(){
		return w;
	}

	public Color[][] getPic(){
		return pic;
	}

	public PixelReader getPR(){
		return pR;
	}

	public PixelWriter getPW(){
		return pW;
	}

}