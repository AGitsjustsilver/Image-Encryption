package com.ag.brain.crypt;

import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.util.Random;

public class Encrypt extends Crypt{


	public Encrypt(String i){
		super(i);
		createInstruction();
		create();
	}

	public void shift(int instuct){
		if(instuct%2 != 0){
			shiftCellsRight(instuct);
		}
		if(instuct%2 == 0){
			shiftCellsLeft(instuct);
		}
		if(instuct%5 == 0){
			shiftCellsDiagonal(instuct);
		}
	}

	public void shiftCellsLeft(int shiftCount){
		while(shiftCount != 0){
			for (int row = 0;row < pic.length; row++) {
				for (int col = 0;col < pic[row].length; col++) {
					Color temp = pic[row][col];
					if(col == 0){
						//end of the Column
						if(row == 0){
							// first cell in the array
							pic[row][col] = pic[getLength().intValue()-1][getWidth().intValue()-1];
							pic[getLength().intValue()-1][getWidth().intValue()-1] = temp;
						}else{
							pic[row][col] = pic[row-1][getWidth().intValue()-1];
							pic[row-1][getWidth().intValue()-1] = temp;
						}
					}else{
						// cells that i hope wont cause an out of bounds exception
						pic[row][col] = pic[row][col-1];
						pic[row][col-1] = temp; 
					}
				}
			}
			shiftCount--;
		}
	}

	public void shiftCellsRight(int shiftCount){
		while(shiftCount != 0){
			for (int row = 0;row < pic.length; row++) {
				for (int col = 0;col < pic[row].length; col++) {
					Color temp = pic[row][col];
					if(col == pic[row].length-1){
						//end of the Column
						if(row == pic.length-1){
							// last cell in the array
							pic[row][col] = pic[0][0];
							pic[0][0] = temp;
						}else{
							pic[row][col] = pic[row+1][0];
							pic[row+1][0] = temp;
						}
					}else{
						// cells that i hope wont cause an out of bounds exception
						pic[row][col] = pic[row][col+1];
						pic[row][col+1] = temp; 
					}
				}
			}
			shiftCount--;
		}
	}

	public void shiftCellsDiagonal(int shiftCount){
		while(shiftCount != 0){
			for (int row = 0;row < pic.length; row++) {
				for (int col = 0;col < pic[row].length; col++) {
					Color temp = pic[row][col];
					if (row != pic.length-1) {
						if(col != pic[row].length-1){
							pic[row][col] = pic[row+1][col+1];
							pic[row+1][col+1] = temp;
						}else{
							pic[row][col] = pic[row+1][0];
							pic[row+1][0] = temp;
						}
					}else{
						if(col != pic[row].length-1){
							pic[row][col] = pic[0][col+1];
							pic[0][col+1] = temp;
						}else{
							pic[row][col] = pic[0][0];
							pic[0][0] = temp;
						}
					}
				}
			}
			shiftCount--;
		}
	}

	public void createInstruction(){
		Random r = new Random();
		for(int i = 0; i < getMetaShift().length; i++){
			metaShift[i] = r.nextInt(255)+1;
		}
	}

	public void create(){
		int[] t = getMetaShift();
		pic[0][0] = Color.rgb(t[0], t[1], t[2], .5);
		pic[0][1] = Color.rgb(t[3], t[4], t[5], .5);
		int row = 0, col = 2, i = 0;
		int[] color = new int[3];
		String[] words = inMess.split(" ");
		for (String s : words) {
			char[] splitWords = s.toCharArray();
			for (char c : splitWords) {
				int hashVal = Character.hashCode(c);
				if(hashVal <= 255){
					if(i==3){
						if(row != getLength().intValue()-1){
							if (col != getWidth().intValue()-1) {
								// general cells - the inbetween
								pic[row][col] = Color.rgb(color[0],color[1],color[2]);
								col++;
							}else{
								//if it is the last column in the row
								pic[row][col] = Color.rgb(color[0],color[1],color[2]);
								col = 0;
								row++;
							}
						}else{
							//if it is the last row
							if (col != getWidth().intValue()-1) {
								//all cells before the last cell
								pic[row][col] = Color.rgb(color[0],color[1],color[2]);
								col++;
							}else{
								//the last cell
								pic[row][col] = Color.rgb(color[0],color[1],color[2]);
							}
						}
						for(int d: color){
							d = 0;
						}
						i = 0;
					}else{
						//initializes the array of hash values to put into colors
						color[i] = hashVal;
						i++;
					}
				}
			}
		}
		for (int a : getMetaShift()) {
			shift(a);
		}
	}


	public void setPixelWriter(WritableImage i){
		pW = i.getPixelWriter();
	}

	public WritableImage resultImg(){
		WritableImage i = new WritableImage(getLength().intValue(), getWidth().intValue());
		setPixelWriter(i);
		for (int row = 0;row < pic.length; row++) {
			for (int col = 0;col < pic[row].length;col ++) {
				pW.setColor(row, col, pic[row][col]);
			}
		}
		return i;
	}

}