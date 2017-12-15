package com.ag.brain.crypt;

import java.io.FileNotFoundException;
import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Encrypt extends Crypt{


	private int[] metaShift = new int[6];

	public Encrypt(String i){
		super(i);
		createInstruction();
		create();
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

	public void createInstruction(){
		Random r = new Random();
		for(int i = 0; i < getMetaShift().length; i++){
			metaShift[i] = r.nextInt(255)+1;
		}
	}

	public void create(){
		int[][][] colorVal = new int[getLength().intValue()][getWidth().intValue()][3];
		for (int i = 0; i < getMetaShift().length; i++){
			colorVal[0][i/3][i%3] = metaShift[i];
		}
		int row = 0, col = 2, i = 0;
		String[] words = getMess().split("\\s"); 
		for (String s : words) {
			char[] splitWords = s.toCharArray();
			for (char c : splitWords) {
				int hashVal = Character.hashCode(c);
				if(row != getLength().intValue()-1){
					if (col != getWidth().intValue()-1) {
						if(i != 3){
							//if it not the last row or column and the hash values are not finished being submitted
						}else{
							//all hash values are set
						}
					}else{
						//if it is the last column in the row
					}
				}else{
					//if it is the last row
				}
			}
		}
	}

	public int[] getMetaShift(){
		return metaShift;
	}

	// public static Image result(){

	// }

}