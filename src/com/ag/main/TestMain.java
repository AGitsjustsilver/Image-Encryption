package com.ag.main;

import com.ag.brain.crypt.*;

import java.util.Scanner;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.SortedMap;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TestMain /*extends Application*/{

	public static final String TEST_STRING = "The quick brown fox jumps over the lazy dog";
	public static Color[][] pic;

	public static void main(String [] args){

/*		Crypt c = new Encrypt(test);

		System.out.println(c.toString());*/
		// launch(args);
/*		String test = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXY1234567890-=!@#$%^&*()_+\\,./<>?;':\"{}[] ";
		System.out.println("total length: "+test.length());
		System.out.println(test.hashCode());*/
		int g = TEST_STRING.length();
		int completeColors = (g/3)+2;
		int unPairedColors = g%3;
		// for a 4:3 aspect ratio
		Double r = Math.floor(Math.sqrt((completeColors+((unPairedColors%3!=0)? 1:0))/(4/3.0)))+1;
		Double c = Math.floor((4/3.0) * r)+1;

		pic = new Color[r.intValue()][c.intValue()];
		String[] test1 = TEST_STRING.split(" ");
		int row = 0, col = 0, i = 0;
		for (String a : test1) {
			char[] t = a.toCharArray();
			for (char b : t) {
				int[] color = new int[3];
				int hashVal = Character.hashCode(b);
				if(i==3){
					if(row != r.intValue()-1){
						if (col != c.intValue()-1) {
							// general cells - the inbetween
							System.out.println("2 1");
							// pic[row][col] = Color.valueOf(color[0] + color[1] + color[2]);
							pic[row][col] = Color.rgb(color[0],color[1],color[2]);
							col++;
						}else{
							//if it is the last column in the row
							System.out.println("3");
							// pic[row][col] = Color.valueOf(color[0] + color[1] + color[2]);
							pic[row][col] = Color.rgb(color[0],color[1],color[2]);
							col = 0;
							row++;
						}
					}else{
						//if it is the last row
						System.out.println("2 2");
						if (col != c.intValue()-1) {
							//all cells before the last cell
							// pic[row][col] = Color.valueOf(color[0] + color[1] + color[2]);
							pic[row][col] = Color.rgb(color[0],color[1],color[2]);
							col++;
						}else{
							//the last cell
							System.out.println("4");
							// pic[row][col] = Color.valueOf(color[0] + color[1] + color[2]);
							pic[row][col] = Color.rgb(color[0],color[1],color[2]);
						}
					}
					i = 0;
				}else{
					//initializes the array of hash values to put into colors
					System.out.println("1 - " + hashVal);
					/*if(hashVal >= 16){
						color[i] = Integer.toHexString(hashVal);
						System.out.println("\t1 " + i + " " + color[i] + " " + hashVal);
					}else{
						color[i] = "0"+ Integer.toHexString(hashVal);
						System.out.println("\t2 " + i + " " + color[i] + " " + hashVal);
					}*/
					color[i] = hashVal;
					i++;
				}
			}
		}
		String res = "";
		for (int r1 = 0;r1 < pic.length; r1++) {
			for (int c1 = 0;c1 < pic[r1].length; c1++) {
				if(pic[r1][c1] != null){
					res += pic[r1][c1].toString() + " ";
				}else{
					res += "null ";
				}
			}
		}
		System.out.println(res);
		// Color t = Color.web("000000");
		// aspectTesting();
	}

	/*private GridPane g;

	public void start(Stage pStage){
		pStage.setTitle("Testing Class");
		g = new GridPane();



		Scene s = new Scene(g, 500, 500);
		pStage.setScene(s);
		pStage.show();
	}*/


/*	public static void aspectTesting(){
		// Scanner s = new Scanner(System.in);
		// boolean f = true;
		// while(f){
		// 	int in = s.nextInt();
		// 	if(in == -1){
		// 		f = false;
		// 	}else{
				// int[] test = {43, 35};
				int[] test = {TEST_STRING.length()};
				for (int i : test) {
					int completeColors = (i/3)+2;
					int unPairedColors = i%3;
					// for a 4:3 aspect ratio
					double row = Math.floor(Math.sqrt((completeColors+((unPairedColors%3!=0)? 1:0))/(4/3.0)))+1;
					double col = Math.floor((4/3.0) * row)+1;
					double totalPix = row*col;
					double emptyPix43 = totalPix - (completeColors+((unPairedColors%3!=0)? 1:0));
					System.out.println("Number of Characters\tTotal Pixels\tColumn Pixels\tRow Pixels\tEmpty Pixels");
					System.out.printf("%d\t\t\t%.0f\t\t%.0f\t\t%.0f\t\t%.0f\n\n", i, totalPix, col, row, emptyPix43);
				}
		// 	}
		// }
		// s.close();

			// int len = inMess.length();
			// int numOfColors = len / 3;
			// int numOfUnpaired = len % 3;
			// w = new Double(Math.floor((numOfColors+((numOfUnpaired%3 != 0)? 1:0))/(4/3.0))+1);
			// l = new Double(Math.floor((4/3.0) * w)+1);
	}*/

}