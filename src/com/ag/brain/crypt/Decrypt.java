package com.ag.brain.crypt;

import com.ag.brain.IEUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.scene.paint.Color;
import javafx.scene.image.WritableImage;

public class Decrypt extends Crypt{

	private PrintWriter opr;

	public Decrypt(File i) throws IOException{
		super(i);
		try{
			opr = new PrintWriter(new File(IEUtils.OUT_PATH));
			read();
		}catch (FileNotFoundException fnfe){
			System.out.println(fnfe.getMessage());
		}
	}

	public void read(){
		for (int row = 0;row < pic.length ; row++) {
			for (int col = 0;col < pic[row].length ; col++) {
				pic[row][col] = pR.getColor(row, col);
			}			
		}
	}

	/*public static File
	
	public static String result(){

	} */

	public WritableImage resultImg(){
		return null;
	};

}