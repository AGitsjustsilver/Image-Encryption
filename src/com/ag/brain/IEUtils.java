package com.ag.brain;

import com.ag.brain.ui.input.FileInput;
import com.ag.brain.ui.input.TextInput;
import com.ag.brain.ui.output.ImageOutput;
import com.ag.brain.ui.output.TextOutput;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class IEUtils{

	public static final double WIDTH = 800;
	public static final double HEIGHT = 800;
	private static final double ERROR_WIDTH = 400;
	private static final double ERROR_HEIGHT  = 100;

	public static final FileInput imIn = new FileInput();
	public static final TextInput textIn = new TextInput();
	public static final ImageOutput imOut = new ImageOutput();
	public static final TextOutput textOut = new TextOutput();

	public static final String OUT_PATH = "C:\\Users\\alessandro.guaresti9\\Desktop";
	private static String fileType;
	private static String fileName;

	private static final ExtensionFilter TXT = new ExtensionFilter("Text File", "*.txt");
	private static final ExtensionFilter IMG = new ExtensionFilter("Image File", "*.png", "*.jpg", "*.gif", "*.bmp");

	public static void errorDisplay(String message){
		Stage p = new Stage();

		GridPane g = new GridPane();
		g.setAlignment(Pos.CENTER);
		Text t = new Text(message);
		t.setWrappingWidth(ERROR_WIDTH - 80);
		g.add(t, 0, 0);

		Scene s = new Scene(g, ERROR_WIDTH, ERROR_HEIGHT);

		p.initModality(Modality.APPLICATION_MODAL);
		p.setResizable(false);
		p.setScene(s);
		p.setTitle("Error");
		p.show();
	}

	/**
	*	there are 3 exit codes
	*	ec -1 is not a proper file
	* 	ec 0 is a text file
	*	ec 1 is any image file
	**/
	public static int isProperFile(String s){
		try{
			Scanner scan = new Scanner(s);
			scan.useDelimiter("\\.");
			while(scan.hasNext()){
				String testing = scan.next();
				if (testing.equals("txt")) {
					return 0;
				}else if((testing.equals("png"))||(testing.equals("jpg"))||(testing.equals("jpeg"))||(testing.equals("bmp"))){
					return 1;
				}
			}
			scan.close();
		} catch(NoSuchElementException nsee){

		}
		return -1;
	}

	public static String getFileType(){
		return fileType;
	}

	public static void setFileType(String s){
		fileType = s;
	}
	public static String getFileName(){
		return fileType;
	}

	public static void setFileName(String s){
		fileName = s;
	}

	public static void saveToFile(Image i){
		FileChooser fc = new FileChooser();
		fc.setInitialDirectory(new File(OUT_PATH));
		fc.setInitialFileName(fileName);
		fc.getExtensionFilters().add(IMG);
        fc.setSelectedExtensionFilter(IMG);
        File f = fc.showSaveDialog(null);
		if(f != null){
			BufferedImage bImage = SwingFXUtils.fromFXImage(i, null);
			try{
				ImageIO.write(bImage, fileType, f);
			}catch(IOException io){
				System.out.println(io);
			}
		}
			
	}
	public static void saveToFile(String s){
	    FileChooser fc = new FileChooser();
	    fc.setInitialDirectory(new File(OUT_PATH));
	    fc.setInitialFileName(fileName);
	    fc.getExtensionFilters().add(TXT);
	    fc.setSelectedExtensionFilter(TXT);
	    File f = fc.showSaveDialog(null);
	    if(f != null){
            try{
                PrintWriter pr = new PrintWriter(f);
                pr.write(s);
                pr.close();
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }
        }
    }

}