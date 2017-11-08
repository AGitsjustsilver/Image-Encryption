package com.ag.brain;

import javafx.scene.paint.Color;

public class Pixel{
	private int x;
	private int y;
	private Color c;

	public Pixel(){
		this(0,0,Color.WHITE);
	}

	public Pixel(int x, int y, Color c){
		this.x = x;
		this.y = y;
		this.c = c;
	}

	public Pixel(int x, int y, double r, double g, double b){
		this(x,y,Color.color(r,g,b));
	}

	public Pixel(int x, int y, double r, double g, double b, double o){
		this(x,y,Color.color(r,g,b,o));
	}

	public Pixel(int x, int y, int r, int g, int b){
		this(x,y,Color.rgb(r,g,b,1.0));
	}

	public Pixel(int x, int y, int r, int g, int b, double o){
		this(x,y,Color.rgb(r,g,b,o));
	}

	public Pixel(int x, int y, String cString){
		this(x,y,Color.web(cString));
	}

	public Pixel(int x, int y, String cString, double o){
		this(x,y,Color.web(cString,o));
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	public Color getColor(){
		return c;
	}

	public void setX(int x){
		this.x = x;
	}

	public void setY(int y){
		this.y = y;
	}

	public void setColor(Color c){
		this.c = c;
	}

	public void setColor(int r, int g, int b, double o){
		c = Color.rgb(r,g,b,o);
	}
	
}