package com.ag.main;

import java.util.Scanner;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.SortedMap;

/*import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;*/
import javafx.scene.paint.Color;

public class TestMain /*extends Application*/{

	public static void main(String [] args){
		//launch(args);
		// String test = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXY1234567890-=!@#$%^&*()_+\\,./<>?;':\"{}[] ";
		// String test = "The quick brown fox jumps over the lazy dog";
		// System.out.println("total length: "+test.length());
		// System.out.println(test.hashCode());
		// String[] test1 = test.split(" ");
		// for (String a : test1) {
		// 	char[] t = a.toCharArray();
		// 	for (char b : t) {
		// 		System.out.print(b + ": ");
		// 		System.out.println( Character.hashCode(b) + ", ");	
		// 	}
		// 	System.out.println();
		// }
		// Color t = Color.web("000000");
		aspectTesting();
	}

    /*private int[][] arrayValues;
	private GridPane g;
	private Integer val;
	private Integer nVal;

	public void start(Stage pStage){
		pStage.setTitle("Testing Class");
		g = new GridPane();

		TextArea t = new TextArea();
		g.add(t, 0, 1);

		Text res = new Text();
		g.add(res, 0, 0);

		Button b = new Button("Do The Thing");
			b.setOnMouseClicked(event -> {
				val = new Integer(t.getText());
				int val2 = val>>1;
				res.setText("The original was " + val + "\n" + "The new value is " + val2);
			});
		g.add(b, 0, 2);

		Scene s = new Scene(g, 500, 500);
		pStage.setScene(s);
		pStage.show();
	}

	public void shift(){
		nVal = new Integer(val<<3);
	}*/

	public static void aspectTesting(){
/*		Scanner s = new Scanner(System.in);
		boolean f = true;
		while(f){
			int in = s.nextInt();
			if(in == -1){
				f = false;
			}else{*/
		int[] test = {43, 35};
		/*for (int i = 0; i < test.length; i++){
			test[i] = 3*(i+1);
		}*/
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
/*			}
		}
		s.close();*/
/*
			int len = inMess.length();
			int numOfColors = len / 3;
			int numOfUnpaired = len % 3;
			w = new Double(Math.floor((numOfColors+((numOfUnpaired%3 != 0)? 1:0))/(4/3.0))+1);
			l = new Double(Math.floor((4/3.0) * w)+1);*/
	}

}