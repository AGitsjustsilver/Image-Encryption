package com.ag.brain.ui.output;

import com.ag.brain.IEUtils;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class TextOutput extends GridPane{

	private static ScrollPane s;
	private static String content = "";

	public TextOutput(){
		s = new ScrollPane();
		s.setPrefSize(500,350);
		this.add(s, 0, 0);
		s.setContent(new Text(content));

		Button download = new Button("Download");
			download.setOnMouseClicked(event -> {
                //TODO
                IEUtils.saveToFile(getContent());
			});
		this.add(download, 0, 1);
	}

	private String getContent(){
	    return content;
    }

	public static void setText(String m){
	    content = m;
		Text t = new Text(content);
		s.setContent(t);
	}

}