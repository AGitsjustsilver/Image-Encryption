package com.ag.brain.image;

import java.awt.image.BufferedImage;
import javafx.scene.image.Image;

public interface DigitalImg{

	//file basics
	public String getFileName();
	public void setFileName(String filename);
	public int getHeight();
	public int getWidth();
	public Image getImage();

	//digital images have pixel data
	public Pixel getPixel(int x, int y);
	public Pixel[] getPixelRow(int row);
	public Pixel[][] getPixels();
	public void setPixel(int x, int y, Pixel p);
	public void setPixelRow(int row, Pixel[] pr);
	public void setPixel(Pixel[][] ps);

	//digital images can be witten
	public BufferedImage getBufferedImage();

	//digital images can be loaded
	public void load(String filename);
	public void load(Image image);


}
/**
*	There is a way to get this done 
* 	all with javafx that includes the WritableImage class
*	I just have to find out how
*
*/