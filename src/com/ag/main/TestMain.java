package com.ag.main;

import com.ag.brain.crypt.Crypt;
import com.ag.brain.crypt.Encrypt;
import javafx.scene.paint.Color;

import java.util.Random;

public class TestMain /*extends Application*/{

	public static final String TEST_STRING = "The quick brown fox jumps over the lazy dog";
	public static Color[][] pic;

	public TestMain(){

    }

	public static void main(String [] args){
//		launch(args);
		/*TestMain a = new TestMain();
        a.algTest();*/
        Crypt c = new Encrypt(TEST_STRING);
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
		int row = 0, col = 2, i = 0;
		int[] color = new int[3];
		for (String a : test1) {
			char[] t = a.toCharArray();
			for (char b : t) {
				int hashVal = Character.hashCode(b);
				if(i==3){
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