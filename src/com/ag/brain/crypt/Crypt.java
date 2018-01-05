package com.ag.brain.crypt;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

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

	protected String inMess;
	private Image inImg;
	protected static PixelWriter pW;
	protected static PixelReader pR;
	private Double l;
	private Double w;
	protected static Color[][] pic;
    protected int[] metaShift = new int[6];


    public Crypt(String in){
		inMess = in;
		int len = inMess.length();
		int numOfColors = (len / 3)+2;//2 colors from the meta data
		int numOfUnpaired = len % 3;
		l = new Double(Math.floor(Math.sqrt((numOfColors+((numOfUnpaired%3!=0)? 1:0))/(4/3.0)))+1);
		w = new Double(Math.floor((4/3.0) * l)+1);
		pic = new Color[l.intValue()][w.intValue()];
		setAllBlank();
	}

	public Crypt(File i) throws FileNotFoundException{
		try{
			inImg = new Image(new FileInputStream(i));
			pR = inImg.getPixelReader();
			inMess = "";
			w = inImg.getWidth();
			l = inImg.getHeight();
		}catch (FileNotFoundException fnfe){
			throw new FileNotFoundException("No file was found.");
		}

	}


    public int[] getMetaShift(){
        return metaShift;
    }

	public void setAllBlank(){
		for (int row = 0;row < pic.length; row++) {
			for (int col = 0;col < pic[row].length; col++) {
				pic[row][col] = Color.rgb(0,0,0,.75);
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

	public String toString(){
		Color[][] p = getPic();
		String res = "";
		for (int row = 0;row < p.length; row++) {
			for (int col = 0;col < p[row].length; col++) {
				res += p[row][col].toString() + " ";
			}
		}
		return res;
	}

	public abstract WritableImage resultImg();

    public abstract File toTxtFile(String name);

}