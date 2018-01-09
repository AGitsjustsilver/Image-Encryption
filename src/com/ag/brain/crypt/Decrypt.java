package com.ag.brain.crypt;

import com.ag.brain.IEUtils;

import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class Decrypt extends Crypt{

	private PrintWriter opr;
	private String mess = "";

	public Decrypt(File i) throws IOException{
		super(i);
		/*try{
			opr = new PrintWriter(new File(IEUtils.OUT_PATH));*/
			read();
			grabMeta();
			create();
	/*	}catch (FileNotFoundException fnfe){
			System.out.println(fnfe.getMessage());
		}*/
	}

	private void read(){
		for (int row = 0;row < pic.length ; row++) {
			for (int col = 0;col < pic[row].length ; col++) {
				pic[row][col] = pR.getColor(row, col);
			}			
		}
	}

    private void grabMeta(){
	    boolean sec = false;
	    for (int row = 0; row < pic.length; row++){
	        for (int col = 0; col < pic[row].length; col++){
	            String colorString = pic[row][col].toString();
                char last_1 = colorString.charAt(colorString.length()-1);
                char last_2 = colorString.charAt(colorString.length()-2);
                if(last_1 == '0' && last_2 == '8'){
                    String hexColor = colorString.substring(2, 8);
                    metaShift[(!sec ? 0 : 3)] = hexToInt(hexColor.substring(0,2));
                    metaShift[(!sec ? 1 : 4)] = hexToInt(hexColor.substring(2,4));
                    metaShift[(!sec ? 2 : 5)] = hexToInt(hexColor.substring(4));
                    sec = true;
                }
            }
        }
    }

    private void unshift(int instruct){
        if(instruct%2 != 0){
            shiftCellsLeft(instruct);
        }
        if(instruct%2 == 0){
            shiftCellsRight(instruct);
        }
        if(instruct%5 == 0){
            shiftCellsDiagonal(instruct);
        }
	}

	private void shiftCellsLeft(int shiftC){
	    while (shiftC != 0){
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
            shiftC--;
        }
    }

    private void shiftCellsRight(int shiftC){
        while(shiftC != 0){
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
            shiftC--;
        }
    }

    private void shiftCellsDiagonal(int shiftC){
	    while(shiftC != 0){
	        for(int row = 0; row < pic.length; row++){
	            for(int col = 0; col < pic[row].length; col++){
	                Color temp = pic[row][col];
	                if(row != 0){
	                    if(col != 0){
                            //1
                            pic[row][col] = pic[row-1][col-1];
                            pic[row-1][col-1] = temp;
                        }else{
                            //2
                            pic[row][col] = pic[row-1][getWidth().intValue()-1];
                            pic[row-1][getWidth().intValue()-1] = temp;
                        }
                    }else{
                        if(col != 0){
                            //3
                            pic[row][col] = pic[getLength().intValue()-1][col-1];
                            pic[getLength().intValue()-1][col-1] = temp;
                        }else{
                            //4
                            pic[row][col] = pic[getLength().intValue()-1][getWidth().intValue()-1];
                            pic[getLength().intValue()-1][getWidth().intValue()-1] = temp;
                        }
                    }
                }
            }
	        shiftC--;
        }
    }

    private void create(){
	    for(int a : getMetaShift()){
	        unshift(a);
        }
        for(Color[] a: pic){
            for(Color b: a){
                String colorString = b.toString().substring(2,8);
                String colorAffix = b.toString().substring(8);
                String[] split = {colorString.substring(0,2), colorString.substring(2,4), colorString.substring(4)};
                if(colorAffix.equals("ff")){
                    for(String d: split){
                        mess += hexToChar(d);
                    }
                }
            }
        }
    }

    private char hexToChar(String twoDigitHex){
	    return (char) hexToInt(twoDigitHex);
    }

    private int hexToInt(String twoDigitHex){
        HashMap<Character, Integer> map = build();
        char c1 = twoDigitHex.charAt(0);
        char c2 = twoDigitHex.charAt(1);
        int sum = 0;
        for(Character a : map.keySet()){
            if (c1 == a){
                sum += map.get(a) * 16;
            }
            if(c2 == a){
                sum += map.get(a);
            }
        }
        return sum;
    }

    private HashMap<Character, Integer> build(){
        HashMap<Character, Integer> map = new HashMap<>();
        map.put(new Character('0'), new Integer(0));
        map.put(new Character('1'), new Integer(1));
        map.put(new Character('2'), new Integer(2));
        map.put(new Character('3'), new Integer(3));
        map.put(new Character('4'), new Integer(4));
        map.put(new Character('5'), new Integer(5));
        map.put(new Character('6'), new Integer(6));
        map.put(new Character('7'), new Integer(7));
        map.put(new Character('8'), new Integer(8));
        map.put(new Character('9'), new Integer(9));
        map.put(new Character('a'), new Integer(10));
        map.put(new Character('b'), new Integer(11));
        map.put(new Character('c'), new Integer(12));
        map.put(new Character('d'), new Integer(13));
        map.put(new Character('e'), new Integer(14));
        map.put(new Character('f'), new Integer(15));
        return map;
    }

    public WritableImage resultImg(){
		return null;
	};

	public File toTxtFile(String name){
	    File f = new File(name + ".txt");
	    try{
            PrintWriter pr = new PrintWriter(f);
            pr.write(mess);
            pr.close();
        }catch (FileNotFoundException e){
	        e.printStackTrace();
        }
	    return f;
    }
    public String getMessage(){
	    return mess;
    }
}