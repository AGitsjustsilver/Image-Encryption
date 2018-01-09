package com.ag.brain.crypt;

import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class Encrypt extends Crypt{


	public Encrypt(String i){
		super(i);
		createInstruction();
		create();
	}

    private void shift(int instuct){
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

    private void shiftCellsLeft(int shiftCount){
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

    private void shiftCellsRight(int shiftCount){
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

    private void shiftCellsDiagonal(int shiftCount){
		while(shiftCount != 0){
			for (int row = 0;row < pic.length; row++) {
				for (int col = 0;col < pic[row].length; col++) {
					Color temp = pic[row][col];
					if (row != pic.length-1) {
						if(col != pic[row].length-1){
						    //1
							pic[row][col] = pic[row+1][col+1];
							pic[row+1][col+1] = temp;
						}else{
						    //2
							pic[row][col] = pic[row+1][0];
							pic[row+1][0] = temp;
						}
					}else{
						if(col != pic[row].length-1){
						    //3
							pic[row][col] = pic[0][col+1];
							pic[0][col+1] = temp;
						}else{
						    //4
							pic[row][col] = pic[0][0];
							pic[0][0] = temp;
						}
					}
				}
			}
			shiftCount--;
		}
	}

    private void createInstruction(){
		Random r = new Random();
		for(int i = 0; i < getMetaShift().length; i++){
			metaShift[i] = r.nextInt(255)+1;
		}
	}

    private void create(){
		int[] t = getMetaShift();
		pic[0][0] = Color.rgb(t[0], t[1], t[2], .5);
		pic[0][1] = Color.rgb(t[3], t[4], t[5], .5);
		int row = 0, col = 2;
        ArrayList<Integer> color = new ArrayList<>();
		String[] words = inMess.split(" ");
		for (String s : words) {
			char[] splitWords = s.toCharArray();
			for(char b: splitWords){
			    int nonce = 0;
			    int hashVal = Character.hashCode(b);
                if(hashVal <= 255){
                    color.add(hashVal);
                    if(b == splitWords[splitWords.length-1]){
                        color.add(32);
                    }
                }else{
                    while((hashVal > 255) && !(hashVal + nonce <= 255)){
                        hashVal -= 255;
                        nonce++;
                        if(hashVal+nonce <255){
                            hashVal += nonce;
                        }
                    }
                }
            }
            if((s.equals(words[words.length-1]))&&(color.size()%3 != 0)){
			    while (color.size()%3 != 0){
			        color.add(32);
                }
            }
            while(color.size() >= 3){
                if(row != getLength().intValue()-1){
                    if (col != getWidth().intValue()-1) {
                        // general cells - the inbetween
                        pic[row][col] = Color.rgb(color.get(0),color.get(1),color.get(2));
                        col++;
                    }else{
                        //if it is the last column in the row
                        pic[row][col] = Color.rgb(color.get(0),color.get(1),color.get(2));
                        col = 0;
                        row++;
                    }
                }else{
                    //if it is the last row
                    if (col != getWidth().intValue()-1) {
                        //all cells before the last cell
                        pic[row][col] = Color.rgb(color.get(0),color.get(1),color.get(2));
                        col++;
                    }else{
                        //the last cell
                        pic[row][col] = Color.rgb(color.get(0),color.get(1),color.get(2));
                    }
                }
                for(int l = 2; l >= 0; l--){
                    color.remove(l);
                }
            }
		}
		for (int a : getMetaShift()) {
			shift(a);
		}
	}


    private void setPixelWriter(WritableImage i){
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

	public File toTxtFile(String n){
	    return null;
    }
}