package com.ag.brain;

import java.awt.image.BufferedImage;
import java.io.File;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

public abstract class SimpleImg implements DigitalImg{

	private String filename;
	private String extention;
	private Pixel[][] pic;
	private BufferedImage b;

	public SimpleImg(){
		this(200,200);
	}

	public SimpleImg(String f){
		load(f);
	}

	public SimpleImg(int height, int width){

	}



	public int getWidth(){
		return width;
	}

	public int getHeight(){
		return height;
	}


	public Pixel getPixel(int x, int y){
		return pic[x][y];
	}

	public Pixel[] getPixelRow(int row){
		Pixel[] p = new Pixel[width];
		for(int i = 0; i < width; i++){
			p[i] = pic[row][i];
		}
		return p;
	}

	public Pixel[][] getPixels(){
		return pic;
	}
	
	public void setPixel(int x, int y, Pixel p){
		pic[x][y] = p;
	}
	
	public void setPixelRow(int row, Pixel[] pr){
		for (int i = 0; i < width; i++) {
			pic[row][i] = pr[i];
		}
	}
	
	public void setPixel(Pixel[][] ps){
		for (int row = 0; row < pic.length; row++) {
			for (int col = 0; col < pic[row].length; col++) {
				pic[row][col] = ps[row][col];
			}
		}
	}
	

	public void load(String fn){
		File f = new File(fn);

	}

}