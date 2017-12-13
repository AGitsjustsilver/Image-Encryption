package com.ag.main;

import java.util.Scanner;

/*import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;*/

public class TestMain /*extends Application*/{

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

	/*public void aspectTesting(){
		Scanner s = new Scanner(System.in);
		boolean f = true;
		while(f){
			int in = s.nextInt();
			if(in == -1){
				f = false;
			}else{
				int completeColors = in/3;
				int unPairedColors = in%3;
				double area = Math.floor(in/3.0);
				// for a 1:1 aspect ratio
				double lw = Math.floor(Math.sqrt(area));
				double emptyPix11 = ((lw+1) * (lw+1)) - (completeColors+1);
				// for a 4:3 aspect ratio
				double w = Math.floor(Math.sqrt(area / (4/3.0)))+1;
				double l = Math.floor((4/3.0) * w)+1;
				double emptyPix43 = (l * w) - (completeColors+1);
				System.out.println("There would be " + completeColors + " Complete Colors and " + unPairedColors + " unpaired Colors in " + in + " Characters.");
				System.out.println("For a 1:1 Aspect Ratio the length and width would be " + lw + " pixels.\nWe would have to create " + emptyPix11 + " empty pixels.");
				System.out.println("For a 4:3 Aspect Ratio the width would be " + l + " pixels and the height would be " + w + "pixels.\nWe would have to create " +emptyPix43 + " empty pixels.");
			}
		}
		s.close();
	}*/

	private static String s;

	public static void main(String [] args){
		//launch(args);
		s = null;
		// System.out.println(s.length());
		System.out.println(s.isEmpty());
		s = "";
		System.out.println(s.length());
		System.out.println(s.isEmpty());
	}
}