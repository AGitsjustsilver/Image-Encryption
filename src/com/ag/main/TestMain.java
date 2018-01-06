package com.ag.main;

import com.ag.brain.crypt.Crypt;
import com.ag.brain.crypt.Encrypt;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Random;

public class TestMain /*extends Application*/{

	public static final String TEST_STRING = "The quick brown fox jumps over the lazy dog";
	public static Color[][] pic;

	public TestMain(){

    }

	public static void main(String [] args){
//		launch(args);
		TestMain a = new TestMain();
        a.algTest();
//        Crypt c = new Encrypt(TEST_STRING);
//		regExTest();
//		aspectTesting();

//        System.out.println("a has the hash code of " + Character.hashCode('a') + ".\n" + "a also has the hashcode of " + (int)'a' +". \n" + "but 97 is the character " + (char)97);
	}

	/*private GridPane g;

	public void start(Stage pStage){
		pStage.setTitle("Testing Class");
		g = new GridPane();



		Scene s = new Scene(g, 500, 500);
		pStage.setScene(s);
		pStage.show();
	}*/



	public static void setAllTo(){
		for(int row = 0; row < pic.length; row++){
			for(int col = 0; col < pic[row].length; col++){
                pic[row][col] = Color.rgb(0,0,0,.25);
			}
		}
	}

	public static void aspectTesting(){
		// Scanner s = new Scanner(System.in);
		// boolean f = true;
		// while(f){
		// 	int in = s.nextInt();
		// 	if(in == -1){
		// 		f = false;
		// 	}else{
				// int[] test = {43, 35};
				int[] test = {TEST_STRING.length(), 32};
				for (int i : test) {
					int completeColors = (i/3)+2;
					int unPairedColors = i%3;
					// for a 4:3 aspect ratio
					double row = Math.floor(Math.sqrt((completeColors+((unPairedColors%3!=0)? 1:0))/(4/3.0)))+1;
					double col = Math.floor((4/3.0) * row)+1;
					double totalPix = row*col;
					double emptyPix43 = totalPix - (completeColors+((unPairedColors%3!=0)? 1:0));
					System.out.println("Number of Characters\tTotal Pixels\tColumn Pixels\tRow Pixels\tEmpty Pixels");
					System.out.printf("%-23d %-15.0f %-15.0f %-11.0f %-15.0f\n", i, totalPix, col, row, emptyPix43);
				}
		// 	}
		// }
		// s.close();

			// int len = inMess.length();
			// int numOfColors = len / 3;
			// int numOfUnpaired = len % 3;
			// w = new Double(Math.floor((numOfColors+((numOfUnpaired%3 != 0)? 1:0))/(4/3.0))+1);
			// l = new Double(Math.floor((4/3.0) * w)+1);
	}

	public void algTest(){
		Random rand = new Random();
		int[] meta = new int[6];
		for(int l = 0; l < meta.length; l++){
			meta[l] = rand.nextInt(255)+1;
		}
		int g = TEST_STRING.length();
		int completeColors = (g/3)+2;
		int unPairedColors = g%3;
		// for a 4:3 aspect ratio
		Double r = Math.floor(Math.sqrt((completeColors+((unPairedColors%3!=0)? 1:0))/(4/3.0)))+1;
		Double c = Math.floor((4/3.0) * r)+1;

		pic = new Color[r.intValue()][c.intValue()];
		setAllTo();
		String[] test1 = TEST_STRING.split(" ");
		pic[0][0] = Color.rgb(meta[0], meta[1], meta[2], .5);
		pic[0][1] = Color.rgb(meta[3], meta[4], meta[5], .5);
		int row = 0, col = 2, i = 0, cap = 0;
		boolean flag = true; // true is color & false is color2
		int[] color = new int[3];
		int[] color2 = new int[3];
		for (String a : test1) {
			char[] t = a.toCharArray();
            if(flag){
                if(cap==3){
                    if(row != r.intValue()-1){
                        if (col != c.intValue()-1) {
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
                        if (col != c.intValue()-1) {
                            //all cells before the last cell
                            pic[row][col] = Color.rgb(color[0],color[1],color[2]);
                            col++;
                        }else{
                            //the last cell
                            pic[row][col] = Color.rgb(color[0],color[1],color[2]);
                        }
                    }
                    for(int l = 0; l < color.length; l++){
                        color[l] = 0;
                    }
                }
                cap = 0;
            }else{
                if(i==3){
                    if(row != r.intValue()-1){
                        if (col != c.intValue()-1) {
                            // general cells - the inbetween
                            pic[row][col] = Color.rgb(color2[0],color2[1],color2[2]);
                            col++;
                        }else{
                            //if it is the last column in the row
                            pic[row][col] = Color.rgb(color2[0],color2[1],color2[2]);
                            col = 0;
                            row++;
                        }
                    }else{
                        //if it is the last row
                        if (col != c.intValue()-1) {
                            //all cells before the last cell
                            pic[row][col] = Color.rgb(color2[0],color2[1],color2[2]);
                            col++;
                        }else{
                            //the last cell
                            pic[row][col] = Color.rgb(color2[0],color2[1],color2[2]);
                        }
                    }
                    for(int l = 0; l < color2.length; l++){
                        color2[l] = 0;
                    }
                }
                i = 0;
            }
            for (char b : t) {
                //initializes the array of hash values to put into colors
                int hashVal = Character.hashCode(b);
				/*try putting a secondary array to hold the rest of the values
				and have a flag system to switch which one it goes into*/
                if(flag) {
                    if (cap != 3) {
                        color[cap] = hashVal;
                        cap++;
                    }else{
                        flag = false;
                    }
                }else {
                    if (i != 3) {
                        color2[i] = hashVal;
                        i++;
                    }else{
                        flag = true;
                    }
                }
			}
		}
		String res = "";
		for (int r1 = 0;r1 < pic.length; r1++) {
			for (int c1 = 0;c1 < pic[r1].length; c1++) {
				if(pic[r1][c1] != null){
					if (c1 == pic[r1].length-1){
						res += pic[r1][c1].toString() + " \n";
					}else{
						res += pic[r1][c1].toString() + " ";
					}
				}else{
					if (c1 == pic[r1].length-1){
						res += "null \n";
					}else{
						res += "null ";
					}
				}
			}
		}
		System.out.println(res);
		String mess = "";
        for(int row2 = 0; row2 < pic.length; row2++){
            for(int col2 = 2; col2 < pic[row2].length; col2++){
                String hexColor = pic[row2][col2].toString().substring(2,8);
                String[] split = {hexColor.substring(0,2), hexColor.substring(2,4),hexColor.substring(4)};
                for(String a : split){
                    mess += hexToChar(a);
                }
            }
        }
        System.out.println(mess);
	}

	private char hexToChar(String g){
	    return (char) hexToInt(g);
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



    public static void regExTest(){
		String[] t = TEST_STRING.split(" ");
		for(String s: t){
			System.out.print(s);
		}
		System.out.println();
		StringBuilder b;
		for (int i  = 0; i < t.length; i++){
			 t[i].concat(" ");
		}
		for(String s: t){
			System.out.print(s);
		}
	}
}